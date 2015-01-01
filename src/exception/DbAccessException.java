package exception;

public class DbAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "DB에서 문제가 발생하였습니다.";
	private String errorMessage;

	public DbAccessException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public DbAccessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorMessage = message;
	}

	public DbAccessException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public DbAccessException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public DbAccessException(Throwable cause) {
		super(cause);
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
