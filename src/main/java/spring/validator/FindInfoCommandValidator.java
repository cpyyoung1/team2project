package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.FindInfoCommand;
import spring.vo.LoginCommand;
import spring.vo.RegisterRequest;

public class FindInfoCommandValidator implements Validator
{
   @Override
   public boolean supports(Class<?> clazz)
   {
      return FindInfoCommand.class.isAssignableFrom(clazz);
   }
   
   @Override
   public void validate(Object target, Errors errors)
   {   
      //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberName", "required");
      ValidationUtils.rejectIfEmpty(errors, "memberTel", "required");
   }
}