package Item;

import entity.Maincharacter;
import entity.Player;

public class Accessory extends Equipment implements Equipable{
	private int bonusDamage;
	private int bonusDefense;
	
	public Accessory() {
		bonusDamage = 0;
		bonusDefense = 0;
	}
	
	public Accessory(String name,String description,int price,int bonusDamage,int bonusDefense,String image) {
		super(name,description,price,image);
		this.bonusDamage = bonusDamage;
		this.bonusDefense = bonusDefense;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}

	public int getBonusDefense() {
		return bonusDefense;
	}
	
	@Override
	public void equipItem(Player selectedCharacter) {
		// set accessory to character
		selectedCharacter.setAttack(selectedCharacter.getAttack() + (bonusDamage - selectedCharacter.getAccessory().getBonusDamage()));
		selectedCharacter.setDefense(selectedCharacter.getDefense() + (bonusDefense - selectedCharacter.getAccessory().getBonusDefense()));

	}
	
	public String getBonusDamageText() {
		if (bonusDamage > 0) {
			return "\nBonusDamage: "+ bonusDamage;
		}
		return "";
	}
	
	public String getBonusDefenseText() {
		if (bonusDefense > 0) {
			return "\nBonusDefense: "+ bonusDefense;
		}
		return " ";
	}
	
	public String toString() {
		return "You equip" + name + "already.";
	}

	

	

}
