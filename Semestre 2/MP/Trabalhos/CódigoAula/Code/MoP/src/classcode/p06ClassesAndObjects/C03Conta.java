package classcode.p06ClassesAndObjects;



/**
 * Classe para suportar conta de depósitos com taxa de juro anual e juros
 * aplicados somente no final do ano. Só se regista o mês do último movimento e
 * os juros são aplicados no final do ano ao saldo existente. Os juros são
 * registados como sendo um movimento do mês 0, que correponde ao saldo de
 * início do ano.
 * 
 * Classe que suporta uma conta, remetendo o suporte às contas para a classe
 * Gestor de Conta
 */
public class C03Conta {

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
	public C03Conta(int numeroDeconta) {
		// chama o outro construtor, tem de ser a 1ª instrução neste contrutor
		// System.out.println("construtor 1 ..."); // erro
		this(numeroDeconta, 0, 0);
		System.out.println("construtor 1 ...");
	}

	/**************************************************
	 * Constructor - método que inicializa um novo objecto
	 */
	public C03Conta(int numeroDeconta, double saldo, int mesCorrente) {
		this.saldo = saldo;
		this.mesDoUltimoDeposito = mesCorrente;
		this.numeroDeConta = numeroDeconta;
		// System.out.println("construtor 2 ...");
	}

	/**
	 * Depositar dinheiro
	 */
	public void depositar(double valor, int mesDoDeposito) {
		// falta verificar se valor e medDoDeposito são válidos
		saldo += valor;
		mesDoUltimoDeposito = mesDoDeposito;
	}

	/**
	 * Levantar dinheiro
	 */
	public void levantar(double valor) {
		// falta verificar se há saldo e se valor é positivo
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
	public boolean equals(C03Conta conta) {
		return (conta != null)
				&& (getNumeroDeConta() == conta.getNumeroDeConta());
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// teste à conta 1
		C03Conta conta1 = new C03Conta(1, 10000, 3);
		System.out.println("conta1 -> " + conta1);
		conta1.aplicarJuros();
		System.out.println("conta1 -> " + conta1);

		// teste à conta 2
		C03Conta conta2 = new C03Conta(2, 5000, 5);
		System.out.println("\nconta2 -> " + conta2);
		conta2.depositar(3000, 5);
		System.out.println("conta2 deposito de 3000 no mês 5");
		System.out.println("conta2 -> " + conta2);

		C03Conta conta3 = new C03Conta(3);
		System.out.println("conta3 -> " + conta3);
		conta3.depositar(100000, 3);
		System.out.println("conta3 -> " + conta3);
		conta3.aplicarJuros();
		System.out.println("conta3 -> " + conta3);
		System.out.println();
		
		boolean c1EqualsC3 = conta1.equals(conta3);
		System.out.println("conta1 equals conta3 = " + c1EqualsC3);
		C03Conta c = conta1;
		System.out.println("c = conta1; c equals conta1 -> " + c.equals(conta1));
	}

}
