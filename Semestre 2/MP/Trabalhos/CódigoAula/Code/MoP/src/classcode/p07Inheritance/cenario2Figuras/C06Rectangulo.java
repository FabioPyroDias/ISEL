package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;

/**
 * Class Rectangulo - suporta um rectângulo
 * 
 */
public class C06Rectangulo extends C04Figura {

	double largura, altura;

	int count = 0;
	boolean grow = true;

	public C06Rectangulo(C02Ponto2D p1, int largura, int altura, Color color) {
		super(color);
		C02Ponto2D[] ps = new C02Ponto2D[4];

		this.largura = largura;
		this.altura = altura;

		ps[0] = p1.clone();
		ps[1] = new C02Ponto2D(p1.getX() + largura, p1.getY());
		ps[2] = new C02Ponto2D(p1.getX() + largura, p1.getY() + altura);
		ps[3] = new C02Ponto2D(p1.getX(), p1.getY() + altura);

		setPontos(ps);
	}

	public String getNome() {
		return "rectangulo";
	}

	public double getArea() {
		return largura * altura;
	}

	public void translate() {
		if (grow) {
			if (++count == 200) {
				count = 0;
				grow = false;
			}
		} else {
			if (++count == 200) {
				count = 0;
				grow = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			pontos[i].setX(pontos[i].getX() + (grow ? 1 : -1));
			pontos[i].setY(pontos[i].getY() + (grow ? 1 : -1));
		}

	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C06Rectangulo r1 = new C06Rectangulo(new C02Ponto2D(1, 1), 4, 2,
				Color.green);
		System.out.println("r1 -> " + r1);
	}

}