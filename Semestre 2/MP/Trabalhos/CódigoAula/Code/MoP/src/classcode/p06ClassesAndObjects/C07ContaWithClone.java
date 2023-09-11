package classcode.p06ClassesAndObjects;

/**
 * Exemplo de classe que suporta a operação por omissão de clone
 */
public class C07ContaWithClone implements Cloneable {

	// variáveis de instância - são variáveis que cada instância da classe
	// conterá uma cópia

	// número da conta
	private int numeroDeConta;

	// saldo corrente da conta
	double saldo;

	// mês do último depósito, 0 representa o início do ano
	public int mesDoUltimoDeposito;

	/**************************************************
	 * Constructor - método que inicializa um novo objecto
	 */
	public C07ContaWithClone(int numeroDeconta) {
		// chama o outro construtor
		this(numeroDeconta, 0, 0);
		System.out.println("construtor 1 ...");
	}

	/**************************************************
	 * Constructor - método que inicializa um novo objecto
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
	 * Aplicar juros à conta
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
	 * Obter o número da conta
	 */
	public int getNumeroDeConta() {
		return numeroDeConta;
	}

	/**
	 * Obter uma string descritora da conta. TESTE: comentar todo este método,
	 * incluindo a linha de public e até ao seu final. Observar o resultado.
	 */
	public String toString() {
		return "conta número " + getNumeroDeConta() + " com saldo de "
				+ getSaldo() + " com último deposito no mês "
				+ mesDoUltimoDeposito;
	}

	/**
	 * Método que indica se duas contas são a mesma ou não. Duas contas são a
	 * mesma se têm o mesmo número de conta.
	 */
	public boolean equals(C07ContaWithClone conta) {
		return (conta != null)
				&& (getNumeroDeConta() == conta.getNumeroDeConta());
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// teste à conta 1
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

		// teste à conta 2
		C07ContaWithClone conta2 = new C07ContaWithClone(2, 5000, 5);
		System.out.println("\nconta2 -> " + conta2);
		conta2.depositar(3000, 5);
		System.out.println("conta2 deposito de 3000 no mês 5");
		System.out.println("conta2 -> " + conta2);

		C07ContaWithClone conta3 = new C07ContaWithClone(3);
		System.out.println("conta3 -> " + conta3);
		conta3.depositar(100000, 3);
		System.out.println("conta3 -> " + conta3);
		conta3.aplicarJuros();
		System.out.println("conta3 -> " + conta3);
	}

}
