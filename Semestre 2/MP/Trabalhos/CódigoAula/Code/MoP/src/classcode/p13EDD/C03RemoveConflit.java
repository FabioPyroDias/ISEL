package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Teste que utiliza dois iteradores e faz alterações com um deles e o outro
 * fica inválido
 */
public class C03RemoveConflit {

	public static void createRemoveConflict(Iterable<String> container) {
		Iterator<String> it1 = container.iterator();
		Iterator<String> it2 = container.iterator();

		// could be used or not
//		if (it1.hasNext())
//			it1.next();

		// Initialising It2 and remove with it
		if (it2.hasNext()) {
			String s = it2.next();
			System.out.println(s);
			it2.remove();
		}

		// hasNext do not throw the exception
		System.out.println("it1.hasNext() -> " + it1.hasNext());

		// use of it1, will throw exception
		//it1.remove();
		System.out.println(it1.next());
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		ArrayList<String> container = new ArrayList<String>(Arrays.asList("um",
				"dois", "três", "quatro"));

		createRemoveConflict(container);
	}
}
