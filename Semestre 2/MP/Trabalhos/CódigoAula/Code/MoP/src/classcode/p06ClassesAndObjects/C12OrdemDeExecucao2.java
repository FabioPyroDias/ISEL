package classcode.p06ClassesAndObjects;

/**
 * Teste à ordem de execução
 *
 */
public class C12OrdemDeExecucao2 {

	/**
	 * Static variables
	 */
	public static int k = m1("static k");

	
	/**
	 * Instance variable
	 */
	public int i = m1("instance i");

	/**
	 * Static method
	 */
	public static int m1(String str) {
		System.out.println(str);
		return 0;
	}

	/**
	 * Initializer blocks
	 */
	{
		System.out.println("Initializer block1");
	}

	{
		System.out.println("Initializer block2");
	}

	static {
		System.out.println("Initializer static block");
	}

	/**
	 * constructor
	 */
	public C12OrdemDeExecucao2() {
		System.out.println("constructor: " + m1("constructor"));
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		System.out.println("Main--");
		m1("main");

		System.out.println("Main: vai criar objecto C12OrdemDeExecução");
		C12OrdemDeExecucao2 c = new C12OrdemDeExecucao2();
		System.out.println(c);
	}

}
