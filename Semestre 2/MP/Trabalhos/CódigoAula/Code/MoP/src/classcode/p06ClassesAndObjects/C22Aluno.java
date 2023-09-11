package classcode.p06ClassesAndObjects;

/**
 * Clase Aluno com nome, numero e UCs terminadas
 *
 */
public class C22Aluno {
	// número máximo de UCS que um aluno pode registar
	public static final int MAXUCS = 100;

	// nome do aluno
	String nome;

	// número do aluno
	int numero;

	// registo das UCs terminadas (a nota não é necessária). As UCs devem estar
	// sempre nos menores índices.
	String[] ucsTerminadas = new String[MAXUCS];

	// deverá conter o número de UCs terminadas
	int nUCsTerminadas = 0;

	/**
	 * método construtor, método que inicializa uma nova instância de aluno
	 */
	public C22Aluno(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	/**
	 * Adiciona a UC se houver espaço. Se a UC não for null ou vazia deve lançar
	 * a excepção de IllegalArgumentException.
	 */
	public boolean addUCTerminada(String uc) {
		// verificar uc
		if (uc == null || uc.trim().length() == 0)
			throw new IllegalArgumentException(
					"A UC não pode ser null ou vazia: " + uc);

		// verificar espaço
		if (nUCsTerminadas == ucsTerminadas.length)
			return false;

		// guardar UC no array e devolver sucesso
		ucsTerminadas[nUCsTerminadas++] = uc;
		return true;
	}

	/**
	 * Método toString, método que a plataforma java quando necessita de
	 * "converter" o objecto para String. Deve devolver uma descrição textual do
	 * objecto
	 */
	public String toString() {
		return nome + ", " + numero + ", ucs terminadas " + getUCsTerminadas();
	}

	/**
	 * devolve uma String com a lista das UCs terminadas peço aluno corrente
	 */
	public String getUCsTerminadas() {
		String result = "[";
		for (int i = 0; i < nUCsTerminadas; i++) {
			if (i > 0)
				result += ", ";
			result += ucsTerminadas[i];
		}
		return result + "]";
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// criar um objecto aluno e mostrar o seu toString na consola
		C22Aluno a1 = new C22Aluno("João Almeida", 75678);
		System.out.println(a1);

		// criar um objecto aluno e mostrá-lo na consola
		C22Aluno a2 = new C22Aluno("Ana Martins", 75070);
		System.out.println(a2);

		// adicionar duas UC ao aluno "João Almeida" e mostrá-lo na consola
		a1.addUCTerminada("MDP");
		a1.addUCTerminada("TI");
		System.out.println(a1);
	}
}
