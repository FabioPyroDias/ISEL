package classcode.p07Inheritance;

import java.util.Date;

/*
 * Exemplo de herança - instanceof
 * 
 * Exemplo do a classe Date
 */
public class C02 {

	public String toString() {
		return "sou um C02";

	}

	public static void main(String[] args) {

		// criar o array para objectos C02
		C02[] elems = new C02[100];

		// criar objectos e colocá-los no array
		C03 c3 = new C03();
		elems[0] = new C02();
		elems[1] = new C03();
		elems[2] = c3;

		// ===============================================
		// contagem dos C02 e C03 existentes
		//
		int nC02 = 0, nC03 = 0;
		for (int i = 0; i < elems.length; i++) {

			if (elems[i] != null) {
				// use of instanceof operator
				if (elems[i] instanceof C02) {
					nC02++;
				}

				if (elems[i] instanceof C03) {
					nC03++;
				}
				// toString will be called independently of the kind of object,
				// because this method is defined for both classes at class
				// Object
				System.out.println(elems[i]);
			}
		}

		System.out.println("nC02 -> " + nC02);
		System.out.println("nC03 -> " + nC03);

		System.out.println();

		// ===============================================
		// listagem dos C03 existentes
		//
		System.out.println("Listagem dos C03 existentes:");
		for (int i = 0; i < elems.length; i++) {
			if (elems[i] != null) {
				if (elems[i] instanceof C03) {

					// use of cast operator - could throw
					// java.lang.ClassCastException if the cast can not be done
					C03 aux = (C03) elems[i];
					// C01Bclass aux2 = (C01Bclass) (Object) elems[i];
					System.out.println(aux + " created at -> "
							+ aux.getCreationDataAndTime());
					// ((C03) elems[i]).getCreationDataAndTime();
				}
			}
		}
	} // end of main

} // end of C02 class

class C03 extends C02 {

	// each C03 will keep its creation date and time
	Date creationDate = new Date();

	public String toString() {
		return "sou um C03";
	}

	public String getCreationDataAndTime() {
		return creationDate.toString();
	}

}

class C1 {
	public C1() {
		super();
	}

	public C1(int x) {

	}

	// final
	// public
	void m1() {

	}
}

class C2 extends C1 {

	public C2() {
		System.out.println();
	}

	void m1() {

	}
}

class C5 extends Object {
	private int x = 10;

	void m1() {
		this.toString();

	}

	public static void main(String[] args) {
		C5 c = new C5();
		c.x = 60;
		System.out.println(c.x);
	}
}
