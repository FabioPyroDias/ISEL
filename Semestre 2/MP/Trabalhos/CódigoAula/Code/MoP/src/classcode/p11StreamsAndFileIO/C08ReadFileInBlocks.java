package classcode.p11StreamsAndFileIO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Leitura de caracteres ao bloco. Permite uma melhor percepção de como lidar
 * com a situação de fim de ficheiro
 * 
 */
public class C08ReadFileInBlocks {
	public static void main(String[] args) throws IOException {
		FileReader in = null;
		String fileName = "joke.txt";

		try {
			// abrir o ficheiros
			in = new FileReader(fileName);
			System.out.println("File " + fileName + " opened...");

			char[] array = new char[10];
			int nCharsReaded = 0;
			StringBuilder sb = new StringBuilder(200);

			// ler o ficheiros
			while ((nCharsReaded = in.read(array, 0, 10)) != -1) {
				System.out.println("Foram lidos " + nCharsReaded
						+ " caracteres -> " + Arrays.toString(array));
				// guardar os caracteres num StringBuilder
				sb.append(array, 0, nCharsReaded);
			}

			// mostrar o conteúdo lido
			System.out.println("\nConteúdo lido:\n" + sb);
		} finally {
			if (in != null) {
				in.close();
				System.out.println("\nFile " + fileName + " closed...");
			}
		}
	}
}
