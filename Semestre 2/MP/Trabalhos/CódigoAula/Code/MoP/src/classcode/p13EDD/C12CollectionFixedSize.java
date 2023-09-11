package classcode.p13EDD;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * From array to Collection/list and from Collection/List to Array
 */
public class C12CollectionFixedSize {

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

		// =================================================================
		// from array to List
		List<String> container = Arrays.asList("um", "dois", "três", "quatro");

		System.out.print("List<String> -> ");
		printIterable(container);

		// its a fixed size list - the list is a mapping to the array, any
		// change to the list will be done in the array

		// container.add("seis"); // not allowed

		// =================================================================
		// from Collection to Array
		String[] strings = container.toArray(new String[container.size()]);
		System.out.println("Arrays de Strings -> " + Arrays.toString(strings));
		
		container = Arrays.asList(strings);
		System.out.print("List<String> -> ");
		printIterable(container);
		
	}
}
