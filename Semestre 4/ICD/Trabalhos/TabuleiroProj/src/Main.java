import javax.swing.JFrame;
import javax.swing.WindowConstants;

import tabuleiroGUI.CelulaEstado;
import tabuleiroGUI.ClickHandler;
import tabuleiroGUI.JPanelTabuleiro;

public class Main {

	public static void main(String[] args) {
		
		testarTabuleiro4EmLinha();
		
		//testarTabuleiroBatalhaNaval();


	}

	private static void testarTabuleiro4EmLinha() {
		System.out.println("Teste...");
		JFrame j = new JFrame();
		j.setSize(500,500);
		j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanelTabuleiro tab = new JPanelTabuleiro(8,8);
		j.setContentPane(tab);

		// para colocar o nosso tabuleiro em readOnly apos inicio do jogo
		//tab.setReadOnly(true);

		j.setVisible(true);

		tab.setCelula(7, 0, CelulaEstado.JOG1);
		tab.setCelula(7, 1, CelulaEstado.JOG2);

		tab.setCelula(7, 4, CelulaEstado.JOG1);
		tab.setCelula(7, 5, CelulaEstado.JOG2);
		tab.setCelula(6, 4, CelulaEstado.JOG1);
		tab.setCelula(6, 5, CelulaEstado.JOG2);

		// TESTES PARA JOGO DO 4 EM LINHA
		// Fase de Jogo
		System.out.println();
		System.out.println("################################");
		System.out.println("       ...Fase de JOGO...");
		System.out.println("################################");
		ClickHandler chJogo = new ClickHandler(){
			@Override
			public void clicked(int linha,int coluna,int estado) {
				System.out.println("...CLICK...");
				System.out.println("linha: " + linha);
				System.out.println("coluna: " + coluna);
				System.out.println("estado anterior: " + CelulaEstado.decodeEstadoString(estado));
				if(estado == CelulaEstado.LIVRE)
					tab.setCelula(linha, coluna, CelulaEstado.JOG1);
				if(estado == CelulaEstado.JOG1)
					tab.setCelula(linha, coluna, CelulaEstado.JOG2);
				if(estado == CelulaEstado.JOG2)
					tab.setCelula(linha, coluna, CelulaEstado.LIVRE);
				System.out.println("estado novo: " + tab.getCelulaEstadoString(linha, coluna));

			}
		};

		tab.setClickHandler(chJogo);
		
	}

	//TESTES PARA SETUP E JOGO DO TABULEIRO DO JOGO BATALHA NAVAL
	public static void testarTabuleiroBatalhaNaval() {

		System.out.println("Teste...");
		JFrame j = new JFrame();
		j.setSize(500,500);
		j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanelTabuleiro tab = new JPanelTabuleiro(10,10);
		j.setContentPane(tab);

		// para colocar o nosso tabuleiro em readOnly apos inicio do jogo
		//tab.setReadOnly(true);

		j.setVisible(true);

		tab.setCelula(0, 0, CelulaEstado.TIRO);
		tab.setCelula(0, 1, CelulaEstado.BARCO);

		tab.setCelula(2, 4, CelulaEstado.BARCO);
		tab.setCelula(2, 5, CelulaEstado.AGUA);
		tab.setCelula(2, 6, CelulaEstado.BARCO);
		tab.setCelula(2, 7, CelulaEstado.BARCO);

		
		//fase de setup do tabuleiro Batalha Naval
		System.out.println("...Fase SETUP do tabuleiro...");
		ClickHandler chSetup = new ClickHandler(){
			@Override
			public void clicked(int linha,int coluna,int estado) {
				System.out.println("...CLICK...");
				System.out.println("linha: " + linha + "(" + CelulaEstado.encodeCoordIntChar(linha)+")");
				System.out.println("coluna: " + coluna);
				System.out.println("estado: " + estado);
				if(estado == CelulaEstado.BARCO)
					tab.setCelula(linha, coluna, CelulaEstado.LIVRE);
				else
					tab.setCelula(linha, coluna, CelulaEstado.BARCO);

				// libertar a thread main para prosseguir para o jogo
				if(tab.tabuleiroBatalhaNavalCompleto())
					synchronized (tab) {
						tab.notifyAll();
					}
			}
		};
		tab.setClickHandler(chSetup);

		try {
			synchronized (tab) {
				tab.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		tab.removeClickHandler();
		// Fase de Jogo
		System.out.println();
		System.out.println("################################");
		System.out.println("       ...Fase de JOGO...");
		System.out.println("################################");
		ClickHandler chJogo = new ClickHandler(){
			@Override
			public void clicked(int linha,int coluna,int estado) {
				System.out.println("...CLICK...");
				System.out.println("linha: " + linha + "(" + CelulaEstado.encodeCoordIntChar(linha)+")");
				System.out.println("coluna: " + coluna);
				System.out.println("estado: " + estado);
				if(estado == CelulaEstado.BARCO)
					tab.setCelula(linha, coluna, CelulaEstado.TIRO);
				else
					tab.setCelula(linha, coluna, CelulaEstado.AGUA);
			}
		};

		tab.setClickHandler(chJogo);

		System.out.println("TESTE: " + CelulaEstado.encodeCoordIntChar(0));
		System.out.println("TESTE: " + CelulaEstado.decodeCoordIntChar("A"));
		System.out.println("TESTE: " + CelulaEstado.encodeCoordIntChar(10));
		System.out.println("TESTE: " + CelulaEstado.decodeCoordIntChar("K"));


	}

}
