package exception;

public class DaoRequestFailException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MESSAGE = "db 요청에 기대하던 값을 받지 못하였습니다.";

	public DaoRequestFailException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
}
