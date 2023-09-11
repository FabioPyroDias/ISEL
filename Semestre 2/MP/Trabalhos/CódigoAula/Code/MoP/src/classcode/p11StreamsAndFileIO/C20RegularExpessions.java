package classcode.p11StreamsAndFileIO;

import java.util.Arrays;

public class C20RegularExpessions {

	public static void main(String[] args) {

		String input = " 1  fish    2 fish red fish blue fish ";
		String input2 = "1  fish    2 fish red fish blue fish";
		System.out.println("input  = '" + input + "'");

		String[] result = input.split(" ");
		System.out.println("input.split(\" \")   = " + Arrays.toString(result));

		result = input.split("\\s");
		System.out
				.println("input.split(\"\\\\s\") = " + Arrays.toString(result));

		// separator one or more times
		result = input.split("\\s+");
		System.out.println(
				"input.split(\"\\\\s+\") = " + Arrays.toString(result));

		result = input.split("\\s+fish\\s+");
		System.out.println(
				"input.split(\"\\s+fish\\s+\") = " + Arrays.toString(result));

		result = input.split("\\s*fish\\s*");
		System.out.println("input.split(\"\\s*fish\\s*\") = "
				+ Arrays.toString(result));

		///////////////////////////////////////
		System.out.println("input2 = '" + input2 + "'");
		
		result = input2.split("\\s+");
		System.out.println(
				"input2.split(\"\\\\s+\") = " + Arrays.toString(result));

		result = input2.split("\\s+");
		System.out.println(
				"input2.split(\"\\\\s+\") = " + Arrays.toString(result));

		result = input2.split("\\s+fish\\s+");
		System.out.println(
				"input2.split(\"\\s+fish\\s+\") = " + Arrays.toString(result));

		result = input2.split("\\s*fish\\s*");
		System.out.println("input2.split(\"\\s*fish\\s*\") = "
				+ Arrays.toString(result));
		
		////////////////////////////////////////////////////////////////
		System.out.println();
		
		String str = " 100   200   300 400  500  ";
		
		String[] tokens = str.split(" ");
		System.out.println(Arrays.toString(tokens));
		
		
		tokens = str.split("\\s+");
		System.out.println(Arrays.toString(tokens));
		
		str = " 100 -  200 -  300 -400 - 500  ";
		tokens = str.split("-");
		System.out.println(Arrays.toString(tokens));                                                                               
		
		
		str = " 100 -  200   300 -400 - 500  ";
		tokens = str.split("\\s+(-\\s*)?");
		System.out.println("3 " + Arrays.toString(tokens));
		
		str = " 100 -  200 :  300 -400 : 500  ";
		tokens = str.split("\\s+((-|:)\\s*)?");
		System.out.println(Arrays.toString(tokens));
		
		System.out.println("sd\tf".trim());
	}

}
