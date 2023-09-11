package classcode.p06ClassesAndObjects;

/**
 * Clase Aluno com nome, numero e UCs terminadas
 *
 */
public class C22Aluno {
	// n�mero m�ximo de UCS que um aluno pode registar
	public static final int MAXUCS = 100;

	// nome do aluno
	String nome;

	// n�mero do aluno
	int numero;

	// registo das UCs terminadas (a nota n�o � necess�ria). As UCs devem estar
	// sempre nos menores �ndices.
	String[] ucsTerminadas = new String[MAXUCS];

	// dever� conter o n�mero de UCs terminadas
	int nUCsTerminadas = 0;

	/**
	 * m�todo construtor, m�todo que inicializa uma nova inst�ncia de aluno
	 */
	public C22Aluno(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	/**
	 * Adiciona a UC se houver espa�o. Se a UC n�o for null ou vazia deve lan�ar
	 * a excep��o de IllegalArgumentException.
	 */
	public boolean addUCTerminada(String uc) {
		// verificar uc
		if (uc == null || uc.trim().length() == 0)
			throw new IllegalArgumentException(
					"A UC n�o pode ser null ou vazia: " + uc);

		// verificar espa�o
		if (nUCsTerminadas == ucsTerminadas.length)
			return false;

		// guardar UC no array e devolver sucesso
		ucsTerminadas[nUCsTerminadas++] = uc;
		return true;
	}

	/**
	 * M�todo toString, m�todo que a plataforma java quando necessita de
	 * "converter" o objecto para String. Deve devolver uma descri��o textual do
	 * objecto
	 */
	public String toString() {
		return nome + ", " + numero + ", ucs terminadas " + getUCsTerminadas();
	}

	/**
	 * devolve uma String com a lista das UCs terminadas pe�o aluno corrente
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
		C22Aluno a1 = new C22Aluno("Jo�o Almeida", 75678);
		System.out.println(a1);

		// criar um objecto aluno e mostr�-lo na consola
		C22Aluno a2 = new C22Aluno("Ana Martins", 75070);
		System.out.println(a2);

		// adicionar duas UC ao aluno "Jo�o Almeida" e mostr�-lo na consola
		a1.addUCTerminada("MDP");
		a1.addUCTerminada("TI");
		System.out.println(a1);
	}
}
