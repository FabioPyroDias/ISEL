package bookcode.p09ExceptionHandling;

/**
 * A personalised exception
 */
public class C03DivideByZeroException extends Exception {
	private static final long serialVersionUID = 4363887778209068442L;

	public C03DivideByZeroException() {
		super("Dividing by Zero!");
	}

	public C03DivideByZeroException(String message) {
		super(message);
	}
}
