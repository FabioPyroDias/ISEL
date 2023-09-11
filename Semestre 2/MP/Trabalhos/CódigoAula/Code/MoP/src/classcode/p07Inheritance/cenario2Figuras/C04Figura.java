package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;

/**
 * Classe Figura - Esta classe é um contentor de pontos.
 * 
 */
public class C04Figura {
	C02Ponto2D[] pontos;
	private int nPontos;
	Color color;

	public C04Figura(Color color) {
		pontos = null;
		nPontos = 0;
		this.color = color;
	}

	public C04Figura(C02Ponto2D[] pontos, Color color) {
		setPontos(pontos);
		this.color = color;
	}

	public C02Ponto2D[] getPontos() {
		// TODO
		return new C02Ponto2D[0];
	}

	/**
	 * Falta copiar os pontos em si
	 */
	public void setPontos(C02Ponto2D[] pontos) {
		this.pontos = Arrays.copyOf(pontos, pontos.length);
		nPontos = pontos.length;
		// TODO copiar os pontos em si
	}

	public C02Ponto2D getPonto(int index) {
		if (index < 0 || index >= pontos.length)
			return null;
		return pontos[index].clone();
	}

	public boolean setPonto(C02Ponto2D ponto, int index) {
		if (index < 0 || index >= pontos.length)
			return false;

		pontos[index] = ponto.clone();
		return true;
	}

	public double getArea() {
		return 0;
	}

	public String getNome() {
		return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder(getNome());
		s.append(" [");
		for (int i = 0; i < nPontos; i++) {
			s.append(pontos[i]);
			if (i < nPontos - 1)
				s.append(", ");
		}
		s.append("]");
		return s.toString();

	}

	/**
	 * Draw the polygon into the graphics g
	 */
	public void paintComponent(Graphics g) {

		Polygon p = new Polygon();
		for (int i = 0; i < pontos.length; i++) {
			p.addPoint(pontos[i].getX(), pontos[i].getY());
		}

		g.setColor(color);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.drawPolygon(p);

	}
}
