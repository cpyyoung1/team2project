package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.FindPwCommand;

public class FindPwCommandValidator implements Validator
{
   @Override
   public boolean supports(Class<?> clazz)
   {
      return FindPwCommand.class.isAssignableFrom(clazz);
   }
   
   @Override
   public void validate(Object target, Errors errors)
   {   
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberName", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberTel", "required");
   }
}