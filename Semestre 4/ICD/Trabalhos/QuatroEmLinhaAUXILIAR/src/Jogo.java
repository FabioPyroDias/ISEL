import java.util.Scanner;

public class Jogo {

	private final int COLS_NUM = 8;
	private final int ROWS_NUM = 8;
	String[][] board;

	private String player1;
	private String player2;
	
	private String symbolPlayer1;
	private String symbolPlayer2;
	
	private int lastRow;
	private int lastCol;
	
	private String currentPlayer;
	
	public Jogo(String player1, String player2)
	{	
		initializeBoard();
	
		this.player1 = player1;
		this.player2 = player2;
		
		symbolPlayer1 = "A";
		symbolPlayer2 = "B";
		
		currentPlayer = player1;
	}
	
	private void initializeBoard()
	{
		board = new String[ROWS_NUM][COLS_NUM];
		
		for(int row = 0; row < ROWS_NUM; row++)
		{
			for(int col = 0; col < COLS_NUM; col++)
			{
				board[row][col] = "";
			}	
		}
	}

	public boolean makePlay(String player, String column)
	{
		int col = Integer.parseInt(column);
		String currentSymbol = player.equals(player1) ? symbolPlayer1 : symbolPlayer2;
		
		if(validateInput(player, col))
		{
			lastRow = placeOnBoard(col, currentSymbol);
			lastCol = col;
			
			currentPlayer = (player == player1) ? player2 : player1;
			return true;
		}
		
		return false;
	}
	
	private boolean validateInput(String playerName, int col)
	{
		if(playerName != currentPlayer)
		{
			return false;
		}
		
		if(col < 0 || col >= COLS_NUM)
		{
			System.out.println("Input inválido");
			return false;
		}
		
		if(!board[0][col].equals(""))
		{
			System.out.println("Coluna totalmente preenchida");
			return false;
		}
		
		return true;
	}
	
	private int placeOnBoard(int col, String symbol)
	{
		for(int row = ROWS_NUM - 1; row >= 0; row--)
		{
			if(board[row][col].equals(""))
			{
				board[row][col] = symbol;
				return row;
			}
		}
		
		return -1;
	}
	
	public boolean checkVictory(String player)
	{
		String symbol = player.equals(player1) ? symbolPlayer1 : symbolPlayer2;
		
		displayBoard();
		
		//Check by Cols:
		int fourInRow = 0;		
		for(int colCheck = 0; colCheck < COLS_NUM; colCheck++)
		{
			if(board[lastRow][colCheck].equals(symbol))
			{
				fourInRow++;
				
				if(fourInRow == 4)
				{
					return true;
				}
			}
			else
			{
				fourInRow = 0;
			}
		}
		
		//Check by Rows:
		fourInRow = 0;		
		for(int rowCheck = 0; rowCheck < ROWS_NUM; rowCheck++)
		{
			if(board[rowCheck][lastCol].equals(symbol))
			{
				fourInRow++;
				
				if(fourInRow == 4)
				{
					return true;
				}
			}
			else
			{
				fourInRow = 0;
			}
		}
		
		//Check Diagonal (Upper Left to Bottom Right)
		fourInRow = 0;
		boolean foundTheEdge = false;
		int upperRowLeft = lastRow;
		int upperColLeft = lastCol;
		
		while(!foundTheEdge)
		{
			if(upperRowLeft - 1 < 0 || upperColLeft - 1 < 0)
			{
				foundTheEdge = true;
			}
			else
			{
				upperRowLeft--;
				upperColLeft--;
			}
		}
		
		int closestOppositeEdge = Math.min(ROWS_NUM - upperRowLeft, COLS_NUM - upperColLeft);
		
		for(int diagonalCheck = 0; diagonalCheck < closestOppositeEdge; diagonalCheck++)
		{
			if(board[upperRowLeft + diagonalCheck][upperColLeft + diagonalCheck].equals(symbol))
			{
				fourInRow++;
				
				if(fourInRow == 4)
				{
					return true;
				}
			}
		}
		
		//Check Diagonal (Bottom Left to Top Right)
		fourInRow = 0;
		foundTheEdge = false;
		int bottomRowLeft = lastRow;
		int bottomColLeft = lastCol;
		
		while(!foundTheEdge)
		{
			if(bottomRowLeft + 1 >= ROWS_NUM || bottomColLeft - 1 < 0)
			{
				foundTheEdge = true;
			}
			else
			{
				bottomRowLeft++;
				bottomColLeft--;
			}
		}
		
		closestOppositeEdge = Math.min(bottomRowLeft, COLS_NUM - bottomColLeft);
		
		for(int diagonalCheck = 0; diagonalCheck < closestOppositeEdge; diagonalCheck++)
		{
			if(board[bottomRowLeft - diagonalCheck][bottomColLeft + diagonalCheck].equals(symbol))
			{
				fourInRow++;
				
				if(fourInRow == 4)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkGameOver()
	{
		for(int row = 0; row < ROWS_NUM; row++)
		{
			for(int col = 0; col < COLS_NUM; col++)
			{
				if(board[row][col] == "")
				{
					return false;
				}
			}	
		}
		
		return true;
	}
	private void displayBoard()
	{
		System.out.println("-------------------");
		
		for(int row = 0; row < ROWS_NUM; row++)
		{
			System.out.print("| ");
			
			for(int col = 0; col < COLS_NUM; col++)
			{
				if(board[row][col].equals(""))
				{
					System.out.print("- ");
				}
				else
				{
					System.out.print(board[row][col] + " ");
				}
				
				if(col == COLS_NUM - 1)
				{
					System.out.println("|");					
				}
			}	
		}
	}
	
	public String[] getPlayers()
	{
		return new String[]{player1, player2};
	}
	
	public String[][] getBoard()
	{
		return board;
	}
}