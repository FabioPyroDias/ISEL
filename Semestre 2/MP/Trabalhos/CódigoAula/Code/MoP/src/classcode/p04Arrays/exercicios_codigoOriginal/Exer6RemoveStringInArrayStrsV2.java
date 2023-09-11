package classcode.p04Arrays.exercicios_codigoOriginal;

import java.util.Arrays;

/**
 * now with the use of java array methods
 */
public class Exer6RemoveStringInArrayStrsV2 {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_addString(null, "ola");
		test_addString(new String[] {}, "ola");
		test_addString(new String[] { "111", null }, "ola");
		test_addString(new String[] { "111", null  }, "111");
		test_addString(new String[] { "111", "222", null, null, null, null }, "222");
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_addString(String[] s1, String str) {
		String[] res = removeString(s1, str);
		System.out.println(Arrays.toString(s1) + " - " + str + " = "
				+ Arrays.toString(res));
	}

	/**
	 * remover a primeira ocorrência de str no array; e deslocar as Strings de
	 * índex maiores de forma a não haver nulls entre Strings. Se remover deve
	 * devolver o array, caso contrário deve devolver null. Caso o número de
	 * Strings final no array seja inferior a 40% da dimensão do mesmo, deve
	 * devolver um novo array com metade da dimensão do array recebido e com o
	 * novo conteúdo de Strings. A dimensão mínima do array a devolver, quando
	 * se diminui o array, é de 5 .
	 */
	public static String[] removeString(String[] s1, String str) {
		// TODO ...
		return null;
	}

}
