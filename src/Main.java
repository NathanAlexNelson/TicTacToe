import java.util.Scanner;

public class Main {
	public static void main (String[] args){
	
		int Teamchose;
		int myTeam = 1;
		int TeamPlaying = 0;
		char TTTpicked;
		boolean BoardisFull;
		int F = 0;
		int N = 0;
		char WinTeam;
		int FNF = 0;
		boolean inputValid = false;
		int computer = 1;
		char currentPlayer = 'X';
		int computer2 = 1;
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Which team would you like to be? \n1.X's \n2.O's \n3.Computers");
		Teamchose = input.nextInt();
		
		if (Teamchose == 1){
			myTeam = 0;
			computer = 1;
		}

		else if (Teamchose == 2){
			myTeam = 1;
			computer = 0;
		}
		
		else if (Teamchose == 3){
			computer = 0;
			computer2 = 1;
		}
		else {
			System.out.println("You have chosen an invalid option.");
		}
		
		
		TicTacToe Game = new TicTacToe();
		
		
		
		Game.createBoard();
		
		while (FNF == 0){
			Game.returnPlayerchange();
			Game.GameBoard();
			
		System.out.println("Please place your piece \nRow: 1 - 3\nCol: 1 - 3");
		do {
		if (TeamPlaying == myTeam) {
		F = input.nextInt() - 1;
		N = input.nextInt() - 1;
		}
		else if (TeamPlaying == computer || TeamPlaying == computer2) {
		F = Computer.Boardmove() - 1;
		N = Computer.Boardmove() - 1;
		}
		char[][]board = Game.returnBoardcol();
		
		if ((F<3)&&(N<3)&&(F>=0)&&(N>=0)){ // Verifies that it's a valid move.
			if (board[F][N] == '-'){ //Verifies that no one has moved to that space yet.
			Game.placeMark(F,N);
			inputValid = true;
			if (TeamPlaying == myTeam) {
				computer = 0;
				myTeam = 1;
			}
			else if (TeamPlaying == computer || TeamPlaying == computer2) {
				if (Teamchose != 3){
					myTeam = 0;
					computer = 1;
				}
				else if (Teamchose == 3 && TeamPlaying == computer){
					computer = 1;
					computer2 = 0;
				}
				else if (Teamchose == 3 && TeamPlaying == computer2){
					computer = 0;
					computer2 = 1;			
				}
			}
			}
			else {
				
				System.out.println("Someone has already moved here.");
				inputValid = false;
			}
		}
		else {
			System.out.println("The move you are trying to make is invalid.");
			inputValid = false;
		}
	} while (!inputValid);
		
		if (Game.WinCondition()){
		WinTeam = Game.returnPlayerchange();
		Game.GameBoard();
		Game.changePlayer();
		System.out.println("Team " + WinTeam + " wins!");	
		FNF = 1;
		}
		else if (Game.BoardFull()){
		System.out.println("There is a draw!");
		FNF = 1;
		}
		
		if (inputValid == true){
			Game.changePlayer();
		}
		
		//System.out.print("You have chosen " + team + " as your team."); //Code used to confirm which team was chosen
		
		//TTTpicked = Game.team(team);
		
	}
	}
}
