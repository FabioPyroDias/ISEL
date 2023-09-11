package bookcode.p08Inheritance;

import java.util.Arrays;

public class C19FruitDemo {
	public static void main(String[] args) {
		// create array of fruits
		C18Fruit[] fruits = new C18Fruit[4];

		// create fruits and place it in the array
		fruits[0] = new C18Fruit("Orange");
		fruits[1] = new C18Fruit("Apple");
		fruits[2] = new C18Fruit("Kiwi");
		fruits[3] = new C18Fruit("Durian");

		// call sort utility method in class Arrays
		Arrays.sort(fruits);

		// Output the sorted array of fruits
		for (C18Fruit f : fruits) {
			System.out.println(f.getName());
		}
	}
}
