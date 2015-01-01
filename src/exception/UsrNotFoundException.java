package exception;

public class UsrNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "Id가 존재하지 않습니다.";
private String errorMessage;
	
	public UsrNotFoundException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public UsrNotFoundException(String string) {
		super(string);
		this.errorMessage = string;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
