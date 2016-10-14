import java.util.ArrayList;
import java.util.HashMap;

public class Item {

	private ArrayList<Modifier> modifiers;
	
	public Item() {
		this.modifiers = new ArrayList<Modifier>();
	}
	
	public void addModifier(Modifier mod) {
		this.modifiers.add(mod);
	}
	
	public void removeModifier(Modifier mod) {
		if(this.modifiers.contains(mod)) {
			this.modifiers.remove(mod);
		}
	}
	
	public Modifier[] getModifiers() {
		return (Modifier[]) modifiers.toArray();
	}
	
	public int calculateTypedDamage(String type) {
		int extraDamage = modifiers.stream().filter(m -> m.getDamageType().equals(type)).mapToInt(m -> m.getAdditionalDamage()).sum();
		return extraDamage;
	}

	public HashMap<String, Integer> calculateTotalDamage() {
		HashMap<String, Integer> damage = new HashMap<String, Integer>();
		modifiers.stream().map(m -> m.getDamageType()).distinct().forEach(damageType -> damage.put(damageType, calculateTypedDamage(damageType)));
		return damage;
	}
	
	public void onDamageTaken(Character src, Character target, HashMap<String, Integer> damage) {
		modifiers.stream().forEach(mod -> mod.onDamageTaken(src, target, this, damage));
	}
	
}
