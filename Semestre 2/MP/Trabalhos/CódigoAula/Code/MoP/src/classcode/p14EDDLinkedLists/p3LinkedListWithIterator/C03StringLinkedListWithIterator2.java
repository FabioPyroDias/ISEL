package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

import java.util.*;

/**
 * List simples com head, current, previous e twoBack e que implementa a
 * interface Iterator
 * 
 * A lista tem a noção de iteração corrente
 * 
 * 
 */
public class C03StringLinkedListWithIterator2<E> implements Iterator<E> {
	private ListNode head;

	private ListNode current; // next element to be returned

	private ListNode previous; // follows current element

	private ListNode twoBack; // follows previous

	/**
	 * removeSinceNext is true if removed has been called since the last
	 * invocation of next. Also true if next has not been called at all.
	 */
	private boolean removeSinceNext;

	public C03StringLinkedListWithIterator2() {
		head = null;
		current = null;
		previous = null;
		twoBack = null;
		removeSinceNext = true;
	}

	/**
	 * Returns the next element (E) in the list. Throws a NoSuchElementException
	 * if there is no next element to return. You should invoke resetIteration
	 * before the first invocation of next( ).
	 */
	public E next() {
		if (current != null) {
			twoBack = previous;
			previous = current;
			current = current.link;
			removeSinceNext = false;
			return (previous.data);
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Removes the last element that was returned by next. Throws an
	 * IllegalStateException if the next method has not yet been called or if
	 * the remove method has already been called after the last call to the next
	 * method.
	 */
	public void remove() {
		if ((previous != null) && (!removeSinceNext)) {
			if (twoBack != null) {
				// remove node at previous
				twoBack.link = previous.link;
				previous = twoBack;
				removeSinceNext = true;
				// twoBack not updated until next invocation of next( )
			} else {
				// at head node after deletion
				head = current;
				previous = null;
				twoBack = null;
				removeSinceNext = true;
			}
		} else {
			throw new IllegalStateException();
		}
	}

	/**
	 * Returns true if there is at least one more element for next to return.
	 * Otherwise, returns false.
	 */
	public boolean hasNext() {
		return (current != null);
	}

	public void resetIteration() {
		current = head;
		previous = null;
		twoBack = null;
		removeSinceNext = true;
	}

	public E getDataAtCurrent() throws C01LinkedListException {
		if (current != null)
			return (current.data);
		else
			throw new C01LinkedListException(
					"Getting data when current is not at any node.");
	}

	public void resetDataAtCurrent(E newData) throws C01LinkedListException {
		if (current != null)
			current.data = newData;
		else
			throw new C01LinkedListException(
					"Setting data when current is not at any node.");
	}

	/**
	 * Inserts node with newData after the current node. The current node is the
	 * same after invocation as it is before invocation. Should not be used with
	 * an empty list. Should not be used when the current node has iterated past
	 * the entire list.
	 */
	public void insertNodeAfterCurrent(E newData) throws C01LinkedListException {
		ListNode newNode = new ListNode();
		newNode.data = newData;
		if (current != null) {
			newNode.link = current.link;
			current.link = newNode;
		} else if (head != null) {
			throw new C01LinkedListException("Inserting when iterator is past all"
					+ " nodes or uninitialized iterator.");
		} else {
			throw new C01LinkedListException(
					"Using insertNodeAfterCurrent with empty list.");
		}
	}

	/**
	 * Deletes current node. After the invocation, the current node is the node
	 * after the deleted node, or null if there is no next node.
	 */
	public void deleteCurrentNode() throws C01LinkedListException {
		if ((current != null) && (previous != null)) {
			previous.link = current.link;
			current = current.link;
		} else if ((current != null) && (previous == null)) {// At head node
			head = current.link;
			current = head;
		} else // current == null
		{
			throw new C01LinkedListException("Deleting with uninitialized current"
					+ " or an empty list.");
		}
	}

	/**
	 * Returns the number of nodes in the list.
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

	public void addANodeToStart(E addData) {
		head = new ListNode(addData, head);
		if (current == head.link && current != null)
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
		E dataAtPosition;
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

	// public E[] arrayCopy2() {
	// E[] a = new E[length()];
	//
	// ListNode position;
	// position = head;
	// int i = 0;
	// while (position != null) {
	// a[i] = position.data;
	// i++;
	// position = position.link;
	// }
	//
	// return a;
	// }

	private class ListNode {
		private E data;

		private ListNode link;

		public ListNode() {
			link = null;
			data = null;
		}

		public ListNode(E newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}
}