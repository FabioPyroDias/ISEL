package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

public class C01LinkedListException extends Exception {

	private static final long serialVersionUID = -6207783708871573380L;

	public C01LinkedListException() {
		this(null);
	}

	public C01LinkedListException(String message) {
		super("Linked List Exception" + message);
	}
}
