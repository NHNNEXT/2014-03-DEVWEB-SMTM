package exception;

public class SameStoreExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "이름과 주소가 모두 동일한 store가 이미 존재합니다.";
	private String errorMessage;

	public SameStoreExistException() {
		super();
		this.errorMessage = DEFAULT_ERROR_MESSAGE;
	}
	
	public SameStoreExistException(String string) {
		super(string);
		this.errorMessage = string;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
