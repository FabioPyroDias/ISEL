package classcode.p11StreamsAndFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Gerar um ficheiro com inteiros em várias linhas
 */

public class C09WriteFileOfInts {

	public static void main(String[] args) throws FileNotFoundException {

		// escrita num printWriter, que permite fazer print e println de tipos
		// básicos e objectos (toString), também permite: append, fflush, format
		// e write
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("fileOfInts.txt");

			Random rg = new Random();
			int nLines = 3 + rg.nextInt(7);
			System.out.println("O ficheiro terá " + nLines + " linhas");

			for (int i = 0; i < nLines; i++) {
				int nints = rg.nextInt(10);
				System.out.print("A linha " + i + " terá " + nints
						+ " inteiros -> ");
				for (int j = 0; j < nints; j++) {
					String s = rg.nextInt(100) + " ";
					pw.print(s);
					System.out.print(s);
				}
				pw.println();
				System.out.println();
			}

		} finally {
			if (pw != null)
				pw.close();
		}

		// observar o contéudo do ficheiro produzido
	}

}
