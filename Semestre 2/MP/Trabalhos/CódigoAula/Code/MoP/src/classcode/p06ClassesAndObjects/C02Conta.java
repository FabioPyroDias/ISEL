package classcode.p06ClassesAndObjects;

/**
 * Classe para suportar conta de depósitos com taxa de juro anual e juros
 * aplicados somente no final do ano. Só se regista o mês do último movimento e
 * os juros são aplicados no final do ano ao saldo existente. Os juros são
 * registados como sendo um movimento do mês 0, que correponde ao saldo de
 * início do ano.
 * 
 * Suporta agora vários atributos de instância o que permite criar várias contas
 */
public class C02Conta {

	// Atributos estáticos - são variável globais à classe

	// taxa de juro anual a aplicar so no final do ano
	private static double taxaJuroAnual = 0.01;
	// número a atribuir à pxóima conta que for criada
	private static int proximoNumeroDeConta = 1;

	// Métodos estáticos - métodos que podem aceder só aos atributos estáticos

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
	 * método para cálcular os juros a partir do mês recebido
	 */
	public static double calcularJuros(double valor, int nMeses) {
		return valor * nMeses / 12 * taxaJuroAnual;
	}
	
	// ===========================================================
	// Membros de instância

	// variáveis de instância - são variáveis que cada instância da classe
	// conterá uma cópia

	// número da conta
	int numeroDeConta;

	// saldo corrente da conta
	double saldo;

	// mês do último depósito, 0 representa o início do ano
	int mesDoUltimoDeposito;

	/**************************************************
	 * Constructor - método que inicializa um novo objecto
	 */
	public C02Conta() {
		System.out.println("constructor vazio...");
		saldo = 0;
		mesDoUltimoDeposito = 0;
		numeroDeConta = proximoNumeroDeConta++;
	}

	/**************************************************
	 * Constructor - método que inicializa um novo objecto
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
	 * Aplicar juros à conta
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
	 * Obter o número da conta
	 */
	public int getNumeroDeConta() {
		return numeroDeConta;

	}

	/**
	 * Obter uma string descritora da conta
	 */
	public String toString() {
		return "conta número " + getNumeroDeConta() + " com saldo de "
				+ getSaldo() + " com último deposito no mês "
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
		
		// criar uma série de contas
		C02Conta[] array =  new C02Conta[10000];
		for (int i = 0; i < 10000; i++) {
			array[i] = new C02Conta();	
		}
		
		
		System.out.println("conta0 -> " + conta0);
		conta0.aplicarJuros();
		System.out.println("conta0 -> " + conta0);

		// teste à conta 1
		C02Conta conta1 = new C02Conta(10000, 3);
		System.out.println("\nconta1 -> " + conta1);
		conta1.aplicarJuros();
		System.out.println("conta1 -> " + conta1);

		// teste à conta 2
		C02Conta conta2 = new C02Conta(5000, 5);
		System.out.println("\nconta2 -> " + conta2);
		conta2.depositar(3000, 5);
		System.out.println("conta2 deposito de 3000 no mês 5");
		System.out.println("conta2 -> " + conta2);

		// uso de referências
		C02Conta c2 = conta2;
		c2.depositar(2000, 6);
		System.out.println("conta2 -> " + conta2);
		System.out.println("c2 -> " + c2);

	}

}
