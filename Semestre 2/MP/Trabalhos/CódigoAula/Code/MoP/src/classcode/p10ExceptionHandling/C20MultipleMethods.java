package classcode.p10ExceptionHandling;


/**
 * Agora o método DIVISAO tem de declarar que pode lançar a excepção Exception e
 * o método METODO1 tem de declarar que pode lançar a a excepção
 * NegativeValueException. Deste modo quem usar estes métodos sabe com o que
 * pode esperar.
 * 
 */
public class C20MultipleMethods {

	/**
	 * Método base
	 */
	public static int divisao(int dividendo, int divisor) {
		if (divisor == 0)
			throw new RuntimeException("Divisao por zero");
		int quociente = dividendo / divisor;
		return quociente;
	}

	/**
	 * método que utiliza o método base
	 */
	public static int metodo1(int dividendo, int divisor) {
		return divisao(dividendo, divisor);
	}

	/**
	 * main
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		metodo1(10, 0);
	}
}