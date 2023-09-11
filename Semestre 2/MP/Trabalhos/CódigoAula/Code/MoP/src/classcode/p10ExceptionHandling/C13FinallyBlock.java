package classcode.p10ExceptionHandling;

/**
 * Para analizar o resultado
 * 
 */
public class C13FinallyBlock {

	public static void metodo1(int x) throws Exception {
		try {
			// gerar uma excepção
			throw new Exception("Erro");
		} catch (Exception e) {
			System.out.println("Exception catched in m1 -> "
					+ e.getClass().getSimpleName() + " " + e.getMessage());
			// testar com o return e substituir o return pela linha seguinte
			return;
			// throw new Exception("Ole");
		} finally {
			System.out.println("Finally in m1...");
		}
	}

	public static void metodo2(int x) {
		// gerar uma excepção de runtime
		ArithmeticException ae = new ArithmeticException("AE");
		throw ae;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		try {
			metodo1(20);
			metodo2(20);
		} catch (Exception e) {
			System.out.println("Exception catched in main -> "
					+ e.getClass().getSimpleName() + " " + e.getMessage());
			// experimentar com o exit
			// System.exit(0);
		} finally {
			System.out.println("Finally in main ...");
		}

		metodo2(20);
	}
}