package exception;

public class UserNotFoundException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		DEFAULT_ERROR_MESSAGE = "Id가 존재하지 않습니다.";
	}
}
