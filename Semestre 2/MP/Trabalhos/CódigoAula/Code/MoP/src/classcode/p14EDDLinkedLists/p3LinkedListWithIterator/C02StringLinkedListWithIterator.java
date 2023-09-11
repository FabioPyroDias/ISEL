package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

/**
 * Linked list with a notion of "current node." The current node can be changed
 * to the next node with the method goToNext. At any time after the iteration is
 * Initialised, one node is the current node, until the iteration has moved
 * beyond the end of the list.
 * 
 * A lista tem a noção de iteração. Lista com head, current e previous.
 * 
 * New methods: resetIteration goToNext moreToIterate getDataAtCurrent
 * resetDataAtCurrent insertNodeAfterCurrent deleteCurrentNode
 * 
 */
public class C02StringLinkedListWithIterator {
	private ListNode head;

	private ListNode current;

	private ListNode previous;

	public C02StringLinkedListWithIterator() {
		head = null;
		current = null;
		previous = null;
	}

	/**
	 * Retorna o número de nós da lista.
	 */
	public int length() {
		int count = 0;
		ListNode position = head;
		while (position != null) {
			position = position.link;
			count++;
		}
		return count;
	}

	public void addANodeToStart(String addData) {
		head = new ListNode(addData, head);
		if (current != null && current == head.link)
			// if current is at old start node
			previous = head;
	}

	public boolean contains(String target) {
		return (Find(target) != null);
	}

	/**
	 * Returns a reference to the first node containing the target data. If
	 * target is not in the list, null is returned.
	 */
	private ListNode Find(String target) {
		ListNode position;
		position = head;
		String dataAtPosition;
		while (position != null) {
			dataAtPosition = position.data;
			if (dataAtPosition.equals(target))
				return position;
			position = position.link;
		}
		// target was not found
		return null;
	}

	public void showList() {
		ListNode position;
		position = head;
		while (position != null) {
			System.out.println(position.data);
			position = position.link;
		}
	}

	public String[] arrayCopy() {
		String[] a = new String[length()];

		ListNode position = head;
		int i = 0;
		while (position != null) {
			a[i] = position.data;
			i++;
			position = position.link;
		}

		return a;
	}

	public void resetIteration() {
		current = head;
		previous = null;
	}

	public void goToNext() {
		if (current != null) {
			previous = current;
			current = current.link;
		} else if (head != null) {
			System.out
					.println("Iterated too many times or uninitialized iteration.");
			System.exit(0);
		} else {
			System.out.println("Iterating with an empty list.");
			System.exit(0);
		}
	}

	public boolean moreToIterate() {
		return (current != null);
	}

	public String getDataAtCurrent() {
		if (current != null)
			return (current.data);
		else {
			throw new IllegalStateException();
		}
	}

	public void resetDataAtCurrent(String newData) {
		if (current != null) {
			current.data = newData;
		} else {
			System.out.println("Setting data when current is not at any node.");
			System.exit(0);
		}
	}

	/**
	 * Inserts node with newData after the current node. The current node is the
	 * same after invocation as it is before invocation. Should not be used with
	 * an empty list. Should not be used when the current node has iterated past
	 * the entire list.
	 */
	public void insertNodeAfterCurrent(String newData) {
		ListNode newNode = new ListNode();
		newNode.data = newData;
		if (current != null) {
			newNode.link = current.link;
			current.link = newNode;
		} else if (head != null) {
			System.out.println("Inserting when iterator is past all "
					+ "nodes or uninitialized iterator.");
			System.exit(0);
		} else {
			System.out.println("Using insertNodeAfterCurrent with empty list.");
			System.exit(0);
		}
	}

	/**
	 * Deletes the current node. After the invocation, the current node is the
	 * node after the deleted node or null if there is no next node.
	 */
	public void deleteCurrentNode() {
		if (current != null) {
			if (previous != null) {
				// nota at head node
				previous.link = current.link;
				current = current.link;
			} else {
				// at head node
				head = current.link;
				current = head;
			}
		} else { // current == null
			System.out
					.println("Deleting with uninitialized current or an empty list.");
			System.exit(0);
		}
	}

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
}
