package classcode.p12Generics;

/**
 * Uma classe genérica com dois tipos genéricos e com um método que declara uma
 * argumento de outro tipo genérico
 */
public class C03Box3<T, U> {
	private T obj1;
	private U obj2;

	public C03Box3(T t, U u) {
		obj1 = t;
		obj2 = u;
	}

	public void set1(T t) {
		obj1 = t;
	}

	public void set2(U u) {
		obj2 = u;
	}

	public T get1() {
		return obj1;
	}

	public U get2() {
		return obj2;
	}

	/**
	 * Método que declara um tipo genérico que é utilizado dentro dele
	 */
	public <V> V inspect(V o) {
		System.out.println("T: " + obj1.getClass().getName());
		System.out.println("V: " + o.getClass().getName());
		return o;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		C03Box3<Integer, String> box = new C03Box3<Integer, String>(100, "Olá");
		box.set1(30);
		System.out.println(box.get2() + " " + box.get1());

		// utilização do método que declara um tipo extra genérico

		// indicação explicita do tipo
		// float f1 = box.<Float> inspect(new Float(3.9f));
		float f1 = box.<Float> inspect(3.9f);

		// indicação implicita do tipo
		// String s =
		box.inspect(f1);

		// utilização de outro tipo, recordar que o tipo só é válido na chamada
		// ao método, pelo que cada chamada pode utilizar um tipo diferente
		// String s =
		box.inspect("olá");

		// situações incompatíveis
		// box.<Float> inspect(10); // ERRO
		// String s = box.inspect(f1);
	}
}
