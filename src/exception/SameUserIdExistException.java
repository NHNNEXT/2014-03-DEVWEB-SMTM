package exception;

public class SameUserIdExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "Id가 이미 존재합니다.";

	public SameUserIdExistException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
}
