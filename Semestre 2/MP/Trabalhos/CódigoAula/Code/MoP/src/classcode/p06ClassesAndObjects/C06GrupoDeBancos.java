package classcode.p06ClassesAndObjects;

import java.util.Scanner;

/**
 * classe que define um grupo de Bancos
 */
public class C06GrupoDeBancos {

	// suporte aos v�rios bancos - os bancos estar�o sempre nos �ndices mais
	// baixos
	private C05Banco[] bancos = new C05Banco[10];

	// n�mero de bancos existentes
	private int nBancos = 0;

	/**
	 * main
	 */
	public static void main(String[] args) {

		// o keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// sauda��o inicial
		System.out.println("Gestor de Bancos 1.0  ... ");

		// criar o gestor de bancos
		C06GrupoDeBancos gb = new C06GrupoDeBancos();

		// inicializar o gestor de bancos com a informa��o inicial
		gb.init();
		System.out.println();

		// activar o menu de interac��o
		gb.menu(keyboard);
	}

	/**
	 * Inicializa os bancos e suas contas, cada uma com: banco, nc, saldo,
	 * m�sDoUltimoDeposito
	 */
	private void init() {
		String[] contas = { "CGD 1 1000 6", "CGD 2 2000 5", "CGD 4 400 8",
				"BCP 1 2000 2", "BCP 2 5000 6", "BCP 3 800 5", "BPI 1 2000 2",
				"BPI 2 6000 6" };

		System.out.print("Init bancos: ");

		// processar cada conta
		for (int i = 0; i < contas.length; i++) {
			System.out.print(". ");

			// dividir as v�rias componentes da string
			String[] data = contas[i].split(" "); // ou "\\s+" um ou mais
													// separadores

			// obter o objecto banco se j� existir ou criar um novo com o nome
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
	 * obt�m ou caso n�o haja cria o banco com o nome igual ao nome recebido
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
	 * obt�m o banco com o nome igual ao nome recebido
	 */
	private C05Banco getBanco(String nomeBanco) {
		for (int i = 0; i < nBancos; i++) {
			if (bancos[i].getNome().equalsIgnoreCase(nomeBanco))
				return bancos[i];
		}
		return null;
	}

	/**
	 * Menu de opera��o com os v�rios bancos
	 */
	private void menu(Scanner keyboard) {

		// flag que controla o ciclo
		boolean terminar = false;

		// ciclo de leitura e execu��o de opera��es
		do {
			// mostrar o menu das op��es
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
						.println("O input introduzido � inv�lido -> " + input);

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
