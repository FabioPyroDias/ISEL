package classcode.p01IntroJava;

import java.util.Arrays;

public class C01 {

	/**
	 * Este � o m�todo de arranque da execu��o
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("Args = " + Arrays.toString(args));
		
	}

}

class C0 {
	public static void main(String[] args) {
		System.out.println("Hello World C0");
		C01.main(args);
		
		
	}

}
