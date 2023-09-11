package tp1.pack1Revisoes;

import java.util.Scanner;

public class P02FourInaRow {

    /**
     * Shows (prints) the board on the console
     *
     * @param board The board
     */
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
}
