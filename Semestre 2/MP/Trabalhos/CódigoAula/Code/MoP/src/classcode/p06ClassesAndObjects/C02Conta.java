package classcode.p06ClassesAndObjects;

/**
 * Classe para suportar conta de dep�sitos com taxa de juro anual e juros
 * aplicados somente no final do ano. S� se regista o m�s do �ltimo movimento e
 * os juros s�o aplicados no final do ano ao saldo existente. Os juros s�o
 * registados como sendo um movimento do m�s 0, que correponde ao saldo de
 * in�cio do ano.
 * 
 * Suporta agora v�rios atributos de inst�ncia o que permite criar v�rias contas
 */
public class C02Conta {

	// Atributos est�ticos - s�o vari�vel globais � classe

	// taxa de juro anual a aplicar so no final do ano
	private static double taxaJuroAnual = 0.01;
	// n�mero a atribuir � px�ima conta que for criada
	private static int proximoNumeroDeConta = 1;

	// M�todos est�ticos - m�todos que podem aceder s� aos atributos est�ticos

	/**
	 * alterar a taxa de juro
	 */
	public static void setTaxaJuroAnual(double novaTaxa) {
		taxaJuroAnual = novaTaxa;
	}

	/**
	 * obter a taxa de juro
	 */
	public static double getTaxaJuroAnual() {
		return taxaJuroAnual;
	}

	/**
	 * m�todo para c�lcular os juros a partir do m�s recebido
	 */
	public static double calcularJuros(double valor, int nMeses) {
		return valor * nMeses / 12 * taxaJuroAnual;
	}
	
	// ===========================================================
	// Membros de inst�ncia

	// vari�veis de inst�ncia - s�o vari�veis que cada inst�ncia da classe
	// conter� uma c�pia

	// n�mero da conta
	int numeroDeConta;

	// saldo corrente da conta
	double saldo;

	// m�s do �ltimo dep�sito, 0 representa o in�cio do ano
	int mesDoUltimoDeposito;

	/**************************************************
	 * Constructor - m�todo que inicializa um novo objecto
	 */
	public C02Conta() {
		System.out.println("constructor vazio...");
		saldo = 0;
		mesDoUltimoDeposito = 0;
		numeroDeConta = proximoNumeroDeConta++;
	}

	/**************************************************
	 * Constructor - m�todo que inicializa um novo objecto
	 */
	public C02Conta(double saldo, int mesCorrente) {
		this.saldo = saldo;
		this.mesDoUltimoDeposito = mesCorrente;
		this.numeroDeConta = proximoNumeroDeConta++;
	}

	/**
	 * Depositar dinheiro
	 */
	public boolean depositar(double valor, int mesDoDeposito) {
		boolean sucesso = false;
		if (valor > 0) {
			saldo += valor;
			mesDoUltimoDeposito = mesDoDeposito;
			sucesso = true;
		}
		return sucesso;
	}

	/**
	 * Levantar dinheiro
	 */
	public boolean levantar(double valor) {
		boolean sucesso = false;
		if (valor > 0 && saldo >= valor) {
			saldo -= valor;
			sucesso = true;
		}
		return sucesso;
	}

	/**
	 * Aplicar juros � conta
	 */
	public void aplicarJuros() {
		double juros = calcularJuros(saldo, 12 - mesDoUltimoDeposito);
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
	 * Obter uma string descritora da conta
	 */
	public String toString() {
		return "conta n�mero " + getNumeroDeConta() + " com saldo de "
				+ getSaldo() + " com �ltimo deposito no m�s "
				+ mesDoUltimoDeposito;
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		//C02Conta.setTaxaJuroAnual(0);
		
		C02Conta conta0 = new C02Conta();
		System.out.println("conta0 -> " + conta0);
		conta0.depositar(100000, 3);
		
		// criar uma s�rie de contas
		C02Conta[] array =  new C02Conta[10000];
		for (int i = 0; i < 10000; i++) {
			array[i] = new C02Conta();	
		}
		
		
		System.out.println("conta0 -> " + conta0);
		conta0.aplicarJuros();
		System.out.println("conta0 -> " + conta0);

		// teste � conta 1
		C02Conta conta1 = new C02Conta(10000, 3);
		System.out.println("\nconta1 -> " + conta1);
		conta1.aplicarJuros();
		System.out.println("conta1 -> " + conta1);

		// teste � conta 2
		C02Conta conta2 = new C02Conta(5000, 5);
		System.out.println("\nconta2 -> " + conta2);
		conta2.depositar(3000, 5);
		System.out.println("conta2 deposito de 3000 no m�s 5");
		System.out.println("conta2 -> " + conta2);

		// uso de refer�ncias
		C02Conta c2 = conta2;
		c2.depositar(2000, 6);
		System.out.println("conta2 -> " + conta2);
		System.out.println("c2 -> " + c2);

	}

}
