import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Character {

	private int health;
	private ArrayList<Item> items;
	
	public Character(int initialHealth) {
		this.health = initialHealth;
		this.items = new ArrayList<Item>();
	}
	
	public Item[] getItems() {
		return (Item[]) items.toArray();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void removeItem(Item item) {
		if(this.items.contains(item)) {
			this.items.remove(item);
		}
	}
	
	public void addHealth(int health) {
		this.health += health;
	}
	
	public void doHit(Character target, Item weapon) {
		HashMap<String, Integer> damage = weapon.calculateTotalDamage();
		Stream.of(weapon.getModifiers()).forEach(mod -> mod.onHit(this, target, weapon, damage));
		target.onHit(this, damage);
	}
	
	public void onHit(Character src, HashMap<String, Integer> damage) {
		Stream.of(this.getItems()).forEach(item -> item.onDamageTaken(src, this, damage));
		damage.entrySet().stream().forEach(entry -> this.health -= entry.getValue());
	}
	
}
