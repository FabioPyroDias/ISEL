package bookcode.p09ExceptionHandling;

public class C07NegativeNumberException extends Exception {
	private static final long serialVersionUID = -742039163475612503L;

	public C07NegativeNumberException() {
		super("Negative Number Exception!");
	}

	public C07NegativeNumberException(String message) {
		super(message);
	}
}
