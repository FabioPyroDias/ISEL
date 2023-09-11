package tabuleiroGUI;
import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JButton;

public class JPanelTabuleiro extends JPanel {

	public int nColunas;
	public int nLinhas;
	
	private JButtonCelula [][] tabuleiro;
	private ClickHandler clickHandler;
	
	public boolean readOnly = false;
	
	
	public JPanelTabuleiro() {
		this(10,10);
	}		
	
	public JPanelTabuleiro(int nLinhas, int nColunas) {
		super();
		this.nLinhas = nLinhas;
		this.nColunas = nColunas;
		
		tabuleiro = new JButtonCelula[nLinhas][nColunas];
		
		GridLayout l = new GridLayout(nLinhas,nColunas);
		System.out.println("Colunas " + l.getColumns());
		setLayout(l);
		
		for(int i=0; i<nLinhas; i++) {
			for(int j=0; j<nColunas; j++) {
				JButtonCelula celula = new JButtonCelula(i, j);
				add(celula);
				tabuleiro[i][j] = celula;
			}
		}
	}
	
	public void setReadOnly(boolean ro) {
		readOnly = ro;
		for(int i=0; i<nLinhas; i++) {
			for(int j=0; j<nColunas; j++) {
				tabuleiro[i][j].setEnabled(!ro);
			}
		}
	}
	
	public String getCelulaEstadoString(int linha, int coluna) {
		return tabuleiro[linha][coluna].getEstadoString();		
	}

	public int getCelulaEstado(int linha,int coluna) {
		return tabuleiro[linha][coluna].getEstado();
	}
	
	public void setCelula(int linha,int coluna, int estado) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, estado);
	}
	public void setCelulaLivre(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.LIVRE);
	}
	// Estados da Batalha naval
	public void setCelulaTiro(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.TIRO);
	}
	public void setCelulaAgua(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.AGUA);
	}
	public void setCelulaBarco(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.BARCO);
	}
	public void setCelulaFundo(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.FUNDO);
	}
	// Estados do 4 em linha
	public void setCelulaJog1(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.JOG1);
	}
	public void setCelulaJog2(int linha,int coluna) {
		tabuleiro[linha][coluna].setEstado(linha, coluna, CelulaEstado.JOG2);
	}

	public void setClickHandler(ClickHandler handler) {
		this.clickHandler = handler;
		for(int i=0; i<nLinhas; i++) {
			for(int j=0; j<nColunas; j++) {
				tabuleiro[i][j].setClickHandler(handler);
			}
		}
		
	}
	
	public void removeClickHandler() {
		for(int i=0; i<nLinhas; i++) {
			for(int j=0; j<nColunas; j++) {
				tabuleiro[i][j].removeClickHandler();
			}
		}
		
	}

	
	public boolean tabuleiroBatalhaNavalCompleto() {
		// Se todas as pecas colocadas retornar true
		// Os navios são: 1 porta-aviões (cinco quadrados), 2 navios-tanque (quatro quadrados),
		// 3 contratorpedeiros (três quadrados) e 4 submarinos (dois quadrados). 5 + 2*4 + 3*3 + 4*2 = 5+8+9+8 = 30 Total de  celulas
		int counter = 0;
		for(int i=0; i<nLinhas; i++) {
			for(int j=0; j<nColunas; j++) {
				if(tabuleiro[i][j].getEstado() == CelulaEstado.BARCO)
					++counter;
			}
		}
		System.out.println("Pecas colocadas: " + counter);
		if (counter == 30)
			return true;
		else
			return false;
	}


}
