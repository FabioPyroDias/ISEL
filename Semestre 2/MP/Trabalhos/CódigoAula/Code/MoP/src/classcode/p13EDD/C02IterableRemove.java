package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class C02IterableRemove {

	/**
	 * Print
	 */
	public static void printIterable(Iterable<String> container) {
		Iterator<String> it = container.iterator();
		System.out.print("[");
		while (it.hasNext()) {
			System.out.print(it.next());
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * remove strings with n chars
	 */
	public static void removeWordsWithNChars(Iterable<String> container,
			int nChars) {
		Iterator<String> it = container.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.length() == nChars)
				it.remove();
		}
	}

	/**
	 * remove all strings
	 */
	public static void removeAll(Iterable<String> container) {
		Iterator<String> it = container.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	public static void main(String[] args) {

		// Um ArrayList é um contentor dinâmico baseado num array
		Iterable<String> itStrings = new ArrayList<String>(Arrays.asList("um",
				"dois", "três", "quatro"));

		// mostrar conteúdo
		printIterable(itStrings);

		// remover as String com size == 4
		removeWordsWithNChars(itStrings, 4);
		// mostrar o contentor sem essas strings
		printIterable(itStrings);

		// remover os restantes elementos
		removeAll(itStrings);
		// mostrar
		printIterable(itStrings);
	}
}
