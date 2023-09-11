package classcode.p10ExceptionHandling;

class NegativeValueException extends Exception {
	private static final long serialVersionUID = 1L;

	static int n = 0;

	public NegativeValueException() {
		super("Negative value!");
		++n;
	}

	public NegativeValueException(String message) {
		super(message);
		++n;
	}

	public static int getN() {
		return n;
	}
}