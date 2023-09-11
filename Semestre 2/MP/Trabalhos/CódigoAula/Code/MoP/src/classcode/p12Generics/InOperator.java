package classcode.p12Generics;

import java.util.Arrays;

public class InOperator {

	/**
	 * In operator, a useful operator
	 */
	@SafeVarargs
	public static <T> boolean in(T value, T... list) {
		for (T item : list) {
			if (value.equals(item))
				return true;
		}
		return false;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		boolean in = in(1, 1, 2, 3);
		System.out.println("in(1, 1, 2, 3) -> " + in);

		in = Arrays.asList(1, 2, 3).contains(1);
		System.out.println("Arrays.asList(1, 2, 3).contains(1) -> " + in);

		in = in("um", "zero", "um", "dois");
		System.out.println("in(\"um\", \"zero\", \"um\", \"dois\") -> " + in);

		in = Arrays.asList("zero", "um", "dois").contains("um");
		System.out.println("Arrays.asList(\"zero\", \"um\", \"dois\").contains(\"um\") -> " + in);
	}

}
