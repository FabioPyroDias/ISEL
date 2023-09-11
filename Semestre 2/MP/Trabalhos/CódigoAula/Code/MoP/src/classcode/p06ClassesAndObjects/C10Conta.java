package classcode.p06ClassesAndObjects;

/**
 * Teste à visibilidade: public, private, package-private
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

		// é possível aceder aos método public de C10Conta
		C10Conta.setTaxaJuroAnual(0.0);

		// é possível aceder aos métodos private de C10Conta
		C10Conta.calcularJuros(10000, 2);

		// é possível aceder aos métodos package-private de C10Conta
		C10Conta.getTaxaJuroAnual();
	}

}
