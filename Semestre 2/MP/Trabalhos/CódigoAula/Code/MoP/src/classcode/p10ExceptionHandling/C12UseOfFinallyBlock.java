package classcode.p10ExceptionHandling;

public class C12UseOfFinallyBlock {

	public static void metodo1(int x) throws MyException {
		try {
			System.out.println("Do something...");
			throw new MyException("Erro 1");
		} catch (Exception e) {
			System.out.println("Exception catched in m1 -> " + e.getMessage());
			if (e != null)
				throw new MyException("Erro 2");
			// new NullPointerException("null");
		} finally {
			System.out.println("Finally in method 1");
			// throw new MyException("Erro 3");
		}
	}

	public static void main(String[] args) throws MyException {
		// metodo1(20);
		try {
			System.out.println("Olá");
			metodo1(20);
			// throw new MyException("Erro 3"); // teste 1
			// throw new NullPointerException("null"); // teste 2
			return;
		} catch (MyException e) {
			System.out
					.println("Exception catched in main -> " + e.getMessage());
			e.printStackTrace();
			// System.out.println("Cause -> " + e.getCause());
			// System.out.println(
			// "Supressed -> " + Arrays.toString(e.getSuppressed()));
		} finally {
			System.out.println("Finally in main");
		}
		// System.out.println("End of main");
	}

}
