package spring.service;

import spring.dao.ProductDAO;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Product;
import spring.vo.RegisterRequestProduct;

public class ProductRegisterService {

	private ProductDAO productDAO; // = new MemberDao();

	public ProductRegisterService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void regist(RegisterRequestProduct req) {
		Product newProduct = new Product(
				req.getProductNumber(), req.getProductTitle(), req.getProductPrice(),req.getProductText(),req.getProductName()
				,req.getProductPictureNameURL(),
				req.getProductCount(), req.getProductDate(),req.getMemberNumber(), req.getCategoryNumber()
				);
		System.out.println("뉴프로덕트등록");
		productDAO.insert(newProduct);
	}
	
	public void modify(RegisterRequestProduct req) {
//		Product product = productDAO.selectByproductNumber(req.getProductNumber());
		Product newProduct = new Product(
				req.getProductNumber(), req.getProductTitle(), req.getProductPrice(),req.getProductText(),req.getProductName()
				,req.getProductPictureNameURL(),
				req.getProductCount(), req.getProductDate(),req.getMemberNumber(), req.getCategoryNumber()
				);
		System.out.println("뉴프로덕트등록");
		productDAO.modify(newProduct);
	}
}
