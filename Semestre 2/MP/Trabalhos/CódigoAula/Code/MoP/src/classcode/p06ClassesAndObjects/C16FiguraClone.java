package classcode.p06ClassesAndObjects;

/**
 * Uso do método clone para criar uma cópia do objecto actual. O método clone
 * utiliza um copy constructor.
 * 
 */
public class C16FiguraClone {

	private Recta4[] rectas = new Recta4[10];

	private int nRectas = 0;

	/**
	 * 
	 */
	public void addRect(Recta4 r) {
		// falta validar se há espaço e se r não é null
		rectas[nRectas++] = r;
	}

	/**
	 * 
	 */
	public Recta4 getRect(int index) {
		if (index < 0 || index >= nRectas)
			return null;
		return rectas[index].clone();
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "{  ";
		for (int i = 0; i < nRectas; i++) {
			s += rectas[i];
			if (i < nRectas - 1)
				s += ", ";
		}
		return s + "  }";
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// Criar dois pontos e uma recta
		Ponto4 p11 = new Ponto4(10, 20);
		Ponto4 p12 = new Ponto4(30, 100);
		Recta4 r1 = new Recta4(p11, p12);

		// Criar outros dois pontos e outra recta
		Ponto4 p21 = new Ponto4(5, 20);
		Ponto4 p22 = new Ponto4(15, 100);
		Recta4 r2 = new Recta4(p21, p22);

		// criar a figura f1
		C16FiguraClone fig1 = new C16FiguraClone();
		fig1.addRect(r1);
		fig1.addRect(r2);
		System.out.println("Figura f1 -> " + fig1.toString());

		// TEST 1
		System.out.println("\nTEST 1 - trying to change point p1 of rect 0...");
		// getRect returns a deep copy a the Fig1
		Recta4 r = fig1.getRect(0);
		r.setP1(r.getP2());
		System.out.println("Figura f1 -> " + fig1);

		// TEST 2
		System.out.println(
				"\nTEST 2 - trying to change X of point p1 of rect 1...");
		Recta4 rr = fig1.getRect(1);
		rr.getP1().setX(300);
		System.out.println("Figura f1 -> " + fig1);
	}
}

/**
 * Class Ponto - suporta um ponto
 * 
 */
class Ponto4 {

	private int x, y;

	/**
	 * Normal constructor
	 */
	public Ponto4(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Copy constructor - a constructor that build a copy of the received object
	 */
	public Ponto4(Ponto4 p) {
		this.x = p.x;
		this.y = p.y;
	}

	/**
	 * clone method - method that does a copy of object itself
	 */
	protected Ponto4 clone() {
		return new Ponto4(this);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return x + ", " + y;
	}

}

/**
 * Class Recta - suporta uma recta
 * 
 */
class Recta4 {

	private Ponto4 p1, p2;

	/**
	 * Normal constructor
	 */
	public Recta4(Ponto4 p1, Ponto4 p2) {
		this.p1 = p1.clone();
		this.p2 = p2.clone();
	}

	/**
	 * Copy constructor - a constructor that build a copy of the received
	 * object. Do a deep copy (cópia profunda)
	 */
	public Recta4(Recta4 rect) {
		this(rect.p1, rect.p2);
	}

	/**
	 * clone method - method that does a copy of object itself
	 */
	public Recta4 clone() {
		return new Recta4(this);
	}

	/**
	 * 
	 */
	public Ponto4 getP1() {
		return p1;
	}

	/**
	 * 
	 */
	public void setP1(Ponto4 p1) {
		this.p1 = p1;
	}

	/**
	 * 
	 */
	public Ponto4 getP2() {
		return p2;
	}

	/**
	 * 
	 */
	public void setP2(Ponto4 p2) {
		this.p2 = p2;
	}

	/**
	 * 
	 */ 
	public String toString() {
		return "[ (" + p1 + "), (" + p2 + ") ]";
	}

}
