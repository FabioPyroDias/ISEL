package classcode.p08AbstractClassesAndInterfaces.cenario2FigurasAbstract;

/**
 * Class Ponto1D - suporta um ponto num espaço a uma dimensão
 * 
 */
public class C01Ponto1D {

	private int x;

	//
	// ## Métodos ## ----------------------

	public C01Ponto1D(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String getDescricao() {
		return "x -> " + getX();
	}

	public String toString() {
		return "(" + getDescricao() + ")";
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C01Ponto1D p1 = new C01Ponto1D(3);
		System.out.println(p1);
		System.out.println();

		p1.setX(p1.getX() * 2);
		System.out.println(p1);
	}

}
