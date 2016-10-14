import java.util.HashMap;

public final class Modifiers {
	
	public static Modifier NO_DAMAGE = new Modifier() {};

	public static Modifier flatNormalDamage(int damage) {
		return new Modifier() {
			public int getAdditionalDamage() {
				return damage;
			}
		};
	}
	
	public static Modifier flatTypedDamage(String type, int damage) {
		return new Modifier() {
			public int getAdditionalDamage() {
				return damage;
			}
			public String getDamageType() {
				return type;
			}
		};
	}
	
	public static Modifier diceNormalDamage(int numDice, int numSides) {
		return new Modifier() {
			public int getAdditionalDamage() {
				return new Dice(numDice, numSides).roll();
			}
		};
	}
	
	public static Modifier diceLeechNormalDamage(int numDice, int numSides) {
		return new Modifier() {
			public int getAdditionalDamage() {
				return new Dice(numDice, numSides).roll();
			}
			public void onHit(Character src, Character target, Item weapon, HashMap<String, Integer> damage) {
				src.addHealth(damage.entrySet().stream().mapToInt(entry -> entry.getValue()).sum());
			}
		};
	}
	
}
