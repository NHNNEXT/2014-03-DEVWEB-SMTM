package exception;

public class UserNotFoundException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "Id가 존재하지 않습니다.";

	public UserNotFoundException() {
		super();
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorMessage = message;
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		errorMessage = message;
	}

	public UserNotFoundException(String message) {
		super(message);
		errorMessage = message;
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}

}
