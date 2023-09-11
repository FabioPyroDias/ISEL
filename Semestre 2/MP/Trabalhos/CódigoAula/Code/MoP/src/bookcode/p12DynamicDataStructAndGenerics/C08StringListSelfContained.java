package bookcode.p12DynamicDataStructAndGenerics;

/**
 * A linked list with a inner class that implements the list node
 */
public class C08StringListSelfContained {
	private ListNode head;

	public C08StringListSelfContained() {
		head = null;
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
	 * Adds a node containing the data addData at the start of the list.
	 */
	public void addANodeToStart(String addData) {
		head = new ListNode(addData, head);
	}

	/**
	 * Deletes the first node on the list.
	 */
	public void deleteHeadNode() {
		if (head != null)
			head = head.link;
		else {
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}

	/**
	 * Sees whether target is on the list.
	 */
	public boolean onList(String target) {
		return (find(target) != null);
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
	 * Inner class list node
	 */
	private class ListNode {
		private String data;
		private ListNode link;

		// public ListNode() {
		// link = null;
		// data = null;
		// }

		public ListNode(String newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// create the list
		C08StringListSelfContained list = new C08StringListSelfContained();

		// add some items
		list.addANodeToStart("One");
		list.addANodeToStart("Two");
		list.addANodeToStart("Three");

		// show the list contents
		System.out.println("List has " + list.length() + " entries.");
		list.showList();

		if (list.onList("Three"))
			System.out.println("Three is on list.");
		else
			System.out.println("Three is NOT on list.");

		// delete node
		list.deleteHeadNode();
		if (list.onList("Three"))
			System.out.println("Three is on list.");
		else
			System.out.println("Three is NOT on list.");

		// delet more nodes
		list.deleteHeadNode();
		list.deleteHeadNode();

		System.out.println("Start of list:");
		list.showList();
		System.out.println("End of list");
	}
}