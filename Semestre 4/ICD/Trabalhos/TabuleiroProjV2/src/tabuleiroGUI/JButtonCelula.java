package tabuleiroGUI;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JButtonCelula extends JButton {

	int linha;
	int coluna;
	int estado = CelulaEstado.LIVRE;
	
	private ClickHandler clickHandler;	
	
	public JButtonCelula(int linha, int coluna) {
		super(CelulaEstado.decodeEstadoString(CelulaEstado.LIVRE));
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public String getEstadoString() {
		return CelulaEstado.decodeEstadoString(estado);
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int linha, int coluna, int e) {
		this.estado = e;
		this.setText(CelulaEstado.decodeEstadoString(e));
	}
	
	public void setClickHandler(ClickHandler handler) {
		this.clickHandler = handler;
		this.actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.clicked(linha, coluna, estado);
			}
		};
		
		this.addActionListener(this.actionListener);
	}

	public void removeClickHandler() {
			this.removeActionListener(this.actionListener);
	}
	
}
