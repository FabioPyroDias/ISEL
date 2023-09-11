package bookcode.p09ExceptionHandling;

public class C08UnknownOpException extends Exception {
	private static final long serialVersionUID = -5880802614048067682L;

	public C08UnknownOpException() {
		super("UnknownOpException");
	}

	public C08UnknownOpException(char op) {
		super(op + " is an unknown operator.");
	}

	public C08UnknownOpException(String message) {
		super(message);
	}
}
