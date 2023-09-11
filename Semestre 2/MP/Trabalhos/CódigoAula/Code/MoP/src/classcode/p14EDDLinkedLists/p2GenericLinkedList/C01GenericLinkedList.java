package classcode.p14EDDLinkedLists.p2GenericLinkedList;

import java.util.*;

/**
 * Este exemplo apenas acrescenta o facto de a lista ser genérica. É uma lista
 * simples sem sentinela
 */
public class C01GenericLinkedList<E> {
	private ListNode head;

	public C01GenericLinkedList() {
		head = null;
	}

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
	 * The added node will be the first node in the list.
	 */
	public void addANodeToStart(E addData) {
		head = new ListNode(addData, head);
	}

	public E deleteHeadNode() {
		E data = null;
		if (head != null) {
			data = head.data;
			head = head.link;
		} else {
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
		return data;
	}

	public boolean contains(E target) {
		return (find(target) != null);
	}

	/**
	 * Finds the first node containing the target data, and returns a reference
	 * to that node. If target is not in the list, null is returned.
	 */
	private ListNode find(E target) {
		ListNode currElem = head;
		while (currElem != null) {
			E data = currElem.data;
			if (data.equals(target))
				return currElem;
			currElem = currElem.link;
		}
		// target was not found.
		return null;
	}

	public void showList() {
		ListNode position = head;
		while (position != null) {
			System.out.println(position.data);
			position = position.link;
		}
	}

	// Obter um vector com a copia dos elementos
	public ArrayList<E> ArrayListCopy() {
		ArrayList<E> v = new ArrayList<E>(length());

		ListNode position;
		position = head;

		while (position != null) {
			v.add(position.data);
			position = position.link;
		}

		return v;
	}

	// esta classe é uma inner class (nested class)
	// a declaração do E está válida neste contexto
	// mas se a classe fosse declarada fora da classe principal
	// já teria que ter: class LisNode<E> {
	private class ListNode {
		private E data;
		private ListNode link;

		public ListNode(E newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}

}
