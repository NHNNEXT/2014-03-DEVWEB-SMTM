package exception;

public class PasswordMismatchException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "비밀번호가 틀립니다";

	public PasswordMismatchException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
}
