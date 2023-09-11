package classcode.p15Swing.p06moreStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: JList, DefaultListModel, JScrollPane
 * 
 * Uma JList permite visualizar os seus elementos um por cada linha.
 * 
 * Podemos colocar na JList um ListModel que é um objecto que contém um modelo
 * de dados e que a JList sabe mostrar. O ListModel tem de ser registado na
 * JList. Assim a JList sabe quando o ListModel foi modificado e actualiza o seu
 * output. Quando se cria a JList passando o listModel, o JList regista-se no
 * listmodel.
 * 
 * Quando ocorre uma alteração à ListModel, todos os listeners registados nela
 * são chamados.
 * 
 * Temos portanto uma arquitectura de MODEL e VIEWER (padrão Model View Control
 * - MVC). O controle aos dados é realizado pelos botões e lógica da interface
 * 
 * Pode-se utilizar uma JList sem model, mas nesse caso deve-se utilizar um
 * array de dados para passar os dados para a JLIST, esse array é copiado e
 * imutável.
 * 
 * @author António Teófilo
 * 
 */
public class C2MyListAndScrollFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton buttonAppend = null;

	private JButton buttonRemoveFirst = null;

	private JButton buttonRemoveSelected = null;

	JPanel panel = null;

	JPanel panelCenter = null;

	private JLabel labelAppend = null;

	private JTextField textToAppend = null;

	// a JList
	private JList<String> list = null;

	// o ScrollPane oara que a lista tenha scroll
	private JScrollPane sp = null;

	// o model para que se possa alterar os dados da lista e as alterações sejam
	// reflectidas na vista
	private DefaultListModel<String> listModel = null;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My JList frame :...");
		// set size
		setSize(500, 500);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// use of BorderLayout for main frame

		// Initial data
		String[] data = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio",
				"Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro" };

		// bvuild the list model - este DefaultListModel é baseado num vector
		listModel = new DefaultListModel<String>();
		
		// colocar todos os elementos de DATA dentro da listmodel
		// FOR EACH element in "data", put each element in "str"
		for (String str : data) {
			listModel.addElement(str);
		}

		// build center panel
		panelCenter = new JPanel();

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.05f, 0.05f, 0.05f, 0.05f);
		panelCenter.setLayout(cl);

		// criar a lista com o model já preenchido
		list = new JList<String>(listModel);
		
		// colocar a JList num JScrollPane para ter scroll
		sp = new JScrollPane(list);
		
		panelCenter.add(sp, ProportionalLayout.CENTER);
		// panelCenter.add(list, ProportionalLayout.CENTER);

		panelCenter.setBackground(new Color(120, 240, 140));
		add(panelCenter, BorderLayout.CENTER);

		// Painel dos botões
		panel = new JPanel(); // Janel default layout -> FlowLayout
		panel.setBackground(new Color(240, 220, 120));

		// buttonAppend
		labelAppend = new JLabel("Data to append:");
		panel.add(labelAppend);
		textToAppend = new JTextField("Verão", 10);
		panel.add(textToAppend);

		buttonAppend = new JButton("Append data");
		buttonAppend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = textToAppend.getText();
				// adição dos elementos directamente no listModel
				listModel.addElement(data);
				int lastIndex = listModel.getSize() - 1;
				list.ensureIndexIsVisible(lastIndex);
				list.setSelectedIndex(lastIndex);
			}
		});
		panel.add(buttonAppend);

		// buttonRemove
		buttonRemoveFirst = new JButton("Remove first");
		buttonRemoveFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listModel.getSize() > 0) {
					// remoção dos elementos directamente do listModel
					String str = (String) listModel.remove(0);
					textToAppend.setText(str);
				}

			}
		});
		panel.add(buttonRemoveFirst);

		// buttonRemoveSelected
		buttonRemoveSelected = new JButton("Remove selected");
		buttonRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selValues = list.getSelectedIndices();
				for (int index = selValues.length - 1; index >= 0; --index) {
					// remoção dos elementos directamente do listModel
					String str = (String) listModel.remove(selValues[index]);
					System.out.println("Remoção em " + index + " -> " + str);
				}
			}
		});
		panel.add(buttonRemoveSelected);

		// adicionar o painel do botões à frame principal
		add(panel, BorderLayout.PAGE_END);

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C2MyListAndScrollFrame myFrame = new C2MyListAndScrollFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

// TODO: colocar o botão para remover todas as linhas seleccionadas
