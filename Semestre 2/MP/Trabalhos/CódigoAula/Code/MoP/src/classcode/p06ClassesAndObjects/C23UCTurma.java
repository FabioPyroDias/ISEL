package classcode.p06ClassesAndObjects;

/**
 * Dever� conter uma turma de uma UC, por exemplo MOP-T21N
 */
public class C23UCTurma {
	// n�mero m�ximo de alunos que uma turma pode registar
	public final int MAXALUNOS_POR_UCTURMA = 100;

	// nome da UC
	String nomeUC;

	// identifica��o da turma
	String idTurma;

	// semestre em quest�o, ex�: 1516SV
	String semestre;

	// Alunos inscritos, os objectos devem ficar sempre nos menores �ndices
	C22Aluno[] alunosInscritos = new C22Aluno[MAXALUNOS_POR_UCTURMA];

	// dever� conter o n�mero de alunos inscritos e presentes no array
	int nAlunosInscritos = 0;

	/**
	 * m�todo construtor, m�todo que inicializa uma nova inst�ncia de UCTurma
	 */
	public C23UCTurma(String nomeUC, String idTurma, String semestre) {
		this.nomeUC = nomeUC;
		this.idTurma = idTurma;
		this.semestre = semestre;
	}

	/**
	 * Adiciona o aluno se houver espa�o. Se o aluno for null deve lan�ar a
	 * excep��o de IllegalArgumentException.
	 */
	public boolean addInscricao(C22Aluno aluno) {
		// verificar uc
		if (aluno == null)
			throw new IllegalArgumentException(
					"O aluno n�o pode ser null: " + aluno);

		// verificar espa�o
		if (nAlunosInscritos == alunosInscritos.length)
			return false;

		// guardar UC no array e devolver sucesso
		alunosInscritos[nAlunosInscritos++] = aluno;
		return true;
	}

	/**
	 * M�todo toString, m�todo que a plataforma java quando necessita de
	 * "converter" o objecto UCTurma para String. Deve devolver uma descri��o
	 * textual do objecto.
	 */
	public String toString() {
		return nomeUC + "-" + idTurma + "-" + semestre + ", alunos inscritos "
				+ getAlunosInscritos();
	}

	/**
	 * devolve uma String com a lista dos alunos inscritos
	 */
	public String getAlunosInscritos() {
		String result = "[";
		for (int i = 0; i < nAlunosInscritos; i++) {
			if (i > 0)
				result += ", ";
			result += "{" + alunosInscritos[i] + "}";
		}
		return result + "]";
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// criar mopNoite e mostrar o seu toString na consola
		C23UCTurma mopNoite = new C23UCTurma("MoP", "T21N", "1516SI");
		System.out.println(mopNoite);

		// criar mopDia
		C23UCTurma mopDia = new C23UCTurma("MoP", "T21D", "1516SI");
		System.out.println(mopDia);
		System.out.println();

		// ===================================================
		// criar objectos alunos e mostr�-los na consola
		C22Aluno a1 = new C22Aluno("Jo�o Almeida", 75678);
		a1.addUCTerminada("MDP");
		System.out.println(a1);

		C22Aluno a2 = new C22Aluno("Ana Martins", 75070);
		System.out.println(a2);
		System.out.println();

		// ===================================================
		// inscrever alunos nas turmas
		mopNoite.addInscricao(a1);
		mopNoite.addInscricao(a2);
		System.out.println(mopNoite);
		
		System.out.println(mopDia.MAXALUNOS_POR_UCTURMA);
	}
}
