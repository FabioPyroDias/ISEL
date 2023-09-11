package classcode.p10ExceptionHandling;

import java.util.Arrays;

public class C17CatchWithMultiExceptions {

	public static void main(String[] args) {
		MyException e = new MyException("e1");
		System.out.println("Exception -> " + e.getMessage());
		try {
			System.out.println("args = "+ Arrays.toString(args));
			System.out.println("std out");
			Thread.sleep(5000);
			System.err.println("std err");

			if (args.length == 0)
				throw new DivideByZeroException();

			throw e;
		} catch (MyException | DivideByZeroException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
