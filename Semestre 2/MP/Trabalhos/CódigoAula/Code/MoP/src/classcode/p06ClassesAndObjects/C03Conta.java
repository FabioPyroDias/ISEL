package classcode.p06ClassesAndObjects;



/**
 * Classe para suportar conta de dep�sitos com taxa de juro anual e juros
 * aplicados somente no final do ano. S� se regista o m�s do �ltimo movimento e
 * os juros s�o aplicados no final do ano ao saldo existente. Os juros s�o
 * registados como sendo um movimento do m�s 0, que correponde ao saldo de
 * in�cio do ano.
 * 
 * Classe que suporta uma conta, remetendo o suporte �s contas para a classe
 * Gestor de Conta
 */
public class C03Conta {

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
	public C03Conta(int numeroDeconta) {
		// chama o outro construtor, tem de ser a 1� instru��o neste contrutor
		// System.out.println("construtor 1 ..."); // erro
		this(numeroDeconta, 0, 0);
		System.out.println("construtor 1 ...");
	}

	/**************************************************
	 * Constructor - m�todo que inicializa um novo objecto
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
		// falta verificar se valor e medDoDeposito s�o v�lidos
		saldo += valor;
		mesDoUltimoDeposito = mesDoDeposito;
	}

	/**
	 * Levantar dinheiro
	 */
	public void levantar(double valor) {
		// falta verificar se h� saldo e se valor � positivo
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
	public boolean equals(C03Conta conta) {
		return (conta != null)
				&& (getNumeroDeConta() == conta.getNumeroDeConta());
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// teste � conta 1
		C03Conta conta1 = new C03Conta(1, 10000, 3);
		System.out.println("conta1 -> " + conta1);
		conta1.aplicarJuros();
		System.out.println("conta1 -> " + conta1);

		// teste � conta 2
		C03Conta conta2 = new C03Conta(2, 5000, 5);
		System.out.println("\nconta2 -> " + conta2);
		conta2.depositar(3000, 5);
		System.out.println("conta2 deposito de 3000 no m�s 5");
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
