package classcode.p07Inheritance.cenario3Escola;

/**
 * Classe derivada de Aluno - Exemplo de chamada aos vários construtores
 */
public class C03Docente extends C01Pessoa {

	// nomeDoMestrado e nomeDoDoutoramento podem ser null, o que indica o
	// docente não tem o respectivo grau
	private String nomeDaLicenciatura;
	private String nomeDoMestrado;
	private String nomeDoDoutoramento;

	/**
	 * 
	 */
	public C03Docente(String nome, int id, String nomeLicenciatura) {
		this(nome, id, nomeLicenciatura, null);
	}

	/**
	 * 
	 */
	public C03Docente(String nome, int id, String nomeLicenciatura,
			String nomeMestrado) {
		this(nome, id, nomeLicenciatura, nomeMestrado, null);
	}

	/**
	 * 
	 */
	public C03Docente(String nome, int id, String nomeLicenciatura,
			String nomeMestrado, String nomeDoutoramento) {
		// chamar o construtor da classe base
		super(nome, id);

		// validar que a licenciatura existe
		if (nomeLicenciatura == null)
			throw new IllegalArgumentException(
					"O nome da licenciatura não podem ser null...");

		// guardar os vaores recebidos
		this.nomeDaLicenciatura = nomeLicenciatura;
		this.nomeDoMestrado = nomeMestrado;
		this.nomeDoDoutoramento = nomeDoutoramento;
	}

	/**
	 * 
	 */
	public String getLicenciaturaEm() {
		return nomeDaLicenciatura;
	}

	/**
	 * 
	 */
	public void setLicenciaturaEm(String licenciaturaEm) {
		this.nomeDaLicenciatura = licenciaturaEm;
	}

	/**
	 * 
	 */
	public String getMestradoEm() {
		return nomeDoMestrado;
	}

	/**
	 * 
	 */
	public void setMestradoEm(String mestradoEm) {
		this.nomeDoMestrado = mestradoEm;
	}

	/**
	 * 
	 */
	public String getDoutoramentoEm() {
		return nomeDoDoutoramento;
	}

	/**
	 * 
	 */
	public void setDoutoramentoEm(String doutoramentoEm) {
		this.nomeDoDoutoramento = doutoramentoEm;
	}

	/**
	 * 
	 */
	public String getNome() {
		String profissionalName = nomeDoDoutoramento != null ? "Dr"
				: (nomeDoMestrado != null ? "Ms" : "Eng");
		return profissionalName + ". " + super.getNome();
	}

	/**
	 * 
	 */
	public String getFuncao() {
		return "docente";
	}

	/**
	 * 
	 */
	public String toString() {
		return getNome() + ", nº D" + getId();
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		C03Docente d1 = new C03Docente("André Fernandes", 2,
				"Engenharia de Materiais");
		System.out.println("d1 -> " + d1);

	}

}
