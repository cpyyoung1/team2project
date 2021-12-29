package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.ModifyAddressCommand;

public class ModifyAddressCommandValidator implements Validator
{
   @Override
   public boolean supports(Class<?> clazz)
   {
      return ModifyAddressCommand.class.isAssignableFrom(clazz);
   }
   
   @Override
   public void validate(Object target, Errors errors)
   {
      ValidationUtils.rejectIfEmpty(errors, "memberAddress", "required");
   }
}