package classcode.p02FlowDecisionsCycles;

/**
 * Switch com Strings - o compilador tem de estar com Compiler COmpliance Level
 * de 1.7. Ir a Project->Properties->Java Compiler.
 * 
 * @author ateofilo
 * 
 */
public class C10OperadorTernario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the initial season
		String estacao = "Inverno";

		// show it
		System.out.println("Estação corrente -> " + estacao);

		// set the next season
		String proximaEstacao = estacao.equals("Inverno") ? "Primavera" : 
			(estacao.equals("Primavera") ? "Verão" : 
				(estacao .equals("Verão") ? "Outono" : 
					estacao.equals("Outono") ? "Inverno" : "erro"));

		// show next season
		System.out.println("Próxima estação -> " + proximaEstacao);

	}

}
