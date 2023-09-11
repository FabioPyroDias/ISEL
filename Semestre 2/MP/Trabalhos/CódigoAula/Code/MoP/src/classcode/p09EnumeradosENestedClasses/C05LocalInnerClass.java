package classcode.p09EnumeradosENestedClasses;

/**
 * Interface ICounter
 * 
 */
interface ICounter {
	int next();
}

/**
 * 
 */
public class C05LocalInnerClass {
	private int count = 0;

	/**
	 * Method that defines an local inner class
	 */
	ICounter getCounter(final String name) {
		// the local inner class:
		class LocalCounter implements ICounter {
			int localCounter = 0;

			public LocalCounter() {
				// Local inner class can have a constructor
				System.out.println("LocalCounter()");
			}
			
			// class XX {
			// int l = localCounter;
			// String s = name;
			// }

			public int next() {
				// Access local variable, it must be final
				System.out.print(name);

				// local counter;
				localCounter++;
				System.out.print("localCounter -> " + localCounter + "  ");

				// access class field, don't have to be final
				return count++;
			}
		}
		return new LocalCounter();
	}

	// Method with an anonymous inner class:
	ICounter getCounter2(final String name) {
		ICounter ic = new ICounter() {
			int localCounter = 0;

			// Anonymous inner class cannot have a named
			// constructor, only an instance initializer:
			{
				System.out.println("Anonymous ICounter()");
			}

			public int next() {
				// Access local final
				System.out.print(name);

				localCounter++;
				System.out.print("localCounter -> " + localCounter + "  ");

				return count += 2;
			}
		};
		return ic;
	}

	public static void main(String[] args) {

		C05LocalInnerClass lic = new C05LocalInnerClass();

		ICounter c1 = lic.getCounter("Local inner ");
		ICounter c2 = lic.getCounter2("Anonymous inner ");

		for (int i = 0; i < 5; i++)
			System.out.println(c1.next());

		for (int i = 0; i < 5; i++)
			System.out.println(c2.next());
	}
}
