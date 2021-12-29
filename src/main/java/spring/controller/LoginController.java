package spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.exception.MemberNotFoundException;
import spring.service.AuthService;
import spring.validator.FindInfoCommandValidator;
import spring.validator.FindPwCommandValidator;
import spring.validator.LoginCommandValidator;
import spring.validator.ModifyPwCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.FindInfoCommand;
import spring.vo.FindPwCommand;
import spring.vo.LoginCommand;
import spring.vo.ModifyPwCommand;

@Controller
@RequestMapping("/login")
public class LoginController {
   
   private AuthService authService;

   public void setAuthService(AuthService authService) {
      this.authService = authService;
   }
   
   @RequestMapping(method=RequestMethod.GET)
   public String form(LoginCommand loginCommand,
         @CookieValue(value="remembermemberId", required=false)Cookie remembermemberId) {
      if(remembermemberId != null) {
         loginCommand.setMemberId(remembermemberId.getValue());
         loginCommand.setRemembermemberId(true);
      }
            
      return "login/signin";
   }
   
   @RequestMapping(method=RequestMethod.POST)
   public String submit(LoginCommand loginCommand, Errors errors, 
         HttpSession session,HttpServletResponse response) {
      //1. 아이디, 비밀번호가 입력이 되기는 했는지 검증
      new LoginCommandValidator().validate(loginCommand, errors);
      
      if(errors.hasErrors() ) {// 로그인 실패
         return "login/signin";
      }
      //2. 입력받은 이메일이 DB에 저장이 되었는가? /DB에서 가져온 비밀번호와 일치하는가?
      
      try {
         AuthInfo authInfo = authService.authenticate(
               loginCommand.getMemberId(), 
               loginCommand.getMemberPw());
         // 로그인 성공시 인증 정보를 저장  => 세션 저장
         session.setAttribute("authInfo", authInfo);
         
         // 아이디 저장용 쿠키
         Cookie rememberCookie = 
               new Cookie("remembermemberId",loginCommand.getMemberId());
         
         rememberCookie.setPath("/");
         if(loginCommand.isRemembermemberId() ) {
            rememberCookie.setMaxAge(60*60*24*365);
         }else {
            rememberCookie.setMaxAge(0);
         }
         // 쿠키 클라이언트에 저장
         response.addCookie(rememberCookie);
         
         return "/main";
      }catch(IdPasswordNotMatchingException e) {
         errors.reject("idPasswordNotMatching");
         return "login/signin";
      }
      
   }
   
   @RequestMapping("/findInfo") 
   public String handlerStep3() {
      return "login/findInfo";
   }
   
   @RequestMapping("/findId")
   public String handlerStep4() {
      return "login/findId";
   }

   @RequestMapping("/findPw")
   public String handlerStep5() {
      return "login/findPw";
   }
   
   @RequestMapping("/findInfoResult")
   public String handlerStep6() {
      return "login/findInfoResult";
   }
   
   @RequestMapping(value="/findId", method=RequestMethod.POST) // ID 찾기
   public String searchId(
         @ModelAttribute("formData") FindInfoCommand finfoCom, Errors errors,
         HttpSession request)
   {
      new FindInfoCommandValidator().validate(finfoCom, errors);
      
      if(errors.hasErrors() )
      {
          return "login/findId";
      }
      
      try
      {
         AuthInfo findIdResult = authService.findId(finfoCom.getMemberName(), finfoCom.getMemberTel() );
         request.setAttribute("findPwResult", "");
         request.setAttribute("findIdResult", findIdResult);
         return "login/findInfoResult";
      }
      catch(MemberNotFoundException e)
      {
         errors.reject("idNotMatching");
         return "login/findId";
      }
   }
   
   @RequestMapping(value="/findPw", method=RequestMethod.POST) // PW 찾기
   public String searchPw(
         @ModelAttribute("formData") FindPwCommand fpwCom, Errors errors,
         HttpSession request)
   {
      new FindPwCommandValidator().validate(fpwCom, errors);
      
      if(errors.hasErrors() )
      {
          return "login/findPw";
      }
      
      try
      {
         AuthInfo findPwResult = authService.findPw(fpwCom.getMemberId(), fpwCom.getMemberName(), fpwCom.getMemberTel() );
         request.setAttribute("findIdResult", "");
         request.setAttribute("findPwResult", findPwResult);
         return "login/findInfoResult";
      }
      catch(MemberNotFoundException e)
      {
         errors.reject("idNotMatching");
         return "login/findPw";
      }
   }
   
   @RequestMapping(value="modifyPw", method=RequestMethod.POST) // 비밀변호 변경
   public String modifyPw(
         @ModelAttribute("modifyPass") ModifyPwCommand modPw, Errors errors)
   {
      System.out.println(modPw.getMemberId() );
      System.out.println(modPw.getCurrentPassword() );
      System.out.println(modPw.getNewPassword() );
      System.out.println(modPw.getConfirmPassword() );
      
      
      new ModifyPwCommandValidator().validate(modPw, errors);
      
      if(errors.hasErrors() )
       {
           return "login/findInfoResult";
       }
      
      try
      {
         authService.modifyPassword( modPw.getMemberId(), modPw.getCurrentPassword(),
               modPw.getNewPassword(), modPw.getConfirmPassword() );
         return "main";
      }
      catch(MemberNotFoundException e)
      {
         errors.rejectValue("currentPassword", "nomatch");
         return "login/findInfoResult";
      }
   }
   
}






