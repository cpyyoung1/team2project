package spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.MemberDao;
import spring.dao.ProductDAO;
import spring.vo.AuthInfo;
import spring.vo.Like;
import spring.vo.Member;
import spring.vo.Order;
import spring.vo.Product;

@Controller
public class ProductDetailController {

	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//특정 제품을 자세하게 보여주는 기능
	@RequestMapping("/product/productDetails/{productNumber}")
	public String Detail(@PathVariable("productNumber") int productNumber, Model model) {

		Product product = productDAO.selectByproductNumber(productNumber);

		if(product==null) {
			System.out.println("상품정보를 불러올 수 없습니다.");
		}

		productDAO.plusCount(product);
		model.addAttribute("product", product);

		int num = product.getMemberNumber();
		List<Member> members = memberDao.selectAll();
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getMemberNumber()==num) {
				String nickname = members.get(i).getMemberNickname();
				model.addAttribute("nickname", nickname);
				String memberId = members.get(i).getMemberId();
		        model.addAttribute("toSeller",memberId);
		        Date regDate = product.getProductDate();
		        model.addAttribute("regDate", regDate);

			}
		}

		return "product/productDetails";
	}

	//카테고리별로 상품을 보여주는 페이지로 이동시켜주는 기능
	@RequestMapping("product/{categoryNumber}")
	public String list(@PathVariable("categoryNumber") int categoryNumber,
			Model model) {
		List<Product> products = productDAO.selectAll();
		model.addAttribute("products", products);

		if(categoryNumber==1) {
			return "product/sofa";
		}else if(categoryNumber==2) {
			return "product/bed";
		}else if(categoryNumber==3) {
			return "product/table";
		}else if(categoryNumber==4) {
			return "product/lighting";
		}else if(categoryNumber==5) {
			return "product/drawer";
		}else {
			return "product/acc";
		}
	}
	
	//상품 구매페이지로 넘어가는 기능
	@RequestMapping("/product/payPage/{productNumber}") 
	public String buyProudctPage(@PathVariable("productNumber") int productNumber, Model model, HttpSession session) {
		
		Product product = productDAO.selectByproductNumber(productNumber);
		Member member = memberDao.selectBymemberNumber(product.getMemberNumber());
		
		model.addAttribute("product", product);
		model.addAttribute("member", member);
		
		return "/product/payPage";
	}
	

	//상품 구매기능
	@RequestMapping("/product/buy/{productNumber}") 
	public String buyProudct(@PathVariable("productNumber") int productNumber, Model model, HttpSession session) {

		Product product = productDAO.selectByproductNumber(productNumber);
		int price = product.getProductPrice();
		int sellerNumber = product.getMemberNumber();
		Member seller = memberDao.selectBymemberNumber(sellerNumber);

		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int buyerNumber = authInfo.getMemberNumber();
		Member buyer = memberDao.selectBymemberNumber(buyerNumber);


			memberDao.plus(price, seller);
			memberDao.minus(price, buyer);
			
			Order order = new Order(product.getProductPictureNameURL(),
					product.getProductName(),
					product.getProductPrice(),
					seller.getMemberNumber(),
					seller.getMemberNickname(),
					authInfo.getMemberNickname(),
					authInfo.getMemberNumber()
					);
			
			productDAO.order(order);
			productDAO.likeProductDelete(product);
			productDAO.delete(product);
			
			List<Order> orders = productDAO.orderSelectAll();
			model.addAttribute("order", orders);
			
			return "mypage/purchaseList";
		
	}

	//상품 삭제기능
	@RequestMapping("/product/delete/{productNumber}") 
	public String deleteProudct(@PathVariable("productNumber") int productNumber) {

		Product product = productDAO.selectByproductNumber(productNumber);
		productDAO.likeProductDelete(product);
		productDAO.delete(product);

		return "redirect:/main";
		
	}
	
	//제품번호를 가져와 제품 수정페이지로 이동시켜주는 기능
	 	@RequestMapping("/product/productModify/{productNumber}") 
	 	public String modifyProduct(@PathVariable("productNumber") int productNumber,Model model) {
	 		
	 	Product product = productDAO.selectByproductNumber(productNumber);
	 	model.addAttribute("product", product);
	 		
	 	return "/product/productModify";
	 	
	 }
	 
	 	//찜하기 기능
	 	@RequestMapping("/product/likeProduct/{productNumber}")
	 	public String likeProduct(@PathVariable("productNumber") int productNumber,Model model,HttpSession session) {
	 		
	 		Product product = productDAO.selectByproductNumber(productNumber);
	 		
	 		Member seller = memberDao.selectBymemberNumber(product.getMemberNumber());
	 		
	 		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
	 		
	 		Like like = new Like(product.getProductName(),seller.getMemberNickname(),product.getProductPrice(),authInfo.getMemberNumber(),
	 				product.getProductNumber(),product.getProductPictureNameURL());
	 		
	 		productDAO.like(like);
	 		
	 		List<Like> likes = productDAO.likeSelectAll();
	 		model.addAttribute("like", likes);
	 		
	 		return "/mypage/Like";
	 	}

	 	
	 	// 상품 검색해서 찾아주는 기능
	 	@RequestMapping("/product/searchProduct")
		public String searchMember(@RequestParam(value = "searchProduct",required = false) String searchProduct,Model model) {
			
	 		
			List<Product> products =  productDAO.findProductName(searchProduct);
			model.addAttribute("searchProductName", searchProduct);
			model.addAttribute("products", products);
			
			if(products==null) {
				model.addAttribute("mag", "조회된 검색 결과가 없습니다.");
			}else {
				model.addAttribute("msg", "총 "+products.size()+"개의 상품이 검색되었습니다.");
			}
	 			
			
			return "/product/searchProduct";
		}
		
	 
}
