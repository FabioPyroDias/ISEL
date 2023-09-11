package bookcode.p12DynamicDataStructAndGenerics;

import java.util.HashSet;

/**
 * HashSet demo
 */
public class C02HashSetDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// create a HashSet and add data to it
		HashSet<Integer> intSet = new HashSet<Integer>();
		intSet.add(2);
		intSet.add(7);
		intSet.add(7);
		intSet.add(3);

		// print it
		printSet(intSet);
		System.out.println("Set by toString -> " + intSet);

		// remove an element from it
		intSet.remove(3);
		System.out.println();
		printSet(intSet);

		// test if it contains certain elements
		System.out.println("\nSet contains 2: " + intSet.contains(2));
		System.out.println("Set contains 3: " + intSet.contains(3));
	}

	/**
	 * the print hasSet method
	 */
	public static void printSet(HashSet<Integer> intSet) {
		System.out.print("The set contains: [ ");
		for (Object obj : intSet.toArray()) {
			Integer num = (Integer) obj;
			System.out.print(num.intValue() + " ");
		}
		System.out.println("]");
	}
}
