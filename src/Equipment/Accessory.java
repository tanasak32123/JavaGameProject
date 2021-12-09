package Equipment;

public class Accessory extends Equipment implements Equipable{
	private int bonusDamage;
	private int bonusCrit;
	private int bonusDefense;
	
	public Accessory() {
		bonusDamage = 0;
		bonusCrit = 0;
		bonusDefense = 0;
	}
	
	public Accessory(String name,String description,int bonusDamage,int bonusCrit,int bonusDefense) {
		super(name,description);
		this.bonusDamage = bonusDamage;
		this.bonusCrit = bonusCrit;
		this.bonusDefense = bonusDefense;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}

	public int getBonusCrit() {
		return bonusCrit;
	}

	public int getBonusDefense() {
		return bonusDefense;
	}
	
	public void equipItem(??? assignedCharacter) {
		// set accessory to character
		//assignedCharacter.increaseAttack(bonusDamage);
		//assignedCharacter.increaseCritical(bonusCrit);
		//assignedCharacter.increaseDefense(bonusDefense);
		assignedCharacter.setAccessory(this);
	}
	
	public String getBonusDamageText() {
		if (bonusDamage > 0) {
			return "\nBonusDamage: "+ bonusDamage;
		}
		return "";
	}
	
	public String getBonusCritText() {
		if (bonusCrit > 0) {
			return "\nBonusCrit: "+ bonusCrit + " %";
		}
		return " ";
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
