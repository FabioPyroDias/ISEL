package classcode.p14EDDLinkedLists.p3LinkedListWithIterator;

import java.util.Iterator;

/**
 * Com esta demo pretende-se demonstrar que a utilização de iteradores gera
 * excepções de concurrent modification quando um iterador está a iterarar e
 * ocorre uma alteração na lista fora da interface Iterator e no iterador em
 * questão.
 * 
 * @author António Teófilo
 * 
 */
public class C07StringLinkedListWithSelfIterator4Demo {
	public static void main(String[] args) {

		C06StringLinkedListWithSelfIterator4<String> stringList = new C06StringLinkedListWithSelfIterator4<String>();

		System.out.println("Lista de String ...");
		stringList.addANodeToStart("Hello");
		stringList.addANodeToStart("Good-bye");

		System.out.println("\nListagem da lista:");
		stringList.showList();

		Iterator<String> it1 = stringList.iterator();
		@SuppressWarnings("unused")
		Iterator<String> it2 = stringList.iterator();

		it1.next();
		it1.remove();
		// it2.next(); // teste1 - depois, comentar para ver teste 2
		// excepção devido a alteração através de iterador concorrente

		stringList.addANodeToStart("Hello");
		it1.next(); // teste 2 - excepção por alteração concorrente
		// mas devido a inserção directa na lista

	}
}
