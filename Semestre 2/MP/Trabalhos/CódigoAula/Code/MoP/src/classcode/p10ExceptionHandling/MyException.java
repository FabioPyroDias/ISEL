package classcode.p10ExceptionHandling;

public class MyException extends Exception {

	private static final long serialVersionUID = -5874369864447499135L;

	public MyException(String message) {
		super(message);
	}

	public MyException() {
		this("no message");
	}
	
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}
}