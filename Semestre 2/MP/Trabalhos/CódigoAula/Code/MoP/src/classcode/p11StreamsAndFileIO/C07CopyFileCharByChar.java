package classcode.p11StreamsAndFileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Copia um ficheiro a caracter a caracter. Com o default character encoding (in
 * Windows is Windows-1252 or CP-1252)
 */
public class C07CopyFileCharByChar {
	public static void main(String[] args) throws IOException {
		FileReader inputStream = null;
		FileWriter outputStream = null;
		String inputFileName = "joke.txt";
		String outputFileName = "joke_copy.txt";
		try {
			inputStream = new FileReader(inputFileName);
			outputStream = new FileWriter(outputFileName);

			int n = 0;
			char c;
			while ((c = (char) inputStream.read()) != (char) -1) {
				outputStream.write(Character.toUpperCase(c));
				++n;
			}
			System.out.println("CopyCharacters: File copied...");
			System.out.println("File " + inputFileName + " to file "
					+ outputFileName + ": " + n + " characters.");
		} finally {
			if (inputStream != null) {
				inputStream.close();
				if (outputStream != null)
					outputStream.close();
			}
		}
	}
}
