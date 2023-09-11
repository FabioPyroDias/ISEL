package classcode.p06ClassesAndObjects;

/**
 * Exemplos de atributos e métodos com as várias visibilidades Só para se ver
 * como o eclipse os mostra na View de Outline (ou no Package Explorer se se
 * abre o conteúdo de um ficheiro java (ver a cor e a forma, triângulo azul com branco
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
	// Métodos ====================================

	// método private
	private int metodoPrivate(int x) {
		return x;
	}

	// método package private
	void metodoProtected() {
		System.out.println(metodoPrivate(privateInt));
	}

	// método public
	public void metodoPublic() {

	}
	
	public static void main(String[] args) {
		System.out.println(new C30AtributosEMetodos());
	}

}
