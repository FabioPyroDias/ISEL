package bookcode.p09ExceptionHandling;

public class C10UnknownColorException extends Exception {
	private static final long serialVersionUID = -3095274527451215297L;

	public C10UnknownColorException() {
		super("Unknown Color!");
	}

	public C10UnknownColorException(String message) {
		super(message);
	}
}
