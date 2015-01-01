package exception;

public class RegisterUsrException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "Usr 등록에 문제가 발생했습니다";
	private String errorMessage;

	public RegisterUsrException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public RegisterUsrException(String string) {
		super(string);
		this.errorMessage = string;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
