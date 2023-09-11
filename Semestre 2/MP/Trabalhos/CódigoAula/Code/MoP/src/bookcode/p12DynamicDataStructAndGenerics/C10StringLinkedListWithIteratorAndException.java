package bookcode.p12DynamicDataStructAndGenerics;

/**
 * Linked list with an iterator. One node is the "current node." Initially, the
 * current node is the first node. It can be changed to the next node until the
 * iteration has moved beyond the end of the list.
 */
public class C10StringLinkedListWithIteratorAndException {
	private ListNode head;
	private ListNode current;
	private ListNode previous;

	public C10StringLinkedListWithIteratorAndException() {
		head = null;
		current = null;
		previous = null;
	}

	public void addANodeToStart(String addData) {
		head = new ListNode(addData, head);
		if ((current == head.link) && (current != null))
			// if current is at old start node
			previous = head;
	}

	/**
	 * Sets iterator to beginning of list.
	 */
	public void resetIteration() {
		current = head;
		previous = null;
	}

	/**
	 * Returns true if iteration is not finished.
	 */
	public boolean moreToIterate() {
		return current != null;
	}

	/**
	 * Advances iterator to next node.
	 */
	public void goToNext() throws LinkedListException {
		if (current != null) {
			previous = current;
			current = current.link;
		} else if (head != null)
			throw new LinkedListException("Iterated too many times"
					+ " or uninitialized iteration.");
		else
			throw new LinkedListException("Iterating an empty " + "list.");
	}

	/**
	 * Returns the data at the current node.
	 */
	public String getDataAtCurrent() {
		String result = null;
		if (current != null)
			result = current.data;
		else {
			System.out.println("Getting data when current is not at any node.");
			System.exit(0);
		}
		return result;
	}

	/**
	 * Replaces the data at the current node. /* public void
	 * setDataAtCurrent(String newData) { if (current != null) { current.data =
	 * newData; } else { System.out.println(
	 * "Setting data when current is not at any node."); System.exit(0); } } /**
	 * Inserts a new node containing newData after the current node. The current
	 * node is the same after invocation as it is before. Precondition: List is
	 * not empty; current node is not beyond the entire list.
	 */
	public void insertNodeAfterCurrent(String newData) {
		ListNode newNode = new ListNode();
		newNode.data = newData;
		if (current != null) {
			newNode.link = current.link;
			current.link = newNode;
		} else if (head != null) {
			System.out.println("Inserting when iterator is past all "
					+ "nodes or is not initialized.");
			System.exit(0);
		} else {
			System.out.println("Using insertNodeAfterCurrent with empty list.");
			System.exit(0);
		}
	}

	/**
	 * Deletes the current node. After the invocation, the current node is
	 * either the node after the deleted node or null if there is no next node.
	 */
	public void deleteCurrentNode() {
		if ((current != null) && (previous != null)) {
			previous.link = current.link;
			current = current.link;
		} else if ((current != null) && (previous == null)) {// At head node
			head = current.link;
			current = head;
		} else // current==null
		{
			System.out
					.println("Deleting with uninitialized current or an empty "
							+ "list.");
			System.exit(0);
		}
	}

	// Returns a reference to the first node containing the
	// target data. If target is not on the list, returns null.
	private ListNode find(String target) {
		boolean found = false;
		ListNode position = head;
		while ((position != null) && !found) {
			String dataAtPosition = position.data;
			if (dataAtPosition.equals(target))
				found = true;
			else
				position = position.link;
		}
		return position;
	}

	/**
	 * Displays the data on the list.
	 */
	public void showList() {
		ListNode position = head;
		while (position != null) {
			System.out.println(position.data);
			position = position.link;
		}
	}

	/**
	 * Returns the number of nodes on the list.
	 */
	public int length() {
		int count = 0;
		ListNode position = head;
		while (position != null) {
			count++;
			position = position.link;
		}
		return count;
	}

	/**
	 * Sees whether target is on the list.
	 */
	public boolean onList(String target) {
		return (find(target) != null);
	}

	/**
	 * writes the list to a String
	 */
	public String[] toArray() {
		String[] anArray = new String[length()];
		ListNode position = head;
		int i = 0;
		while (position != null) {
			anArray[i] = position.data;
			i++;
			position = position.link;
		}
		return anArray;
	}

	/**
	 * List node - an inner class
	 */
	private class ListNode {
		private String data;
		private ListNode link;

		public ListNode() {
			link = null;
			data = null;
		}

		public ListNode(String newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		
		C10StringLinkedListWithIteratorAndException list = new C10StringLinkedListWithIteratorAndException();
		
		System.out.println("Inserting tree nodes...");
		list.addANodeToStart("One");
		list.addANodeToStart("Two");
		list.addANodeToStart("Three");

		System.out.println("\nTesting list.length...");
		System.out.println("List has " + list.length() + " entries.");

		System.out.println("\nTesting list.showList...");
		list.showList();

		System.out.println("\nTesting list.onList...");
		if (list.onList("Three"))
			System.out.println("Three is on list.");
		else
			System.out.println("Three is NOT on list.");

		// iterate
		System.out.println("\nIterating in the list...");
		int i = 0;
		list.resetIteration();
		try {
			while (list.moreToIterate()) {
				String elem = list.getDataAtCurrent();
				System.out.println("Elem [" + i++ + "] -> " + elem);
				list.goToNext();
			}
		} catch (LinkedListException e) {
			if (e.getMessage().equals("Iterating an empty list.")) {
				// This should never happen, butthe catch block is compulsory.
				System.out.println("Fatal Error.");
				System.exit(0);
			}
		}

		// testing delete
		System.out
				.println("\nlist.resetIteration() and list.deleteCurrentNode()");
		list.resetIteration();
		list.deleteCurrentNode();
		if (list.onList("Three"))
			System.out.println("Three is on list.");
		else
			System.out.println("Three is NOT on list.");

		System.out.println("\nDeleting more two nodes..");
		list.deleteCurrentNode();
		list.deleteCurrentNode();

		System.out.println("Start of list:");
		list.showList();
		System.out.println("End of list");

		System.out.println("\nCall goToNext with empty list..");
		try {
			list.goToNext();
		} catch (LinkedListException e) {
			System.out.println("Exception catched " + e
					+ ": goToNext called with list empty");
		}
	}

}

class LinkedListException extends Exception {
	private static final long serialVersionUID = 523533416833279769L;

	public LinkedListException() {
		super("Linked List Exception");
	}

	public LinkedListException(String message) {
		super(message);
	}
}
