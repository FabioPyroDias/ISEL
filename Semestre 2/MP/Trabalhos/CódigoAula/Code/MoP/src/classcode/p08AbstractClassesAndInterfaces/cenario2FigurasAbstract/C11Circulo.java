package classcode.p08AbstractClassesAndInterfaces.cenario2FigurasAbstract;

import java.awt.Color;

/**
 * Class Circulo - suporta um círculo
 * 
 */
public class C11Circulo extends C10Elipse {

	public C11Circulo(C02Ponto2D p1, int raio, Color color) {
		super(p1.clone(), raio * 2, raio * 2, color);

	}

	public String getNome() {
		return "círculo";
	}

	@Override
	public String toString() {
		return super.toString() + " com raio de " + eixoX / 2;
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C11Circulo r1 = new C11Circulo(new C02Ponto2D(1, 1), 20, Color.cyan);
		System.out.println("r1 -> " + r1);
	}

}