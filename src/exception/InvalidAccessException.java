package exception;

public class InvalidAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "비정상적인 접근입니다.";
	private String errorMessage;

	public InvalidAccessException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public InvalidAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorMessage = message;
	}

	public InvalidAccessException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public InvalidAccessException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public InvalidAccessException(Throwable cause) {
		super(cause);
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
