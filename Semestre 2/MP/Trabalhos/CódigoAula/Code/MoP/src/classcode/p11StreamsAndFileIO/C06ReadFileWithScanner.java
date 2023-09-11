package classcode.p11StreamsAndFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ler as linhas de um ficheiro de texto com scanner
 */
public class C06ReadFileWithScanner {

	public static void main(String[] args) {

		// Leitura do ficheiro
		String inputFileName = "file10.txt";
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new File(inputFileName));
			String line = null;
			int nLines = 0;

			System.out.println("Conteúdo do ficheiro:");

			// ciclo de leituras de linhas do ficheiro
			// enquanto houver linhas...
			while (fileScan.hasNextLine()) {
				// ler linha
				line = fileScan.nextLine();
				// mostrar linha
				System.out.println("[" + line.length() + "]" + line);
				// contabilizar o nº de linhas
				++nLines;
			}
			System.out.println("\nForam lidas " + nLines + " linhas");
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} finally {
			if (fileScan != null) {
				fileScan.close();
			}
		}
	}
}
