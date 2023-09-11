package classcode.p06ClassesAndObjects;

import java.util.Scanner;

/**
 * Um gestor de contas, do qual se pode criar v�rias inst�ncias.
 */
public class C05Banco {

	// nome do banco
	private String nome;

	// constante que define o n�mero m�ximo de contas que podem existir
	// simultaneamente no banco
	private final int NMAXCONTAS = 20;

	// as contas correntes - as contas v�o ficar sempre colocadas nos �ndexes
	// menores
	private C03Conta[] contas = new C03Conta[NMAXCONTAS];

	// n�mero a atribuir � pr�xima conta que for criada
	private int proximoNumeroDeConta = 1;

	// n�mero de contas existentes
	private int numeroDeContasExistentes = 0;

	// taxa de juro anual a aplicar s� no final do ano
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
	 * m�todo para c�lcular os juros a partir do m�s recebido
	 */
	public double calcularJuros(double valor, int nMeses) {
		return valor * nMeses / 12 * taxaJuroAnual;
	}

	/**
	 * verifica se n�o � poss�vel criar mais contas
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

				// colocar na �ltima posi��o um null
				contas[numeroDeContasExistentes - 1] = null;

				// dinimuir o n�mero de contas existentes
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
	 * Obt�m a conta com o n�mero de conta recebido devolve null caso n�o
	 * encontre uma conta com esse n�mero
	 */
	private C03Conta getAccount(int accountNumber) {
		for (int i = 0; i < numeroDeContasExistentes; i++) {
			if (contas[i].getNumeroDeConta() == accountNumber)
				return contas[i];
		}
		// devolve null, indica que n�o encontrou uma conta com esse n�mero
		return null;
	}

	/**
	 * Menu de um banco
	 */
	public void menuBanco(Scanner keyboard) {

		// flag que controla o ciclo
		boolean terminar = false;

		// ciclo de leitura e execu��o de opera��es
		do {
			// mostrar o menu das op��es
			System.out.println("Banco " + getNome()
					+ " Gestor de Contas 1.0 ... contas existentes -> "
					+ numeroDeContasExistentes);
			System.out.println("Op��es dispon�veis:");
			System.out.println(" c - Criar uma conta nova");
			System.out.println(" o - Operar uma conta");
			System.out.println(" j - aplicar juros a todas as contas");
			System.out.println(" l - listar contas existentes");
			System.out.println(" e - eliminar conta");
			System.out.println(" x - terminar a gest�o do banco");
			System.out.print("Escolha a op��o pretendida: ");

			// ler a op��o
			String line = keyboard.nextLine();
			// eliminar espa�os no in�cio e no fim da string
			line = line.trim();

			// validar o tamanho
			if (line.length() > 1) {
				System.out.println("S� deveria ter introduzido um caractere: "
						+ line);

			} else {

				// obter o caracter e em maiusculas
				char option = Character.toLowerCase(line.charAt(0));

				// agulhar para a ac��o correcta
				switch (option) {
				case 'c':
					// Criar uma conta nova
					System.out.println("\nOp��o: Criar uma conta nova.\n");
					if (!isFull()) {
						int mesCorrente = 0;
						System.out
								.print("Introduza o saldo inicial da nova conta -> ");
						if (keyboard.hasNextDouble()) {
							double saldoInicial = keyboard.nextDouble();
							System.out
									.print("Introduza o n� do m�s corrente -> ");

							if (keyboard.hasNextInt()) {
								if ((mesCorrente = keyboard.nextInt()) > 0
										&& mesCorrente <= 12) {
									// criar a conta nova com o n� de conta
									// sequ�ncial
									int accountNumber = proximoNumeroDeConta++;
									C03Conta newAccount = new C03Conta(
											accountNumber, saldoInicial,
											mesCorrente);
									// adicionar a conta ao array de contas
									addNewAccount(newAccount);
								} else
									System.out
											.println("O n�mero do m�s est� incorrecto -> "
													+ mesCorrente);
							} else
								System.out
										.println("o n�mero do m�s corrente n�o � um inteiro -> "
												+ keyboard.next());
						} else
							System.out
									.println("Os dados introduzidos n�o podem ser iterpertados como um saldo -> "
											+ keyboard.next());
					} else {
						// indicar que o n� de contas est� no m�ximo
						System.out
								.println("N�o � poss�vel criar uma conta nova.");
						System.out
								.println("O n�mero de contas j� est� no m�ximo.");
					}
					// eliminar lixo que possa existir no keyboard
					keyboard.nextLine();
					break;

				case 'o':
					// Operar uma conta
					System.out.println("\nOp��o: Operar uma conta.\n");
					C03Conta conta = C04GestorContas
							.obterContaFromUser(keyboard);
					if (conta != null)
						C04GestorContas.operarConta(conta);
					break;

				case 'j':
					// aplicar juros a todas as contas - no final do ano
					System.out
							.println("\nOp��o: Aplicar juros a todas as contas (fim de ano).\n");
					aplicarJurosNoFinalDeAno();
					break;

				case 'l':
					// listar contas existentes
					System.out
							.println("\nOp��o: Listar as contas existentes.\n");
					listarContasCorrentes();
					break;

				case 'e':
					// eliminar conta
					System.out.println("\nOp��o: Eliminar uma conta.\n");
					C03Conta conta2 = C04GestorContas
							.obterContaFromUser(keyboard);
					if (conta2 != null) {
						System.out
								.println("A seguinte conta vai ser eliminada -> "
										+ conta2);
						boolean foiEliminada = eliminarConta(conta2);
						System.out.println("A conta: " + conta2 + " "
								+ (foiEliminada ? "foi" : "n�o foi")
								+ " eliminada");
					}
					break;

				case 'x':
					// terminar o gestor
					System.out.println("\nBye...");
					terminar = true;
					break;
				default:
					// op��o inv�lida
					System.out.println("A op��o escolhida � inv�lida: "
							+ option);
				}
			}

			// colocar uma linha em branco
			System.out.println();
		} while (!terminar);
	}

	/**
	 * Obt�m um n�mero de conta do utilizador e devolve a conta correspondente
	 * se existir
	 */
	C03Conta obterContaFromUser(Scanner keyboard) {
		C03Conta conta = null;

		System.out.print("Introduza o n� da conta desejada -> ");
		if (keyboard.hasNextInt()) {
			int accountNumber = keyboard.nextInt();
			if (accountNumber > 0 && accountNumber < proximoNumeroDeConta) {
				conta = getAccount(accountNumber);
				if (conta == null)
					System.out.println("N�o existe uma conta com o n� "
							+ accountNumber);
			} else
				System.out.println("N�mero de conta inv�lido -> "
						+ accountNumber);
		} else
			System.out
					.println("Os dados introduzidos n�o podem ser interpretados como um n�mero de conta -> "
							+ keyboard.next());
		// eliminar lixo que possa existir no keyboard
		keyboard.nextLine();
		return conta;
	}

}
