package edu.usm.cos375.model.constraint.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.usm.cos375.model.constraint.CheckFieldNotBlank;

public class CheckFieldNotBlankImplementation implements ConstraintValidator<CheckFieldNotBlank, String> {

	public void initialize(CheckFieldNotBlank arg0) {
		
	}
	
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if(arg0 == null)
			return false;
		
		return arg0.trim().length() != 0;
	}
}
