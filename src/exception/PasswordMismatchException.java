package exception;

public class PasswordMismatchException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "비밀번호가 틀립니다.";
	private String errorMessage;
	
	public PasswordMismatchException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public PasswordMismatchException(String string) {
		super(string);
		this.errorMessage = string;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
