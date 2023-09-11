package classcode.p01IntroJava;

/**
 * String demo
 */
public class C09String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("String demo program - this string is a string");

		String str1 = "A Páscoa está próxima!!";
		System.out.println("\nstr1 -> " + str1);

		// length()
		System.out.println("str1.length() -> " + str1.length());

		// charAt(int index)
		System.out.println("str1.charAt(4) -> " + str1.charAt(4));

		// indexOf(char c)
		System.out.println("str1.indexOf('a') -> " + str1.indexOf('a'));

		// indexOf(char c)
		System.out.println("str1.lastIndexOf('a') -> " + str1.lastIndexOf('a'));

		// isEmpty()
		System.out.println("str1.isEmpty() -> " + str1.isEmpty());

		// toUpperCase()
		System.out.println("str1.toUpperCase() -> " + str1.toUpperCase());

		// subString(int beginIndex, int EndIndex)
		String str2 = str1.substring(2, 2 + "Páscoa".length());
		System.out
				.println("str2 = str1.substring(2, 2 + \"Páscoa\".length()) -> "
						+ str2);

		// toLowerCase
		System.out.println("str2.toLowerCase() -> " + str2.toLowerCase());

		// Comparisons
		boolean theyAreEquals = str2 == "Páscoa";
		System.out.println("\nstr2 (" + str2 + ") == \"Páscoa\" -> " + theyAreEquals);

		theyAreEquals = str2.equals("Páscoa");
		System.out.println("str2.equals(\"Páscoa\") -> " + theyAreEquals);

		// read the documentation of compareTo
		System.out.println("\"olá\".compareTo(\"Olá\") -> "
				+ "olá".compareTo("Olá"));
		System.out.println("\"olá\".compareToIgnoreCase(\"Olá\") -> "
				+ "olá".compareToIgnoreCase("Olá"));
		
		"olá".trim();
		
		
		
System.out.println("olá".equals(null));
	}

}
