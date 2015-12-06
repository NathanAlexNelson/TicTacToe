
public class Computer {
	private static int Boardmove;
	public static int Boardmove(){
	Boardmove = 1 + (int) (Math.random() * 3);
	return Boardmove;
	}
}
