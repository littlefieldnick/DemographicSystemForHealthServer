package edu.usm.cos375.model.constraint.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.usm.cos375.model.constraint.CheckFieldNotBlank;
import edu.usm.cos375.model.constraint.CheckInteger;

public class CheckIntegerImplementation implements ConstraintValidator<CheckInteger, Object> {
	CheckInteger checkInt;
	
	public void initialize(CheckInteger arg0) {
		this.checkInt = arg0;
	}
	
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		try {
			int check = Integer.parseInt(arg0.toString());
			if(check >= checkInt.min())
				return true;
		} catch(Exception e) {
			
		}
		
		return false;
	}
}
