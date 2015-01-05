package exception;

public class SameStoreExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "이름과 주소가 모두 동일한 store가 이미 존재합니다.";

	public SameStoreExistException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
}
