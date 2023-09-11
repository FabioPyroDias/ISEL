package bookcode.p12DynamicDataStructAndGenerics;

import java.util.ArrayList;

/**
 * A Generic Linked list
 */
public class C12LinkedList2<E> {

	// head node
	private ListNode head;

	/**
	 * constructor
	 */
	public C12LinkedList2() {
		head = null;
	}

	/**
	 * show method
	 */
	public void showList() {
		ListNode position = head;
		while (position != null) {
			System.out.println(position.getData());
			position = position.getLink();
		}
	}

	/**
	 * length
	 */
	public int length() {
		int count = 0;
		ListNode position = head;
		while (position != null) {
			count++;
			position = position.getLink();
		}
		return count;
	}

	/**
	 * addANodeToStart
	 */
	public void addANodeToStart(E addData) {
		head = new ListNode(addData, head);
	}

	/**
	 * deleteHeadNode
	 */
	public void deleteHeadNode() {
		if (head != null) {
			head = head.getLink();
		} else {
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}

	/**
	 * onList
	 */
	public boolean onList(E target) {
		return find(target) != null;
	}

	/**
	 * find
	 */
	private ListNode find(E target) {
		ListNode position = head;
		while (position != null) {
			E dataAtPosition = position.getData();
			if (dataAtPosition.equals(target))
				return position;
			else
				position = position.getLink();
		}
		return null;
	}

	/**
	 * toArrayList
	 */
	public ArrayList<E> toArrayList() {
		ArrayList<E> list = new ArrayList<E>(length());
		ListNode position = head;
		while (position != null) {
			list.add(position.data);
			position = position.link;
		}
		return list;
	}

	/**
	 * List node - an inner class
	 */
	private class ListNode {

		private E data;
		private ListNode link;

		// public ListNode() {
		// link = null;
		// data = null;
		// }

		public ListNode(E newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}

		public E getData() {
			return data;
		}

		public ListNode getLink() {
			return link;
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// String list demo
		C12LinkedList2<String> stringList = new C12LinkedList2<String>();
		// add nodes
		stringList.addANodeToStart("Hello");
		stringList.addANodeToStart("Good-bye");

		// show its data
		System.out.println(stringList.toArrayList());
		stringList.showList();

		// Integer list demo
		C12LinkedList2<Integer> numberList = new C12LinkedList2<Integer>();
		// add some items
		for (int i = 0; i < 5; i++)
			numberList.addANodeToStart(i);

		// show its data
		System.out.println(numberList.toArrayList());

		// delete head node
		numberList.deleteHeadNode();

		// show its data
		numberList.showList();
	}

}
