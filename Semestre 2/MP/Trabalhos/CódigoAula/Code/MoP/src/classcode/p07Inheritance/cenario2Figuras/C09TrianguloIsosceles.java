package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;

/**
 * Class Triangulo - suporta um triângulo isósceles
 * 
 */
public class C09TrianguloIsosceles extends C08Triangulo {

	public C09TrianguloIsosceles(C02Ponto2D p1, int base, int altura,
			Color color) {
		super(p1.clone(), new C02Ponto2D(p1.getX() + base, p1.getY()),
				new C02Ponto2D(p1.getX() + base / 2, p1.getY() + altura), base,
				altura, color);
	}

	public String getNome() {
		return "triângulo isósceles";
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C09TrianguloIsosceles r1 = new C09TrianguloIsosceles(new C02Ponto2D(1,
				1), 4, 2, Color.magenta);
		System.out.println("r1 -> " + r1);
	}

}