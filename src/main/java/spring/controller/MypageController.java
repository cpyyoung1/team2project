package spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDAO;
import spring.dao.MemberDao;
import spring.dao.MessageDao;
import spring.dao.ProductDAO;
import spring.exception.MemberNotFoundException;
import spring.service.AuthService;
import spring.service.MessageService;
import spring.validator.ModifyAddressCommandValidator;
import spring.validator.ModifyNicknameCommandValidator;
import spring.validator.ModifyPwCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.BoardVO;
import spring.vo.Like;
import spring.vo.Member;
import spring.vo.Message;
import spring.vo.ModifyAddressCommand;
import spring.vo.ModifyNicknameCommand;
import spring.vo.ModifyPwCommand;
import spring.vo.Order;
import spring.vo.Product;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	public MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	private BoardDAO BoardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		BoardDAO = boardDAO;
	}

	private AuthService authService;

	public void setAuthService(AuthService authService)
	{
		this.authService = authService;
	}

	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}


	// 마이페이지 메인
	@RequestMapping("/MypageMain") 
	public String handlerStep1(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int memberNumber = authInfo.getMemberNumber();
		Member member = memberDao.selectBymemberNumber(memberNumber);

		authInfo = new AuthInfo(
				member.getMemberNumber(),
				member.getMemberName(),
				member.getMemberId(),
				member.getMemberPw(),
				member.getMemberTel(),
				member.getMemberAddress(),
				member.getMemberGrade(),
				member.getMemberProfile(),
				member.getMemberPoint(),
				member.getMemberNickname()
				);
		session.setAttribute("authInfo", authInfo);

		int reciveMsgCnt = messageDao.messagCnt(member.getMemberId());
		model.addAttribute("reciveMsgCnt",reciveMsgCnt);

		return "mypage/MypageMain";
	}

	//찜목록 확인
	@RequestMapping("/Like") 
	public String handlerStep2(Model model) {

		List<Like> like = productDAO.likeSelectAll();
		model.addAttribute("like", like);

		return "mypage/Like";
	}

	// 찜 제품 삭제
	@RequestMapping("/deleteLike/{likeNumber}")
	public String deleteLike(@PathVariable("likeNumber") int likeNumber, Model model) {

		productDAO.deleteLike(likeNumber);

		List<Like> likes = productDAO.likeSelectAll();
		model.addAttribute("like", likes);

		return "mypage/Like";
	}

	//정보수정 페이지
	@RequestMapping("/ModifyInfo") 
	public String handlerStep3() {
		return "mypage/ModifyInfo";
	}

	//패스워드 변경
	@RequestMapping(value="modifyPw", method=RequestMethod.POST) // 비밀변호 변경
	public String modifyPw(
			@ModelAttribute("modifyPass") ModifyPwCommand modPw, Errors errors)
	{
		new ModifyPwCommandValidator().validate(modPw, errors);

		if(errors.hasErrors() )
		{
			errors.reject("confirm");
			return "mypage/ModifyInfo";
		}

		try
		{
			authService.modifyPassword( modPw.getMemberId(), modPw.getCurrentPassword(),
					modPw.getNewPassword(), modPw.getConfirmPassword() );
			return "mypage/MypageMain";
		}
		catch(MemberNotFoundException e)
		{
			errors.reject("confirm");
			errors.rejectValue("currentPassword", "nomatch");
			return "mypage/ModifyInfo";
		}
	}

	//닉네임 변경
	@RequestMapping(value="modifyNick", method=RequestMethod.POST) // 비밀변호 변경
	public String modifyNick(
			@ModelAttribute("modifyNic") ModifyNicknameCommand modNick, Errors errors,
			HttpSession session)
	{
		new ModifyNicknameCommandValidator().validate(modNick, errors);

		if(errors.hasErrors() )
		{
			errors.reject("confirm");
			return "mypage/ModifyInfo";
		}

		try
		{
			authService.modifyNickname(modNick.getMemberId(), modNick.getMemberNickname() );
			session.setAttribute("authInfo", authService.sessionReset(modNick.getMemberId() ) );
			return "mypage/MypageMain";
		}
		catch(MemberNotFoundException e)
		{
			errors.reject("confirm");
			errors.rejectValue("memberNickname", "duplicate");
			return "mypage/ModifyInfo";
		}
	}

	// 주소 변경
	@RequestMapping(value="modifyAddress", method=RequestMethod.POST) // 주소 변경
	public String modifyAddress(
			@ModelAttribute("modifyAddr") ModifyAddressCommand modAddr, Errors errors,
			HttpSession session)
	{
		System.out.println(modAddr.getMemberId() );
		System.out.println(modAddr.getMemberAddress() );

		new ModifyAddressCommandValidator().validate(modAddr, errors);

		if(errors.hasErrors() )
		{
			errors.reject("confirm");
			return "mypage/ModifyInfo";
		}

		try
		{
			authService.modifyAddress(modAddr.getMemberId(), modAddr.getMemberAddress() );
			session.setAttribute("authInfo", authService.sessionReset(modAddr.getMemberId() ) );
			return "mypage/MypageMain";
		}
		catch(MemberNotFoundException e)
		{
			errors.reject("confirm");
			return "mypage/ModifyInfo";
		}
	}


	// 내가 올린 게시판 글, 상품 조회
	@RequestMapping("/MyContent") 
	public String handlerStep4(Model model) throws Exception {

		List<BoardVO> list = BoardDAO.list();
		model.addAttribute("list", list);

		List<Product> product = productDAO.selectAll();
		model.addAttribute("product", product);

		return "mypage/MyContent";
	}


	@RequestMapping("/noteSend") 
	public String handlerStep6() {
		return "mypage/noteSend";
	}


	//결제 페이지 이동
	@RequestMapping("/Payment") 
	public String handlerStep8() {
		return "mypage/Payment";
	}

	//구매목록
	@RequestMapping("/purchaseList") 
	public String handlerStep9(Model model) {
		List<Order> orders = productDAO.orderSelectAll();
		model.addAttribute("order", orders);

		return "mypage/purchaseList";
	}

	//포인트 충전기능
	@RequestMapping("/payNow") 
	public String changePoint(@RequestParam(value = "payMoney", required = false) int payMoney,
			Model model, HttpSession session) {

		if(payMoney==20000) {
			payMoney=22000;
		}else if(payMoney==30000) {
			payMoney=33300;
		}else if(payMoney==40000) {
			payMoney=44800;
		}else if(payMoney==50000) {
			payMoney=57000;
		}

		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int num = authInfo.getMemberNumber();

		Member member = memberDao.selectBymemberNumber(num);
		memberDao.changePoint(payMoney, member);

		member = memberDao.selectBymemberNumber(member.getMemberNumber());

		AuthInfo newAuthInfo = new AuthInfo(
				member.getMemberNumber(),
				member.getMemberName(),
				member.getMemberId(),
				member.getMemberPw(),
				member.getMemberTel(),
				member.getMemberAddress(),
				member.getMemberGrade(),
				member.getMemberProfile(),
				member.getMemberPoint(),
				member.getMemberNickname()
				);
		session.setAttribute("authInfo", newAuthInfo);

		return "mypage/MypageMain";
	}

	//쪽지 읽기
		@RequestMapping("/noteView/{mno}")
		public String Detail(@PathVariable("mno") int mno, Model model) {

			Message msg = messageDao.selectByMno(mno);
			model.addAttribute("readMsg", msg);
			return "mypage/noteView";
		}

		// 쪽지 전송
		@RequestMapping(value = "noteSend/send", method = RequestMethod.POST)
		public String sendMessage(Message message,Model model)throws Exception{
			String chkId = message.getReciver();  //확인할 ID
			Member member = memberDao.selectBymemberId(chkId);  //회원 아이디확인
			if(member==null) {  //없을경우 에러
				String errMsg ="존재하지않는 회원입니다. 아이디를 확인해주세요.";
				model.addAttribute("notFoundId",errMsg);
				model.addAttribute("errPage","/mypage/noteSend/");
				return "/mypage/ErrId";
			} //있을경우 전송실행
			messageService.send(message);
			List<Message> msgList = messageDao.msgList();
			model.addAttribute("msgList", msgList);
			return "redirect:/mypage/noteMain";
		}


		//메인화면
		@RequestMapping("/noteMain")
		public String Mainlist(Model model) throws Exception {
			List<Message> msgList = messageDao.msgList();
			model.addAttribute("msgList", msgList);

			return "mypage/noteMain";
		}





		//쪽지 삭제
		@RequestMapping("/msgDelete/{mno}")
		public String delete(@PathVariable("mno") int mno,
				Model model) throws Exception{

			Message message = messageDao.selectByMno(mno);

			messageDao.selectDelete(message);

			List<Message> msgList = messageDao.msgList();
			model.addAttribute("msgList", msgList);
			return "redirect:/mypage/noteMain";
		}

		//모든 보낸 편지함 
		@RequestMapping("allSendList.do")
		public String SendList(Model model)throws Exception{
			List<Message> msgList = messageDao.msgList();
			model.addAttribute("msgList", msgList);
			return "/mypage/sendList";
		}


		//모든 받은 편지함 
		@RequestMapping("allReciveList.do")
		public String ReciveList(Model model)throws Exception{
			List<Message> msgList = messageDao.msgList();
			model.addAttribute("msgList", msgList);
			return "/mypage/reciveList";
		}
		




}
