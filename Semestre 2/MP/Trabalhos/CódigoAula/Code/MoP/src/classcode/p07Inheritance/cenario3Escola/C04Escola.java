package classcode.p07Inheritance.cenario3Escola;

/**
 * cenário de utilização da hierarquia de classes definida: classe Pessoa,
 * classe Aluno e classe Docente
 */
public class C04Escola {

	// nome da escola
	private String nomeEscola;

	// array de pessoas na escola
	private C01Pessoa[] pessoas = new C01Pessoa[1000];
	private int nPessoas = 0;

	/**
	 * constructor
	 */
	public C04Escola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	// general methods

	/**
	 * 
	 */
	public String getNomeEscola() {
		return nomeEscola;
	}

	/**
	 * Contar o nº de docentes. Utiliza
	 */
	public int getNumDocentes() {
		int nDocentes = 0;
		for (int i = 0; i < nPessoas; i++) {
			if (pessoas[i] instanceof C03Docente)
				nDocentes++;
		}
		return nDocentes;
	}

	/**
	 * 
	 */
	public int getNumAlunos() {
		int nAlunos = 0;
		for (int i = 0; i < nPessoas; i++) {
			if (pessoas[i] instanceof C02Aluno)
				nAlunos++;
		}
		return nAlunos;
	}

	/**
	 * 
	 */
	public int getNumDocentesOuAlunos(boolean isDocente) {
		int num = 0;
		for (int i = 0; i < nPessoas; i++) {
			if ((isDocente && pessoas[i] instanceof C03Docente)
					|| (!isDocente && pessoas[i] instanceof C02Aluno))
				num++;
		}
		return num;
	}

	/**
	 * 
	 */
	public void printAll() {
		for (int i = 0; i < nPessoas; i++) {
			System.out.println(pessoas[i]);
		}
	}

	/**
	 * 
	 */
	public String toString() {
		return "escola " + getNomeEscola() + ", com " + getNumDocentes()
				+ " docentes e com " + getNumAlunos() + " alunos";
	}

	/**
	 * 
	 */
	public boolean addDocente(C03Docente doc) {
		if (nPessoas == pessoas.length)
			return false;
		pessoas[nPessoas++] = doc;
		return true;
	}

	/**
	 * 
	 */
	public boolean addAluno(C02Aluno al) {
		if (nPessoas == pessoas.length)
			return false;
		pessoas[nPessoas++] = al;
		return true;
	}

	/**
	 * 
	 */
	public boolean addPessoa(C01Pessoa p) {
		if (nPessoas == pessoas.length)
			return false;
		pessoas[nPessoas++] = p;
		return true;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// criar Escola
		C04Escola esc = new C04Escola("ISEE");

		// criar docentes e colocá-los na escola

		C03Docente d1 = new C03Docente("André Fernandes", 1,
				"Engenharia de Materiais");
		esc.addDocente(d1);

		// criar alunos e colocá-los na escola

		C02Aluno a1 = new C02Aluno("André Fernandes", 2,
				"Engenharia Física Tecnológica");
		esc.addAluno(a1);

		C02Aluno a2 = new C02Aluno("Júlio Fernandes", 3,
				"Engenharia Física Tecnológica");
		esc.addAluno(a2);

		C02Aluno a3 = new C02Aluno("Ana Fernandes", 4,
				"Engenharia Física Tecnológica");
		esc.addPessoa(a3);

		// fazer o print de todas as pessoas na escola
		esc.printAll();
	}

}
