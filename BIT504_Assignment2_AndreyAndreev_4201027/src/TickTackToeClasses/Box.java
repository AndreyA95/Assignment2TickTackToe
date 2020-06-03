package TickTackToeClasses;

public class Box {
	
	Player content; //The move this box holds(Empty, x or o)
	int row, col; 	//row and column of this box
	
	//Constructor
	
	public Box(int row, int col) {
		this.row = row;
		this.col = col;
		this.content = Player.Empty;
	}
	
	public void clear() {
		content = Player.Empty;
	}


	public void display() {
		//TODO: Print X and O for players
		//can use an if-else or switch statement
		switch(content) {
		case X:{
			System.out.print(" X ");
			break;
		}
		case O:{
			System.out.print(" O ");
			break;
		}
		case Empty:{
			System.out.print("   ");
			break;
		}
		}
	}
}
