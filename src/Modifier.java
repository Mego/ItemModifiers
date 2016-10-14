import java.util.HashMap;

public abstract class Modifier {
	
	public String getDamageType() {
		return "normal";
	}
	
	public int getAdditionalDamage() {
		return 0;
	}
	
	public void onHit(Character src, Character target, Item weapon, HashMap<String, Integer> damage) {
		
	}
	
	public void onDamageTaken(Character src, Character target, Item weapon, HashMap<String, Integer> damage) {
		
	}
	
}
