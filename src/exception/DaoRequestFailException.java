package exception;

public class DaoRequestFailException extends ErrorMessageException {
	private static final long serialVersionUID = 1L;

	public DaoRequestFailException() {
		DEFAULT_ERROR_MESSAGE = "요청 실패하였습니다.";
	}
}
