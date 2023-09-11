package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

import java.util.*;

/**
 * 
 * Lista com head, current, previous, que implementa a interface Iterator
 * 
 * A lista tem a noção de iteração. A iteração NÃO PERMITE MODIFICAÇÕES
 * CONCORRENTES. É um exemplo simples de como uma inserção fora do iterador
 * invalida a iteração corrente
 * 
 * @author António Teófilo
 * 
 */
public class C04StringLinkedListWithIterator3<E> implements Iterator<E> {
	private ListNode head;

	private ListNode current; // elemento corrente a ser devolvido

	private ListNode previous; // follows current

	private boolean nextCalled; // true if next has called

	private boolean insertDone; // true if insert has done

	public C04StringLinkedListWithIterator3() {
		head = null;
		resetIteration();
	}

	/**
	 * Returns the next element (String) in the list. Throws a
	 * NoSuchElementException if there is no next element to return.
	 */
	public E next() {
		if (insertDone) {
			throw new IllegalStateException("List modified");
		}
		if (head == null) {
			throw new NoSuchElementException();
		}
		if (current == null && previous == null) {
			// primeira vez que o next é chamado
			current = head;
		} else if (current != null && current.link != null) {
			previous = current;
			current = current.link;

		} else {
			throw new NoSuchElementException();
		}
		nextCalled = true;
		return (current.data);
	}

	/**
	 * Removes the last element that was returned by next. Throws an
	 * IllegalStateException if the next method has not yet been called or if
	 * the remove method has already been called after the last call to the next
	 * method.
	 */
	public void remove() {
		if (insertDone) {
			throw new IllegalStateException("List modified.");
		}
		if (!nextCalled) {
			throw new IllegalStateException("Double remotion.");
		}
		if (previous != null) {
			// remove on middle of list
			previous.link = current.link;
			current = previous;
		} else {
			// remove at head
			head = current.link;
			current = null;
		}
		nextCalled = false;
	}

	/**
	 * Returns true if there is at least one more element for next to return.
	 * Otherwise, returns false.
	 */
	public boolean hasNext() {
		if (insertDone) {
			throw new IllegalStateException("List modified");
		}
		return (current != null ? current.link != null : previous == null
				&& head != null);
	}

	/* outros métodos */

	public void resetIteration() {
		current = null;
		previous = null;
		nextCalled = false;
		insertDone = false;
	}

	public void addANodeToStart(E addData) {
		head = new ListNode(addData, head);
		if (current == head.link && current != null) {
			// if current is at old start node
			previous = head;
		}
		insertDone = true;
	}

	public void showList() {
		ListNode position;
		position = head;
		while (position != null) {
			System.out.println(position.data);
			position = position.link;
		}
	}

	private class ListNode {
		private E data;

		private ListNode link;

		public ListNode(E newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}
}