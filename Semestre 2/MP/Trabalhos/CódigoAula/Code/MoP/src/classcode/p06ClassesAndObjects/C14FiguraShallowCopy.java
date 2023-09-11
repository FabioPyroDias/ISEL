package classcode.p06ClassesAndObjects;

/**
 * Teste às violações de encapsulamento. Contructor com cópia superficial
 * (shallow copy).
 * 
 */
public class C14FiguraShallowCopy {

	private Recta2[] rectas = new Recta2[10];

	private int nRectas = 0;

	/**
	 * 
	 */
	public void addRect(Recta2 r) {
		// falta validar se há espaço e se r não é null
		rectas[nRectas++] = r;
	}

	/**
	 * Método que devolve a referência para a recta do índice recebido 
	 */
	public Recta2 getRect(int index) {
		if (index < 0 || index >= nRectas)
			return null;
		return rectas[index];
	}

	/**
	 * Método que devolve uma cópia do objecto
	 */
	public Recta2 getRect2(int index) {
		if (index < 0 || index >= nRectas)
			return null;
		return new Recta2(rectas[index]);
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
		Ponto2 p11 = new Ponto2(10, 20);
		Ponto2 p12 = new Ponto2(30, 100);
		Recta2 r1 = new Recta2(p11, p12);

		// Criar outros dois pontos e outra recta
		Ponto2 p21 = new Ponto2(5, 20);
		Ponto2 p22 = new Ponto2(15, 100);
		Recta2 r2 = new Recta2(p21, p22);

		// criar a figura f1
		C14FiguraShallowCopy fig1 = new C14FiguraShallowCopy();
		fig1.addRect(r1);
		fig1.addRect(r2);
		System.out.println("Figura f1 -> " + fig1.toString());

		
		// TEST 1 - violation of fig1 integrity, method returns the reference
		System.out
				.println("\nTEST 1 - with copy of references - trying to change point p1 of rect 0...");
		System.out.println("Figura f1 -> " + fig1);
		// getRect returns the reference to the object itself
		Recta2 r = fig1.getRect(0);
		r.setP1(r.getP2());
		System.out.println("Figura f1 -> " + fig1);

		
		// TEST 2 - violation of fig1 integrity, method returns a shallow copy
		System.out
				.println("\nTEST 2 - with shallow copy - trying to change point p1 of rect 1...");
		System.out.println("Figura f1 -> " + fig1);
		// now with the use of copy constructor
		// this change now don't violate the integrity of fig1
		Recta2 rr = fig1.getRect2(1);
		rr.setP1(rr.getP2());
		System.out.println("Figura f1 -> " + fig1);

		System.out
				.println("TEST 2 - with shallow copy - trying to change X of point p1 of rect 1...");
		// violation of fig1 integrity - because the copy was not a deep copy
		// attention: rr.p1 is now pointing to fig1.p2
		rr.getP1().setX(300);
		System.out.println("Figura f1 -> " + fig1);
	}
}

/**
 * Class Ponto - suporta um ponto
 * 
 */
class Ponto2 {

	private int x, y;

	public Ponto2(int x, int y) {

		this.x = x;
		this.y = y;
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
class Recta2 {

	private Ponto2 p1, p2;

	/**
	 * Normal constructor
	 */
	public Recta2(Ponto2 p1, Ponto2 p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Copy constructor - a constructor that build a copy of the received
	 * object. Faz uma cópia superficial (shallow copy)
	 */
	public Recta2(Recta2 rect) {
		this.p1 = rect.p1;
		this.p2 = rect.p2;
	}

	public Ponto2 getP1() {
		return p1;
	}

	public void setP1(Ponto2 p1) {
		this.p1 = p1;
	}

	public Ponto2 getP2() {
		return p2;
	}

	public void setP2(Ponto2 p2) {
		this.p2 = p2;
	}

	public String toString() {
		return "[ (" + p1 + "), (" + p2 + ") ]";
	}

}
