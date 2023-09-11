package classcode.p10ExceptionHandling;

/**
 * Agora o método DIVISAO tem de declarar que pode lançar a excepção Exception e
 * o método METODO1 tem de declarar que pode lançar a a excepção
 * NegativeValueException. Deste modo quem usar estes métodos sabe com o que
 * pode esperar.
 * 
 */
public class C22Catch {

	/**
	 * Método base
	 * @throws Exception 
	 */
	public static int divisao(int dividendo, int divisor) throws Exception {
		// try {
		if (divisor == 0)
			throw new Exception("Divisao por zero");

		// } catch (Exception e) {
		// divisor = 1;
		// }
		int quociente = dividendo / divisor;
		return quociente;
	}

	/**
	 * método que utiliza o método base
	 * @throws Exception 
	 */
	public static int metodo1(int dividendo, int divisor) throws Exception {

		return divisao(dividendo, divisor);
	}

	/**
	 * main
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			metodo1(10, 0);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}