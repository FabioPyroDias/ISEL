package classcode.p11StreamsAndFileIO;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Um exemplo de obter as entradas de uma directoria mas com critério de
 * filtragem. É permitido utilizar '*' e '?' na string para definir o filtro.
 * Essa string é convertida para uma expressão regular na classe Filter
 */
public class C13XFileFilterGetDirs {

	public static void main(String[] args) throws IOException {
		// search local, must be a directory
		String fileName = "."; 

		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File does not exist: " + file);
			return;
		}
		if (!file.canRead()) {
			System.out.println("Can't read file:" + file);
			return;
		}
		if (!file.isDirectory()) {
			System.out.println(fileName + " must be a directory ...");
			return;
		}

		FileFilter filterDirs = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		
		// get the directory entries that satisfies the filter
		File[] files = file.listFiles(filterDirs);

		// show the entries
		for (int i = 0; i < files.length; i++) {
			System.out.format("  %-40s", files[i]);
			if (files[i].isDirectory())
				System.out.println(" [dir]");
			else
				System.out.println(" " + files[i].length() + " bytes");
		}
	}
}