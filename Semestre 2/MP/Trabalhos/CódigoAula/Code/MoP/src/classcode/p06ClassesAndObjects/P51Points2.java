package classcode.p06ClassesAndObjects;

import java.util.Arrays;

public class P51Points2 {

	public static void main(String[] args) {
		// Criar um ponto e inicializá-lo
		Point2 p1 = new Point2(0, 1);

		// Criar um outro ponto e inicializá-lo
		Point2 p2 = new Point2(1, 1);
		// erro - constructor inexistente
		// Point2 p2 = new Point2();

		// criar um array de pontos
		Point2[] points = new Point2[10];

		// criar tantos pontos quantas as posições do array
		for (int i = 0; i < points.length; i++) {
			// Criar um ponto e inicilizá-lo
			Point2 p = new Point2(i, 1);
			// guardá-lo no array
			points[i] = p;
		}

		// mostrar os pontos p1 e p2
		System.out.println("P1 -> " + p1.toString());
		System.out.println("P2 -> " + p2); // chamada implícita ao toString
		System.out.println();

		// mostrar o array de pontos
		System.out.println("points -> " + Arrays.toString(points));
	}
}

/**
 * classe Point
 *
 */
class Point2 {
	int x, y;

	// método constructor
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;		
	}

	// método toString
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
