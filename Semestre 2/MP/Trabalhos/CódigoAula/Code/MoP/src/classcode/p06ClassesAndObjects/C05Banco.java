package classcode.p06ClassesAndObjects;

import java.util.Scanner;

/**
 * Um gestor de contas, do qual se pode criar várias instâncias.
 */
public class C05Banco {

	// nome do banco
	private String nome;

	// constante que define o número máximo de contas que podem existir
	// simultaneamente no banco
	private final int NMAXCONTAS = 20;

	// as contas correntes - as contas vão ficar sempre colocadas nos índexes
	// menores
	private C03Conta[] contas = new C03Conta[NMAXCONTAS];

	// número a atribuir à próxima conta que for criada
	private int proximoNumeroDeConta = 1;

	// número de contas existentes
	private int numeroDeContasExistentes = 0;

	// taxa de juro anual a aplicar só no final do ano
	private double taxaJuroAnual = 0.01;

	/**
	 * constructor
	 */
	public C05Banco(String nome) {
		this.nome = nome;
	}

	/**
	 * Obter o nome do banco
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * altera a taxa de juro
	 */
	public void setTaxaJuroAnual(double novaTaxa) {
		taxaJuroAnual = novaTaxa;
	}

	/**
	 * obter a taxa de juro
	 */
	public double getTaxaJuroAnual() {
		return taxaJuroAnual;
	}

	/**
	 * método para cálcular os juros a partir do mês recebido
	 */
	public double calcularJuros(double valor, int nMeses) {
		return valor * nMeses / 12 * taxaJuroAnual;
	}

	/**
	 * verifica se não é possível criar mais contas
	 */
	private boolean isFull() {
		return numeroDeContasExistentes == NMAXCONTAS;
	}

	/**
	 * adiciona uma nova conta
	 */
	public boolean addNewAccount(C03Conta newAccount) {
		if (isFull() || getAccount(newAccount.getNumeroDeConta()) != null)
			return false;
		contas[numeroDeContasExistentes++] = newAccount;
		if(proximoNumeroDeConta <= newAccount.getNumeroDeConta())
			proximoNumeroDeConta = newAccount.getNumeroDeConta() + 1;
		return true;

	}

	/**
	 * Aplicar juros a todas as contas - no final do ano
	 */
	private void aplicarJurosNoFinalDeAno() {
		for (int i = 0; i < numeroDeContasExistentes; i++) {
			contas[i].aplicarJuros();
		}
	}

