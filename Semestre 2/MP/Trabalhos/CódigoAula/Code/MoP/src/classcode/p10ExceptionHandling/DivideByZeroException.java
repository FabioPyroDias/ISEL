package classcode.p10ExceptionHandling;

public class DivideByZeroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	static int n = 0;

	public DivideByZeroException() {
		super("Dividing by Zero!");
		++n;
	}

	public DivideByZeroException(String message) {
		super(message);
		++n;
	}

	public static int getN() {
		return n;
	}
}
