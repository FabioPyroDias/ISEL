package classcode.p11StreamsAndFileIO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Um exemplo de obter as entradas de uma directoria mas com critério de
 * filtragem. É permitido utilizar '*' e '?' na string para definir o filtro.
 * Essa string é convertida para uma expressão regular na classe Filter
 */
public class C13FileFilter {

	public static void main(String[] args) throws IOException {
		// search local, must be a directory
		String fileName = "."; // f.txt";

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

		// the filter string - we can use: *, ?
		String filterString = "*"; //f*.txt"; // s*, f*.t*t
		System.out.println("Listing " + filterString + " in directory -> "
				+ file);

		// the filter
		Filter filter = new Filter(filterString);
		// get the directory entries that satisfies the filter
		File[] files = file.listFiles(filter);

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

/**
 * Filter class that accepts filterString that can be written with * and ? as
 * shell normal commands
 * 
 * @author ateofilo
 * 
 */
class Filter implements FilenameFilter {
	String filterString;

	Filter(String filterString) {
		this.filterString = filterString;
	}

	public boolean accept(File dir, String name) {
		// System.out.println("Accept: dir -> " + dir + ", name -> " + name);
		String regEx = toRegEx(filterString);
		// System.out.println("Accept: filterString -> " + filterString
		// + ", regEx -> " + regEx);
		return name.matches(regEx);
	}

	/**
	 * Accepts a filterName that can have * and ?
	 * 
	 * @return the corresponding regular expression
	 */
	private String toRegEx(String filterName) {
		StringBuilder sb = new StringBuilder(filterName.length() * 3);
		for (int i = 0; i < filterName.length(); i++) {
			char c = filterName.charAt(i);
			if (c == '*')
				sb.append("\\S*");
			else if (c == '?')
				sb.append("\\S");
			else if (c == '.')
				sb.append("\\.");
			else
				sb.append(c);
		}
		return sb.toString();
	}
}
