import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UserGUI extends JFrame {

	private JPanel content;
	private JTextField textField_MainMenu_Username;
	private JTextField textField_MainMenu_password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
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
	public UserGUI()
	{
		/* Color Palettes Used:
		 * - PT:
		 *      45, 50, 80
		 *      249, 177, 122
		 *      66, 71, 105
		 * 
		 * - Client:
		 *  
		 *
		 */
		
		//---------- Window ----------
		setTitle("Health Club");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		content = new JPanel();

		setContentPane(content);
		content.setLayout(null);
		//---------- Window ----------
		
		//---------- Main Menu ----------
		JPanel mainMenu = new JPanel();
		mainMenu.setLayout(null);
		mainMenu.setBackground(new Color(10, 10, 10));
		mainMenu.setBounds(0, 0, 984, 661);
		content.add(mainMenu);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(45, 50, 80));
		panel.setBounds(25, 25, 30, 30);
		mainMenu.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 177, 122));
		panel_1.setBounds(80, 25, 30, 30);
		mainMenu.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(66, 71, 105));
		panel_1_1.setBounds(135, 25, 30, 30);
		mainMenu.add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(40, 75, 82));
		panel_2.setBounds(25, 80, 30, 30);
		mainMenu.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(35, 129, 130));
		panel_2_1.setBounds(80, 80, 30, 30);
		mainMenu.add(panel_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(5, 228, 190));
		panel_2_1_1.setBounds(135, 80, 30, 30);
		mainMenu.add(panel_2_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(14, 18, 17));
		panel_3.setBounds(25, 135, 30, 30);
		mainMenu.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(21, 37, 29));
		panel_3_1.setBounds(80, 135, 30, 30);
		mainMenu.add(panel_3_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(48, 131, 59));
		panel_3_1_1.setBounds(135, 135, 30, 30);
		mainMenu.add(panel_3_1_1);
		
		JButton btnNewButton = new JButton("Personal Trainer");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(249, 177, 122));
		btnNewButton.setBounds(60, 613, 248, 23);
		mainMenu.add(btnNewButton);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBackground(new Color(5, 228, 190));
		btnCliente.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCliente.setBounds(368, 613, 248, 23);
		mainMenu.add(btnCliente);
		
		JButton btnNewButton_1_1 = new JButton("Gerente");
		btnNewButton_1_1.setBackground(new Color(48, 131, 59));
		btnNewButton_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(676, 613, 248, 23);
		mainMenu.add(btnNewButton_1_1);
		
		//---------- Main Menu ----------
	}
	
	//If we change the name to UserGUI and remove the "void", it shows the previously made GUI
	public void UserGUIOutdated() {
		
		//-------------- Window ----------------------
		setTitle("Health Club");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		content = new JPanel();

		setContentPane(content);
		content.setLayout(null);
		//-------------- Window ----------------------
		
		
		//-------------- Main Menu -------------------
		JPanel mainMenu_V2 = new JPanel();
		mainMenu_V2.setLayout(null);
		mainMenu_V2.setBackground(new Color(45, 50, 80));
		mainMenu_V2.setBounds(0, 0, 984, 661);
		content.add(mainMenu_V2);
		
		JLabel lblHealthClub = new JLabel("Health Club");
		lblHealthClub.setHorizontalAlignment(SwingConstants.LEFT);
		lblHealthClub.setForeground(new Color(255, 255, 255));
		lblHealthClub.setFont(new Font("Century Gothic", Font.PLAIN, 48));
		lblHealthClub.setBackground(new Color(255, 240, 230));
		lblHealthClub.setBounds(80, 80, 300, 100);
		mainMenu_V2.add(lblHealthClub);
		
		JButton button_MainMenu_SignIn_1 = new JButton("Sign In");
		button_MainMenu_SignIn_1.setForeground(new Color(0, 0, 0));
		button_MainMenu_SignIn_1.setBackground(new Color(249, 177, 122));
		button_MainMenu_SignIn_1.setBounds(80, 550, 100, 40);
		mainMenu_V2.add(button_MainMenu_SignIn_1);
		
		JButton button_MainMenu_Login_1 = new JButton("Login");
		button_MainMenu_Login_1.setForeground(new Color(0, 0, 0));
		button_MainMenu_Login_1.setBackground(new Color(249, 177, 122));
		button_MainMenu_Login_1.setBounds(80, 380, 100, 40);
		mainMenu_V2.add(button_MainMenu_Login_1);
		
		textField_MainMenu_Username = new JTextField();
		textField_MainMenu_Username.setForeground(new Color(255, 255, 255));
		textField_MainMenu_Username.setBackground(new Color(66, 71, 105));
		textField_MainMenu_Username.setBounds(80, 250, 200, 30);
		mainMenu_V2.add(textField_MainMenu_Username);
		textField_MainMenu_Username.setColumns(10);
		
		textField_MainMenu_password = new JTextField();
		textField_MainMenu_password.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MainMenu_password.setForeground(new Color(255, 255, 255));
		textField_MainMenu_password.setBackground(new Color(66, 71, 105));
		textField_MainMenu_password.setColumns(10);
		textField_MainMenu_password.setBounds(80, 310, 200, 30);
		mainMenu_V2.add(textField_MainMenu_password);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(66, 71, 105));
		lblNewLabel.setBounds(80, 290, 200, 20);
		mainMenu_V2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(66, 71, 105));
		lblNewLabel_1.setBounds(80, 230, 200, 20);
		mainMenu_V2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Not signed in yet? ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(80, 530, 200, 20);
		mainMenu_V2.add(lblNewLabel_2);
		
		//JPanel panel = new JPanel();
		//panel.setBounds(504, 230, 400, 350);
		//mainMenu_V2.add(panel);
		
		ImageIcon icon = new ImageIcon("media/main_menu_kim_jong_un_edited.png"); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		thumb.setBounds(504, 230, 400, 350);
		//mainMenu_V2.add(thumb);
		
		ImageIcon iconv2 = new ImageIcon("media/main_menu_kim_jong_un_edited2.png"); 
		JLabel thumbv2 = new JLabel();
		thumbv2.setIcon(iconv2);
		thumbv2.setBounds(484, 210, 440, 390);
		mainMenu_V2.add(thumbv2);
		//-- Buttons - Main Menu --		
	}
}
