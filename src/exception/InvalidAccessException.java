package exception;

public class InvalidAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "비정상적인 접근입니다.";
	
	public InvalidAccessException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
}
