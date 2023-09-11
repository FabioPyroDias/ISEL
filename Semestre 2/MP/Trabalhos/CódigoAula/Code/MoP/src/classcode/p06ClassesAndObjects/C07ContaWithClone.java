package classcode.p06ClassesAndObjects;

/**
 * Exemplo de classe que suporta a opera��o por omiss�o de clone
 */
public class C07ContaWithClone implements Cloneable {

	// vari�veis de inst�ncia - s�o vari�veis que cada inst�ncia da classe
	// conter� uma c�pia

	// n�mero da conta
	private int numeroDeConta;

	// saldo corrente da conta
	double saldo;

	// m�s do �ltimo dep�sito, 0 representa o in�cio do ano
	public int mesDoUltimoDeposito;

	/**************************************************
	 * Constructor - m�todo que inicializa um novo objecto
	 */
	public C07ContaWithClone(int numeroDeconta) {
		// chama o outro construtor
		this(numeroDeconta, 0, 0);
		System.out.println("construtor 1 ...");
	}

	/**************************************************
	 * Constructor - m�todo que inicializa um novo objecto
	 */
	public C07ContaWithClone(int numeroDeconta, double saldo, int mesCorrente) {
		this.saldo = saldo;
		this.mesDoUltimoDeposito = mesCorrente;
		this.numeroDeConta = numeroDeconta;
		System.out.println("construtor 2 ...");
	}

	/**
	 * Depositar dinheiro
	 */
	public void depositar(double valor, int mesDoDeposito) {
		saldo += valor;
		mesDoUltimoDeposito = mesDoDeposito;
	}

	/**
	 * Levantar dinheiro
	 */
	public void levantar(double valor) {
		saldo -= valor;
	}

	/**
	 * Aplicar juros � conta
	 */
	public void aplicarJuros() {
		double juros = C04GestorContas.calcularJuros(saldo,
				12 - mesDoUltimoDeposito);
		saldo += juros;
		mesDoUltimoDeposito = 0;
	}

	/**
	 * Obter o saldo corrente
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Obter o n�mero da conta
	 */
	public int getNumeroDeConta() {
		return numeroDeConta;
	}

	/**
	 * Obter uma string descritora da conta. TESTE: comentar todo este m�todo,
	 * incluindo a linha de public e at� ao seu final. Observar o resultado.
	 */
	public String toString() {
		return "conta n�mero " + getNumeroDeConta() + " com saldo de "
				+ getSaldo() + " com �ltimo deposito no m�s "
				+ mesDoUltimoDeposito;
	}

	/**
	 * M�todo que indica se duas contas s�o a mesma ou n�o. Duas contas s�o a
	 * mesma se t�m o mesmo n�mero de conta.
	 */
	public boolean equals(C07ContaWithClone conta) {
		return (conta != null)
				&& (getNumeroDeConta() == conta.getNumeroDeConta());
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// teste � conta 1
		C07ContaWithClone conta1 = new C07ContaWithClone(1, 10000, 3);
		System.out.println("conta1 -> " + conta1);
		conta1.aplicarJuros();
		System.out.println("conta1 -> " + conta1);
		C07ContaWithClone conta11 = null;

		try {
			conta11 = (C07ContaWithClone) conta1.clone();
			conta11.depositar(2000, 2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("conta1 -> " + conta1);
		System.out.println("conta1Clone -> " + conta11);

		// teste � conta 2
		C07ContaWithClone conta2 = new C07ContaWithClone(2, 5000, 5);
		System.out.println("\nconta2 -> " + conta2);
		conta2.depositar(3000, 5);
		System.out.println("conta2 deposito de 3000 no m�s 5");
		System.out.println("conta2 -> " + conta2);

		C07ContaWithClone conta3 = new C07ContaWithClone(3);
		System.out.println("conta3 -> " + conta3);
		conta3.depositar(100000, 3);
		System.out.println("conta3 -> " + conta3);
		conta3.aplicarJuros();
		System.out.println("conta3 -> " + conta3);
	}

}
