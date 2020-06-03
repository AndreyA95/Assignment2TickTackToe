package TickTackToeClasses;

public class Grid {
	
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	
	
	Box[][] board;		//represents the game board as a grid

	int currentRow;		//row that was played last
	int currentCol;		//column that was played last
	
	public Grid() {
		//TODO: initialize the board array using ROWS and COLUMNS
		board = new Box[3][3];/*/*/
		
		for (int row=0; row <ROWS; ++row) {
			for(int col =0; col < COLUMNS; ++col) {
				board[row][col] = new Box(row,col);
			}
		}
	}
	
	/**
	 * Checks if the game has ended in a draw
	 * One way to do this is check that htere are no empty positons left
	 */
	public boolean isDraw(Player player) {
		if (hasWon (player) == false){
		}
		return true;
		//TODO: Check whether the game has ended in a draw
		//Hint: Use a nested loop
		//Hint: Reutnr false if it is not adraw, return true if there are no \t emptyu positions
	}

	public boolean hasWon(Player player) {
		//column check
		if (board[0][currentCol].content ==player && board [1][currentCol].content == player&&board[2][currentCol].content == player) {
			return true;
		}
		//TODO: Check if the curentCol is filled.
		//Hint: Use the row code above as a starting point,remember that it goes board[row][colmn].
		//Row check for win
		if (board[currentRow][0].content ==player && board [currentRow][1].content == player&&board[currentRow][2].content == player) {
			return true;
		}
		//Diagonal check(check both directions)
		if (board[0][0].content ==player && board [1][1].content == player&&board[2][2].content == player) {
			return true;
		} //opposite diagonal direction check
		if (board[2][0].content ==player && board [1][1].content == player&&board[0][2].content == player) {
			return true;
		}
		//TODO: Check the diagonal in the other direction
		
		// no one has won
		else {
			return false;
		}
	}
	//Draw tic tac toe board to screen
	public void display() {
		for (int row=0; row < ROWS; ++row) {
			for(int col= 0; col < COLUMNS; ++col) {
				//Draw the content of the box
				board[row][col].display();
				
				if (col< COLUMNS -1) System.out.print("|"); //prints vertical line
			}
			System.out.println();
			if (row<ROWS -1) {
				System.out.println("------------"); //Draws horizontal line
			}
		}
	}
}
