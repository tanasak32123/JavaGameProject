package Item;

import entity.Player;

public class Weapon extends Equipment implements Equipable {
	private int damage;
	private int lifesteal;

	public Weapon() {
		damage = 0;
		lifesteal = 0;
	}

	public Weapon(String name, String description, int price, int damage, int lifesteal,String image) {
		super(name, description, price,image);
		this.damage = damage;
		this.lifesteal = lifesteal;
	}

	public int getDamage() {
		return damage;
	}

	public int getLifesteal() {
		return lifesteal;
	}

	public void equipItem(Player selectedCharacter) {
		// set weapon to character
		selectedCharacter.setWeapon(this);
		selectedCharacter
				.setAttack(selectedCharacter.getAttack() + (damage - selectedCharacter.getWeapon().getDamage()));
		selectedCharacter.setLifesteal(
				selectedCharacter.getLifesteal() + (lifesteal - selectedCharacter.getWeapon().getLifesteal()));
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