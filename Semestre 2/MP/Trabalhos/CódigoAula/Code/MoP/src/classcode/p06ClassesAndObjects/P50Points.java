package classcode.p06ClassesAndObjects;

import java.util.Arrays;

public class P50Points {

	public static void main(String[] args) {
		// Criar um ponto e inicializá-lo
		Point p1 = new Point();
		p1.x = 0;
		p1.y = 1;

		// Criar um outro ponto e inicializá-lo
		Point p2 = new Point();
		p2.x = 1;
		p2.y = 1;

		// criar um array de pontos
		Point[] points = new Point[10];

		// criar tantos pontos quantas as posições do array
		for (int i = 0; i < points.length; i++) {
			// Criar um ponto
			Point p = new Point();
			// inicializá-lo
			p.x = i;
			p.y = 1;
			// guardá-lo no array
			points[i] = p;
		}

		// mostrar o array de pontos
		System.out.println("points -> " + Arrays.toString(points));

	}
}

/**
 * classe Point
 *
 */
class Point {
	int x, y;
}
