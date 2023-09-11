package classcode.p11StreamsAndFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */
public class C15TryWithResources {

	public static void main(String[] args) throws IOException {
		String filepath = "src/classcode/p11StreamsAndFileIO/C15TryWithResources.java";
		System.out.println("First line: " + readFirstLineFromFileWithFinallyBlock(filepath));
		System.out.println("First line: " + readFirstLineFromFileWithTryWithRes(filepath));
		System.out.println("First line: " + readFirstLineFromFileWithTryWithRes2(filepath));
	}

	/**
	 * File read with BufferedReader with try-finally block
	 * 
	 * If readLine throws an exception and close also throws an exception, only
	 * the close exception will be thrown. The first one will be suppressed.
	 */
	static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	/**
	 * File read with BufferedReader with try-with-resources
	 * 
	 * If readLine throws an exception and close also throws an exception, the
	 * exception in the try block will be thrown. The close exception will be
	 * suppressed.
	 */
	static String readFirstLineFromFileWithTryWithRes(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	/**
	 * 
	 */
	static String readFirstLineFromFileWithTryWithRes2(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end");
		}
		return null;
	}
}
