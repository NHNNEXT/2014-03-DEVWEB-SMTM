package exception;

public class PasswordMismatchException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "비밀번호가 틀립니다";

	public PasswordMismatchException() {
		super();
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public PasswordMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorMessage = message;
	}

	public PasswordMismatchException(String message, Throwable cause) {
		super(message, cause);
		errorMessage = message;
	}

	public PasswordMismatchException(String message) {
		super(message);
		errorMessage = message;
	}

	public PasswordMismatchException(Throwable cause) {
		super(cause);
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}
}
