package classcode.p07Inheritance;

/**
 * Exemplo de Herança
 * 
 */
public class C01Bclass {
	private int val;
	int val2;

	C01Bclass(int x) {
		val2 = val = x;
	}

	{
		System.out.println("Olá");
	}

	public int getVal() {

		return val;
	}

	public int metodo1(int x) {
		System.out.println("Bclass: methodo1 called...");
		int z = val2 + x;
		return z;
	}

	public static void main(String[] args) {
		Cclass c = new Cclass(10);
		System.out.println("c.metodo1(20) -> " + c.metodo1(20));
		C01Bclass b = (C01Bclass) c;
		System.out.println("b.metodo1(20) -> " + b.metodo1(20));
	}

	public void m1() {

	}
}

class Cclass extends C01Bclass {
	private int cc;

	// Cclass() {
	// super(1);
	// }

	Cclass(int n) {
		super(n); // calls Bclass(int)
		val2 = n; // val2 not private
		// val = 89;
		cc = n;
		cc = cc + 1;
	}

	public int metodo1(int x) {
		int z = getVal() + x;
		return z;
	}
}