	/**
	 * Elimina a conta que recebe em argumento
	 */
	private boolean eliminarConta(C03Conta conta) {
		// percorrer todas as contas
		for (int i = 0; i < numeroDeContasExistentes; i++) {
			if (contas[i].equals(conta)) {

				// eliminar a conta de index i - copiar as contas de j + 1 para
				// j
				for (int j = i; j < numeroDeContasExistentes - 1; j++)
					contas[j] = contas[j + 1];

				// colocar na última posição um null
				contas[numeroDeContasExistentes - 1] = null;

				// dinimuir o número de contas existentes
				numeroDeContasExistentes--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Listar as contas correntes
	 */
	private void listarContasCorrentes() {
		for (int i = 0; i < numeroDeContasExistentes; i++) {
			System.out.println(contas[i]);
		}
	}

	/**
	 * Obtém a conta com o número de conta recebido devolve null caso não
	 * encontre uma conta com esse número
	 */
	private C03Conta getAccount(int accountNumber) {
		for (int i = 0; i < numeroDeContasExistentes; i++) {
			if (contas[i].getNumeroDeConta() == accountNumber)
				return contas[i];
		}
		// devolve null, indica que não encontrou uma conta com esse número
		return null;
	}

	/**
	 * Menu de um banco
	 */
	public void menuBanco(Scanner keyboard) {

		// flag que controla o ciclo
		boolean terminar = false;

		// ciclo de leitura e execução de operações
		do {
			// mostrar o menu das opções
			System.out.println("Banco " + getNome()
					+ " Gestor de Contas 1.0 ... contas existentes -> "
					+ numeroDeContasExistentes);
			System.out.println("Opções disponíveis:");
			System.out.println(" c - Criar uma conta nova");
			System.out.println(" o - Operar uma conta");
			System.out.println(" j - aplicar juros a todas as contas");
			System.out.println(" l - listar contas existentes");
			System.out.println(" e - eliminar conta");
			System.out.println(" x - terminar a gestão do banco");
			System.out.print("Escolha a opção pretendida: ");

			// ler a opção
			String line = keyboard.nextLine();
			// eliminar espaços no início e no fim da string
			line = line.trim();

			// validar o tamanho
			if (line.length() > 1) {
				System.out.println("Só deveria ter introduzido um caractere: "
						+ line);

			} else {

				// obter o caracter e em maiusculas
				char option = Character.toLowerCase(line.charAt(0));

				// agulhar para a acção correcta
				switch (option) {
				case 'c':
					// Criar uma conta nova
					System.out.println("\nOpção: Criar uma conta nova.\n");
					if (!isFull()) {
						int mesCorrente = 0;
						System.out
								.print("Introduza o saldo inicial da nova conta -> ");
						if (keyboard.hasNextDouble()) {
							double saldoInicial = keyboard.nextDouble();
							System.out
									.print("Introduza o nº do mês corrente -> ");

							if (keyboard.hasNextInt()) {
								if ((mesCorrente = keyboard.nextInt()) > 0
										&& mesCorrente <= 12) {
									// criar a conta nova com o nº de conta
									// sequêncial
									int accountNumber = proximoNumeroDeConta++;
									C03Conta newAccount = new C03Conta(
											accountNumber, saldoInicial,
											mesCorrente);
									// adicionar a conta ao array de contas
									addNewAccount(newAccount);
								} else
									System.out
											.println("O número do mês está incorrecto -> "
													+ mesCorrente);
							} else
								System.out
										.println("o número do mês corrente não é um inteiro -> "
												+ keyboard.next());
						} else
							System.out
									.println("Os dados introduzidos não podem ser iterpertados como um saldo -> "
											+ keyboard.next());
					} else {
						// indicar que o nº de contas está no máximo
						System.out
								.println("Não é possível criar uma conta nova.");
						System.out
								.println("O número de contas já está no máximo.");
					}
					// eliminar lixo que possa existir no keyboard
					keyboard.nextLine();
					break;

				case 'o':
					// Operar uma conta
					System.out.println("\nOpção: Operar uma conta.\n");
					C03Conta conta = C04GestorContas
							.obterContaFromUser(keyboard);
					if (conta != null)
						C04GestorContas.operarConta(conta);
					break;

				case 'j':
					// aplicar juros a todas as contas - no final do ano
					System.out
							.println("\nOpção: Aplicar juros a todas as contas (fim de ano).\n");
					aplicarJurosNoFinalDeAno();
					break;

				case 'l':
					// listar contas existentes
					System.out
							.println("\nOpção: Listar as contas existentes.\n");
					listarContasCorrentes();
					break;

				case 'e':
					// eliminar conta
					System.out.println("\nOpção: Eliminar uma conta.\n");
					C03Conta conta2 = C04GestorContas
							.obterContaFromUser(keyboard);
					if (conta2 != null) {
						System.out
								.println("A seguinte conta vai ser eliminada -> "
										+ conta2);
						boolean foiEliminada = eliminarConta(conta2);
						System.out.println("A conta: " + conta2 + " "
								+ (foiEliminada ? "foi" : "não foi")
								+ " eliminada");
					}
					break;

				case 'x':
					// terminar o gestor
					System.out.println("\nBye...");
					terminar = true;
					break;
				default:
					// opção inválida
					System.out.println("A opção escolhida é inválida: "
							+ option);
				}
			}

			// colocar uma linha em branco
			System.out.println();
		} while (!terminar);
	}

	/**
	 * Obtém um número de conta do utilizador e devolve a conta correspondente
	 * se existir
	 */
	C03Conta obterContaFromUser(Scanner keyboard) {
		C03Conta conta = null;

		System.out.print("Introduza o nº da conta desejada -> ");
		if (keyboard.hasNextInt()) {
			int accountNumber = keyboard.nextInt();
			if (accountNumber > 0 && accountNumber < proximoNumeroDeConta) {
				conta = getAccount(accountNumber);
				if (conta == null)
					System.out.println("Não existe uma conta com o nº "
							+ accountNumber);
			} else
				System.out.println("Número de conta inválido -> "
						+ accountNumber);
		} else
			System.out
					.println("Os dados introduzidos não podem ser interpretados como um número de conta -> "
							+ keyboard.next());
		// eliminar lixo que possa existir no keyboard
		keyboard.nextLine();
		return conta;
	}

}
