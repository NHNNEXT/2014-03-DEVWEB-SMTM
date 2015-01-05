package exception;

public class DbAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "DB에서 문제가 발생하였습니다.";

	public DbAccessException() {
		super(DEFAULT_ERROR_MESSAGE);
	}

	public DbAccessException(Throwable cause) {
		super(cause);
	}
}
