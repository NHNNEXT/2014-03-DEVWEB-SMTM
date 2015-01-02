package support;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MyValidatorFactory {
	public static Validator createValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}
	
	public static <T> String getErrorMessage(
			Set<ConstraintViolation<T>> constraintViolations) {
		String errorMessage = "";
		
		Iterator<ConstraintViolation<T>> violations = constraintViolations.iterator();
		while(violations.hasNext()) {
			ConstraintViolation<T> each = violations.next();
			errorMessage += each.getPropertyPath() + "(입력 : " + each.getInvalidValue() +")" + " - " + each.getMessage() + "<br />";
		}
		return errorMessage;
	}
}
