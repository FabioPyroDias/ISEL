package exercicioAula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.util.Scanner;


public class QuatroEmLinha {
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Game());
	}
	
	static class Game implements Runnable {

	    private static void showboard(char[][] board) {
	    	
	    	System.out.println("+-------------+");
	    	
	    	for(int rows = 0; rows < board.length; rows++)
	    	{
	    		System.out.print("| ");
	    		
	    		for(int cols = 0; cols < board[rows].length; cols++)
	    		{
	    			if(board[rows][cols] == '\u0000')
	    			{
	    				System.out.print('0' + " ");
	    			}
	    			else
	    			{
	    				System.out.print(board[rows][cols] + " ");
	    			}
	    		}
	    		
	    		System.out.println("|");
	    	}
	    	
	    	System.out.println("+-------------+");
	    	System.out.println();
	    }

	    /**
	     * Puts one piece for the received player. First asks the user to choose one
	     * column, then validates it and repeat it until a valid column is chosen.
	     * Finally, puts the player character on top of selected column.
	     *
	     * @param player   The player: 'A' or 'B'. Put this character on the board
	     * @param board    The board
	     * @param keyboard The keyboard Scanner
	     * @return The column selected by the user.
	     */
	    private static int play(char player, char[][] board, Scanner keyboard) {
	    	
	    	boolean isExecuting = true;
	    	int number = -1;

	    	while(isExecuting)
	    	{
	    		boolean isString = false;
	    		
	    		System.out.print("Choose a column (Player " + player + "): ");
	    		String inputReceived = keyboard.next();

	    		try
	    		{
	    			number = Integer.parseInt(inputReceived);
	    		}
	    		catch (Exception e) {
					System.out.println("Invalid Input.");
					isString = true;
				}
	    		
	    		if(!isString)
	    		{
	    			if(number < 1 || number > 6)
	    		
	    			{
	    				System.out.println("Must be a number between 1 and " + board[0].length);
	    			}
	    			else
	    			{
	    				number -= 1;
	    				
	    				int index = board.length - 1;
	    				
	    				while(index >= 0)
	    				{
	    					if(board[index][number] == '\u0000')
	    					{
	    						board[index][number] = player;
	    						return number;
	    					}
	    					
	    					index--;
	    				}
	    				
	    				System.out.println("Column full.");
	    			}
	    		}
	    	
	    	}
	    	
	        return 0;
	    }

	    /**
	     * Checks if the player, with the character on top on the received column, won
	     * the game or not. It will get the top move on that column, and check if there
	     * are 4 pieces in a row, in relation to that piece and from the same player.
	     * Returns true is yes, false is not.
	     *
	     * @param board The board
	     * @param col   The last played column
	     * @return True is that player won the game, or false if not.
	     */
	    private static boolean lastPlayerWon(char[][] board, int col) {
	        char player = '0';    	
	    	int row = 0;
	    	
	    	for(int rows = 0; rows < board.length; rows++)
	    	{
	    		if(board[rows][col] != '\u0000') 
	    		{
	    			player = board[rows][col];
	    			row = rows;
	    			break;
	    		}
	    	}
	    	
	    	
	    	//Evaluate Row.
	    	int inARow = 0;
	    	int rowAux = row;
	    	
	    	while(rowAux < board.length)
	    	{
	    		//System.out.print("Row: " + rowAux);
	    		
	    		if(board[rowAux][col] == player)
	    		{
	    			inARow++;
	    			
	    			if(inARow > 3)
	    			{
	    				return true;
	    			}
	    		}
	    		else
	    		{
	    			inARow = 0;
	    		}
	    		
	    		//System.out.println(" | In A Row: " + inARow);
	    		rowAux++;
	    	}
	    	
	    	
	    	//Evaluate Col
	    	inARow = 0;
	    	int colAux = 0;
	    	    	
	    	while(colAux < board[row].length)
	    	{
	    		//System.out.print("Col: " + colAux);
	    		
	    		if(board[row][colAux] == player)
	    		{
	    			inARow++;
	    			
	    			if(inARow > 3)
	    			{
	    				return true;
	    			}
	    		}
	    		else
	    		{
	    			inARow = 0;
	    		}
	    		
	    		//System.out.println(" | In A Row: " + inARow);
	    		colAux++;
	    	}
	    	
	    	
	    	//Evaluate Diagonal - Top Left to Bottom Right
	    	inARow = 0;
	    	rowAux = row;
	    	colAux = col;
	    	
	    	//System.out.println("--- Diagonal Top Left to Bottom Right ---");
	    	
	    	//System.out.println("Initial Row: " + rowAux + " | Initial Col: " + colAux);
	    	
	    	//Find Diagonal Beginning
	    	while(rowAux > 0 && colAux > 0)
	    	{
	    		rowAux--;
	    		colAux--;
	    	}
	    	
	    	//System.out.println("Final Row: " + rowAux + " | Final Col: " + colAux);
	    	
	    	//Check Diagonal
	    	while(rowAux < board.length - 1 && colAux < board[rowAux].length - 1)
	    	{
	    		//System.out.print("Diagonal - Row: " + rowAux + " | Col: " + colAux);
	    		
	    		if(board[rowAux][colAux] == player)
	    		{
	    			inARow++;
	    			
	    			if(inARow > 3)
	    			{
	    				return true;
	    			}
	    		}
	    		else
	    		{
	    			inARow = 0;
	    		}
	    		
	    		//System.out.println(" | In A Row: " + inARow);
	    		rowAux++;
	    		colAux++;
	    	}
	    	
	    	
	    	//Evaluate Diagonal - Top Right to Bottom Left
	    	inARow = 0;
	    	rowAux = row;
	    	colAux = col;
	    	
	    	//System.out.println("--- Diagonal Top Right to Bottom Left ---");
	    	
	    	//System.out.println("Initial Row: " + rowAux + " | Initial Col: " + colAux);
	    	
	    	//Find Diagonal Beginning
	    	while(rowAux < board.length - 1 && colAux < board[rowAux].length - 1)
	    	{
	    		rowAux++;
	    		colAux++;
	    	}
	    	
	    	//System.out.println("Final Row: " + rowAux + " | Final Col: " + colAux);
	    	
	    	//Check Diagonal
	    	while(rowAux > 0 && colAux > 0)
	    	{
	    		//System.out.print("Diagonal - Row: " + rowAux + " | Col: " + colAux);
	    		
	    		if(board[rowAux][colAux] == player)
	    		{
	    			inARow++;
	    			
	    			if(inARow > 3)
	    			{
	    				return true;
	    			}
	    		}
	    		else
	    		{
	    			inARow = 0;
	    		}
	    		
	    		//System.out.println(" | In A Row: " + inARow);
	    		rowAux--;
	    		colAux--;
	    	}
	    	
	        return false;
	    }

	    /**
	     * Check if there are at least one free position on board.
	     *
	     * @param board The board
	     * @return True if there is, at least, one free position on board
	     */
	    private static boolean existsFreePlaces(char[][] board) {
	        
	    	for(int rows = 0; rows < board.length; rows++)
	    	{
	    		for(int cols = 0; cols < board[rows].length; cols++)
	    		{
	    			if(board[rows][cols] == '\u0000')
	    			{
	    				return true;
	    			}
	    		}
	    	}
	    	
	        return false;
	    }

	    /**
	     * Main method - this method should not be changed
	     */
	    public static void main(String[] args) {
	        final int NCOLs = 7;
	        final int NROWS = 6;

	        // program variables
	        Scanner keyboard = new Scanner(System.in);
	        char[][] board = new char[NCOLs][NROWS];
	        char winner = ' ';

	        // show empty board
	        showboard(board);

	        // game cycle
	        do {
	            int col = play('A', board, keyboard);
	            showboard(board);
	            if (lastPlayerWon(board, col)) {
	                winner = 'A';
	                break;
	            }
	            if (!existsFreePlaces(board))
	                break;

	            col = play('B', board, keyboard);
	            showboard(board);
	            if (lastPlayerWon(board, col)) {
	                winner = 'B';
	                break;
	            }

	        } while (existsFreePlaces(board));

	        // show final result
	        switch (winner) {
	            case ' ':
	                System.out.println("We have a draw....");
	                break;
	            case 'A':
	                System.out.println("Winner: Player A. Congratulations...");
	                break;
	            case 'B':
	                System.out.println("Winner: Player B. Congratulations...");
	                break;
	        }

	        // close keyboard
	        keyboard.close();
	    }

		
		public void run() {
			GameUI();
		}
	}
	
	public static void GameUI() {
		
		int nRows = 7;
		int nCols = 7;
		
		// create a JFrame
		JFrame frame = new JFrame();

		// set title
		frame.setTitle("Quatro em Linha");

		// set size
		frame.setSize(1000, 700);
		
		// to center the frame
		frame.setLocationRelativeTo(null);
		
		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		
		BorderLayout bl = new BorderLayout(5, 2);
		// 5 is horizontalGap, 1 is verticalGap
		// colocar o BorderLayout no contentPane da frame
		frame.getContentPane().setLayout(bl);
		// frame.setLayout(bl);
	
		// criar uma JLabel dar-lhe cor e coloc�-la no topo da p�gina
		JLabel labelPlayerWon = new JLabel("Isto tem de ser fixo");
		labelPlayerWon.setOpaque(true);
		labelPlayerWon.setBorder(null);
		labelPlayerWon.setBackground(new Color(0, 0, 240));
		labelPlayerWon.setHorizontalAlignment(SwingConstants.CENTER);
		// das linhas seguintes s� activar uma, pois s�o equivalentes
		// frame.add(labelTop, BorderLayout.PAGE_START);
		frame.getContentPane().add(labelPlayerWon, BorderLayout.NORTH);

		// criar uma JLabel dar-lhe alguma cor e coloc�-la no centro
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(true);
		panelCenter.setBorder(null);
		panelCenter.setBackground(new Color(0, 0, 0));
		panelCenter.setToolTipText("    Label Center uuuu    ");
		// colocar esta label no centro
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);

		// criar uma JLabel dar-lhe cor e coloc�-la no topo da p�gina
		JPanel panelBottom = new JPanel();
		panelBottom.setOpaque(true);
		panelBottom.setBorder(null);
		panelBottom.setBackground(new Color(0, 0, 240));
		// das linhas seguintes s� activar uma, pois s�o equivalentes
		// frame.getContentPane().add(labelBottom, BorderLayout.PAGE_END);
		frame.getContentPane().add(panelBottom, BorderLayout.SOUTH);
		
		JPanel panelEast = new JPanel();
		panelEast.setBorder(null);
		panelEast.setBackground(new Color(0, 0, 240));
		panelEast.setMinimumSize(new Dimension(200, 0));
		
		JPanel panelWest = new JPanel();
		panelWest.setBorder(null);
		panelWest.setBackground(new Color(0, 0, 240));
		panelWest.setMinimumSize(new Dimension(200, 0));
		
		
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		frame.getContentPane().add(panelWest, BorderLayout.WEST);
		
		//Criação da Grid
		GridLayout gl = new GridLayout(nRows, nCols);
		panelCenter.setLayout(gl);
		JLabel[][] labels = new JLabel[nRows][nCols];
		for (int y = 0; y < nRows; ++y) {
			for (int x = 0; x < nCols; ++x) {
				JLabel label = labels[y][x] = new JLabel();
				label.setBorder(new LineBorder(Color.black, 1));
				label.setOpaque(true);
				label.setBackground(new Color(0, 0, 240));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panelCenter.add(label);
			}
		}

		// alterar a cor de fundo do contentPane
		frame.getContentPane().setBackground(new Color(0, 0, 240));
	}
}


