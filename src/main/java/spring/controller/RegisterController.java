package spring.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exception.AlreadyExistingMemberException;
import spring.service.MemberRegisterService;
import spring.validator.LoginCommandValidator;
import spring.validator.RegisterRequestValidator;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegisterController { //jsp 컨트롤러
   
   private MemberRegisterService memberRegisterService;
   
   public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
      this.memberRegisterService = memberRegisterService;
   }
   
   
   @RequestMapping("/term")  
   public String handlerStepR1() {
      return "register/term";
   }
   
   @RequestMapping("/step3")
   public String handlerStepR2() {
      return "register/step3";
   }
   
   
//  요청 파라미터를 받는 첫번째 방법  HttpServletRequest 객체를 사용하는 방법
//   @RequestMapping(value="/step2", method=RequestMethod.POST)   //  =>   /register/step2
//   public String handlerStep2(HttpServletRequest request) {
//      //=> 서블릿     doGet(HttpServletRequest request,HttpServletResponse response)
//      //~~~~~~~
//      String agreeParam = request.getParameter("agree");
//      if(agreeParam == null || !agreeParam.equals("true")) {
//         return "register/step1";
//      }
//      return "register/step2";
//   }
   
//  요청 파라미터를 받는 두번째 방법  @RequestParam애노테이션을 이용하는 방법
   @RequestMapping(value="/signup", method=RequestMethod.POST)   //  =>   /register/step2
   public String handlerStep2(
         @RequestParam(value="agree", defaultValue="false")Boolean agree,
      //                'agree'라는 파라미터로 들어온 속성값을 => 매개변수 agree에 담는다.
      //                 null값은 형변환 불가 => 데이터가 없는 경우  기본값을 만들수 있다.
      //                                    defaultValue
      //System.out.println("*****Step2 메소드가 잘 실행됩니다.*****");
         Model model, HttpSession session) {
      
//       public String handlerStep2(Boolean agree,Model model) {~~~}
      if(!agree) {
         return "register/term";
      }
      model.addAttribute("registerRequest", new RegisterRequest());
      return "register/signup";
   }
   
   @RequestMapping(value="/signup", method=RequestMethod.GET)
   public String handlerStep2Get() {
      return "register/signup";
      //return "register/step1";               /WEB-INF/views/register/signup.jsp
   }
   
//   @RequestMapping("/step3")    //  =>   /register/step3
//   public String handlerStep3(
//         @RequestParam(value="email")String email,
//         @RequestParam(value="name")String name,
//         @RequestParam(value="password")String password,
//         @RequestParam(value="confirmPassword")String confirmPassword
//         ) {
//      //~~~~~~~
//      return "register/step3";
//   }
   
   @RequestMapping(value="/step3", method=RequestMethod.POST)    //  =>   /register/step3
   public String handlerStep3(
       @ModelAttribute("formData") RegisterRequest regReq,Errors errors) {
      
      new RegisterRequestValidator().validate(regReq, errors);
      
      if(errors.hasErrors() )
      {
            return "register/signup";
      }
      
      if(memberRegisterService.nickChk(regReq) == 1) // 닉네임 중복확인 로직
      {
         errors.rejectValue("memberNickname", "duplicate");
         return "register/signup";
      }
      
      if(memberRegisterService.telChk(regReq) == 1) // 연락처 중복확인 로직
      {
         errors.rejectValue("memberTel", "duplicate");
         return "register/signup";
      }
      
      try
      {
         memberRegisterService.regist(regReq);
         return "register/step3";
      }
      catch(AlreadyExistingMemberException ee)
      {
         errors.rejectValue("memberId", "duplicate");
         return "register/signup";
      }
      
      
   }
   
   
}

