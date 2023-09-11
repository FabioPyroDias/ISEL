package tp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Game extends JFrame{
	
	private enum GameState
	{
		OpeningMenu,
		MainMenu,
		ArmoryMenu,
		Adventure
	}
	
	private static JFrame frame;
	
	//Overall Panel
	private static JPanel panelOverall;
	
	//Opening Menu
	private static JPanel panelMenuOpening;
	private static JPanel panelMenuOpeningOptions;
	private static JPanel panelMenuOpeningNewGame;
	private static JPanel panelMenuOpeningLoadGame;
	
	//Main Menu
	private static JPanel panelMenuMain;
	
	private static JLabel labelPlayerName;
	private static JLabel labelPlayerBaseHealth;
	private static JLabel labelPlayerModifiedHealth;
	private static JLabel labelPlayerBaseAttack;
	private static JLabel labelPlayerModifiedAttack;
	private static JLabel labelPlayerBaseDefense;
	private static JLabel labelPlayerModifiedDefense;
	
	//Armory Menu
	private static JPanel panelMenuArmory;
	
	//Adventure Menu
	private static JPanel panelMenuAdventure;
	
	private static JLabel labelEnemyName;
	private static JLabel labelEnemyHealth;
	private static JLabel labelPlayerNameAdventure;
	private static JLabel labelPlayerModifiedHealthAdventure;
	private static JLabel labelPlayerModifiedAttackAdventure;
	private static JLabel labelPlayerModifiedDefenseAdventure;
	
	
	private static GameState currentGameState;
	
	private static ItemGenerator itemGenerator = new ItemGenerator();
	private static EnemyGenerator enemyGenerator = new EnemyGenerator();
	private static Player player;
	private static Enemy enemy;
	
	private static int playerHealth;
	private static int playerAttack;
	private static int playerDefense;
	
	private static int enemyHealth;
	private static int enemyAttack;
	private static int enemyDefense;
	
	private static int adventureLevel  = 1;
	
	public static void main(String[] args)
	{
		//Carregar o Save File
		SaveSystem.saveFileInitialization();
		
		currentGameState = GameState.OpeningMenu;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				showGUI();
				initializeMenuOpening();
				initializeMenuMain();
				initializeMenuArmory();
				initializeMenuAdventure();
			}
		});
	}
	
	private static void showGUI()
	{
		//Create a JFrame
		frame = new JFrame();
		
		//Set JFrame title
		frame.setTitle("Leveling Soul");
		
		//Set JFrame Centered
		frame.setLocationRelativeTo(null);
		
		//Set JFrame Size
		frame.setBounds(0, 0, 1382, 784);
		
		//Set JFrame not Resizable
		frame.setResizable(false);
		
		//Set Default Close Operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//Set JFrame Color
		frame.getContentPane().setBackground(new Color(158, 138, 135));
		
		//Set JFrame Layout
		frame.getContentPane().setLayout(null);
		
		//Set JFrame visible
		frame.setVisible(true);
		
		//Initialize JPanel
		panelOverall = new JPanel();
		
		//Set JPanel Size
		panelOverall.setBounds(0, 0, 1382, 784);
		
		//Set JPanel Opaque
		panelOverall.setOpaque(false);
		
		//Set JPanel Layout
		panelOverall.setLayout(null);
		
		frame.getContentPane().add(panelOverall);
	}
	
	private static void initializeMenuOpening()
	{
		//Initialize JPanel Menu Opening
		panelMenuOpening = new JPanel();
		panelMenuOpening.setBounds(0, 0, 1382, 784);
		panelMenuOpening.setOpaque(true);
		panelMenuOpening.setBackground(new Color(158, 138, 135));
		panelMenuOpening.setLayout(null);
		
		//Initialize JPanel Menu Opening Options
		panelMenuOpeningOptions = new JPanel();
		panelMenuOpeningOptions.setBounds(0, 0, 1382, 784);
		panelMenuOpeningOptions.setOpaque(false);
		panelMenuOpeningOptions.setLayout(null);
		
		//Add JPanel to Opening Panel
		panelMenuOpening.add(panelMenuOpeningOptions);		
		
		//Initialize JPanel Menu Opening New Game
		panelMenuOpeningNewGame = new JPanel();
		panelMenuOpeningNewGame.setBounds(0, 0, 1382, 784);
		panelMenuOpeningNewGame.setOpaque(false);
		panelMenuOpeningNewGame.setLayout(null);
		
		//Initialize JPanel Menu Opening Load Game
		panelMenuOpeningLoadGame = new JPanel();
		panelMenuOpeningLoadGame.setBounds(0, 0, 1382, 784);
		panelMenuOpeningLoadGame.setOpaque(false);
		panelMenuOpeningLoadGame.setLayout(null);
		
		//Add Menu Opening Panel to JFrame
		panelOverall.add(panelMenuOpening);
		
		//Label Game Title 
		/* Set Title. 
		 * Set Alignment. 
		 * Set Bounds (Size). 
		 * Set Background (Color). 
		 * Set Opaque.
		 */
		JLabel labelGameTitle = new JLabel("Solo Leveling");
		labelGameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelGameTitle.setBounds(601, 100, 180, 100);
		labelGameTitle.setBackground(new Color(90, 100, 0));
		labelGameTitle.setOpaque(true);
		panelMenuOpeningOptions.add(labelGameTitle);

		//Button Continue
		/*
		 * Set Text.
		 * Set Bounds (Size)
		 */
		JButton buttonContinue = new JButton("Continue");
		buttonContinue.setBounds(601, 225, 180, 100);
		panelMenuOpeningOptions.add(buttonContinue);
		
		//Add Action Listener
		ActionListener actionContinue = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				SaveSystem.loadLastGame();
			}
		};
		
		buttonContinue.addActionListener(actionContinue);
		
		//Button New Game
		/*
		 * Set Text.
		 * Set Bounds (Size)
		 */
		JButton buttonNewGame = new JButton("New Game");
		buttonNewGame.setBounds(601, 350, 180, 100);
		panelMenuOpeningOptions.add(buttonNewGame);
		
		//Add Action Listener
		ActionListener actionNewGame = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelMenuOpening.removeAll();
				panelMenuOpening.add(panelMenuOpeningNewGame);
				panelMenuOpening.repaint();
				panelMenuOpening.revalidate();
			}
		};
		
		buttonNewGame.addActionListener(actionNewGame);
		
		//Button Load Game
		/*
		 * Set Text.
		 * Set Bounds (Size)
		 */
		JButton buttonLoadGame = new JButton("Load Game");
		buttonLoadGame.setBounds(601, 475, 180, 100);
		panelMenuOpeningOptions.add(buttonLoadGame);
		
		//Menu Opening New Game
		JLabel labelError = new JLabel();
		labelError.setBounds(491, 242, 400, 50);
		labelError.setBackground(Color.red);
		labelError.setOpaque(true);
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenuOpeningNewGame.add(labelError);
		
		JLabel labelInsertName = new JLabel("Insert Character Name");
		labelInsertName.setBounds(491, 292, 400, 50);
		labelInsertName.setBackground(Color.blue);
		labelInsertName.setOpaque(true);
		labelInsertName.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenuOpeningNewGame.add(labelInsertName);
		
		JTextField textFieldPlayerName = new JTextField();
		textFieldPlayerName.setBounds(491, 342, 400, 50);
		textFieldPlayerName.setBackground(Color.green);
		textFieldPlayerName.setOpaque(true);
		textFieldPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenuOpeningNewGame.add(textFieldPlayerName);
		
		textFieldPlayerName.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		    	char c = evt.getKeyChar();
		    	
		    	if(!Character.isLetter(c) && !Character.isWhitespace(c) && c != KeyEvent.VK_DELETE)
		    	{
		    		evt.consume();
		    	}
		    	else if ((textFieldPlayerName.getText() + evt.getKeyChar()).length() > 20) {
		            evt.consume();
		        }
		     }
		});
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(541, 412, 100, 60);
		panelMenuOpeningNewGame.add(buttonCancel);
		
		//Add Action Listener
		ActionListener actionCancel = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				labelError.setText("");
				textFieldPlayerName.setText("");
				
				panelMenuOpening.removeAll();
				panelMenuOpening.add(panelMenuOpeningOptions);
				panelMenuOpening.repaint();
				panelMenuOpening.revalidate();
			}
		};
		
		buttonCancel.addActionListener(actionCancel);
		
		JButton buttonNext = new JButton("Next");
		buttonNext.setBounds(741, 412, 100, 60);
		panelMenuOpeningNewGame.add(buttonNext);
		
		//Add Action Listener
		ActionListener actionNext = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String playerName = textFieldPlayerName.getText();
				
				if(playerName.length() < 3)
				{
					labelError.setText("Character's name must be over 3 characters");
					return;
				}
				
				Item basicSword = new Item("Basic Sword of the Basics", "Common", "Weapon", 0, 20, 0);
				Item basicStaff = new Item("Basic Staff of the Tests", "Common", "Weapon", 0, 30, 0);
				player = new Player(playerName, 20, 10, 0, basicSword);
				player.placeItemInInvetory(basicStaff);
				
				System.out.println(player.getNome());
				
				if(SaveSystem.checkSavedGame(player))
				{
					labelError.setText("A Character with the same name already exists");
					return;
				}
				
				panelOverall.removeAll();
				panelOverall.add(panelMenuMain);
				setPlayerInformation();
				refreshPanelOverall();
				
				currentGameState = GameState.MainMenu;
			}
		};
		
		buttonNext.addActionListener(actionNext);
		
		refreshPanelOverall();
	}
	
	private static void initializeMenuMain()
	{
		//Initialize JPanel Menu Main
		panelMenuMain = new JPanel();
		panelMenuMain.setBounds(0, 0, 1382, 784);
		panelMenuMain.setOpaque(false);
		panelMenuMain.setLayout(null);
		
		//Initialize JPanel Player Info
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBounds(0, 0, 630, 180);
		panelPlayer.setBackground(new Color(184, 170, 167));
		panelPlayer.setLayout(null);
		panelPlayer.setVisible(true);		
		panelMenuMain.add(panelPlayer);

		//Initialize JLabel Player Name
		labelPlayerName = new JLabel();
		labelPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerName.setBounds(0, 0, 630, 80);
		labelPlayerName.setBackground(new Color(90, 100, 0));
		labelPlayerName.setOpaque(true);
		panelPlayer.add(labelPlayerName);

		//Initialize JPanel Player Health
		JPanel panelPlayerHealth = new JPanel();
		panelPlayerHealth.setBounds(0, 80, 210, 100);
		panelPlayerHealth.setBackground(new Color(255, 0, 0));
		panelPlayerHealth.setLayout(null);
		panelPlayerHealth.setVisible(true);		
		panelPlayer.add(panelPlayerHealth);
		
		//Initialize JLabel Player Health
		JLabel labelHealth = new JLabel("Health Points");
		labelHealth.setHorizontalAlignment(SwingConstants.CENTER);
		labelHealth.setBounds(0, 0, 100, 100);
		labelHealth.setBackground(new Color(20, 30, 0));
		labelHealth.setOpaque(true);
		panelPlayerHealth.add(labelHealth);
		
		//Initialize JLabel Player Base Health
		labelPlayerBaseHealth = new JLabel();
		labelPlayerBaseHealth.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerBaseHealth.setBounds(100, 0, 50, 100);
		labelPlayerBaseHealth.setBackground(new Color(0, 90, 10));
		labelPlayerBaseHealth.setOpaque(true);
		panelPlayerHealth.add(labelPlayerBaseHealth);
		
		//Initialize JLabel Player Modified Health
		labelPlayerModifiedHealth = new JLabel();
		labelPlayerModifiedHealth.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerModifiedHealth.setBounds(150, 0, 60, 100);
		labelPlayerModifiedHealth.setBackground(new Color(0, 90, 90));
		labelPlayerModifiedHealth.setOpaque(true);
		panelPlayerHealth.add(labelPlayerModifiedHealth);
		
		//Initialize JPanel Player Attack
		JPanel panelPlayerAttack = new JPanel();
		panelPlayerAttack.setBounds(210, 80, 210, 100);
		panelPlayerAttack.setBackground(new Color(0, 255, 0));
		panelPlayerAttack.setLayout(null);
		panelPlayerAttack.setVisible(true);		
		panelPlayer.add(panelPlayerAttack);
		
		//Initialize JLabel Player Attack
		JLabel labelAttack = new JLabel("Attack Points");
		labelAttack.setHorizontalAlignment(SwingConstants.CENTER);
		labelAttack.setBounds(0, 0, 100, 100);
		labelAttack.setBackground(new Color(20, 30, 0));
		labelAttack.setOpaque(true);
		panelPlayerAttack.add(labelAttack);
		
		//Initialize JLabel Player Base Attack
		labelPlayerBaseAttack = new JLabel();
		labelPlayerBaseAttack.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerBaseAttack.setBounds(100, 0, 50, 100);
		labelPlayerBaseAttack.setBackground(new Color(0, 90, 10));
		labelPlayerBaseAttack.setOpaque(true);
		panelPlayerAttack.add(labelPlayerBaseAttack);
		
		//Initialize JLabel Player Base Attack
		labelPlayerModifiedAttack = new JLabel();
		labelPlayerModifiedAttack.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerModifiedAttack.setBounds(150, 0, 60, 100);
		labelPlayerModifiedAttack.setBackground(new Color(0, 90, 90));
		labelPlayerModifiedAttack.setOpaque(true);
		panelPlayerAttack.add(labelPlayerModifiedAttack);
		
		//Initialize JPanel Player Defense
		JPanel panelPlayerDefense = new JPanel();
		panelPlayerDefense.setBounds(420, 80, 210, 100);
		panelPlayerDefense.setBackground(new Color(0, 255, 0));
		panelPlayerDefense.setLayout(null);
		panelPlayerDefense.setVisible(true);		
		panelPlayer.add(panelPlayerDefense);
		
		//Initialize JLabel Player Defense
		JLabel labelDefense = new JLabel("Defense Points");
		labelDefense.setHorizontalAlignment(SwingConstants.CENTER);
		labelDefense.setBounds(0, 0, 100, 100);
		labelDefense.setBackground(new Color(20, 30, 0));
		labelDefense.setOpaque(true);
		panelPlayerDefense.add(labelDefense);
		
		//Initialize JLabel Player Base Defense
		labelPlayerBaseDefense = new JLabel();
		labelPlayerBaseDefense.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerBaseDefense.setBounds(100, 0, 50, 100);
		labelPlayerBaseDefense.setBackground(new Color(0, 90, 10));
		labelPlayerBaseDefense.setOpaque(true);
		panelPlayerDefense.add(labelPlayerBaseDefense);
		
		//Initialize JLabel Player Modified Defense
		labelPlayerModifiedDefense = new JLabel();
		labelPlayerModifiedDefense.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerModifiedDefense.setBounds(150, 0, 60, 100);
		labelPlayerModifiedDefense.setBackground(new Color(0, 90, 90));
		labelPlayerModifiedDefense.setOpaque(true);
		panelPlayerDefense.add(labelPlayerModifiedDefense);
		
		//Initialize JButton Adventure
		JButton buttonAdventure = new JButton("Adventure");
		buttonAdventure.setBounds(752, 80, 550, 100);
		panelMenuMain.add(buttonAdventure);
		
		//Add Action Listener
		ActionListener actionAdventure = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				goToAdventure();
				panelOverall.removeAll();
				panelOverall.add(panelMenuAdventure);
				refreshPanelOverall();
			}
		};
		
		buttonAdventure.addActionListener(actionAdventure);
		
		//Initialize JButton Armory
		JButton buttonArmory = new JButton("Armory");
		buttonArmory.setBounds(752, 200, 550, 100);
		panelMenuMain.add(buttonArmory);
		
		//Add Action Listener
		ActionListener actionArmory = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelOverall.removeAll();
				panelOverall.add(panelMenuArmory);
				refreshPanelOverall();
			}
		};
		
		buttonArmory.addActionListener(actionArmory);
		
		//Initialize JButton Save Game
		JButton buttonSaveGame = new JButton("Save Game");
		buttonSaveGame.setBounds(752, 320, 550, 100);
		panelMenuMain.add(buttonSaveGame);
		
		//Add Action Listener
		ActionListener actionSaveGame = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		};
		
		buttonSaveGame.addActionListener(actionSaveGame);
		
		//Initialize JButton Exit
		JButton buttonExit = new JButton("Exit");
		buttonExit.setBounds(752, 440, 550, 100);
		panelMenuMain.add(buttonExit);
		
		//Add Action Listener
		ActionListener actionExit = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		};
		
		buttonExit.addActionListener(actionExit);
	}
			
	private static void initializeMenuArmory()
	{
		//Initialize JPanel Menu Armory
		panelMenuArmory = new JPanel();
		panelMenuArmory.setBounds(0, 0, 1382, 784);
		panelMenuArmory.setOpaque(false);
		panelMenuArmory.setLayout(null);
		
		//Image Related Variables
		float scaleDimension = 1.5f;
		int[] imageScaleDimension = new int[] {(int) Math.floor(148 * scaleDimension), (int) Math.floor(339 * scaleDimension)};
		
		//Load Image
		ImageIcon icon = new ImageIcon("Silhouette.png");
		Image image = icon.getImage();
		Image imageScaled = image.getScaledInstance(imageScaleDimension[0], imageScaleDimension[1], Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		
		//JLabel Image Presentation
		JLabel labelPlayerSilhouette = new JLabel(imageIcon);
		labelPlayerSilhouette.setBounds(-30, 0, 600, 640);
		panelMenuArmory.add(labelPlayerSilhouette);
		
		//Initialize JButton Helmet Item
		JButton buttonHelmet = new JButton();
		buttonHelmet.setBounds(220, 60, 80, 80);
		panelMenuArmory.add(buttonHelmet);
		
		//Initialize JButton Armor Item
		JButton buttonArmor = new JButton();
		buttonArmor.setBounds(205, 150, 110, 140);
		panelMenuArmory.add(buttonArmor);
		
		//Initialize JButton Pants Item
		JButton buttonPants = new JButton();
		buttonPants.setBounds(200, 300, 120, 200);
		panelMenuArmory.add(buttonPants);
		
		//Initialize JButton Gloves Left Item
		JButton buttonGlovesLeft = new JButton();
		buttonGlovesLeft.setBounds(150, 290, 40, 60);
		panelMenuArmory.add(buttonGlovesLeft);
		
		//Initialize JButton Gloves Right Item
		JButton buttonGlovesRight = new JButton();
		buttonGlovesRight.setBounds(340, 290, 50, 80);
		panelMenuArmory.add(buttonGlovesRight);
		
		//Initialize JButton Boots Item
		JButton buttonBoots = new JButton();
		buttonBoots.setBounds(200, 510, 120, 70);
		panelMenuArmory.add(buttonBoots);
		
		//Panel for Inventory Displayer
		JPanel panelInventory = new JPanel();
		panelInventory.setBounds(730, 20, 600, 560);
		panelInventory.setBackground(Color.black);
		panelMenuArmory.add(panelInventory);
		
		//Initialize JButton Back
		JButton buttonBack = new JButton("Back");
		buttonBack.setBounds(100, 640, 300, 80);
		panelMenuArmory.add(buttonBack);
		
		//Add Action Listener
		ActionListener actionBack = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelOverall.removeAll();
				panelOverall.add(panelMenuMain);
				refreshPanelOverall();
			}
		};
		
		buttonBack.addActionListener(actionBack);
		
		//Initialize JButton Adventure
		JButton buttonAdventure = new JButton("Adventure");
		buttonAdventure.setBounds(982, 640, 300, 80);
		panelMenuArmory.add(buttonAdventure);
		
		//Add Action Listener
		ActionListener actionAdventure = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				goToAdventure();
				panelOverall.removeAll();
				panelOverall.add(panelMenuAdventure);
				refreshPanelOverall();
			}
		};
		
		buttonAdventure.addActionListener(actionAdventure);

		panelMenuArmory.setComponentZOrder(labelPlayerSilhouette, 9);
	}
	
	private static void initializeMenuAdventure()
	{
		//Initialize JPanel Menu Adventure
		panelMenuAdventure = new JPanel();
		panelMenuAdventure.setBounds(0, 0, 1382, 784);
		panelMenuAdventure.setOpaque(false);
		panelMenuAdventure.setLayout(null);
	
		//JPanel Enemy Info
		JPanel panelEnemyInfo = new JPanel();
		panelEnemyInfo.setBounds(920, 0, 462, 100);
		panelEnemyInfo.setBackground(Color.red);
		panelEnemyInfo.setLayout(null);
		panelMenuAdventure.add(panelEnemyInfo);
		
		//Instantiate JLabel Enemy Name
		labelEnemyName = new JLabel();
		labelEnemyName.setBounds(0, 0, 462, 50);
		labelEnemyName.setBackground(Color.blue);
		labelEnemyName.setOpaque(true);
		panelEnemyInfo.add(labelEnemyName);
		
		//Instantiate JLabel Enemy Health Text
		JLabel labelEnemyHealthText = new JLabel("HP");
		labelEnemyHealthText.setBounds(0, 50, 231, 50);
		labelEnemyHealthText.setBackground(Color.green);
		labelEnemyHealthText.setOpaque(true);
		panelEnemyInfo.add(labelEnemyHealthText);
				
		//Instantiate JLabel Enemy Health
		labelEnemyHealth = new JLabel();
		labelEnemyHealth.setBounds(231, 50, 231, 50);
		labelEnemyHealth.setBackground(Color.yellow);
		labelEnemyHealth.setOpaque(true);
		panelEnemyInfo.add(labelEnemyHealth);
		
		//Instantiate JPanel Player Info
		JPanel panelPlayerInfo = new JPanel();
		panelPlayerInfo.setBounds(0, 645, 1382, 100);
		panelPlayerInfo.setBackground(Color.black);
		panelPlayerInfo.setLayout(null);
		panelMenuAdventure.add(panelPlayerInfo);

		//Instantiate JLabel Player Name Adventure
		labelPlayerNameAdventure = new JLabel();
		labelPlayerNameAdventure.setBounds(0, 0, 691, 50);
		labelPlayerNameAdventure.setBackground(Color.green);
		labelPlayerNameAdventure.setOpaque(true);
		panelPlayerInfo.add(labelPlayerNameAdventure);
		
		//Instantiate JLabel Player Health
		JLabel labelPlayerHealth = new JLabel("HP");
		labelPlayerHealth.setBounds(0, 50, 115, 50);
		labelPlayerHealth.setBackground(new Color(112, 0, 200));
		labelPlayerHealth.setOpaque(true);
		panelPlayerInfo.add(labelPlayerHealth);
		
		//Instantiate JLabel Player Modified Health Adventure
		labelPlayerModifiedHealthAdventure = new JLabel();
		labelPlayerModifiedHealthAdventure.setBounds(115, 50, 115, 50);
		labelPlayerModifiedHealthAdventure.setBackground(Color.green);
		labelPlayerModifiedHealthAdventure.setOpaque(true);
		panelPlayerInfo.add(labelPlayerModifiedHealthAdventure);
		
		//Instantiate JLabel Player Attack
		JLabel labelPlayerAttack = new JLabel("ATK");
		labelPlayerAttack.setBounds(230, 50, 115, 50);
		labelPlayerAttack.setBackground(new Color(112, 0, 200));
		labelPlayerAttack.setOpaque(true);
		panelPlayerInfo.add(labelPlayerAttack);
		
		//Instantiate JLabel Player Modified Attack Adventure
		labelPlayerModifiedAttackAdventure = new JLabel();
		labelPlayerModifiedAttackAdventure.setBounds(345, 50, 115, 50);
		labelPlayerModifiedAttackAdventure.setBackground(new Color(255, 114, 0));
		labelPlayerModifiedAttackAdventure.setOpaque(true);
		panelPlayerInfo.add(labelPlayerModifiedAttackAdventure);
		
		//Instantiate JLabel Player Defense
		JLabel labelPlayerDefense = new JLabel("DEF");
		labelPlayerDefense.setBounds(460, 50, 115, 50);
		labelPlayerDefense.setBackground(new Color(112, 0, 200));
		labelPlayerDefense.setOpaque(true);
		panelPlayerInfo.add(labelPlayerDefense);
		
		//Instantiate JLabel Player Modified Defense Adventure
		labelPlayerModifiedDefenseAdventure = new JLabel();
		labelPlayerModifiedDefenseAdventure.setBounds(575, 50, 116, 50);
		labelPlayerModifiedDefenseAdventure.setBackground(new Color(255, 114, 0));
		labelPlayerModifiedDefenseAdventure.setOpaque(true);
		panelPlayerInfo.add(labelPlayerModifiedDefenseAdventure);
		
		//Instantiate JButton Attack
		JButton buttonAttack = new JButton("Attack");
		buttonAttack.setBounds(691, 0, 691, 100);
		panelPlayerInfo.add(buttonAttack);
		
		//Instantiate JButton Attack
		JButton buttonNext = new JButton("Next");
		buttonNext.setBounds(691, 0, 691, 100);
		panelPlayerInfo.add(buttonNext);
		
		//Add Action Listener
		ActionListener actionAttack= new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{				
				playerAttack();
				
				if(enemy.getCurrentHealth() > 0)
				{
					enemyAttack();

					if(player.getCurrentHealth() <= 0)
					{
						buttonNext.setVisible(true);
						panelPlayerInfo.setComponentZOrder(buttonNext, 0);
						
						buttonAttack.setVisible(false);
						panelPlayerInfo.setComponentZOrder(buttonNext, 5);
					}
				}
				else
				{
					if(player.getNumInventoryItems() < player.getInventoryItems().length)
					{
						Item wonItem = itemGenerator.generateItem();
						player.placeItemInInvetory(wonItem);
						
						buttonNext.setVisible(true);
						panelPlayerInfo.setComponentZOrder(buttonNext, 0);
						
						buttonAttack.setVisible(false);
						panelPlayerInfo.setComponentZOrder(buttonNext, 5);
					}
					else
					{
						panelOverall.removeAll();
						panelOverall.add(panelMenuMain);
						refreshPanelOverall();
					}
				}
				

				updateBattleInformation();
			}
		};
		
		buttonAttack.addActionListener(actionAttack);
		
		
		//Add Action Listener
		ActionListener actionNext = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{			
				buttonNext.setVisible(false);
				panelPlayerInfo.setComponentZOrder(buttonNext, 5);
				
				buttonAttack.setVisible(true);
				panelPlayerInfo.setComponentZOrder(buttonNext, 0);
				
				if(playerHealth <= 0)
				{
					panelOverall.removeAll();
					panelOverall.add(panelMenuMain);
					refreshPanelOverall();
					
					player.printInventoryItems();
				}
				else
				{
					startNextLevel();
				}
				
			}
		};
		
		buttonNext.addActionListener(actionNext);
		
		buttonNext.setVisible(false);
		panelPlayerInfo.setComponentZOrder(buttonNext, 5);
	}

	private static void setPlayerInformation()
	{
		labelPlayerName.setText(player.getNome());
		labelPlayerBaseHealth.setText(Integer.toString(player.getHealthPoints() + player.getModifiedStats()[0]));
		labelPlayerModifiedHealth.setText("+(" + Integer.toString(player.getModifiedStats()[0]) + ")");
		labelPlayerBaseAttack.setText(Integer.toString(player.getAttackPoints() + player.getModifiedStats()[1]));
		labelPlayerModifiedAttack.setText("+(" + Integer.toString(player.getModifiedStats()[1]) + ")");
		labelPlayerBaseDefense.setText(Integer.toString(player.getDefensePoints() + player.getModifiedStats()[2]));
		labelPlayerModifiedDefense.setText("+(" + Integer.toString(player.getModifiedStats()[2]) + ")");
		
		labelPlayerNameAdventure.setText(player.getNome());
		labelPlayerModifiedHealthAdventure.setText(Integer.toString(player.getCurrentHealth()));
		labelPlayerModifiedAttackAdventure.setText(Integer.toString(player.getAttackPoints() + player.getModifiedStats()[1]));
		labelPlayerModifiedDefenseAdventure.setText(Integer.toString(player.getDefensePoints() + player.getModifiedStats()[2]));
	}
	
	private static void setEnemyInformation()
	{
		labelEnemyName.setText(enemy.getNome());
		labelEnemyHealth.setText(Integer.toString(enemy.getHealthPoints()));
	}
	
	private static void refreshPanelOverall()
	{
		panelOverall.repaint();
		panelOverall.revalidate();
	}
	
	private static void goToAdventure()
	{
		adventureLevel = 1;
		enemy = enemyGenerator.generateEnemy(adventureLevel);
		setEnemyInformation();
		
		player.setCurrentHealth(player.getHealthPoints() + player.getModifiedStats()[0]);
		enemy.setCurrentHealth(enemy.getHealthPoints());
		
		setStats();
		setPlayerInformation();
	}

	private static void setStats()
	{
		playerHealth = player.getCurrentHealth();
		playerAttack = player.getAttackPoints() + player.getModifiedStats()[1];
		playerDefense = player.getDefensePoints() + player.getModifiedStats()[2];
		
		enemyHealth = enemy.getCurrentHealth();
		enemyAttack = enemy.getAttackPoints();
		enemyDefense = enemy.getDefensePoints();
	}
	
	private static void playerAttack()
	{
		System.out.println("Player Attack: " + playerAttack + " | " + enemyDefense + " = " + (playerAttack-enemyDefense));
		
		if(playerAttack - enemyDefense > 0)
		{
			enemy.setCurrentHealth(enemyHealth - (playerAttack - enemyDefense));
		}
		
		enemyHealth = enemy.getCurrentHealth();
		System.out.println("Enemy Health: " + enemyHealth);
		
	}
	
	private static void enemyAttack()
	{
		System.out.println("Enemy Attack: " + enemyAttack + " | " + playerDefense + " = " + (enemyAttack-playerDefense));
		
		if(enemyAttack - playerDefense > 0)
		{
			player.setCurrentHealth(playerHealth - (enemyAttack - playerDefense));
			System.out.println("Entrou");
		}
		
		playerHealth = player.getCurrentHealth();
		System.out.println("Player Health: " + playerHealth);
	}
	
	private static void startNextLevel()
	{
		adventureLevel++;
		
		enemy = enemyGenerator.generateEnemy(adventureLevel);
		enemy.setCurrentHealth(enemy.getHealthPoints());		
		
		setStats();
		setPlayerInformation();
		setEnemyInformation();
	}
	
	private static void updateBattleInformation()
	{
		labelPlayerModifiedHealthAdventure.setText(Integer.toString(playerHealth));
		labelEnemyHealth.setText(Integer.toString(enemyHealth));
	}
}