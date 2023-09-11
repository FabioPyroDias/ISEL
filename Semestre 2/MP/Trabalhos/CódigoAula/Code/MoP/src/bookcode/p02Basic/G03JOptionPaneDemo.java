package bookcode.p02Basic;

import javax.swing.JOptionPane;

/**
 * Example showing jOptionPane as a way to output messages
 * 
 * @author ateofilo
 * 
 */
public class G03JOptionPaneDemo {

	public static void main(String[] args) {
		// input the number of Apples
		String appleString = JOptionPane
				.showInputDialog("Enter number of apples:");
		int appleCount = Integer.parseInt(appleString);

		// input the number of Oranges
		String orangeString = JOptionPane
				.showInputDialog("Enter number of oranges:");
		int orangeCount = Integer.parseInt(orangeString);

		// calculate the total
		int totalFruitCount = appleCount + orangeCount;

		// output total
		JOptionPane.showMessageDialog(null, "The total number of fruits = "
				+ totalFruitCount);
	}
}
