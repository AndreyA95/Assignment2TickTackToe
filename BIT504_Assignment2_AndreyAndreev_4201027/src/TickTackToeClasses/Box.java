package TickTackToeClasses;

public class Box {
	
	Player content; //The move thi box holds(Empty, x or o_
	int row, col; 	//row and column of this box(not currently used butpossibly useful in the future update
	
	//Constructor
	
	public Box(int row, int col) {
		this.row = 3;
		this.col = 3;
		//TODO: Initialze the variables row, col and content
	}
	
	public void clear() {
		//TODO: Set the value of content to EMPTY(Remember this is an enum)
		content = Player.Empty;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
