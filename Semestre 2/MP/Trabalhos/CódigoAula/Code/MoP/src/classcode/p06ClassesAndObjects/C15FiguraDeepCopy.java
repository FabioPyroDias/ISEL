package classcode.p06ClassesAndObjects;

/**
 * Uso de constructor com deep copy em Recta3. Esse contructor tem de criar as
 * cópias dos seus objectos. Em Point3 como só tem tipos primitivos, a deep copy
 * corresponde a uma cópia normal
 * 
 */
public class C15FiguraDeepCopy {

	private Recta3[] rectas = new Recta3[10];

	private int nRectas = 0;

	/**
	 * 
	 */
	public void addRect(Recta3 r) {
		// falta validar se há espaço e se r não é null
		rectas[nRectas++] = r;
	}

	/**
	 * 
	 */
	public Recta3 getRect(int index) {
		if (index < 0 || index >= nRectas)
			return null;
		return new Recta3(rectas[index]);
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
		Ponto3 p11 = new Ponto3(10, 20);
		Ponto3 p12 = new Ponto3(30, 100);
		Recta3 r1 = new Recta3(p11, p12);

		// Criar outros dois pontos e outra recta
		Ponto3 p21 = new Ponto3(5, 20);
		Ponto3 p22 = new Ponto3(15, 100);
		Recta3 r2 = new Recta3(p21, p22);

		// criar a figura f1
		C15FiguraDeepCopy fig1 = new C15FiguraDeepCopy();
		fig1.addRect(r1);
		fig1.addRect(r2);
		System.out.println("Figura f1 -> " + fig1.toString());

		// TEST 1
		System.out.println("\nTEST 1 - trying to change point p1 of rect 0...");
		// getRect returns a deep copy a the Fig1
		Recta3 r = fig1.getRect(0);
		r.setP1(r.getP2());
		System.out.println("Figura f1 -> " + fig1);

		// TEST 2
		System.out.println(
				"\nTEST 2 - trying to change X of point p1 of rect 1...");
		Recta3 rr = fig1.getRect(1);
		rr.getP1().setX(300);
		System.out.println("Figura f1 -> " + fig1);
	}
}

/**
 * Class Ponto - suporta um ponto
 * 
 */
class Ponto3 {

	private int x, y;

	/**
	 * Normal constructor
	 */
	public Ponto3(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Copy constructor - a constructor that build a copy of the received object
	 */
	public Ponto3(Ponto3 p) {
		this.x = p.x;
		this.y = p.y;
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
class Recta3 {

	private Ponto3 p1, p2;

	/**
	 * Normal constructor, makes a copy of the received points, to guarantee
	 * isolation
	 */
	public Recta3(Ponto3 p1, Ponto3 p2) {
		this.p1 = new Ponto3(p1);
		this.p2 = new Ponto3(p2);
	}

	/**
	 * Copy constructor - a constructor that build a copy of the received
	 * object. Do a deep copy (cópia profunda). Calls new Ponto3(Ponto p) to
	 * make a copy of the points
	 */
	public Recta3(Recta3 rect) {
		this(rect.p1, rect.p2);
	}

	public Ponto3 getP1() {
		return p1;
	}

	public void setP1(Ponto3 p1) {
		this.p1 = p1;
	}

	public Ponto3 getP2() {
		return p2;
	}

	public void setP2(Ponto3 p2) {
		this.p2 = p2;
	}

	public String toString() {
		return "[ (" + p1 + "), (" + p2 + ") ]";
	}

}
