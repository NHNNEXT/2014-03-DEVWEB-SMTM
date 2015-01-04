package exception;

public class PasswordMismatchException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		DEFAULT_ERROR_MESSAGE = "비밀번호가 틀립니다.";
	}
}
