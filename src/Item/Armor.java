package Item;

import entity.Player;

public class Armor extends Equipment{
	private int bonusDamage;
	private int defense;
	
	public Armor() {
		bonusDamage = 0;
		defense = 0;
	}
	
	public Armor(String name,String description,int price,int bonusDamage,int defense,String image) {
		super(name,description,price,image);
		this.bonusDamage = bonusDamage;
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}
	
	
	public String getBonusDamageText() {
		if (bonusDamage > 0) {
			return "\nBonusDamage: "+ bonusDamage;
		}
		return "";
	}
	
	public String getDefenseText() {
		if (defense > 0) {
			return "\nDefense: "+ defense;
		}
		return " ";
	}
	
	public String toString() {
		return "You equip" + name + "already.";
	}

}
