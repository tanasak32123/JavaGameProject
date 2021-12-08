package Equipment;

public class Accessory extends Item implements Equipable{
	private int bonusDamage;
	private int bonusCrit;
	private int bonusPhysDef;
	private int bonusMagicDef;
	
	Accessory(String name,String description,int bonusDamage,int bonusCrit,int bonusPhysDef,int bonusPhysMagic) {
		super(name,description);
		this.bonusDamage = bonusDamage;
		this.bonusCrit = bonusCrit;
		this.bonusDamage = bonusDamage;
		this.bonusPhysDef = bonusPhysDef;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}

	public int getBonusCrit() {
		return bonusCrit;
	}

	public int getBonusPhysDef() {
		return bonusPhysDef;
	}

	public int getBonusMagicDef() {
		return bonusMagicDef;
	}
	
	public void equipItem(??? assignedCharacter) {
		assignedCharacter.increaseAttack(bonusDamage);
		assignedCharacter.increaseCritical(bonusCrit);
		assignedCharacter.increaseMagicDef(bonusMagicDef);
		assignedCharacter.increasePhysDef(bonusPhysDef);
	}
	
	public String getBonusDamageText() {
		if (bonusDamage > 0) {
			return "\nBonusDamage: "+ bonusDamage;
		}
		return "";
	}
	
	public String getBonusCritText() {
		if (bonusCrit > 0) {
			return "\nBonusCrit: "+ bonusCrit;
		}
		return " ";
	}
	
	public String getBonusPhysDefText() {
		if (bonusPhysDef > 0) {
			return "\nBonusPhysDef: "+ bonusPhysDef;
		}
		return " ";
	}
	
	public String getBonusMagicDefText() {
		if (bonusMagicDef > 0) {
			return "\nBonusMagicDef: "+ bonusMagicDef;
		}
		return " ";	
	}

	public String toString() {
		return "You equip" + name + "already.";
	}

}
