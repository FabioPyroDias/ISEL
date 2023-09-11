package classcode.p11StreamsAndFileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Cria um ficheiro com caracteres e faz append nesse ficheiro
 * 
 * @author António Teófilo
 * 
 */
public class C11AppendCharacters {
	public static void main(String[] args) throws IOException {
		String fileName = "AppendFileChars.txt";
		PrintWriter fout = null;

//		fout = new PrintWriter(fileName); // TEST
//		fout.println("Primeira linha.");
//		fout.append("append text\n"); // TEST
//		fout.close();

		// a escrita no FileOutputStream será realizada em modo Append, ou
		// seja no final do ficheiro
		 fout = new PrintWriter(new FileWriter(fileName, true));
		 fout.println("Segunda linha.");
		 fout.close();

		System.out.println("End of main...");
	}
}
