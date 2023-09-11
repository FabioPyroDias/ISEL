import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteUI extends JFrame {
	
	private JPanel contentPane;
	
	private JPanel panelLogin;
	private JPanel panelPlayersList;
	private JPanel panelChallenging;
	private JPanel panelChallenged;
	private JPanel panelGameplay;
	
	private JTextField textfieldPlayerName;
	private ClienteLigacao ligacao;

	public final static String DEFAULT_HOSTNAME = "localhost"; 
    public final static int DEFAULT_PORT = 50000; 
	   
	final private int numRows = 8;
	final private int numCols = 8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ClienteLigacao ligacao = new ClienteLigacao(DEFAULT_HOSTNAME, DEFAULT_PORT, args);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteUI frame = new ClienteUI(ligacao);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteUI(ClienteLigacao ligacao) {
		this.ligacao = ligacao; 
		
		setTitle("Quatro em Linha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initializePanelLogin();
		initializePanelChallenging();
		initializePanelChallenged();
		initializePanelPlayersList();
		initializePanelGameplay();
		
		//setPanelPlayersListDisplay(false);
		//setPanelChallengingDisplay(false);
		//setPanelChallengedDisplay(false);
		setPanelGameplayDisplay(false);
	}

	private void initializePanelLogin()
	{
		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 514, 546);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel labelPlayerName = new JLabel("Player Name");
		labelPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerName.setBounds(212, 228, 100, 20);
		panelLogin.add(labelPlayerName);
		
		textfieldPlayerName = new JTextField();
		textfieldPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		textfieldPlayerName.setBounds(202, 263, 120, 20);
		panelLogin.add(textfieldPlayerName);
		textfieldPlayerName.setColumns(1);	
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Validar o nome em labelPlayerName
				
				ligacao.RegistarNaListaDeClientes(textfieldPlayerName.getText());
				
				setPanelPlayersListDisplay(true);
				setPanelLoginDisplay(false);
			}
		});
		
		buttonLogin.setBounds(202, 293, 120, 20);
		panelLogin.add(buttonLogin);
	}

	private void initializePanelPlayersList()
	{
		panelPlayersList = new JPanel();
		panelPlayersList.setLayout(null);
		panelPlayersList.setBounds(0, 0, 514, 546);
		contentPane.add(panelPlayersList);
		
		JLabel labelPlayerList = new JLabel("Player List");
		labelPlayerList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPlayerList.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerList.setBounds(0, 0, 514, 40);
		panelPlayersList.add(labelPlayerList);
		
		JPanel panelList = new JPanel();
		//panelList.setBounds(0, 40, 514, 900);
		panelList.setPreferredSize(new Dimension(514, 1000));
		
		JScrollPane scroller = new JScrollPane(panelList);
		scroller.setLocation(0, 40);
		scroller.setSize(512, 506);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPlayersList.add(scroller);
		panelList.setLayout(null);
		
		JPanel panelPlayerV1 = new JPanel();
		panelPlayerV1.setBounds(0, 2, 494, 108);
		panelPlayerV1.setBackground(Color.YELLOW);
		panelList.add(panelPlayerV1);
		panelPlayerV1.setLayout(null);
		
		JLabel labelListPlayerName = new JLabel("Player Name");
		labelListPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		labelListPlayerName.setBounds(0, 0, 256, 47);
		panelPlayerV1.add(labelListPlayerName);
		
		JLabel labelNumeroTotalJogos = new JLabel("Numero Jogos");
		labelNumeroTotalJogos.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroTotalJogos.setBounds(0, 47, 128, 47);
		panelPlayerV1.add(labelNumeroTotalJogos);
		
		JLabel labelNumeroTotalVitorias = new JLabel("Numero Vit\u00F3rias");
		labelNumeroTotalVitorias.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroTotalVitorias.setBounds(128, 47, 128, 47);
		panelPlayerV1.add(labelNumeroTotalVitorias);
		
		JButton buttonChallengePlayer = new JButton("Challenge");
		buttonChallengePlayer.setBounds(28, 94, 200, 45);
		panelPlayerV1.add(buttonChallengePlayer);
		
		JPanel panelPlayerV2 = new JPanel();
		panelPlayerV2.setBounds(0, 110, 494, 108);
		panelPlayerV2.setBackground(Color.GREEN);
		panelList.add(panelPlayerV2);
		panelPlayerV2.setLayout(null);
		
		JLabel labelListPlayerName_1 = new JLabel("Player Name");
		labelListPlayerName_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelListPlayerName_1.setBounds(0, 0, 192, 47);
		panelPlayerV2.add(labelListPlayerName_1);
		
		JLabel labelNumeroTotalVitorias_1 = new JLabel("Numero Vit\u00F3rias");
		labelNumeroTotalVitorias_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroTotalVitorias_1.setBounds(96, 47, 96, 47);
		panelPlayerV2.add(labelNumeroTotalVitorias_1);
		
		JLabel labelNumeroTotalJogos_1 = new JLabel("Numero Jogos");
		labelNumeroTotalJogos_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroTotalJogos_1.setBounds(0, 47, 96, 47);
		panelPlayerV2.add(labelNumeroTotalJogos_1);
		
		JLabel labelEstado = new JLabel("Estado");
		labelEstado.setHorizontalAlignment(SwingConstants.CENTER);
		labelEstado.setBounds(0, 94, 192, 45);
		panelPlayerV2.add(labelEstado);
		
		JButton buttonChallengePlayer_1 = new JButton("Challenge");
		buttonChallengePlayer_1.setBounds(192, 20, 64, 100);
		panelPlayerV2.add(buttonChallengePlayer_1);
		
		JPanel panelPlayerV3 = new JPanel();
		panelPlayerV3.setBounds(0, 218, 494, 108);
		panelPlayerV3.setBackground(Color.RED);
		panelList.add(panelPlayerV3);
		panelPlayerV3.setLayout(null);
		
		JLabel labelListPlayerName_2 = new JLabel("Player Name");
		labelListPlayerName_2.setBounds(0, 0, 128, 47);
		labelListPlayerName_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayerV3.add(labelListPlayerName_2);
		
		JLabel labelNumeroTotalVitorias_2 = new JLabel("Numero Vit\u00F3rias");
		labelNumeroTotalVitorias_2.setBounds(128, 47, 128, 47);
		labelNumeroTotalVitorias_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayerV3.add(labelNumeroTotalVitorias_2);
		
		JLabel labelNumeroTotalJogos_2 = new JLabel("Numero Jogos");
		labelNumeroTotalJogos_2.setBounds(0, 47, 128, 47);
		labelNumeroTotalJogos_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayerV3.add(labelNumeroTotalJogos_2);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(128, 0, 128, 47);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayerV3.add(lblEstado);
		
		JButton buttonChallengePlayer_1_1 = new JButton("Challenge");
		buttonChallengePlayer_1_1.setBounds(28, 94, 200, 45);
		panelPlayerV3.add(buttonChallengePlayer_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 326, 494, 108);
		panel_3.setBackground(Color.CYAN);
		panelList.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel labelListPlayerName_2_1 = new JLabel("Player Name");
		labelListPlayerName_2_1.setBounds(10, 10, 246, 40);
		labelListPlayerName_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(labelListPlayerName_2_1);
		
		JLabel labelNumeroTotalVitorias_2_1 = new JLabel("Numero Vit\u00F3rias");
		labelNumeroTotalVitorias_2_1.setBounds(10, 50, 123, 41);
		labelNumeroTotalVitorias_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(labelNumeroTotalVitorias_2_1);
		
		JLabel labelNumeroTotalJogos_2_1 = new JLabel("Numero Jogos");
		labelNumeroTotalJogos_2_1.setBounds(133, 50, 123, 41);
		labelNumeroTotalJogos_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(labelNumeroTotalJogos_2_1);
		
		JLabel lblEstado_1 = new JLabel("Estado");
		lblEstado_1.setBounds(266, 10, 218, 40);
		lblEstado_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblEstado_1);
		
		JButton buttonChallengePlayer_1_1_1 = new JButton("Challenge");
		buttonChallengePlayer_1_1_1.setBounds(266, 50, 218, 41);
		panel_3.add(buttonChallengePlayer_1_1_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(Color.BLUE);
		panel_3_1_1.setBounds(0, 542, 494, 108);
		panelList.add(panel_3_1_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.YELLOW);
		panel_3_1.setBounds(0, 434, 494, 108);
		panelList.add(panel_3_1);
		
		JLabel labelListPlayerName_2_1_1 = new JLabel("Player Name");
		labelListPlayerName_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelListPlayerName_2_1_1.setBounds(10, 10, 246, 40);
		panel_3_1.add(labelListPlayerName_2_1_1);
		
		JLabel labelNumeroTotalVitorias_2_1_1 = new JLabel("Numero Vit\u00F3rias");
		labelNumeroTotalVitorias_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroTotalVitorias_2_1_1.setBounds(266, 10, 109, 40);
		panel_3_1.add(labelNumeroTotalVitorias_2_1_1);
		
		JLabel labelNumeroTotalJogos_2_1_1 = new JLabel("Numero Jogos");
		labelNumeroTotalJogos_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroTotalJogos_2_1_1.setBounds(375, 10, 109, 41);
		panel_3_1.add(labelNumeroTotalJogos_2_1_1);
		
		JLabel lblEstado_1_1 = new JLabel("Estado");
		lblEstado_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado_1_1.setBounds(10, 50, 246, 41);
		panel_3_1.add(lblEstado_1_1);
		
		JButton buttonChallengePlayer_1_1_1_1 = new JButton("Challenge");
		buttonChallengePlayer_1_1_1_1.setBounds(266, 50, 218, 41);
		panel_3_1.add(buttonChallengePlayer_1_1_1_1);
	}

	private void initializePanelChallenging()
	{
		panelChallenging = new JPanel();
		panelChallenging.setBackground(Color.BLUE);
		panelChallenging.setLayout(null);
		panelChallenging.setBounds(50, 323, 396, 100);
		contentPane.add(panelChallenging);
		
		JLabel labelADesafiar = new JLabel("Challenging");
		labelADesafiar.setHorizontalAlignment(SwingConstants.CENTER);
		labelADesafiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelADesafiar.setBounds(40, 10, 354, 33);
		panelChallenging.add(labelADesafiar);
		
		JButton buttonCancelarDesafio = new JButton("Cancel");
		buttonCancelarDesafio.setBounds(120, 56, 194, 34);
		panelChallenging.add(buttonCancelarDesafio);
	}

	private void initializePanelChallenged()
	{
		panelChallenged = new JPanel();
		panelChallenged.setBackground(Color.RED);
		panelChallenged.setLayout(null);
		panelChallenged.setBounds(50, 123, 396, 100);
		contentPane.add(panelChallenged);
		
		JLabel labelDesafiadoPor = new JLabel("Challenged by");
		labelDesafiadoPor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDesafiadoPor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDesafiadoPor.setBounds(40, 10, 354, 33);
		panelChallenged.add(labelDesafiadoPor);
		
		JButton buttonAcceptChallenge = new JButton("Accept");
		buttonAcceptChallenge.setBounds(40, 56, 137, 34);
		panelChallenged.add(buttonAcceptChallenge);
		
		JButton buttonDeclineChallenge = new JButton("Decline");
		buttonDeclineChallenge.setBounds(257, 56, 137, 34);
		panelChallenged.add(buttonDeclineChallenge);
	}

	private void initializePanelGameplay()
	{
		panelGameplay = new JPanel();
		panelGameplay.setLayout(null);
		panelGameplay.setBounds(0, 0, 512, 546);
		contentPane.add(panelGameplay);
		
		JPanel tabuleiro = new JPanel();
		tabuleiro.setBounds(10, 10, 494, 494);
		panelGameplay.add(tabuleiro);
		tabuleiro.setLayout(null);
		
		JPanel[][] tabuleiroDisplay = new JPanel[8][8];
		
		for(int row = 0; row < 8; row++)
		{
			for(int col = 0; col < 8; col++)
			{
				JPanel celula = new JPanel();
				celula.setBackground(Color.PINK);
				celula.setBounds(row * 62, col * 62, 60, 60);
				tabuleiro.add(celula);
				celula.setLayout(null);
				
				tabuleiroDisplay[row][col] = celula;
			}
		}
		
		JButton buttonCol0 = new JButton("Seta");
		buttonCol0.setBounds(10, 506, 60, 30);
		panelGameplay.add(buttonCol0);
		
		JButton buttonCol1 = new JButton("Seta");
		buttonCol1.setBounds(72, 506, 60, 30);
		panelGameplay.add(buttonCol1);
		
		JButton buttonCol2 = new JButton("Seta");
		buttonCol2.setBounds(134, 506, 60, 30);
		panelGameplay.add(buttonCol2);
		
		JButton buttonCol3 = new JButton("Seta");
		buttonCol3.setBounds(196, 506, 60, 30);
		panelGameplay.add(buttonCol3);
		
		JButton buttonCol4 = new JButton("Seta");
		buttonCol4.setBounds(258, 506, 60, 30);
		panelGameplay.add(buttonCol4);
		
		JButton buttonCol5 = new JButton("Seta");
		buttonCol5.setBounds(320, 506, 60, 30);
		panelGameplay.add(buttonCol5);
		
		JButton buttonCol6 = new JButton("Seta");
		buttonCol6.setBounds(382, 506, 60, 30);
		panelGameplay.add(buttonCol6);
		
		JButton buttonCol7 = new JButton("Seta");
		buttonCol7.setBounds(444, 506, 60, 30);
		panelGameplay.add(buttonCol7);
		
		/*
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
		*/
		
	}
	
	private void setPanelLoginDisplay(boolean isVisible)
	{
		panelLogin.setVisible(isVisible);
	}
	
	private void setPanelPlayersListDisplay(boolean isVisible)
	{
		panelPlayersList.setVisible(isVisible);
	}

	private void setPanelChallengingDisplay(boolean isVisible)
	{
		panelChallenging.setVisible(isVisible);
	}
	
	private void setPanelChallengedDisplay(boolean isVisible)
	{
		panelChallenged.setVisible(isVisible);
	}
	
	private void setPanelGameplayDisplay(boolean isVisible)
	{
		panelGameplay.setVisible(isVisible);
	}
	
	private void OpenConnection()
	{ 
		
	}
}