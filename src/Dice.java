import java.util.Random;

public class Dice {
	
	public static final Dice NO_DICE = new Dice(0, 0) {
		public int roll() {
			return 0;
		}
	};
	
	private static Random rand = new Random();

	private int numDice;
	private int numSides;
	
	public Dice(int numDice, int numSides) {
		this.numDice = numDice;
		this.numSides = numSides;
	}
	
	public int roll() {
		return rand.ints(1, numSides+1).limit(numDice).sum();
	}
	
}
