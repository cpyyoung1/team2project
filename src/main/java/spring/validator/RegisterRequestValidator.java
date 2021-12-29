package spring.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.RegisterRequest;

public class RegisterRequestValidator implements Validator{
   
   private static final String memberIdExp = 
         "^[a-zA-Z0-9]*$";
   
   private static final String memberTelExp = 
         "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
   
   private Pattern pattern;
   private Pattern pattern2;

   public RegisterRequestValidator() {
      pattern = Pattern.compile(memberIdExp);
      pattern2 = Pattern.compile(memberTelExp);
   }

   @Override
   public boolean supports(Class<?> clazz) {
      return RegisterRequest.class.isAssignableFrom(clazz);
   }
   //파라미터로 전달받은 객체가 RegisterRequest로 변환 가능한지 확인
   // 스프링에서 자동 검사 진행

   @Override
   public void validate(Object target, Errors errors) {
    //                  검사 대상 객체,     검사 결과 에러 코드
   //  검사 대상 객체의 특정 프로퍼티나 상태등이 올바른지 검사하고
   //  올바르지 않다면 Errors의 rejectValue() 메서드를 사용해서 에러코드를 저장
      
      RegisterRequest regReq = (RegisterRequest)target;
      
      if(regReq.getMemberId()==null || regReq.getMemberId().trim().isEmpty())
      {
         errors.rejectValue("memberId","required");
      }
      else
      {
         Matcher matcher = pattern.matcher(regReq.getMemberId() );
         Matcher matcher2 = pattern2.matcher(regReq.getMemberTel() );
         
         if(!matcher.matches() )
         {
            errors.rejectValue("memberId", "exceed");
         }
         
         if(!matcher2.matches() )
         {
            errors.rejectValue("memberTel", "bad");
         }
      }
      
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberName", "required");
      // ValidationUtils객체는 자주 사용하는 객체의 값 검증 코드를 보다 간결하게 만들어준다.
      ValidationUtils.rejectIfEmpty(errors, "memberPw", "required");
      ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberTel", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberAddress", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberNickname", "required");
      
      if(!regReq.getMemberPw().isEmpty() )
      {
         if(!regReq.isPasswordEqualToConfirmPassword() )
         {
         errors.rejectValue("confirmPassword", "nomatch");
         }
      }
      
      if(regReq.getMemberId().length() != 0 && regReq.getMemberId().length() < 5 || regReq.getMemberId().length() > 15)
      {
         errors.rejectValue("memberId", "exceed");
      }
      
   }

}