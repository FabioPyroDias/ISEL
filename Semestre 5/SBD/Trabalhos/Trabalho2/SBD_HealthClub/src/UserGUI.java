import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGUI extends JFrame {

	private User user;
	
	private JPanel content;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		User user = new User("localhost", 50000, args);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI(user);
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
	public UserGUI(User user) {
		
		this.user = user;
		
		//-------------- Window ----------------------
		setTitle("Health Club");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		content = new JPanel();

		setContentPane(content);
		content.setLayout(null);
		//-------------- Window ----------------------
		
		
		//-------------- Main Menu -------------------
		JPanel mainMenu = new JPanel();
		mainMenu.setBackground(new Color(250, 240, 230));
		mainMenu.setBounds(0, 0, 984, 661);
		content.add(mainMenu);
		mainMenu.setLayout(null);
		
		JLabel label_MainMenu_Title = new JLabel("Health Club");
		label_MainMenu_Title.setBackground(new Color(255, 240, 230));
		label_MainMenu_Title.setForeground(new Color(10, 10, 10));
		label_MainMenu_Title.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		label_MainMenu_Title.setHorizontalAlignment(SwingConstants.CENTER);
		label_MainMenu_Title.setBounds(400, 120, 200, 100);
		mainMenu.add(label_MainMenu_Title);
		
		JButton button_MainMenu_SignIn = new JButton("Sign In");
		button_MainMenu_SignIn.setForeground(new Color(255, 240, 230));
		button_MainMenu_SignIn.setBackground(new Color(88, 88, 88));
		button_MainMenu_SignIn.setBounds(450, 350, 100, 20);
		mainMenu.add(button_MainMenu_SignIn);
		
		JButton button_MainMenu_Login = new JButton("Login");
		button_MainMenu_Login.setForeground(new Color(255, 240, 230));
		button_MainMenu_Login.setBackground(new Color(88, 88, 88));
		button_MainMenu_Login.setBounds(450, 380, 100, 20);
		mainMenu.add(button_MainMenu_Login);
		//-------------- Main Menu -------------------
		
		
		
		//-------------- Button Actions --------------
		//-- Buttons - Main Menu --
		button_MainMenu_SignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button_MainMenu_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		GUI_CustomButton personalized_Button = new GUI_CustomButton();
		personalized_Button.setText("Sign In - Test");
		personalized_Button.setBounds(800, 350, 100, 20);
		personalized_Button.setRadius(2);
		personalized_Button.setColorHover(new Color(250, 240, 230));
		mainMenu.add(personalized_Button);
		//-- Buttons - Main Menu --		
	}
}
