package Equipment;

public class Armor extends Equipment implements Equipable{
	private int bonusDamage;
	private int defense;
	
	public Armor() {
		bonusDamage = 0;
		defense = 0;
	}
	
	public Armor(String name,String description,int bonusDamage,int defense) {
		super(name,description);
		this.bonusDamage = bonusDamage;
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}
	
	public void equipItem(??? assignedCharacter) {
		//set armor to character
		//assignedCharacter.increaseAttack(bonusDamage);
		//assignedCharacter.increaseDefense(defense);
		assignedCharacter.setArmor(this);
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
