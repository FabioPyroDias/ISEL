package classcode.p08AbstractClassesAndInterfaces;

public abstract class C01Bclass {

	private int val;
	protected int val2;

	C01Bclass(int x) {
		val2 = val = x;
	}

	public int getVal() {
		return val;
	}

	public abstract int metodo1(int x);

}
