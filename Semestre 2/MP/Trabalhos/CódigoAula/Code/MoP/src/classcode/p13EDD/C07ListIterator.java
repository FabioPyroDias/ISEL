package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class C07ListIterator {

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

	public static void printReverse(List<String> container) {
		ListIterator<String> it = container.listIterator(container.size());

		// come to the beginning
		System.out.print("Reversed -> [");
		while (it.hasPrevious()) {
			System.out.print(it.previous());
			if (it.hasPrevious())
				System.out.print(", ");
		}
		System.out.println("]");

		// boolean add(Object e);
		it.add("seis");
		it.add("sete");
		printIterable(container);
	}

	public static void main(String[] args) {
		List<String> container = new ArrayList<String>(Arrays.asList("um",
				"dois", "três", "quatro"));
		printIterable(container);

		printReverse(container);

		// boolean add(Object e);
		System.out.println("add seis -> " + container.add(".."));
		printIterable(container);
	}
}
