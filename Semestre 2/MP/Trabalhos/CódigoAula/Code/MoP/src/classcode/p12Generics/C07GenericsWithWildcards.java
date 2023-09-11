package classcode.p12Generics;

import java.util.Arrays;
import java.util.Comparator;

public class C07GenericsWithWildcards {

	/**
	 * More use cases of generics with wildcards
	 */
	public static void main(String[] args) {

		// método: static Class<?> Class.forName(String className)

		try {
			// devolve um objecto que descreve a class indicada na string
			Class<?> theClass = Class.forName("classcode.p12Generics.C01Box1");

			// com esse objecto podemos perguntar-lhe pelo seu conteúdo
			System.out.println("theClass.getName() -> " + theClass.getName());
			System.out.println("theClass.getPackage() -> "
					+ theClass.getPackage());
			System.out.println("theClass.getSimpleName() -> "
					+ theClass.getSimpleName());
			System.out.println("theClass.getName() -> "
					+ theClass.getSuperclass());

			System.out.println("Class methods: "
					+ Arrays.toString(theClass.getMethods()));

			// esta funcionalidade que permite obter a descrição de uma classe
			// designa-se de Reflection

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println();

		// outro exemplo

		// uso de:
		// static <T> int binarySearch(T[] a, T key, Comparator<? super T> c)

		Dog[] arrayDogs = { new Dog("Biddu"), new Dog("Chispa"),
				new Dog("Mogul"), new Dog("Zinga") };
		System.out.println("arrayDogs -> " + Arrays.toString(arrayDogs));

		int res = Arrays.binarySearch(arrayDogs, new Dog("Mogul"),
				Pet.PetComparator.getcomparator());
		System.out.println("binarySearch Dog(\"Mogul\") returned -> " + res);
	}
}

class Pet {
	private String name;

	public Pet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	static class PetComparator implements Comparator<Pet> {
		static Comparator<Pet> COMP = new PetComparator();

		public int compare(Pet o1, Pet o2) {
			return o1.name.compareTo(o2.name);
		}

		static public Comparator<Pet> getcomparator() {
			return COMP;
		};
	}

	public String toString() {
		return getClass().getSimpleName() + " " + name;
	}
}

class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}
}
