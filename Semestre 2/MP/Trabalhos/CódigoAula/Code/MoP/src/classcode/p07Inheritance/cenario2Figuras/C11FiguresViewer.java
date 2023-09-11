package classcode.p07Inheritance.cenario2Figuras;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import classcode.p07Inheritance.layouts.ProportionalLayout;

/**
 * Class FiguresViewer - classe que permite visualizar um array de Figuras num
 * painel de uma frame.
 * 
 * As classes anteriores são um exemplo de herenaç de classes. NEste ficheiro a
 * classe JPanelFiguras contém o código exemplo de se ter um array de
 * referências para o tipo base e nele conter elementos das suas classes
 * fderivadas.
 * 
 */
public class C11FiguresViewer extends JFrame {
	private static final long serialVersionUID = -4162886183937541L;
	private JFrame frame;

	private JPanel panelFiguras;

	void init(C04Figura[] figuras) {

		// criar a frame
		frame = new JFrame("...: Figures viewer 0.1 :...");
		// definir a dimensão da frame
		frame.setSize(500, 300);
		// definir que quando se premir o botão de close da janela e para fazer
		// dispose à frame, ou seja, para a destruir
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// colocar a frame centrada no écran
		frame.setLocationRelativeTo(null);
		// criar um gestor proporcional de área com rebordo de 10%
		ProportionalLayout pl = new ProportionalLayout(0.1f);
		// colocar esse gestor na frame
		frame.setLayout(pl);

		// criar o painel que conterá as figuras
		panelFiguras = new JPanelFiguras(figuras);
		// adicionar o panel à frame, no seu centro
		frame.add(panelFiguras, ProportionalLayout.CENTER);
		// adicionar ao panel um rebordo a preto
		panelFiguras.setBorder(BorderFactory.createLineBorder(Color.black));

		// import javax.swing.Timer;
		// import java.awt.event.ActionEvent;
		// Timer timer = new Timer(10, new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// panelFiguras.repaint();
		//
		// }
		// });
		// timer.start();

		// colocar a frame visivel, por omissão é invisível
		frame.setVisible(true);
	}

	/**
	 * Métodod main
	 */
	public static void main(String[] args) {

		// array com várias figuras
		final C04Figura[] figuras = new C04Figura[] {
				new C05Recta(new C02Ponto2D(10, 10), new C02Ponto2D(40, 40),
						Color.blue),
				new C06Rectangulo(new C02Ponto2D(100, 10), 90, 50, Color.red),
				new C07Quadrado(new C02Ponto2D(200, 10), 100, Color.green),
				new C08Triangulo(new C02Ponto2D(50, 100),
						new C02Ponto2D(150, 100), new C02Ponto2D(50, 150), 100,
						50, Color.blue),
				new C09TrianguloIsosceles(new C02Ponto2D(250, 150), 100, 50,
						Color.magenta),
				new C10Elipse(new C02Ponto2D(150, 120), 80, 50, Color.yellow),
				new C10Elipse(new C02Ponto2D(165, 140), 20, 5, Color.red),
				new C10Elipse(new C02Ponto2D(195, 140), 20, 5, Color.red),
				new C11Circulo(new C02Ponto2D(85, 140), 25, Color.orange), };

		// submeter um pedido de execução para a Event Dispatch Thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// criar um objecto FiguresViewer
				C11FiguresViewer figFrame = new C11FiguresViewer();
				// construir a frame e torná-la visível
				figFrame.init(figuras);
			}
		});

	}

}

/**
 * Classe JPanelFiguras - classe auxiliar, não se justifica colocar esta classe
 * num ficheiro próprio, pois não é extensa, nem é uma classe com relevância
 * suficiente para isso e ela só tem interesse no contexto da classe
 * FiguresViewer. Ela ficar num ficheiro próprio só iria aumentar o número de
 * ficheiros e isso também não facilita a visualização ao nível do package
 */
class JPanelFiguras extends JPanel {

	private static final long serialVersionUID = 1L;
	// o array de figuras para serem desenhadas
	C04Figura[] figuras;

	/**
	 * constructor
	 */
	public JPanelFiguras(C04Figura[] figuras) {
		// super();
		this.figuras = figuras;
	}

	/**
	 * Método para desenhar as várias figuras
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		// deve-se mandar desenhar todo o background primeiro
		super.paintComponent(g);
		// depois desenhar os nossos objetos
		for (int i = 0; i < figuras.length; i++) {
			// figuras[i].translate();
			// C06Rectangulo ref = ((C06Rectangulo) figuras[i]);
			// ref.translate();
			if (figuras[i] instanceof C06Rectangulo) {
				C06Rectangulo ref = (C06Rectangulo) figuras[i];
				ref.translate();
			}
			// if (figuras[i] instanceof C06Rectangulo
			// && !(figuras[i] instanceof C07Quadrado))
			figuras[i].paintComponent(g);
		}
	}
}
