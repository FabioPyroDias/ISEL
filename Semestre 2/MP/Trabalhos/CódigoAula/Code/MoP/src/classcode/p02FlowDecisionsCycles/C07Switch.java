package classcode.p02FlowDecisionsCycles;

/**
 * Switch com inteiros (bytes) - com múltiplas entradas para o mesmo código
 * 
 * 
 * @author ateofilo
 * 
 */
public class C07Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// número do mês no ano
		byte month = 1;

		System.out.println("Mês -> " + month);

		// nome da respectiva estação - estação em maioria nesse mês
		String seasonName;

		switch (month) {
		case 1:
		case 2:
		case 3:
			seasonName = "Inverno";
			break;
		case 4:
		case 5:
		case 6:
			seasonName = "Primavera";
			break;
		case 7:
		case 8:
		case 9:
			seasonName = "Verão";
			break;
		case 10:
		case 11:
		case 12:
			seasonName = "Outono";
			break;
		default:
			seasonName = "mês inválido";
		}

		System.out.println("Nome da estação -> " + seasonName);
	}
}
