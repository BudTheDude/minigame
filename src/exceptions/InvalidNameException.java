package exceptions;

public class InvalidNameException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
	}

	public InvalidNameException(String msg) {
		super(msg);
	}
}
