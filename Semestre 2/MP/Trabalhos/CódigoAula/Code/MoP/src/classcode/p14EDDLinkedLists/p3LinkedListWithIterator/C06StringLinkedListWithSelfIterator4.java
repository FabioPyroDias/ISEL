package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

import java.util.*;

/**
 * Lista que implementa a interface de Iterator. Mas com iterador modelado como
 * uma classe. Permite obter vários iteradores.
 * 
 * O controle das alterações pelos vários iteradores segue o modelo utilizado na
 * plataforma Java. Ver código da classe java.util.LinkedList
 * 
 * @author António Teófilo
 * 
 */
public class C06StringLinkedListWithSelfIterator4<E> implements Iterable<E> {
	private ListNode head;

	private transient int modCount = 0;

	public C06StringLinkedListWithSelfIterator4() {
		head = null;
	}

	public void addANodeToStart(E addData) {
		head = new ListNode(addData, head);
		++modCount;
	}

	public void showList() {
		ListNode position;
		position = head;
		while (position != null) {
			System.out.println(position.data);
			position = position.link;
		}
	}

	/**
	 * Class LisNode
	 * 
	 */
	private class ListNode {
		private E data;

		private ListNode link;

		public ListNode(E newData, ListNode linkValue) {
			data = newData;
			link = linkValue;
		}
	}

	/**
	 * Method of Iterable interface
	 */
	public Iterator<E> iterator() {
		StringListIterator it = new StringListIterator();
		return it;
	}

	/**
	 * Class StringListIterator
	 * 
	 */
	public class StringListIterator implements Iterator<E> {

		private ListNode current = null; // elemento corrente a ser devolvido

		private ListNode previous = null; // follows current

		private boolean nextCalled = false; // true if next has called

		/**
		 * expectedModCount inicializado com o valor corrente de modCount -
		 * usado para verificar se houve alterações fora do iterador
		 */
		private int expectedModCount = modCount;

		/**
		 * Returns the next element (String) in the list. Throws a
		 * NoSuchElementException if there is no next element to return.
		 */
		public E next() {
			checkForConcurrentModifications();
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
		 * IllegalStateException if the next method has not yet been called or
		 * if the remove method has already been called after the last call to
		 * the next method.
		 */
		public void remove() {
			checkForConcurrentModifications();
			if (nextCalled) {
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
			} else {
				throw new IllegalStateException();
			}
			++modCount; // register an alteration
			++expectedModCount;
		}

		/**
		 * Returns true if there is at least one more element for next to
		 * return. Otherwise, returns false.
		 */
		public boolean hasNext() {
			// na plataforma não se executa esta verificação
			checkForConcurrentModifications();
			return (current != null ? current.link != null : previous == null
					&& head != null);
		}

		/**
		 * Método que verifica se ocorreu modificações fora deste iterador
		 * 
		 */
		private void checkForConcurrentModifications() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
	}
}