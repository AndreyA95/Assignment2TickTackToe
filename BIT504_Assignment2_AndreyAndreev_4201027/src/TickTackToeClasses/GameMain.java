package TickTackToeClasses;
import java.util.Scanner;

public class GameMain {
	private static Scanner scanner = new Scanner(System.in);
	
	private Grid grid;  
	private boolean gameOver;
	private Player winner;
	private Player currentPlayer;
	
	public GameMain() {
		//Game constructor
		//Create the grid
		
		//Create a new instance of the Grid class and required methods
		grid = new Grid();
		//Reset the game variables to their default
		gameOver = false;
		//Assign the default values for currentPlayer (player.X)		
		winner = null;
		//Begin playing the game
		currentPlayer = Player.X;
		
		//Call the "play()" method/*/*/*/*/*/*
		
	}
	
	public void play() {
		do {
			playerMove(currentPlayer);		//HAve the player perform their move
			grid.display();					//Display the current game board
			checkForWinner(currentPlayer);	//checks if the game has been won
			
			//Displays results
			if(gameOver) {
				if(winner == Player.X) {
					System.out.println("Player X wins!");
				}
				if(winner == Player.O) {
					System.out.println("Player O wins!");
				}
			}
			
			//switch turn to next player
			if(currentPlayer == Player.X) {
				currentPlayer = Player.O;
			}else {
				currentPlayer = Player.X;
			}
		} while (!gameOver);
	}
	
	public void playerMove(Player turnPlayer) {
		boolean validInput=false;
		
		do {
			
			if(turnPlayer == Player.X) {
				System.out.print("Player 'X', enter you move (row [1-3] column [1-3]): ");
				}else {
					//TODO: Inform Player O to enter parameters
				}
			//fetch information typed in by player for symbol placement
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			
			row--;
			col--;
			
			if (row>= 0 && row<Grid.ROWS && col < Grid.COLUMNS &&grid.board[row][col].content ==Player) {
				grid.board[row][col].content=turnPlayer;
				grid.currentRow=row;
				grid.currentCol=col;
				validInput = true;
			} else {
				//TODO: Display an error message that the move is invalid.
			}
		} while (!validInput);
	}
	
	public void checkForWinner(Player turnPlayer) { // method to check if the game has ended
		if(grid.hasWon(turnPlayer)) {
			//TODO: Set gameOver and winner appropriately
		} else if(grid.isDraw()) {
			//TODO: Set gameOver and winner appropriately
		}
	}

	public static void main(String[] args) { //main method
		// TODO Add a loop to restart the game once it has finished
		// TODO: Then update the loop, ask player of they wish to play again or not. If not exit program.
	boolean playAgain = true;
	do {
		new GameMain();
		String input = scanner.next();
		if(input == "N")/*condition to make playAgain = false to terminate the loop)*/ {
			playAgain=false;
			System.out.println("Thank you for playing.");
		}
		}
	while(playAgain);
	} 
}