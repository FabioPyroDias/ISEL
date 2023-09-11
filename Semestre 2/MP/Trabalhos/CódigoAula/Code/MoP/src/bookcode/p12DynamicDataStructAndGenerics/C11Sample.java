package bookcode.p12DynamicDataStructAndGenerics;

import bookcode.p05ClassesAndMethods.C18SpeciesEqualsMethod;

/**
 * A Generic class
 */
public class C11Sample<T> {

	private T data;

	public void setData(T newValue) {
		data = newValue;
	}

	public T getData() {
		return data;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// =======================================================
		// a class that could support an object of class String
		C11Sample<String> sample1 = new C11Sample<String>();
		sample1.setData("Hello");

		// =======================================================
		// a class that could support an object of class Species
		C11Sample<C18SpeciesEqualsMethod> mySpeciesSingleContainer = new C11Sample<C18SpeciesEqualsMethod>();

		C18SpeciesEqualsMethod creature = new C18SpeciesEqualsMethod();
		creature.set("frog", 200, 2000);

		// set data
		mySpeciesSingleContainer.setData(creature);

		// get data, see: no cast
		C18SpeciesEqualsMethod myFrog = mySpeciesSingleContainer.getData();
		System.out.println(myFrog);
	}
}
