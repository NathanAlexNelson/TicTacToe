
public class WinMessage {
	
	private String WinMessage;
	
	WinMessage(){
		WinMessage = "Congratulations!";
	}
	
	String ReturnWinMessage(String WinnerStatement){
		WinMessage = WinnerStatement;
		return WinMessage;
	}
	
}
