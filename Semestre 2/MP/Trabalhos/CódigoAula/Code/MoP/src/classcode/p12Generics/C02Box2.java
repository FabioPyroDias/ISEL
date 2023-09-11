package classcode.p12Generics;

/**
 * Uma Box genérica - ou seja, permite definir Boxes dos vários tipos
 */
public class C02Box2<T> {

	private T t; // T stands for "Type"

	public C02Box2(T t) {
		set(t);
		//T[] arr  = new T[10];
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {

		/***********************************************
		 * a box of integer
		 */
		// boxing - passar automáticamente de int para Integer
		C02Box2<Integer> integerBox = new C02Box2<Integer>(100);

		integerBox.set(10);
		//integerBox.set("ola");

		Integer i1 = 200;
		integerBox.set(i1);

		Integer theValue = integerBox.get(); // no cast!
		System.out.println(theValue);

		/***********************************************
		 * a box of integers
		 */
		C02Box2<String> strBox = new C02Box2<String>("olá");
		String value = strBox.get();
		System.out.println(value);

		/***********************************************
		 * a box of box of string
		 */
		C02Box2<C02Box2<String>> strBBox = new C02Box2<C02Box2<String>>(strBox);
		C02Box2<String> b = strBBox.get();
		System.out.println(b.get());
	}
}
