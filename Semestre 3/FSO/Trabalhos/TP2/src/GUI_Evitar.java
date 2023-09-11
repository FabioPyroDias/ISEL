import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GUI_Evitar extends JFrame {

	private JPanel contentPane;
	
	private JTextArea consolaTextArea;
	private JCheckBox debugCheckBox;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Evitar frame = new GUI_Evitar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Evitar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		debugCheckBox = new JCheckBox("");
		debugCheckBox.setSelected(true);
		debugCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		debugCheckBox.setBounds(66, 147, 27, 23);
		contentPane.add(debugCheckBox);
		
		JLabel consolaLabel = new JLabel("Consola");
		consolaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		consolaLabel.setBounds(10, 151, 50, 14);
		contentPane.add(consolaLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 177, 404, 223);
		contentPane.add(scrollPane);
		
		consolaTextArea = new JTextArea();
		scrollPane.setViewportView(consolaTextArea);
		DefaultCaret caret = (DefaultCaret)consolaTextArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		consolaTextArea.setEditable(false);
		consolaTextArea.setRows(100);
		consolaTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Evitar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 131);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
	}
	
	public void debugMode(String s)
	{
		if(debugCheckBox.isSelected())
		{
			consolaTextArea.append(s + '\n');
		}
	}
}