package bookcode.p08Inheritance;

import java.util.Arrays;

/*
 * The execution of this class will throw an exception because Fruit is not Comparable
 */
public class C17FruitDemo {

	public static void main(String[] args) {
		// create array of fruits
		C16Fruit[] fruits = new C16Fruit[4];

		// create fruits and place it in the array
		fruits[0] = new C16Fruit("Orange");
		fruits[1] = new C16Fruit("Apple");
		fruits[2] = new C16Fruit("Kiwi");
		fruits[3] = new C16Fruit("Durian");

		// call sort utility method in class Arrays - it will not work, it will
		// throw an exception of ClassCastexception
		Arrays.sort(fruits);

		// Output the sorted array of fruits
		for (C16Fruit f : fruits) {
			System.out.println(f.getName());
		}
	}
}
