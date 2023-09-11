package classcode.p06ClassesAndObjects.packDummy;

import classcode.p06ClassesAndObjects.C10Conta;

/**
 * Serve somente para testar o acesso aos m�todos public, private e
 * package-private da classe C10Conta
 * 
 */
public class ClassDummy {

	public static void main(String[] args) {

		// � poss�vel aceder aos m�todo public de C10Conta
		C10Conta.setTaxaJuroAnual(0.0);

		// n�o � poss�vel aceder aos m�todos private de C10Conta
		// C10Conta.calcularJuros(10000, 2);

		// n�o � poss�vel aceder aos m�todos package-private de C10Conta
		// C10Conta.getTaxaJuroAnual();

	}
}
