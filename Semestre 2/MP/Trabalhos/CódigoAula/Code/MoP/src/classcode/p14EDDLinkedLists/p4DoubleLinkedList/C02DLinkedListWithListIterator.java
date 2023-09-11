package classcode.p14EDDLinkedLists.p4DoubleLinkedList;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Lista duplamente ligada com sentinela e genérica. Implementa a interface
 * ListIterator.
 */
public class C02DLinkedListWithListIterator<E> implements Iterable<E>, List<E> {

	private DNode head = new DNode(null, null, null);
	private int modCount = 0;

	/**
	 * O iterador normal, só forward
	 */
	public Iterator<E> iterator() {
		ListIterator<E> it = new DListIterator();
		return it;
	}

	/**
	 * O iterador forward e backward
	 */
	public ListIterator<E> listIterator() {
		ListIterator<E> it = new DListIterator();
		return it;
	}

	public String toString() {
		ListIterator<E> li = listIterator();
		String str = "";
		while (li.hasNext()) {
			E elem = li.next();
			str += elem;
			if (li.hasNext()) {
				str += ", ";
			}
		}
		return str;
	}

	public String toStringInverted() {
		ListIterator<E> li = listIterator();
		E lastElem = null;
		while (li.hasNext()) {
			lastElem = li.next();
		}
		String str = lastElem.toString();
		while (li.hasPrevious()) {
			E elem = li.previous();
			str += ", " + elem;
		}
		return str;
	}

	/**
	 * ListIterator - Este iterador permite deslocar para a frente e para trás e
	 * aceder por index.
	 * 
	 */
	public class DListIterator implements ListIterator<E> {
		private DNode current = head;

		private boolean validData = false; // true if next/previous has called

		private int expectedModCount = modCount; // valor inicial

		/**
		 * Returns the next element (String) in the list.
		 */
		public E next() {
			checkForConcurrentModifications();
			if (head.next == null) {
				throw new NoSuchElementException();
			}
			if (current.next != null) {
				current = current.next;
			} else {
				throw new NoSuchElementException();
			}
			validData = true;
			return (current.element);
		}

		public E previous() {
			checkForConcurrentModifications();
			if (head.next == null) {
				throw new NoSuchElementException();
			}
			if (current.previous != head) {
				current = current.previous;
			} else {
				throw new NoSuchElementException();
			}
			validData = true;
			return (current.element);
		}

		/**
		 * Removes the last element that was returned by next or previous.
		 * Throws an IllegalStateException if the next/previous method has not
		 * yet been called or if the remove/add method has already been called
		 * after the last call to the next/previous method.
		 */
		public void remove() {
			checkForConcurrentModifications();
			if (validData) {
				if (head.next == null) {
					throw new NoSuchElementException();
				}
				DNode aux = current.previous;
				aux.next = current.next;
				if (current.next != null) {
					current.next.previous = aux;
				}
				current = aux;
				validData = false;
			} else {
				throw new IllegalStateException();
			}
			++modCount; // register an alteration
			++expectedModCount;
		}

		/**
		 * Insert before the implicit cursor. The new element is returned only
		 * by call to previous, except if is the unique element.
		 */
		public void add(E e) {
			checkForConcurrentModifications();
			DNode elem = new DNode(e, null, null);
			if (validData) {
				// insercao antes de current
				current.previous.next = elem;
				elem.previous = current.previous;
				elem.next = current;
				current.previous = elem;
				// current remains on the same element
				validData = false;
			} else {
				if (head.next == null) {
					// inserção como único elemento
					elem.previous = head;
					head.next = elem;
				} else {
					throw new IllegalStateException();
				}
			}
			++modCount; // register an alteration
			++expectedModCount;
		}

		public boolean hasNext() {
			// na plataforma não se executa esta verificação
			checkForConcurrentModifications();
			return (current.next != null);
		}

		public boolean hasPrevious() {
			checkForConcurrentModifications();
			return (current.previous != head);
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

		/**
		 * Mais métodos da interface ListIterator
		 */

		/**
		 * Retorna o index do próximo element a ser devolvido pelo next
		 */
		public int nextIndex() {
			checkForConcurrentModifications();
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * Retorna o index do próximo element a ser devolvido pelo previous
		 */
		public int previousIndex() {
			checkForConcurrentModifications();
			// TODO Auto-generated method stub
			return 0;
		}

		public void set(E e) {
			checkForConcurrentModifications();
			if (validData) {
				current.element = e;
			} else {
				throw new IllegalStateException();
			}
		}
	}

	private class DNode {
		E element;
		DNode next;
		DNode previous;

		DNode(E element, DNode next, DNode previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

	/**
	 * Métodos da interface List<E>. São métodos que manipulam directamente a
	 * lista sem usar qualquer iterador. Qualquer um deles que altere a lista
	 * deve incrementar o modCount.
	 * 
	 */

	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
