package classcode.p13EDD;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Exemplo do for-each
 */
public class C04ForEach {

	public static void printIterable(Iterable<String> container) {
		System.out.print("[");
		boolean first = true;
		for (String str : container) {
			if (first)
				first = false;
			else
				System.out.print(", ");
			System.out.print(str);
		}
		System.out.println("]");
	}

	// uma segunda versão que pode receber um qualquer tipo
	public static <T> void printIterable2(Iterable<T> container) {
		System.out.print("[");
		boolean first = true;
		for (T str : container) {
			if (first)
				first = false;
			else
				System.out.print(", ");
			System.out.print(str);
		}
		System.out.println("]");
	}

	// uma segunda versão que pode receber um qualquer tipo
	public static <T> void printIterable3(Iterable<T> container) {
		System.out.print("[");
		boolean first = true;
		for (Iterator<T> it = container.iterator(); it.hasNext();) {
			T str = it.next();
			if (first)
				first = false;
			else
				System.out.print(", ");
			System.out.print(str);
		}
		System.out.println("]");
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		Iterable<String> it = Arrays.asList("um", "dois", "três", "quatro");
		printIterable(it);

		// printIterable2
		System.out.println("printIterable2");
		printIterable2(it);

		printIterable2(Arrays.asList(10, 20, 30));
		// printIterable(Arrays.asList(10, 20, 30));
		
		printIterable3(Arrays.asList(10, 20, 30));
	}
}

class Funcionario {

}

class Especialista extends Funcionario {

}
