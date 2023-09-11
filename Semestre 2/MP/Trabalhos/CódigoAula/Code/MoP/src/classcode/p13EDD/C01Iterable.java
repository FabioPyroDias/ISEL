package classcode.p13EDD;

import java.util.Arrays;
import java.util.Iterator;

public class C01Iterable {

	/**
	 * Método que recebe algo Iterable e vai iterar sobre os elementos
	 */
	public static void printIterable(Iterable<String> container) {
		// obtém o iterador
		Iterator<String> it = container.iterator();
		System.out.print("[");
		// pergunta se há mais elementos
		while (it.hasNext()) {
			// obtém o próximo elemento e mostra-o
			System.out.print(it.next());
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// Arrays.asList cria um array com os elementos e devolve uma List de
		// tamanho fixo com esses valores
		Iterable<String> itStrings = Arrays.asList("um", "dois", "três",
				"quatro");
		// List<String> g;

		// chamar o método que vai iterar sobre os elementos
		printIterable(itStrings);
	}

}
