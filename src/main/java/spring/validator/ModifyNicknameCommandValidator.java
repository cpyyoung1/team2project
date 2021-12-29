package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.ModifyNicknameCommand;

public class ModifyNicknameCommandValidator implements Validator
{
   @Override
   public boolean supports(Class<?> clazz)
   {
      return ModifyNicknameCommand.class.isAssignableFrom(clazz);
   }
   
   @Override
   public void validate(Object target, Errors errors)
   {
      ValidationUtils.rejectIfEmpty(errors, "memberNickname", "required");
   }
}