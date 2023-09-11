package classcode.p06ClassesAndObjects;

/**
 * Teste � visibilidade: public, private, package-private
 */
public class C10Conta {

	public static double taxaJuroAnual = 0.01;

	public static void setTaxaJuroAnual(double novaTaxa) {
		taxaJuroAnual = novaTaxa;
	}

	static double getTaxaJuroAnual() {
		return taxaJuroAnual;
	}

	private static double calcularJuros(double valor, int nMeses) {
		return valor * nMeses / 12 * getTaxaJuroAnual();
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Juros - calcularJuros(1000, 6) -> "
				+ calcularJuros(1000, 6));

		// � poss�vel aceder aos m�todo public de C10Conta
		C10Conta.setTaxaJuroAnual(0.0);

		// � poss�vel aceder aos m�todos private de C10Conta
		C10Conta.calcularJuros(10000, 2);

		// � poss�vel aceder aos m�todos package-private de C10Conta
		C10Conta.getTaxaJuroAnual();
	}

}
