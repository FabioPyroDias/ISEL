package classcode.p07Inheritance.cenario2Figuras;

/**
 * Class Ponto2D - suporta um ponto num espaço a duas dimensões
 * 
 */
public class C02Ponto2D extends C01Ponto1D {

	int y;

	//
	// ## Métodos ## ----------------------

	public C02Ponto2D(int x, int y) {
		super(x);
		// this.x = 10;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDescricao() {
		return super.getDescricao() + ", y -> " + getY();
	}

	public C02Ponto2D clone() {
		return new C02Ponto2D(getX(), getY());
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C02Ponto2D p1 = new C02Ponto2D(3, 5);
		System.out.println(p1);
		System.out.println();

		// utilização dos métodos getX e setX definidos na classe base
		p1.setX(p1.getX() * 2);
		System.out.println("x = x * 2 ->  " + p1);
		p1.setY(p1.getY() * 2);
		System.out.println("y = y * 2 ->  " + p1);

	}
}
