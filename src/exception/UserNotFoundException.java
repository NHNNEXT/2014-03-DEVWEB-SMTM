package exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "Id가 존재하지 않습니다.";

	public UserNotFoundException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
}
