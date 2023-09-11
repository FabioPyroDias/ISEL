package classcode.p06ClassesAndObjects;

/**
 * Exemplos de atributos e m�todos com as v�rias visibilidades S� para se ver
 * como o eclipse os mostra na View de Outline (ou no Package Explorer se se
 * abre o conte�do de um ficheiro java (ver a cor e a forma, tri�ngulo azul com branco
 * no meio, quadrado vermelho grande,...
 */
public class C30AtributosEMetodos {

	// ============================================
	// Atributos ====================================

	// atributo private
	private int privateInt;

	// atributo package private
	int packagePrivateInt;

	// atributo public
	public int publicInt;

	// ============================================
	// M�todos ====================================

	// m�todo private
	private int metodoPrivate(int x) {
		return x;
	}

	// m�todo package private
	void metodoProtected() {
		System.out.println(metodoPrivate(privateInt));
	}

	// m�todo public
	public void metodoPublic() {

	}
	
	public static void main(String[] args) {
		System.out.println(new C30AtributosEMetodos());
	}

}
