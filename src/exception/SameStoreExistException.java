package exception;

public class SameStoreExistException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "이름과 주소가 모두 동일한 store가 이미 존재합니다.";
		
	public SameStoreExistException() {
		super();
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public SameStoreExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorMessage = message;
	}

	public SameStoreExistException(String message, Throwable cause) {
		super(message, cause);
		errorMessage = message;
	}

	public SameStoreExistException(String message) {
		super(message);
		errorMessage = message;
	}

	public SameStoreExistException(Throwable cause) {
		super(cause);
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
}
