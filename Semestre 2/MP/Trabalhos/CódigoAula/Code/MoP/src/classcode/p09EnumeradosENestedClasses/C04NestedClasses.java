package classcode.p09EnumeradosENestedClasses;

public class C04NestedClasses {

	// variável static
	static int x = 0;
	static int x1 = 10;

	// variável de instância
	int n = 1;

	CA ca;

	CB cb;

	// constructor
	public C04NestedClasses(int n) {

		// create a instance of the static nested class
		ca = new CA();
		ca.m1(3);

		// create a instance of inner class
		// this instance lives inside this instance of C1
		// it can access its instance variables
		cb = new CB();
		cb.m1(n);
	}

	// static nested class
	static class CA {
		int x = 9;

		void m1(int x) {
			x = 20;

			// access to x of CA
			this.x = 3;
			x1 = 20;

			// access to x of C04
			C04NestedClasses.x = 3;

			// n = 4; // erro
		}

		public String toString() {
			return "x = " + x;
		}
	}

	// non-static nested class - a inner class
	class CB {
		int n = 0;

		void m1(int n) {
			x = 3;
			// access to n of CB
			this.n = n;
			// access to n of C04
			C04NestedClasses.this.n = n;
		}

		public String toString() {
			return "n = " + n;
		}
	}

	public String toString() {
		return "static x = " + x + ", n = " + n + ", ca [ " + ca + " ], cb = [ "
				+ cb + " ]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C04NestedClasses c1 = new C04NestedClasses(10);
		System.out.println(c1);

		// CA ca = new CA();
		// CB cb = new CB(); // erro
	}

}
