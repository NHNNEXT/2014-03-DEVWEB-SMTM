package exception;

public class ErrorMessageException extends Exception {
	private static final long serialVersionUID = 1L;
	protected String errorMessage;
	protected String DEFAULT_ERROR_MESSAGE = "에러";
	
	public ErrorMessageException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public ErrorMessageException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorMessage = message;
	}

	public ErrorMessageException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public ErrorMessageException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public ErrorMessageException(Throwable cause) {
		super(cause);
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
