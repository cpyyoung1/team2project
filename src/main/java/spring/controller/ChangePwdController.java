package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.exception.MemberNotFoundException;
import spring.service.ChangePasswordService;
import spring.validator.ChangePwdCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.ChangePwdCommand;

@Controller
@RequestMapping("product/ModifyInfo") // 클라이언트로부터 요청받는 경로주소
public class ChangePwdController {
	private ChangePasswordService changePasswordService;

	public ChangePwdController(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
//  1. 모델 어노테이션 이용	
//	@RequestMapping(method = RequestMethod.GET)
//	public String form(@ModelAttribute("changePwdCommand") ChangePwdCommand changePwdCommand) {
//		return "edit/changePwdForm"; 
//	}

	//  2. model객체를 이용
//	@RequestMapping(method = RequestMethod.GET) 
//	public String form(Model model) {
//		model.addAttribute("ChangePwdCommand", new ChangePwdCommand());
//		return "edit/changePwdForm"; 
//	}
	

	// 3. post하고 같은 커맨드 객체를 사용하는 경우 model 생략 가능
	@RequestMapping(method = RequestMethod.GET)
	public String form(ChangePwdCommand changePwdCommand, HttpSession session) {
//		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//	
//		if(authInfo == null) {
//			return "redirect:/login";
//		}
		
		return "product/ModifyInfo"; 
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String submit(@ModelAttribute("command") ChangePwdCommand changePwdCommand, Errors errors) {
//		return "edit/changePwdForm"; //실제 jsp파일이 존재하는 위치경로
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(ChangePwdCommand changePwdCommand, Errors errors, HttpSession session) {
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		
		if(errors.hasErrors()) {
			return "product/ModifyInfo";
		}
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		try {
			changePasswordService.changePassword(authInfo.getMemberId(),
					changePwdCommand.getCurrentPassword(), changePwdCommand.getNewPassword());
			return "product/ModifyInfo";
		}catch(IdPasswordNotMatchingException e) { // 입력한 기존 비밀번호가 저장된 비밀번호와 다른 경우
			errors.rejectValue("currentPassword", "notMatching");
			return "product/ModifyInfo";
		}
		
	}
	
}
