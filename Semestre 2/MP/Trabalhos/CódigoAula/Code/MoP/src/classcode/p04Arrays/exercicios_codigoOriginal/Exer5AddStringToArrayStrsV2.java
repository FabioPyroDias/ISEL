package classcode.p04Arrays.exercicios_codigoOriginal;

import java.util.Arrays;


/**
 * now with the use of java array methods
 */
public class Exer5AddStringToArrayStrsV2 {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_addString(null, "ola");
		test_addString(new String[] {}, "ola");
		test_addString(new String[] {"111", null}, "ola");
		test_addString(new String[] {"111", "222"}, "ola");
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_addString(String[] s1, String str) {
		String[] res = addString(s1, str);
		System.out.println(Arrays.toString(s1) + " + " + str + " = "
				+ Arrays.toString(res));
	}

	/**
	 * adicionar a String na primeira posição livre do array, caso o array
	 * esteja cheio deve criar um novo array com o dobro da dimensão do array
	 * recebido e nele colocar o conteúdo de s1 seguido de str
	 * 
	 */
	public static String[] addString(String[] s1, String str) {
		// TODO ...
		return null;
	}

}
