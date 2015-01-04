package exception;

public class SameUserIdExistException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "Id가 이미 존재합니다.";
			
	public SameUserIdExistException() {
		super();
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public SameUserIdExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorMessage = message;
	}

	public SameUserIdExistException(String message, Throwable cause) {
		super(message, cause);
		errorMessage = message;
	}

	public SameUserIdExistException(String message) {
		super(message);
		errorMessage = message;
	}

	public SameUserIdExistException(Throwable cause) {
		super(cause);
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}
}
