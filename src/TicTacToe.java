
public class TicTacToe {

	
	
	private char[][] board;
	private char currentPlayer;

	
	public void createBoard() {
		board = new char[3][3];
		currentPlayer = 'X';
		initializeGame(); //creates null vallues
	}
	

	
	public void initializeGame(){ //separate from print board so I can reset values and keep the board
		for (int z=0;z<3;z++){ //columns
			for (int Z=0;Z<3;Z++){ // rows
				board[Z][z]='-'; //Null value
			}
		}
	}
	
	//GUI replaceable board
	public void GameBoard(){
		System.out.println("-------------------");
		for (int z=0;z<3;z++){ 
			for (int Z=0;Z<3;Z++){ 
				System.out.print(board[Z][z]+"|");
			}
			System.out.println("-------------");
		}
	}
	
	public boolean BoardFull() {
		boolean BFull = true;
		for (int z=0;z<3;z++){ 
			for (int Z=0;Z<3;Z++){ 
				if (board[Z][z] == '-'){
					BFull = false;
				}
			}
		}
		return BFull;
	}
	
	public boolean WinCondition() { //returns true if a win
		return (ColumnsWin()|| RowsWin()|| DiagonalsWin());
	}
	
	private boolean ColumnsWin() {
		for (int z = 0; z < 3; z++){
			if (ColRow(board[0][z], board[1][z], board[2][z])){
					return true;
		}
		}
			return false;
	
	}
	
	private boolean RowsWin() {
		for (int z = 0; z < 3; z++){
			if (ColRow(board[z][0], board[z][1], board[z][2])){
					return true;
		}
		}
			return false;
		
	}
	
	private boolean DiagonalsWin(){
		return ((ColRow(board[0][0], board[1][1], board[2][2]) == true) || (ColRow(board[0][2], board[1][1], board[2][0]) == true));
	}
	
	private boolean ColRow(char c1, char c2, char c3) {
		return ((c1 != '-')&&(c1 == c2)&&(c2 == c3));
	}
	
	public void changePlayer(){ //changes player playing every turn
		if (currentPlayer == 'X'){
			currentPlayer = 'O';
		}
		else {
			currentPlayer = 'X';
		}
	}
	
	public char returnPlayerchange(){
		return currentPlayer;
	}
	
	public boolean placeMark (int row, int col){
		if ((row >= 0)&&(row < 3)) {
			if ((col >=0)&&(col < 3)){
				if (board[row][col] == '-'){
					board [row][col] = currentPlayer;
					return true;
				}
			}
		}
		return false;
	}
	
	public char[][] returnBoardcol(){
		return board;
	}
	
	
}
