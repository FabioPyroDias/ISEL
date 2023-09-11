import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;

public class ClienteUI extends JFrame {

	private JPanel contentPane;

	private Cliente cliente;
	private JTextField textFieldNome;
	private JTextField textFieldPassword;
	
	private JPanel panelInvite;
	private JLabel labelPlayerName;
	
	private JPanel panelPlayers;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Cliente cliente = new Cliente("localhost", 50000, args);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteUI frame = new ClienteUI(cliente);
					frame.setVisible(true);
					cliente.setClienteUI(frame); //Adicionar a referência do UI
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteUI(Cliente cliente) {
		
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("434x261");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 200);
		contentPane.add(lblNewLabel);
		
		JButton buttonCol0 = new JButton("New button");
		buttonCol0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.enviarJogada("0");
				System.out.println(cliente.getNome() + ": Enviei Jogada - Col 0");
			}
		});
		buttonCol0.setBounds(0, 238, 54, 23);
		contentPane.add(buttonCol0);
		
		JButton buttonCol1 = new JButton("New button");
		buttonCol1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.enviarJogada("1");
				System.out.println(cliente.getNome() + ": Enviei Jogada - Col 1");
			}
		});
		buttonCol1.setBounds(54, 238, 54, 23);
		contentPane.add(buttonCol1);
		
		JButton buttonCol2 = new JButton("New button");
		buttonCol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.enviarJogada("2");
				System.out.println(cliente.getNome() + ": Enviei Jogada - Col 2");
			}
		});
		buttonCol2.setBounds(108, 238, 54, 23);
		contentPane.add(buttonCol2);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(260, 239, 120, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.Login(textFieldNome.getText(), textFieldPassword.getText());
			}
		});
		login.setBounds(260, 211, 120, 23);
		contentPane.add(login);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(166, 239, 84, 20);
		contentPane.add(textFieldPassword);
		
		panelInvite = new JPanel();
		panelInvite.setBackground(Color.MAGENTA);
		panelInvite.setBounds(226, 11, 208, 189);
		contentPane.add(panelInvite);
		panelInvite.setLayout(null);
		
		JPanel panelInviteLabel = new JPanel();
		panelInviteLabel.setBounds(10, 10, 188, 169);
		panelInvite.add(panelInviteLabel);
		panelInviteLabel.setLayout(null);
		
		JLabel labelInvite = new JLabel("Invited by");
		labelInvite.setHorizontalAlignment(SwingConstants.CENTER);
		labelInvite.setBounds(0, 0, 188, 32);
		panelInviteLabel.add(labelInvite);
		
		labelPlayerName = new JLabel("");
		labelPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerName.setBounds(0, 32, 188, 32);
		panelInviteLabel.add(labelPlayerName);
		
		JButton buttonYes = new JButton("Yes");
		buttonYes.setBounds(20, 90, 60, 23);
		panelInviteLabel.add(buttonYes);
		
		JButton buttonNo = new JButton("No");
		buttonNo.setBounds(100, 90, 60, 23);
		panelInviteLabel.add(buttonNo);
		
		panelInvite.setVisible(false);
		
		JButton signIn = new JButton("Sign In");
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.RegistarNaListaDeClientes(textFieldNome.getText(), textFieldPassword.getText());
			}
		});
		signIn.setBounds(166, 211, 84, 23);
		contentPane.add(signIn);
		
		panelPlayers = new JPanel();
		panelPlayers.setBackground(Color.ORANGE);
		panelPlayers.setBounds(0, 0, 162, 234);
		contentPane.add(panelPlayers);
	}
	
	public void challengePlayer(String playerName)
	{
		//Chamar um método, do Cliente, que vai enviar para o WriteSocket do outro Cliente um "Challenged"
	}
	
	//Este método é chamado pelo Cliente quando recebe uma mensagem "Challenged"
	public void challenged(String playerName)
	{
		labelPlayerName.setText(playerName);
		panelInvite.setVisible(true);
		//Mudar ClientState do Cliente para Challenged
	}

	//Chamado no Botão "No" do UI
	public void declineChallenge()
	{
		panelInvite.setVisible(false);
		//Cliente chama o "Enviar Não" a jogador do labelPlayerName.getText();
	}
	
	//Chamado no Botão "Yes" do UI
	public void acceptChallenge()
	{
		panelInvite.setVisible(false);
		//Cliente chama o "Enviar Sim" a jogador do labelPlayerName.getText();
		//Por sua vez, este activa, no UI, o tabuleiro e desactiva o convite.
		//Do lado do cliente que recebe o Sim, acontece o último passo.
	}
	
	public void addPlayer(String playerName)
	{
		JPanel panelPlayer = new JPanel();
		FlowLayout fl_panelPlayer = (FlowLayout) panelPlayer.getLayout();
		fl_panelPlayer.setVgap(20);
		fl_panelPlayer.setHgap(0);
		panelPlayers.add(panelPlayer);
		
		JLabel lblNewLabel_1 = new JLabel(playerName);
		panelPlayer.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Challenge");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelPlayer.add(btnNewButton);
		panelPlayers.add(panelPlayer);
		panelPlayers.revalidate();
		panelPlayers.repaint();
		
		System.out.println("CLIENTE UI -> Fui chamado");
		//System.out.println(panelPlayers.);
	}
	
	public void removePlayer(String playerName)
	{
		for(int playerIndex = 0; playerIndex < panelPlayers.getComponentCount(); playerIndex++)
		{
			
		}
	}
}
