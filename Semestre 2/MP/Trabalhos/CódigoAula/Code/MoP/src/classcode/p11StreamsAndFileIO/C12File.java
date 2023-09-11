package classcode.p11StreamsAndFileIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Exemplo que visualiza algumas dad funcionalidades existentes na classe File
 */
public class C12File {

	public static void main(String[] args) throws IOException {
		String fileName = "src"; // "src";
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File does not exist: " + file);
			return;
		}
		if (!file.canRead()) {
			System.out.println("Can't read file:" + file);
			return;
		}
		if (file.isDirectory()) {
			System.out.println("Listing directory -> " + file.getAbsolutePath());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				System.out.format("  %-40s", files[i]);
				// concatenat o nome da directoria para forma o pathname
				File aux = new File(file, files[i]);
				if (aux.isDirectory())
					System.out.println(" [dir]");
				else
					System.out.println(" " + aux.length() + " bytes");
			}
		} else { // é um ficheiro, mostrar o seu conteúdo
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				System.out.println(line);
			}
			fileScan.close();
		}

	}
}
