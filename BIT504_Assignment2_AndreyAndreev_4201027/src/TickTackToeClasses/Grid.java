package TickTackToeClasses;

public class Grid {
	
	int ROWS = 3;
	int COLUMNS = 3;
	
	
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
	public boolean isDraw() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

}
