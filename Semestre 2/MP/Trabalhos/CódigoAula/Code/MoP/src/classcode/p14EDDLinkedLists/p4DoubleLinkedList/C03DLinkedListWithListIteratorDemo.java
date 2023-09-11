package classcode.p14EDDLinkedLists.p4DoubleLinkedList;

import java.util.ListIterator;

/**
 * Com esta demo pretende-se demonstrar que a utilização de iteradores gera
 * excepções de concurrent modification quando um iterador está a iterarar e
 * ocorre uma alteração na lista fora da interface Iterator e no iterador em
 * questão.
 * 
 * @author António Teófilo
 * 
 */
public class C03DLinkedListWithListIteratorDemo {
	public static void main(String[] args) {

		C02DLinkedListWithListIterator<String> stringList = new C02DLinkedListWithListIterator<String>();

		ListIterator<String> it = stringList.listIterator();

		System.out.println("Lista de String ...");
		it.add("Hello");
		it.next();
		it.add("Good-bye");

		System.out.println("Listagem da lista: " + stringList);

		System.out.println("Listagem invertida da lista: "
				+ stringList.toStringInverted());

		System.out.println();
		//it.next(); // erro porque a inserção foi antes do elemento, logo o
					// current esta no fim da lista
		
		// remove all elements
		ListIterator<String> it2 = stringList.listIterator();
		System.out.println("Remoção de todos os elementos da lista.");
		while(it2.hasNext()) {
			String elem = it2.next();
			it2.remove();
			System.out.println("Removeu o elemento -> " + elem);
		}
	}
}
