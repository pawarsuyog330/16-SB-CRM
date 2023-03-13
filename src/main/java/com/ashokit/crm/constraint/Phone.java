package com.ashokit.crm.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ashokit.crm.constraint.validator.PhoneValidator;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
	String message() default "{contact.invalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
