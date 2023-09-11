import java.util.Scanner;

public class Jogo {

	
	String[][] board;
	private final int COLS_NUM = 8;
	private final int ROWS_NUM = 8;
	
	private boolean isGameRunning;
	private boolean isRedPlayerTurn;
	private Scanner scanner;
	
	public Jogo()
	{
		initializeBoard();
		displayBoard();
		
		isGameRunning = true;
		isRedPlayerTurn = true;
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
		
		System.out.println("-------------------");
		System.out.println("| 0 1 2 3 4 5 6 7 |");
		System.out.println("-------------------");
		System.out.println();
	}
	
	private void play()
	{
		while(isGameRunning)
		{
			boolean isValid = false;
			
			while(!isValid)
			{
				try
				{
					scanner = new Scanner(System.in);
					String simbolo = isRedPlayerTurn ? "V" : "A";
					
					System.out.println("Onde é que o jogador " + (isRedPlayerTurn ? "Vermelho" : "Azul") + " pretende jogar?");
					System.out.print("Coluna: ");
					int input = Integer.parseInt(scanner.nextLine());
					System.out.println(input + " | ");
					if(validateInput(input))
					{
						isValid = true;
						
						placeOnBoard(input, simbolo);
						displayBoard();
						isRedPlayerTurn = !isRedPlayerTurn;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Input inválido");
				}
			}
		}
		
		isRedPlayerTurn = !isRedPlayerTurn;
		
		System.out.println("O jogador " + (isRedPlayerTurn ? "Vermelho" : "Azul") + " venceu!");
	}
	
	private boolean validateInput(int col)
	{
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
	
	private void placeOnBoard(int col, String symbol)
	{
		for(int row = ROWS_NUM - 1; row >= 0; row--)
		{
			if(board[row][col].equals(""))
			{
				board[row][col] = symbol;
				checkVictory(row, col, symbol);
				break;
			}
		}
	}
	
	private void checkVictory(int row, int col, String symbol)
	{
		//Check by Cols:
		int fourInRow = 0;		
		for(int colCheck = 0; colCheck < COLS_NUM; colCheck++)
		{
			if(board[row][colCheck].equals(symbol))
			{
				fourInRow++;
				
				if(fourInRow == 4)
				{
					isGameRunning = false;
					return;
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
			if(board[rowCheck][col].equals(symbol))
			{
				fourInRow++;
				
				if(fourInRow == 4)
				{
					isGameRunning = false;
					return;
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
		int upperRowLeft = row;
		int upperColLeft = col;
		
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
					isGameRunning = false;
					return;
				}
			}
		}
		
		//Check Diagonal (Bottom Left to Top Right)
		fourInRow = 0;
		foundTheEdge = false;
		int bottomRowLeft = row;
		int bottomColLeft = col;
		
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
					isGameRunning = false;
					return;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Jogo jogo = new Jogo();
		jogo.play();
	}
}