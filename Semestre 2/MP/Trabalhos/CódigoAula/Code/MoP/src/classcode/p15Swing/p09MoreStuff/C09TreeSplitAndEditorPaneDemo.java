package classcode.p15Swing.p09MoreStuff;

/**
 * New: JTree, JSplit, JEditorPane
 * 
 * The application that requires the following additional files:
 *   TreeDemoHelp.html, arnold.html,  bloch.html, chan.html, jls.html, 
 *   swingtutorial.html, tutorial.html, tutorialcont.html, vm.html
 *   
 *   This is a Java example
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

public class C09TreeSplitAndEditorPaneDemo extends JPanel
		implements TreeSelectionListener {
	private static final long serialVersionUID = 1L;

	/** JSplitPane is used to divide two (and only two) Components. */
	private JSplitPane splitPane;

	/** JEditor pane - A text component to edit various kinds of content. */
	private JEditorPane htmlPane;

	/** JTree pane - A control that displays hierarchical data in a tree */
	private JTree tree;

	private URL helpURL;
	private static boolean DEBUG = false;

	ImageIcon leafIcon2;

	/**
	 * 
	 */
	public C09TreeSplitAndEditorPaneDemo() {
		super(new GridLayout(1, 0));

		// Create the nodes.
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				"The Java Series");
		createNodes(top);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel()
				.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Set the icon for leaf nodes.
		ImageIcon leafIcon = createImageIcon("images/middle.gif");
		ImageIcon leafIcon2 = createImageIcon("images/middle2.gif");
		ImageIcon leafIcon3 = createImageIcon("images/middle3.gif");
		if (leafIcon != null) {
			DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
			renderer.setLeafIcon(leafIcon);
			renderer.setOpenIcon(leafIcon2);
			renderer.setClosedIcon(leafIcon3);
			tree.setCellRenderer(renderer);
		} else {
			System.err.println("Leaf icon missing; using default.");
		}

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);

		// Create the scroll pane and add the tree to it.
		JScrollPane treeView = new JScrollPane(tree);

		// Create the HTML viewing pane.
		htmlPane = new JEditorPane();
		htmlPane.setEditable(false);
		initHelp();
		JScrollPane htmlView = new JScrollPane(htmlPane);

		// Add the scroll panes to a split pane.
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(treeView);
		splitPane.setBottomComponent(htmlView);

		Dimension minimumSize = new Dimension(100, 50);
		htmlView.setMinimumSize(minimumSize);
		treeView.setMinimumSize(minimumSize);
		splitPane.setDividerLocation(100);

		// XXX: ignored in some releases of Swing. bug 4101306
		// workaround for bug 4101306:
		// treeView.setPreferredSize(new Dimension(100, 100));

		splitPane.setPreferredSize(new Dimension(500, 300));

		// Add the split pane to this panel.
		add(splitPane);
	}

	/** Required by TreeSelectionListener interface. */
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			return;

		Object nodeInfo = node.getUserObject();
		if (node.isLeaf() && (nodeInfo instanceof BookInfo)) {
			BookInfo book = (BookInfo) nodeInfo;
			displayURL(book.bookURL);
			if (DEBUG) {
				System.out.print(book.bookURL + ":  \n    ");
			}
		} else {
			displayURL(helpURL);
		}
		if (DEBUG) {
			System.out.println(nodeInfo.toString());
		}
	}

	private class BookInfo {
		public String bookName;
		public URL bookURL;

		public BookInfo(String book, String filename) {
			bookName = book;
			System.out.println("Getting -> " + "files/" + filename);
			bookURL = C09TreeSplitAndEditorPaneDemo.class
					.getResource("files/" + filename);
			if (bookURL == null) {
				System.err.println("Couldn't find file: " + filename);
			}
		}

		public String toString() {
			return bookName;
		}
	}

	private void initHelp() {
		String s = "files/" + "TreeDemoHelp.html";
		helpURL = C09TreeSplitAndEditorPaneDemo.class.getResource(s);
		if (helpURL == null) {
			System.err.println("Couldn't open help file: " + s);
		} else if (DEBUG) {
			System.out.println("Help URL is " + helpURL);
		}

		displayURL(helpURL);
	}

	private void displayURL(URL url) {
		try {
			if (url != null) {
				htmlPane.setPage(url);
			} else { // null url
				htmlPane.setText("File Not Found");
				if (DEBUG) {
					System.out.println("Attempted to display a null URL.");
				}
			}
		} catch (IOException e) {
			System.err.println("Attempted to read a bad URL: " + url);
		}
	}

	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;

		category = new DefaultMutableTreeNode("Books for Java Programmers");
		top.add(category);

		// original Tutorial
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Tutorial: A Short Course on the Basics",
						"tutorial.html"));
		category.add(book);

		// Tutorial Continued
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Tutorial Continued: The Rest of the JDK",
						"tutorialcont.html"));
		category.add(book);

		// JFC Swing Tutorial
		book = new DefaultMutableTreeNode(new BookInfo(
				"The JFC Swing Tutorial: A Guide to Constructing GUIs",
				"swingtutorial.html"));
		category.add(book);

		// Bloch
		book = new DefaultMutableTreeNode(new BookInfo(
				"Effective Java Programming Language Guide", "bloch.html"));
		category.add(book);

		// Arnold/Gosling
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Programming Language", "arnold.html"));
		category.add(book);

		// Chan
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Developers Almanac", "chan.html"));
		category.add(book);

		category = new DefaultMutableTreeNode("Books for Java Implementers");
		top.add(category);

		// VM
		book = new DefaultMutableTreeNode(new BookInfo(
				"The Java Virtual Machine Specification", "vm.html"));
		category.add(book);

		// Language Spec
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Language Specification", "jls.html"));
		category.add(book);

		// Last simple group with two books
		book = new DefaultMutableTreeNode("Group1");
		category.add(book);
		category = book;

		book = new DefaultMutableTreeNode("Book1");
		category.add(book);

		book = new DefaultMutableTreeNode("Book2");
		category.add(book);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = C09TreeSplitAndEditorPaneDemo.class
				.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {

		// set look and feel - just to show this functionality
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			// UIManager
			// .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

			// UIManager
			// .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Look and feel not available...");
		}

		// Create and set up the window.
		JFrame frame = new JFrame("TreeIconDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		C09TreeSplitAndEditorPaneDemo newContentPane = new C09TreeSplitAndEditorPaneDemo();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
