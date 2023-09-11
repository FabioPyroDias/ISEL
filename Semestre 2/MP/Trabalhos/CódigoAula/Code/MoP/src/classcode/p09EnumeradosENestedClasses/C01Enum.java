package classcode.p09EnumeradosENestedClasses;

public class C01Enum {

	public static void main(String[] args) {

		// variável, toString, ordinal, valueOf
		Estacao est = Estacao.PRIMAVERA;
		System.out.println("Estação est -> " + est);
		System.out.println("Ordinal de " + est + " -> " + est.ordinal());
		est = Estacao.valueOf("VERAO");
		//est = Estacao.valueOf("VERAo");
		System.out.println("Estacao.valueOf(\"VERAO\") -> " + est);

		est = Estacao.INVERNO;
		System.out.println(est == Estacao.INVERNO ? "Que frio!"
				: "Bom tempo...");

		// values
		Estacao[] estacoes = Estacao.values();
		System.out.println("\nListagem das estações:");
		for (int i = 0; i < estacoes.length; i++) {
			System.out.println("Estacao[" + i + "] -> " + estacoes[i]);
		}
	}
}

enum Estacao {
	PRIMAVERA, VERAO, OUTONO, INVERNO
	// PRIMAVERA(), VERAO(), OUTONO(), INVERNO()
}