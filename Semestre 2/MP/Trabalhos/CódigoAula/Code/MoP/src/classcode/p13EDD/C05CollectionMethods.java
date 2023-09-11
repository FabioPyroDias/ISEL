package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class C05CollectionMethods {

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
		Collection<String> container = new ArrayList<String>(Arrays.asList(
				"um", "dois", "três", "quatro"));

		printIterable(container);

		// boolean add(Object e);
		container.add("seis");

		// boolean addAll(Collection<? extends E> c);
		container.addAll(Arrays.asList("sete", "oito"));
		printIterable(container);

		// boolean contains(Object o);
		String obj = "quatro";
		System.out.println("Contains " + obj + "  -> "
				+ container.contains(obj));

		// boolean containsAll(Collection<?> c);
		Collection<String> objs = Arrays.asList("um", "oito");
		System.out.println("ContainsAll " + objs + "  -> "
				+ container.containsAll(objs));

		objs = Arrays.asList("um", "nove");
		System.out.println("ContainsAll " + objs + "  -> "
				+ container.containsAll(objs));

		// boolean remove(Object o);
		obj = "cinco";
		System.out.println("Remove " + obj + "  -> " + container.remove(obj));

		obj = "seis";
		System.out.println("Remove " + obj + "  -> " + container.remove(obj));

		// boolean removeAll(Collection<?> c);
		objs = Arrays.asList("um", "nove");
		System.out.println("RemoveAll " + objs + "  -> "
				+ container.removeAll(objs));
		printIterable(container);

		// boolean retainAll(Collection<?> c);
		objs = Arrays.asList("seis", "sete", "oito", "nove");
		System.out.println("retainAll " + objs + "  -> "
				+ container.retainAll(objs));
		printIterable(container);

		// boolean isEmpty();
		System.out.println("IsEmpty -> " + container.isEmpty());
		// int size();
		System.out.println("size -> " + container.size());

		// Object[] toArray();
		Object[] arrayObjs = container.toArray();
		System.out.println("toArray -> " + Arrays.toString(arrayObjs));

		// <T> T[] toArray(T[] a); //o array devolvido é do tipo T
		String[] arrayStrings = container.toArray(new String[container.size()]);
		System.out.println("toArray(String[]) -> "
				+ Arrays.toString(arrayStrings));

		// void clear();
		container.clear();
		System.out.println("After clear: size -> " + container.size());
		printIterable(container);
	}
}
