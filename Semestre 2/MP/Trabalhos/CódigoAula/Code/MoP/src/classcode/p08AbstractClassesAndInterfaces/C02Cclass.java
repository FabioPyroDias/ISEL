package classcode.p08AbstractClassesAndInterfaces;

public class C02Cclass extends C01Bclass {

	private int cc;

	C02Cclass(int n) {
		super(n); // calls Bclass(int)
		val2 = n;
		cc = n;
	}

	public int metodo1(int x) {
		int z = getVal() + x + cc;
		return z;
	}
}
