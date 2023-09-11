package classcode.p11StreamsAndFileIO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Lê de um ficheiro um array de inteiros em formato texto com o Scanner. Lê por
 * linhas e depois monta um scanner para ler os inteiros dentro da linha.
 * 
 * @author António Teófilo
 * 
 */
public class C10ReadFileOfIntsWithScanner {

	public static void main(String[] args) throws IOException {
		Scanner scanLines = null;
		String inputFileName = "fileOfInts.txt";

		int nlines = 1;
		try {
			// mount scan over file
			scanLines = new Scanner(new FileReader(inputFileName));
			String line = null;
			// read lines
			while (scanLines.hasNextLine()) {
				line = scanLines.nextLine();
				// process line
				System.out.println("- Conteúdo da linha " + nlines + " -> "
						+ line);
				System.out.print("  Conteúdo da linha " + nlines + " -> ");
				Scanner scanInts = new Scanner(line);
				// read ints
				while (scanInts.hasNextInt()) {
					int i = scanInts.nextInt();
					System.out.print(i);
					if (scanInts.hasNextInt())
						System.out.print(".");
				}

				++nlines;

				scanInts.close();
				System.out.println();
			}

			// we are at end of file
			System.out.println("Fim do ficheiro " + inputFileName);

			System.out.println("Foram lidas " + nlines + " linhas");

		} finally {
			if (scanLines != null) {
				scanLines.close();
			}

		}
	}
}
