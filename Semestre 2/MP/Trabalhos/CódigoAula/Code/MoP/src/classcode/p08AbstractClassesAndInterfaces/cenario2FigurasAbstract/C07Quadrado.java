package classcode.p08AbstractClassesAndInterfaces.cenario2FigurasAbstract;

import java.awt.Color;

/**
 * Class Quadrado - suporta um quadrado
 * 
 */
public class C07Quadrado extends C06Rectangulo {

	public C07Quadrado(C02Ponto2D p1, int lado, Color color) {
		super(p1, lado, lado, color);
	}

	public String getNome() {
		return "quadrado";
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C07Quadrado r1 = new C07Quadrado(new C02Ponto2D(1, 1), 4, Color.yellow);
		System.out.println("r1 -> " + r1);
	}

}