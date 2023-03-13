package com.ashokit.crm.constraint.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ashokit.crm.constraint.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, Long> {
	
	@Override
	public void initialize(Phone constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		String str = String.valueOf(value);
		if(str.length() == 10) {
			return true;
		}
		else {
			return false;
		}
	}

}
