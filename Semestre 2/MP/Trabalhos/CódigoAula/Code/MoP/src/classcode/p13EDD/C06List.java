package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class C06List {

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

	public static void main(String[] args) {
		List<String> container = new ArrayList<String>(Arrays.asList("um",
				"dois", "três", "quatro"));
		printIterable(container);

		// void add(int index, E element);
		System.out.println("add xxx at 3:");
		container.add(3, "xxx");
		printIterable(container);

		// boolean addAll(int index, Collection<? extends E> c);
		container.addAll(4, Arrays.asList("sete", "oito"));
		printIterable(container);

		// boolean equals(Object o); // true is both lists are equal
		System.out
				.println("equals [um, dois, três, xxx, sete, oito, quatro] -> "
						+ container.equals((Object) (Arrays
								.asList("um", "dois", "três", "xxx", "sete",
										"oito", "quatro"))));

		// E get(int index);
		System.out.println("get(2) -> " + container.get(2));

		// E set(int index, E element); // returns the old element
		System.out.println("set(2, Nove,) -> " + container.set(2, "nove"));
		printIterable(container);

		// int indexOf(Object o); // index of first occurrence
		System.out.println("indexOf(sete) -> " + container.indexOf("sete"));

		// List<E> subList(int fromIndex, int toIndex);
		System.out.println("SubList(2, 5) -> " + container.subList(2, 5));

		// int lastIndexOf(Object o); // index of last occurrence
		container.add("sete");
		printIterable(container);
		System.out.println("lastIndexOf(sete) -> "
				+ container.lastIndexOf("sete"));

		// E remove(int index); // return the removed element
		System.out.println("remove(2) -> " + container.remove(2));
		printIterable(container);
	}
}
