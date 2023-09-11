package classcode.p11StreamsAndFileIO;

import java.io.IOException;

/**
 * Mostra na consola o print dos caracteres de 00 a FF
 * 
 */

public class C01WriteChars {

	public static void main(String[] args) throws IOException {

		/*
		 * printf("%?", val) - o % indica que se segue na string a mostrar um
		 * argumento que deve ser interpretado com a formatação indicada: d -
		 * inteiro, x - inteiro em hexadecimal, c - caracter, s - string, b -
		 * binário, f - float, n - imprime '%'. Ver "Format string syntax" do
		 * help de printf. Pode-se indicar a dimensão do campo a escrever,
		 * alinhamento à esquerda ou direita, etc.
		 */

		// Mostrar tabela

		System.out.print("  ");
		for (int j = 0; j < 16; j++) {
			System.out.printf("%X", j) /* ff */;/* dd */
		}
		System.out.println();

		for (int i = 0; i < 16; i++) { // 16 colunas
			System.out.printf("%X ", i);
			for (int j = 0; j < 16; j++) { // 16 linhas
				if (j < 2)
					System.out.print(".");
				else
					System.out.print((char) (i + j * 16)); // i + j * 16
			}
			System.out.println();
		}

		System.out.println();

		// agora no outro sentido

		System.out.print("  ");
		for (int j = 0; j < 16; j++) {
			System.out.printf("%X", j);
		}
		System.out.println();

		for (int i = 0; i < 16; i++) {
			System.out.printf("%X ", i);
			for (int j = 0; j < 16; j++) {
				if (i < 2)
					System.out.print(".");
				else
					System.out.print((char) (i * 16 + j));
			}
			System.out.println();
		}

		System.out.close();

		// int x=0;if(true)if(true){if(true)
		// {}if(true);if(true){if(true)
		// if
		// (true);}
		// }
	}
}
