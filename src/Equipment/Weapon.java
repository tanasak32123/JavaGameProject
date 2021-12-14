package Equipment;

public class Weapon extends Equipment {
	private int damage;
	private int lifesteal;

	public Weapon() {
		damage = 0;
		lifesteal = 0;
	}

	public Weapon(String name, String description, int price, int damage, int lifesteal) {
		super(name, description, price);
		this.damage = damage;
		this.lifesteal = lifesteal;
	}

	public int getDamage() {
		return damage;
	}

	public int getLifesteal() {
		return lifesteal;
	}

	public String getDamageText() {
		if (damage > 0) {
			return "\nDamage: " + damage;
		}
		return "";
	}

	public String getLifestealText() {
		if (lifesteal > 0) {
			return "\nLifesteal: " + lifesteal;
		}
		return " ";
	}

	public String toString() {
		return "You equip" + name + "already.";
	}

}