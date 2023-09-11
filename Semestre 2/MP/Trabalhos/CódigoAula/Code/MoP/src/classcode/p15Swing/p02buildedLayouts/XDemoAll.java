package classcode.p15Swing.p02buildedLayouts;

import javax.swing.JFrame;

/**
 * CenterLayoutDemo - os botões diminuem ou aumentam a dimensão dos insets
 * 
 * Asuntos: CenterLayout
 * 
 * @author António Teófilo
 * 
 */
public class XDemoAll {

	
	/**
	 * 
	 */
	private static void createAndShowGUIBorder(int w, int h, int x, int y) {
		JFrame frame = createAux("Border Layout Demo", w, h, x, y);
		XBorderLayoutDemo.addComponentsToPane(frame.getContentPane());
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
	private static void createAndShowGUICenter(int w, int h, int x, int y) {
		JFrame frame = createAux("Center Layout Demo", w, h, x, y);
		XCenterLayoutDemo.addComponentsToPane(frame.getContentPane());
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
	private static void createAndShowGUIProportional(int w, int h, int x, int y) {
		JFrame frame = createAux("Proportional Layout Demo", w, h, x, y);
		XProportionalLayoutDemo.addComponentsToPane(frame.getContentPane());
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
	private static JFrame createAux(String frameName, int w, int h, int x, int y) {
		JFrame frame = new JFrame(frameName);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(x, y, w, h);
		return frame;
	}
	
	

	/**
	 * 
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUIBorder(300, 300, 100, 100);
				createAndShowGUIBorder(200, 200, 100, 450);
				createAndShowGUIProportional(300, 300, 500, 100);
				createAndShowGUIProportional(200, 200, 500, 450);
				createAndShowGUICenter(300, 300, 900, 100);
				createAndShowGUICenter(200, 200, 900, 450);
				
			}
		});
	}
}
