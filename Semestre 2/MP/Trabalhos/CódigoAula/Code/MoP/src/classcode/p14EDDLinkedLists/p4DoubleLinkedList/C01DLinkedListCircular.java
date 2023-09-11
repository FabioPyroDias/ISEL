package classcode.p14EDDLinkedLists.p4DoubleLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Lista duplamente ligada com sentinela, circular e genérica. Para Fazer.
 */
public class C01DLinkedListCircular<E> implements Iterable<E>, List<E> {

	private DNode head = null;

	public C01DLinkedListCircular() {
		head = new DNode(null, null, null);
		head.next = head;
		head.previous = head;
	}

	public String toString() {
		// TODO return: elemtoString, elemtoString, ...
		return null;
	}

	public String toStringInverted() {
		// TODO Auto-generated method stub
		return null;
	}

	protected class DNode {
		public E element;
		public DNode next;
		public DNode previous;

		DNode(E element, DNode next, DNode previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

	/**
	 * Métodos da interface List<E>.
	 * 
	 */

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

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

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
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

	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("iterator");
	}

	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException("listIterator");
	}

}
