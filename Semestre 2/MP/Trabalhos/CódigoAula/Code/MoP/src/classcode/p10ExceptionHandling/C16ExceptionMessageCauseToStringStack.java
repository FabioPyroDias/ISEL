package classcode.p10ExceptionHandling;

/**
 * Teste ao conteúdo de Exception
 *
 */
public class C16ExceptionMessageCauseToStringStack {

	/**
	 * main
	 */
	public static void main(String[] args) {

		try {
			throw new NullPointerException("The message");
		} catch (Exception e) {
			System.out.println("Exception message -> " + e.getMessage());
			System.out.println("Exception cause -> " + e.getCause());
			System.out.println("Exception toString -> " + e);
			
			StackTraceElement[] stackTrace = e.getStackTrace();
			for (int i = 0; i < stackTrace.length; i++) {
				System.out.println(stackTrace[i]);
			}
			e.printStackTrace();
		}
	}

}
