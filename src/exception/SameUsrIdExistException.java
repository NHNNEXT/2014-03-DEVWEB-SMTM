package exception;

public class SameUsrIdExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "Id가 이미 존재합니다.";
	private String errorMessage;

	public SameUsrIdExistException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public SameUsrIdExistException(String string) {
		super(string);
		this.errorMessage = string;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
