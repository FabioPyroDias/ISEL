package classcode.p08AbstractClassesAndInterfaces.cenario2FigurasAbstract;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class Elipse - suporta uma Elipse
 * 
 */
public class C10Elipse extends C04Figura {

	int eixoX, eixoY;

	public C10Elipse(C02Ponto2D p1, int eixoX, int eixoY, Color color) {
		super(new C02Ponto2D[] { p1.clone() }, color);

		this.eixoX = eixoX;
		this.eixoY = eixoY;
	}

	public String getNome() {
		return "elipse";
	}

	public double getArea() {
		return eixoX * eixoY * Math.PI;
	}

	@Override
	public String toString() {
		return super.toString() + " com eixos x,y de " + eixoX + "," + eixoY;
	}

	/**
	 * Draw the polygon into the graphics g
	 */
	public void paintComponent(Graphics g) {

		g.setColor(color);
		g.fillOval(getPonto(0).getX(), getPonto(0).getY(), eixoX, eixoY);
		g.setColor(Color.black);
		g.drawOval(getPonto(0).getX(), getPonto(0).getY(), eixoX, eixoY);

	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		C10Elipse r1 = new C10Elipse(new C02Ponto2D(100, 100), 20, 30, Color.cyan);
		System.out.println("r1 -> " + r1);
	}

}