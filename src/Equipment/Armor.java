package Equipment;

import Entity.MainCharacter;

public class Armor extends Equipment implements Equipable{
	private int bonusDamage;
	private int defense;
	
	public Armor() {
		bonusDamage = 0;
		defense = 0;
	}
	
	public Armor(String name,String description,int price,int bonusDamage,int defense) {
		super(name,description,price);
		this.bonusDamage = bonusDamage;
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}
	
	public void equipItem(MainCharacter selectedCharacter) {
		//set armor to character
		selectedCharacter.setAtk(selectedCharacter.getAtk() + (bonusDamage - selectedCharacter.getArmor().getBonusDamage()));
		selectedCharacter.setDef(selectedCharacter.getDef() + (defense - selectedCharacter.getArmor().getDefense()));
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
