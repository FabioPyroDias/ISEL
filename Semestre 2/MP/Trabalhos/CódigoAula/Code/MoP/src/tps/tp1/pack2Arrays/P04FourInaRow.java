package tps.tp1.pack2Arrays;

import java.util.Scanner;

public class P04FourInaRow {

	/**
	 * Shows (prints) the board on the console
	 * 
	 * @param board
	 *            The board
	 */
	private static void showboard(char[][] board) {
		// TODO Auto-generated method stub
	}

	/**
	 * Puts one piece for the received player. First asks the user to choose one
	 * column, then validates it and repeat it until a valid column is chosen.
	 * Finally, puts the player character on top of selected column.
	 * 
	 * @param player
	 *            The player: 'A' or 'B'. Put this character on the board
	 * @param board
	 *            The board
	 * @param keyboard
	 *            The keyboard Scanner
	 * @return The column selected by the user.
	 */
	private static int play(char player, char[][] board, Scanner keyboard) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Checks if the player, with the character on top on the received column, won
	 * the game or not. It will get the top move on that column, and check if there
	 * are 4 pieces in a row, in relation to that piece and from the same player.
	 * Returns true is yes, false is not.
	 * 
	 * @param board
	 *            The board
	 * @param col
	 *            The last played column
	 * @return True is that player won the game, or false if not.
	 */
	private static boolean lastPlayerWon(char[][] board, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Check if there are at least one free position on board.
	 * 
	 * @param board
	 *            The board
	 * @return True if there is, at least, one free position on board
	 */
	private static boolean existsFreePlaces(char[][] board) {
		// TODO Auto-generated method stub
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
