package classcode.p06ClassesAndObjects;

import java.util.Scanner;

/**
 * classe que define um grupo de Bancos
 */
public class C06GrupoDeBancos {

	// suporte aos vários bancos - os bancos estarão sempre nos índices mais
	// baixos
	private C05Banco[] bancos = new C05Banco[10];

	// número de bancos existentes
	private int nBancos = 0;

	/**
	 * main
	 */
	public static void main(String[] args) {

		// o keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// saudação inicial
		System.out.println("Gestor de Bancos 1.0  ... ");

		// criar o gestor de bancos
		C06GrupoDeBancos gb = new C06GrupoDeBancos();

		// inicializar o gestor de bancos com a informação inicial
		gb.init();
		System.out.println();

		// activar o menu de interacção
		gb.menu(keyboard);
	}

	/**
	 * Inicializa os bancos e suas contas, cada uma com: banco, nc, saldo,
	 * mêsDoUltimoDeposito
	 */
	private void init() {
		String[] contas = { "CGD 1 1000 6", "CGD 2 2000 5", "CGD 4 400 8",
				"BCP 1 2000 2", "BCP 2 5000 6", "BCP 3 800 5", "BPI 1 2000 2",
				"BPI 2 6000 6" };

		System.out.print("Init bancos: ");

		// processar cada conta
		for (int i = 0; i < contas.length; i++) {
			System.out.print(". ");

			// dividir as várias componentes da string
			String[] data = contas[i].split(" "); // ou "\\s+" um ou mais
													// separadores

			// obter o objecto banco se já existir ou criar um novo com o nome
			// recebido
			C05Banco bank = getBancoUnconditional(data[0]);

			// criar a nova conta
			int nc = Integer.parseInt(data[1]);
			double saldo = Double.parseDouble(data[2]);
			int mesUltDep = Integer.parseInt(data[3]);
			C03Conta account = new C03Conta(nc, saldo, mesUltDep);

			// adicionar a conta ao banco
			bank.addNewAccount(account);
		}
		System.out.println();
	}

	/**
	 * obtém ou caso não haja cria o banco com o nome igual ao nome recebido
	 */
	private C05Banco getBancoUnconditional(String nomeBanco) {
		C05Banco bank = getBanco(nomeBanco);
		if (bank == null) {
			// create new bank and add it
			bank = new C05Banco(nomeBanco);
			bancos[nBancos++] = bank;
		}
		return bank;
	}

	/**
	 * obtém o banco com o nome igual ao nome recebido
	 */
	private C05Banco getBanco(String nomeBanco) {
		for (int i = 0; i < nBancos; i++) {
			if (bancos[i].getNome().equalsIgnoreCase(nomeBanco))
				return bancos[i];
		}
		return null;
	}

	/**
	 * Menu de operação com os vários bancos
	 */
	private void menu(Scanner keyboard) {

		// flag que controla o ciclo
		boolean terminar = false;

		// ciclo de leitura e execução de operações
		do {
			// mostrar o menu das opções
			System.out.println("Gestor de Bancos 1.0 menu:  ... ");
			mostrarBancosExistentes();
			System.out.print(
					"Introduza o nome do banco a operar, ou X para terminar -> ");
			String input = keyboard.next().trim();
			// limpar o keyboard
			keyboard.nextLine();

			C05Banco bank = getBanco(input);
			if (bank != null) {
				System.out.println();
				bank.menuBanco(keyboard);
			} else if (input.equalsIgnoreCase("x"))
				terminar = true;
			else
				System.out
						.println("O input introduzido é inválido -> " + input);

			// colocar uma linha em branco
			System.out.println();
		} while (!terminar);

		// fechar o keyboard
		keyboard.close();

	}

	/**
	 * mostra os bancos existentes
	 */
	private void mostrarBancosExistentes() {
		System.out.println("Listagem dos bancos existentes...");
		for (int i = 0; i < nBancos; i++) {
			System.out.println("Banco: " + bancos[i].getNome());
		}

	}

}
