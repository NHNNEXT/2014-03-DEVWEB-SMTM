package exception;

public class SameUserIdExistException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ERROR_MESSAGE = "Id가 이미 존재합니다.";

}
