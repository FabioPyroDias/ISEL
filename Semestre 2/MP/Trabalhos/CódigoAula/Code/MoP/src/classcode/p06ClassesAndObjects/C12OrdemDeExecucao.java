package classcode.p06ClassesAndObjects;


/**
 * Teste à ordem de execução
 *
 */
public class C12OrdemDeExecucao {

	/**
	 * Static variables
	 */
	public static int k = 10;

	public static int j = m1("static");

	/**
	 * Instance variable
	 */
	public int i = m1("instance var");

	/**
	 * Static method
	 */
	public static int m1(String str) {
		System.out.println("m1: " + str + " k -> " + k);
		++k; 
		return k;
	}

	/**
	 * Initializer blocks
	 */
	{
		System.out.println("block1: " + m1("block1"));
	}

	{
		System.out.println("block2: " + m1("block2"));
	}

	/**
	 * constructor
	 */
	public C12OrdemDeExecucao() {
		System.out.println("constructor: " + m1("constructor"));
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		System.out.println("Main: " + m1("main"));

		System.out.println("Main: vai criar objecto C12OrdemDeExecução");
		C12OrdemDeExecucao c = new C12OrdemDeExecucao();
		System.out.println(c);
	}

}
