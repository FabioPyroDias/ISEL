package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

public class C04IfMultiBranch {

	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read an integer
		System.out.print("Introduza o nome da estação corrente do ano -> ");
		String estacao = keyboard.next();

		// remove extra chars and put to lowerCase
		estacao = estacao.trim().toLowerCase();

		// the next season variable
		String proximaEstacao = null;

		// multi ifs
		if (estacao.equals("inverno"))
			proximaEstacao = "primavera";
		else if (estacao.equals("primavera"))
			proximaEstacao = "verão";
		else if (estacao.equals("verão"))
			proximaEstacao = "outono";
		else if (estacao.equals("outono"))
			proximaEstacao = "inverno";
		else {
			System.out
					.println("O nome introduzido não corresponde a uma estação do ano");
			System.out.println("O programa vai terminar!!!");
			System.exit(1);
		}

		// show the next season
		System.out.println("A estação seguinte a " + estacao + " é -> "
				+ proximaEstacao);

		// close the keyboard
		keyboard.close();
	}
}
