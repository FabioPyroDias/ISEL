package classcode.p11StreamsAndFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * NOTA IMPORTANTE: Os ficheiros gerados devem ser analizados ao byte. Podem
 * abrir com o notepad++ e ver com o plugin de Hex-Editor. Ou instalar o plugin
 * de Editor Hexadecimal para o eclipse, ver em http://ehep.sourceforge.net/
 * 
 * Quando criarem um ficheiro, assim directamente, devem fazer Refresh (F5)
 * sobre o icon do projecto, pois os ficheiros irão ficar na raiz (src) do
 * projecto mas o refresh não é automático
 * 
 */

public class C03WriteFile {

	public static void main(String[] args) {

		// PrintWriter, permite fazer print e println de tipos básicos e String,

		String filename = "file100.txt";
		try {

			PrintWriter pw = new PrintWriter(filename);
			int x = 100000000;
			String s = "Olá";
			pw.println(x + " " + s);
			pw.println(x + " " + s);
			pw.write(new char[]{'q'}, 2, 4);
			pw.close();

			// observar o contéudo do ficheiro produzido
			System.out.println("Ficheiro " + filename + " criado com sucesso.");

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao criar o ficheiro -> " + filename);
		}

	}

}
