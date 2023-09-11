package classcode.p06ClassesAndObjects;

import classcode.p06ClassesAndObjects.C10Conta;

/**
 * Serve somente para testar o acesso aos métodos public, private e
 * package-private da classe C10Conta
 * 
 */
public class C11ClassDummy {

	public static void main(String[] args) {

		// é possível aceder aos método public de C10Conta
		C10Conta.setTaxaJuroAnual(0.0);

		// não é possível aceder aos métodos private de C10Conta
		//C10Conta.calcularJuros(10000, 2);

		// é possível aceder aos métodos package-private de C10Conta
		C10Conta.getTaxaJuroAnual();

	}
}
