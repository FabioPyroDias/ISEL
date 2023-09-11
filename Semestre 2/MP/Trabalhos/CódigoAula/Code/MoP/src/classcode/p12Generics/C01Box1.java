package classcode.p12Generics;

public class C01Box1 {
	private Object object = null;

	public void set(Object object) {
		this.object = object;
	}

	public Object get() {
		return object;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// criar um object que guarda um integer
		C01Box1 integerBox = new C01Box1();

		// colocar um integer na box
		integerBox.set(Integer.valueOf(10));

		// integerBox.set("ola");

		// obter o integer guardado
		Integer theValue = (Integer) integerBox.get();

		// mostrar o seu valor
		System.out.println(theValue);

	}

}
