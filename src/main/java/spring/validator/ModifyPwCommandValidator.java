package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.Member;
import spring.vo.ModifyPwCommand;
import spring.vo.RegisterRequest;

public class ModifyPwCommandValidator implements Validator
{
   @Override
   public boolean supports(Class<?> clazz)
   {
      return ModifyPwCommand.class.isAssignableFrom(clazz);
   }
   
   @Override
   public void validate(Object target, Errors errors)
   {
      ModifyPwCommand modPw = (ModifyPwCommand)target;
      
      if(!modPw.getNewPassword().equals(modPw.getConfirmPassword() ) )
      {
         errors.rejectValue("confirmPassword", "nomatch");
      }
      
      ValidationUtils.rejectIfEmpty(errors, "currentPassword", "required");
      ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
      ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
   }
}