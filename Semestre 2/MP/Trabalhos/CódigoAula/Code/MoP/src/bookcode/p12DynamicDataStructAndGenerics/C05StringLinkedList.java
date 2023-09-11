package bookcode.p12DynamicDataStructAndGenerics;

/**
 * The linked list of strings
 */
public class C05StringLinkedList {

	// the head of the list
	private C04ListNode head;

	// constructor
	public C05StringLinkedList() {
		head = null;
	}

	/**
	 * Displays the data on the list.
	 */
	public void showList() {
		C04ListNode position = head;
		while (position != null) {
			System.out.println(position.getData());
			position = position.getLink();
		}
	}

	/**
	 * Returns the number of nodes on the list.
	 */
	public int length() {
		int count = 0;
		C04ListNode position = head;
		while (position != null) {
			count++;
			position = position.getLink();
		}
		return count;
	}

	/**
	 * Adds a node containing the data addData at the start of the list.
	 */
	public void addANodeToStart(String addData) {
		head = new C04ListNode(addData, head);
	}

	/**
	 * Deletes the first node on the list.
	 */
	public void deleteHeadNode() {
		if (head != null)
			head = head.getLink();
		else {
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}

	/**
	 * Sees whether target is on the list.
	 */
	public boolean onList(String target) {
		return find(target) != null;
	}

	// Returns a reference to the first node containing the
	// target data. If target is not on the list, returns null.
	private C04ListNode find(String target) {
		boolean found = false;
		C04ListNode position = head;
		while ((position != null) && !found) {
			String dataAtPosition = position.getData();
			if (dataAtPosition.equals(target))
				found = true;
			else
				position = position.getLink();
		}
		return position;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// create the list
		C05StringLinkedList list = new C05StringLinkedList();

		// add some nodes
		list.addANodeToStart("One");
		list.addANodeToStart("Two");
		list.addANodeToStart("Three");

		// show the list
		System.out.println("List has " + list.length() + " entries.");
		list.showList();

		// check if node is on the list
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

		// delete more nodes
		list.deleteHeadNode();
		list.deleteHeadNode();

		System.out.println("Start of list:");
		list.showList();
		System.out.println("End of list");
	}
}
