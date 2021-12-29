package spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.MessageDao;
import spring.service.MessageService;
import spring.service.ProductRegisterService;
import spring.vo.AuthInfo;
import spring.vo.Message;
import spring.vo.RegisterRequestProduct;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductRegisterService productRegisterService;

	private HttpSession session;

	public void setProductRegisterService(ProductRegisterService productRegisterService) {
		this.productRegisterService = productRegisterService;
	}

	MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	MessageService messageService;


	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}



	@RequestMapping("/productMain")   //상품 카테고리 화면으로 이동
	public String handlerStep1() {
		return "product/productMain";
	}

	//특정 회원에게 메시지를 보내는기능
	@RequestMapping("/message/{memberId}")
	   public String userMessage(@PathVariable("memberId") String memberId, Model model) {
	      model.addAttribute("toMessage",memberId);
	      return "product/message";
	   }
	
	//갤러리로 이동
	@RequestMapping("/gallery")   
	public String handlerStep10() {
		return "product/gallery";
	}

	//상품등록페이지로 이동
	@RequestMapping("/productRegistration")   
	public String handlerStep23() {
		return "productRegister/productRegistration";
	}

	//상품 등록하는 기능
	@RequestMapping(value="/step10", method=RequestMethod.POST)
	public String handlerStep3(

			@ModelAttribute("frm")
			RegisterRequestProduct regReq,Errors errors, Model model, HttpSession session) {

		try {
			if(regReq.getProductPictureNameURL()==null) {
				System.out.println("출력문"+regReq.getProductPictureNameURL());
			}

			productRegisterService.regist(regReq);

			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");

			model.addAttribute("nickname", authInfo.getMemberNickname());
			model.addAttribute("product", regReq);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
			String today = sdf.format(date);
			model.addAttribute("regDate", today);

			return "product/productDetails";
		}catch(Exception e) {
			System.out.println("상품등록에 실패했습니다.");
			return "product/productMain";
		}


	}

	@RequestMapping(value="/productRegistration", method=RequestMethod.POST)   //  =>   /register/step2
	public String handlerStep2(
			@RequestParam(value="agree", defaultValue="false")Boolean agree,
			Model model, HttpSession session) {

		if(!agree) {
			return "productRegister/productRegistration";
		}
		model.addAttribute("registerRequestProduct", new RegisterRequestProduct());
		return "productRegister/productRegistration";
	}

	@RequestMapping(value="/productRegistration", method=RequestMethod.GET)
	public String handlerStep2Get() {
		return "productRegister/productRegistration";
	}

	// 수정 상품 등록하는 기능
	@RequestMapping(value="/modifyProductNow", method=RequestMethod.POST)    //  =>   /register/step3
	public String handlerStep4(

			@ModelAttribute("frm")
			RegisterRequestProduct regReq,Errors errors,Model model) {


		try {
			if(regReq.getProductPictureNameURL()==null) {
				System.out.println("출력문"+regReq.getProductPictureNameURL());
			}

			productRegisterService.modify(regReq);

			model.addAttribute("product", regReq);

			return "/product/productDetails";

		}catch(Exception e) {
			System.out.println("상품등록에 실패했습니다.");
			return "product/sofa";
		}


	}
	  // 쪽지 전송
    @RequestMapping(value = "message/toMember", method = RequestMethod.POST)
    public String toMessage(Message message)throws Exception{
       messageService.send(message);
       return "product/closeWindow";
       //창닫기 구현
    }


}