package classcode.p06ClassesAndObjects;

/**
 * Classe para suportar contas de depósito com taxa de juro anual e juros
 * aplicados somente no final do ano. Só se regista o mês do último movimento e
 * os juros são aplicados no final do ano ao saldo existente. Os juros são
 * registados como sendo um movimento do mês 0, que correponde ao saldo de
 * início do ano.
 */
public class C01Conta {

	public static double taxaJuroAnual = 0.01;

	public static void setTaxaJuroAnual(double novaTaxa) {
		taxaJuroAnual = novaTaxa;
	}

	public static double getTaxaJuroAnual() {
		return taxaJuroAnual;
	}

	public static double calcularJuros(double valor, int nMeses) {
		return valor * nMeses / 12 * getTaxaJuroAnual();
	}
	
	public void m1(){
		System.out.println("m1");
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		setTaxaJuroAnual(0.5);
		System.out.println("Juros - calcularJuros(1000, 6) -> " + calcularJuros(1000, 6));
		setTaxaJuroAnual(0.1);
		System.out.println("Juros - calcularJuros(1000, 6) -> " + calcularJuros(1000, 6));
	}

}
