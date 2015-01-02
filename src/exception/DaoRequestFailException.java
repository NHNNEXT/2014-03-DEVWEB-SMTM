package exception;

public class DaoRequestFailException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "요청 실패하였습니다.";
	private String errorMessage;

	public DaoRequestFailException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public DaoRequestFailException(String string) {
		super(string);
		this.errorMessage = string;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
