import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField robotTextField;
	private JTextField raioTextField;
	private JTextField anguloTextField;
	private JTextField distanciaTextField;
	private JTextArea consolaTextArea;
	private JScrollPane scrollPane;

	private JButton frenteButton;
	private JButton pararButton;
	private JButton retaguardaButton;
	private JButton esquerdaButton;
	private JButton direitaButton;
	
	private JRadioButton robotRealRadioButton;
	private JRadioButton robotSimuladoRadioButton;
	
	private JCheckBox vaguearCheckBox;
	private JCheckBox evitarCheckBox;
	private JCheckBox fugirCheckBox;
	
	private minhasVariaveis mv;
	private RobotLego robot;
	
	private Vaguear vaguear;
	private Evitar evitar;
	private Fugir fugir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//GUI gui = new GUI();
		//gui.run();
	}

	public void run() 
	{
		
	}
	
	/**
	 * Create the frame.
	 */
	public GUI_Admin(minhasVariaveis mv, Vaguear vaguear, Evitar evitar, Fugir fugir) 
	{
		this.mv = mv;
		
		this.vaguear = vaguear;
		this.evitar = evitar;
		this.fugir = fugir;
		
		robot = new RobotLegoEV3Simulado();
		
		vaguear.setRobot(robot);
		evitar.setRobot(robot);
		fugir.setRobot(robot);
		
		setTitle("GUI do Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel robotLabel = new JLabel("Robot");
		robotLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		robotLabel.setBounds(132, 11, 46, 14);
		contentPane.add(robotLabel);
		
		robotTextField = new JTextField(mv.getNomeRobot());
		robotTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mv.setNomeRobot(robotTextField.getText());
				myPrint("Nome: " + mv.getNomeRobot());
			}
		});
		robotTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		robotTextField.setBounds(188, 8, 86, 20);
		contentPane.add(robotTextField);
		robotTextField.setColumns(10);
		
		JLabel raioLabel = new JLabel("Raio");
		raioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		raioLabel.setBounds(10, 65, 30, 18);
		contentPane.add(raioLabel);
		
		raioTextField = new JTextField(String.valueOf(mv.getRaio()));
		raioTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					mv.setRaio(Integer.parseInt(raioTextField.getText()));		
					myPrint("Raio: " + mv.getRaio());
				}
				catch(NumberFormatException e)
				{
					raioTextField.setText(String.valueOf(mv.getRaio()));
				}
			}
		});
		raioTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		raioTextField.setBounds(50, 64, 50, 20);
		contentPane.add(raioTextField);
		raioTextField.setColumns(10);
		
		JLabel anguloLabel = new JLabel("\u00C2ngulo");
		anguloLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		anguloLabel.setBounds(132, 65, 48, 18);
		contentPane.add(anguloLabel);
		
		anguloTextField = new JTextField(String.valueOf(mv.getAngulo()));
		anguloTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					mv.setAngulo(Integer.parseInt(anguloTextField.getText()));
					myPrint("�ngulo: " + mv.getAngulo());
				}
				catch(NumberFormatException e)
				{
					anguloTextField.setText(String.valueOf(mv.getAngulo()));
				}
			}
		});
		anguloTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		anguloTextField.setBounds(190, 64, 50, 20);
		contentPane.add(anguloTextField);
		anguloTextField.setColumns(10);
		
		JLabel distanciaLabel = new JLabel("Dist\u00E2ncia");
		distanciaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distanciaLabel.setBounds(281, 65, 60, 18);
		contentPane.add(distanciaLabel);
		
		distanciaTextField = new JTextField(String.valueOf(mv.getDistancia()));
		distanciaTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					mv.setDistancia(Integer.parseInt(distanciaTextField.getText()));
					myPrint("Dist�ncia: " + mv.getDistancia());
				}
				catch(NumberFormatException e)
				{
					distanciaTextField.setText(String.valueOf(mv.getDistancia()));
				}
			}
		});
		distanciaTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distanciaTextField.setBounds(351, 64, 50, 20);
		contentPane.add(distanciaTextField);
		distanciaTextField.setColumns(10);
		
		frenteButton = new JButton("Frente");
		frenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				myPrint("Reta " + mv.getDistancia());
				mv.getRobot().Reta(mv.getDistancia());
				mv.getRobot().Parar(false);
			}
		});
		frenteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frenteButton.setBounds(164, 110, 110, 40);
		frenteButton.setEnabled(false);
		contentPane.add(frenteButton);
		
		pararButton = new JButton("Parar");
		pararButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				myPrint("Parar");
				mv.getRobot().Parar(true);
			}
		});
		pararButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pararButton.setBounds(164, 150, 110, 40);
		pararButton.setEnabled(false);
		contentPane.add(pararButton);
		
		retaguardaButton = new JButton("Retaguarda\r\n");
		retaguardaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				myPrint("Reta " + (-mv.getDistancia()));
				mv.getRobot().Reta(-mv.getDistancia());
				
				System.out.println("Chamado Tr�s");
				System.out.println(mv.getRobot());
				
				mv.getRobot().Parar(false);
			}
		});
		retaguardaButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retaguardaButton.setBounds(164, 190, 110, 40);
		retaguardaButton.setEnabled(false);		
		contentPane.add(retaguardaButton);
		
		esquerdaButton = new JButton("Esquerda");
		esquerdaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				myPrint("Esquerda " + mv.getRaio() + " " + mv.getAngulo());
				mv.getRobot().CurvarEsquerda(mv.getRaio(), mv.getAngulo());
				mv.getRobot().Parar(false);
			}
		});
		esquerdaButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		esquerdaButton.setBounds(54, 150, 110, 40);
		esquerdaButton.setEnabled(false);
		contentPane.add(esquerdaButton);
		
		direitaButton = new JButton("Direita");
		direitaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				myPrint("Direita " + mv.getRaio() + " " + mv.getAngulo());
				mv.getRobot().CurvarDireita(mv.getRaio(), mv.getAngulo());
				mv.getRobot().Parar(false);
			}
		});
		direitaButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		direitaButton.setBounds(274, 150, 110, 40);
		direitaButton.setEnabled(false);
		contentPane.add(direitaButton);
		
		JRadioButton powerRadioButton = new JRadioButton("On / Off");
		powerRadioButton.setSelected(mv.isPower());
		powerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(powerRadioButton.isSelected())
				{
					if(mv.getRobot().OpenEV3(mv.getNomeRobot()))
					{
						powerRadioButton.setSelected(true);
						myPrint("O canal de comunica��o est� aberto com sucesso");
						mv.setPower(powerRadioButton.isSelected());
					}
					else
					{
						powerRadioButton.setSelected(false);
						myPrint("O canal de comunica��o falhou");
						mv.setPower(powerRadioButton.isSelected());
					}
				}
				else
				{
					mv.getRobot().CloseEV3();
					myPrint("O canal de comunica��o est� fechado");
					mv.setPower(powerRadioButton.isSelected());
				}
				
				updateButtons(powerRadioButton.isSelected());
			}
		});
		powerRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		powerRadioButton.setBounds(280, 8, 80, 23);
		contentPane.add(powerRadioButton);
		
		JCheckBox debugCheckBox = new JCheckBox("Debug");
		debugCheckBox.setSelected(mv.isDebug());
		debugCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mv.setDebug(debugCheckBox.isSelected());
			}
		});
		debugCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		debugCheckBox.setBounds(3, 207, 97, 23);
		contentPane.add(debugCheckBox);

		
		vaguearCheckBox = new JCheckBox("Vaguear");
		vaguearCheckBox.setSelected(mv.isVaguear());
		vaguearCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mv.setVaguear(vaguearCheckBox.isSelected());
				myPrint("Vaguear: " + (mv.isVaguear()? "Sim" : "N�o"));
				
				if(mv.isVaguear())
				{
					vaguear.funcionar();					
				}
				else
				{
					vaguear.parar();
				}
			}
		});
		vaguearCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vaguearCheckBox.setBounds(304, 209, 97, 23);
		contentPane.add(vaguearCheckBox);
		
		evitarCheckBox = new JCheckBox("Evitar");
		evitarCheckBox.setSelected(mv.isEvitar());
		evitarCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mv.setEvitar(evitarCheckBox.isSelected());
				myPrint("Evitar: " + (mv.isEvitar()? "Sim" : "N�o"));
				
				if(mv.isEvitar())
				{
					evitar.funcionar();					
				}
				else
				{
					evitar.parar();
				}
			}
		});
		evitarCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		evitarCheckBox.setBounds(304, 235, 97, 23);
		contentPane.add(evitarCheckBox);
		
		fugirCheckBox = new JCheckBox("Fugir");
		fugirCheckBox.setSelected(mv.isFugir());
		fugirCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mv.setFugir(fugirCheckBox.isSelected());
				myPrint("Fugir: " + (mv.isFugir()? "Sim" : "N�o"));
				
				if(mv.isFugir())
				{
					fugir.funcionar();					
				}
				else
				{
					fugir.parar();
				}
			}
		});
		fugirCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fugirCheckBox.setBounds(304, 261, 97, 23);
		contentPane.add(fugirCheckBox);
		
		JLabel consolaLabel = new JLabel("Consola");
		consolaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		consolaLabel.setBounds(10, 266, 50, 14);
		contentPane.add(consolaLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 288, 414, 172);
		contentPane.add(scrollPane);
		
		consolaTextArea = new JTextArea();
		scrollPane.setViewportView(consolaTextArea);
		DefaultCaret caret = (DefaultCaret)consolaTextArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		consolaTextArea.setEditable(false);
		consolaTextArea.setRows(100);
		consolaTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		robotRealRadioButton = new JRadioButton("Robot Real");
		robotRealRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MudarTipoDeRobot(false);
			}
		});
		robotRealRadioButton.setSelected(false);
		robotRealRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		robotRealRadioButton.setBounds(107, 32, 116, 23);
		contentPane.add(robotRealRadioButton);
		
		robotSimuladoRadioButton = new JRadioButton("Robot Simulado");
		robotSimuladoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MudarTipoDeRobot(true);
			}
		});
		robotSimuladoRadioButton.setSelected(true);
		robotSimuladoRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		robotSimuladoRadioButton.setBounds(225, 32, 130, 23);
		contentPane.add(robotSimuladoRadioButton);

		setVisible(true);
		updateButtons(false);
	}
	
	public void myPrint(String s)
	{
		if(mv.isDebug())
		{
			consolaTextArea.append(s + '\n');
		}
	}
	
	private void updateButtons(boolean isActive)
	{
		frenteButton.setEnabled(isActive);
		pararButton.setEnabled(isActive);
		retaguardaButton.setEnabled(isActive);
		esquerdaButton.setEnabled(isActive);
		direitaButton.setEnabled(isActive);
		
		vaguearCheckBox.setEnabled(isActive);
		evitarCheckBox.setEnabled(isActive);
		fugirCheckBox.setEnabled(isActive);
		
		vaguearCheckBox.setSelected(false);
		evitarCheckBox.setSelected(false);
		fugirCheckBox.setSelected(false);
		
		vaguear.parar();
		evitar.parar();
		fugir.parar();
		
		mv.setVaguear(false);
		mv.setEvitar(false);
		mv.setFugir(false);
	}
	
	private void MudarTipoDeRobot(boolean simulado)
	{
		System.out.println(simulado);
		
		if(simulado)
		{
			robotSimuladoRadioButton.setSelected(true);
			robotRealRadioButton.setSelected(false);
			
			//mv.setRobot(new RobotLegoEV3Simulado());
			robot = new RobotLegoEV3Simulado();
		}
		else
		{	
			robotRealRadioButton.setSelected(true);
			robotSimuladoRadioButton.setSelected(false);
			
			//mv.setRobot(new MyRobotLegoEV3());
			robot = new MyRobotLegoEV3();
		}
		
		mv.setRobot(robot);
		vaguear.setRobot(robot);
		evitar.setRobot(robot);
		fugir.setRobot(robot);
	}
}
