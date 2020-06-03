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
		//grid = new Grid();			//Create a new instance of the Grid class and required methods
		grid = new Grid(); //ERROR?	
		gameOver = false;			//Reset the game variables to their default				
		winner = null;		
		currentPlayer = Player.X;	//Assign the default values for currentPlayer (player.X)		
		play();						//Begin playing the game
		
	}
	
	public void play() { //controls game and rotates players
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
				else {
					System.out.println("Match is a draw");
				}
			}
			
			//switch turn to next player
			if(currentPlayer == Player.X) {
				currentPlayer = Player.O;
			}else {
				currentPlayer = Player.X;
			}
		} while (!gameOver); //repeat until game over
	}
	
	public void playerMove(Player turnPlayer) {//Handles the player making moves
		boolean validInput=false;
		
		do {
			
			if(turnPlayer == Player.X) {//gives instructions to user
				System.out.print("Player 'X', enter your move (row [1-3] column [1-3]): ");
				}else if (turnPlayer == Player.O){
					System.out.print("Player 'O', enter your move (row [1-3] column [1-3]): ");
				}
			//fetch information typed in by player for symbol placement
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			
			//decrease the value entered by 1 to make up for array index stating at 0
			row--;
			col--;
			
			if (row>= 0 && row<Grid.ROWS && col < Grid.COLUMNS &&grid.board[row][col].content ==Player.Empty) {
				grid.board[row][col].content=turnPlayer;
				grid.currentRow=row;
				grid.currentCol=col;
				validInput = true;
			} else {
				
				System.out.println("Invalid entry. Please try again...");
			}
		} while (!validInput);
	}
	//check if the game has ended
	public void checkForWinner(Player turnPlayer) { // method to check if the game has ended
		if(grid.hasWon(turnPlayer)) {
			gameOver = true;
			winner=currentPlayer;
			System.out.println("Congratulations " + winner + ". You are the winner!");
			
		} else if(grid.isDraw()) {/*Could be incorrect!!!!!!*/
			gameOver = true;
			System.out.println("The game is a draw.");
			//TODO: Set gameOver and winner appropriately
		}
	}

	public static void main(String[] args) {
		char ans;
		Scanner playAgain = new Scanner(System.in);
		while (true) {
			new GameMain();
			System.out.println("Play again? Press Y to play again or N to exit");
			ans = playAgain.next().charAt(0);
			if (ans == 'Y'||ans == 'y') {
				continue;
			}
			else if (ans == 'N'||ans == 'n') {
				System.out.println("You have successfully exited the program.");
				System.exit(0);
				break;
			}
		}
	}
}