package classcode.p01IntroJava;

public class C13BoxingUnboxing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// auto boxing - automatic conversion from int to integer
		Integer i1 = 20;

		System.out.println("Integer i1 = 20;    i1 -> " + i1);

		// auto unboxing - automatic conversion from Integer to int
		int i = i1;
		System.out.println("\nint i = i1;    i -> " + i);

	}

}
