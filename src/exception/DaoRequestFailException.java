package exception;

public class DaoRequestFailException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "요청 실패하였습니다.";

	public DaoRequestFailException() {
		super();
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}

	public DaoRequestFailException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorMessage = message;
	}

	public DaoRequestFailException(String message, Throwable cause) {
		super(message, cause);
		errorMessage = message;
	}

	public DaoRequestFailException(String message) {
		super(message);
		errorMessage = message;
	}

	public DaoRequestFailException(Throwable cause) {
		super(cause);
		errorMessage = DEFAULT_ERROR_MESSAGE;
	}
}
