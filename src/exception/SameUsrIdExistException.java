package exception;

public class SameUsrIdExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public SameUsrIdExistException(String string) {
		super(string);
	}
	
}
