package classcode.p06ClassesAndObjects;

/**
 * Esta classe é um contentor simples de rectas. A classe Recta e Ponto são duas
 * classes definidas dentro deste ficheiro, mas também poderiam ser definidas
 * cada uma no seu ficheiro.
 * 
 */
public class C13Figura {

	private Recta[] rectas = new Recta[10];

	private int nRectas = 0;

	/**
	 * 
	 */
	public void addRecta(Recta r) {
		rectas[nRectas++] = r;
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "{ ";
		for (int i = 0; i < nRectas; i++) {
			if (i > 0)
				s += ", ";
			s += rectas[i];
		}
		return s + " }";
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// Criar dois pontos e uma recta
		Ponto p11 = new Ponto(10, 20);
		Ponto p12 = new Ponto(10, 100);
		Recta r1 = new Recta(p11, p12);

		// Criar outros dois pontos e outra recta
		Ponto p21 = new Ponto(5, 20);
		Ponto p22 = new Ponto(15, 100);
		Recta r2 = new Recta(p21, p22);

		// mostrar as duas rectas
		System.out.println("R1 -> " + r1);
		System.out.println("R2 -> " + r2);

		// verificar se elas se intersectam em x
		boolean interceptamEmX = r1.intersectaEmX(r2);
		System.out.println(
				"As duas rectas interceptam-se em X ? " + interceptamEmX);

		C13Figura f1 = new C13Figura();
		f1.addRecta(r1);
		f1.addRecta(r2);
		System.out.println("Figura f1 -> " + f1);
		System.out.println();

		// teste ao método intersectaEmX
		Recta r_1 = new Recta(new Ponto(0, 0), new Ponto(10, 0));
		Recta r_2 = new Recta(new Ponto(1, 0), new Ponto(11, 0));
		Recta r_3 = new Recta(new Ponto(-1, 0), new Ponto(9, 0));
		Recta r_4 = new Recta(new Ponto(-1, 0), new Ponto(11, 0));
		Recta r_5 = new Recta(new Ponto(-2, 0), new Ponto(-1, 0));
		Recta r_6 = new Recta(new Ponto(12, 0), new Ponto(13, 0));

		System.out.println(r_1 + " intercepta-se em X com " + r_2 + " -> "
				+ r_1.intersectaEmX(r_2));
		System.out.println(r_1 + " intercepta-se em X com " + r_3 + " -> "
				+ r_1.intersectaEmX(r_3));
		System.out.println(r_1 + " intercepta-se em X com " + r_4 + " -> "
				+ r_1.intersectaEmX(r_4));
		System.out.println(r_1 + " intercepta-se em X com " + r_5 + " -> "
				+ r_1.intersectaEmX(r_5));
		System.out.println(r_1 + " intercepta-se em X com " + r_6 + " -> "
				+ r_1.intersectaEmX(r_6));

	}
}

/**
 * Class que suporta uma recta
 * 
 */
class Recta {

	private Ponto p1, p2;

	/**
	 * 
	 */
	public Recta(Ponto p1, Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * 
	 */
	public Ponto getP1() {
		return p1;
	}

	/**
	 * 
	 */
	public void setP1(Ponto p1) {
		this.p1 = p1;
	}

	/**
	 * 
	 */
	public Ponto getP2() {
		return p2;
	}

	/**
	 * 
	 */
	public void setP2(Ponto p2) {
		this.p2 = p2;
	}

	/**
	 * Detecta se há intersacção em X entre a recta corrente e a recta recebida
	 */
	public boolean intersectaEmX(Recta r) {
		int xMaior = p1.getX() > p2.getX() ? p1.getX() : p2.getX();
		int xMenor = p1.getX() < p2.getX() ? p1.getX() : p2.getX();

		int xRMaior = r.p1.getX() > r.p2.getX() ? r.p1.getX() : r.p2.getX();
		int xRMenor = r.p1.getX() < r.p2.getX() ? r.p1.getX() : r.p2.getX();

		return xRMenor >= xMenor && xRMenor <= xMaior
				|| xRMaior >= xMenor && xRMaior <= xMaior
				|| xRMenor <= xMenor && xRMaior >= xMaior;
	}

	/**
	 * 
	 */
	public String toString() {
		return "[ (" + p1 + "), (" + p2 + ") ]";
	}

}

/**
 * Classe que suporta um Ponto
 * 
 */
class Ponto {

	private int x, y;

	/**
	 * 
	 */
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 */
	public String toString() {
		return x + ", " + y;
	}

}
