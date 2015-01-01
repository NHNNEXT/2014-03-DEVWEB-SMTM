package support;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import entity.Usr;

public class MyValidatorFactory {
	public static Validator createValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}
	
	public static String getErrorMessage(
			Set<ConstraintViolation<Usr>> constraintViolations) {
		String errorMessage = "";
		
		Iterator<ConstraintViolation<Usr>> violations = constraintViolations.iterator();
		while(violations.hasNext()) {
			ConstraintViolation<Usr> each = violations.next();
			errorMessage += each.getPropertyPath() + "(입력 : " + each.getInvalidValue() +")" + " - " + each.getMessage() + "<br />";
		}
		return errorMessage;
	}
}
