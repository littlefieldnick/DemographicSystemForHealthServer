package edu.usm.cos375.model.constraint;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import edu.usm.cos375.model.constraint.impl.CheckIntegerImplementation;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckIntegerImplementation.class)
@Documented
public @interface CheckInteger {
	String message () default "Field requires a integer that is greater than or equal to 0.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	int min() default 0;
}
