package bookcode.p12DynamicDataStructAndGenerics;

import java.util.HashMap;

/**
 * HashMap demo
 */
public class C03HashMapDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// the hasMap and its data
		HashMap<String, Integer> mountains = new HashMap<String, Integer>();
		mountains.put("Everest", 29029);
		mountains.put("K2", 28251);
		mountains.put("Kangchenjunga", 28169);
		mountains.put("Denali", 20335);

		// print the map
		printMap(mountains);

		// check the contains method
		System.out.println("Denali in the map: "
				+ mountains.containsKey("Denali"));
		System.out.println();

		// changing data
		System.out.println("Changing height of Denali.");
		mountains.put("Denali", 20320);
		printMap(mountains);

		// removing data
		System.out.println("Removing Kangchenjunga.");
		mountains.remove("Kangchenjunga");
		printMap(mountains);
	}

	/**
	 * print map method
	 */
	public static void printMap(HashMap<String, Integer> map) {
		System.out.println("Map contains:");
		// use the set of keys and the enumerate to the for each
		for (String keyMountainName : map.keySet()) {
			Integer height = map.get(keyMountainName);
			System.out.println(keyMountainName + " --> " + height.intValue()
					+ " feet.");
		}
		System.out.println();
	}
}
