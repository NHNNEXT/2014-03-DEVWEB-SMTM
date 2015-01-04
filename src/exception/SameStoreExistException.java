package exception;

public class SameStoreExistException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "이름과 주소가 모두 동일한 store가 이미 존재합니다.";

}
