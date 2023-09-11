package classcode.p07Inheritance.cenario1Pontos;

/**
 * Class Ponto2D - suporta um ponto num espaço a duas dimensões. Exemplifica
 * herança. Chamada ao construtor super; chamada a métodos sobrepostos
 * (getDescricao e toString)
 * 
 */
public class Ponto2D extends Ponto1D {

	int y;

	//
	// ## Métodos ## ----------------------

	public Ponto2D(int x, int y) {
		super(x);
		this.y = y;
		//super.x = x;
	}

	 public String getDescricao() {
		return super.getDescricao() + ", y -> " + y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		Ponto2D p1 = new Ponto2D(3, 5);
		System.out.println(p1);
		System.out.println();

		// utilização dos métodos getX e setX definidos na classe base
		p1.x = p1.x * 2;
		System.out.println("x = x * 2 ->  " + p1);
		p1.y = p1.y * 2;
		System.out.println("y = y * 2 ->  " + p1);

	}
}
