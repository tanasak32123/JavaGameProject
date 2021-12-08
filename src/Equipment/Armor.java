package Equipment;

public class Armor extends Item{
	private int bonusDamage;
	private int physDef;
	private int magicDef;
	
	Armor(String name,String description,int bonusDamage,int physDef,int magicDef) {
		super(name,description);
		this.bonusDamage = bonusDamage;
		this.physDef = physDef;
		this.magicDef = magicDef;
	}

	public int getPhysDef() {
		return physDef;
	}

	public int getMagicDef() {
		return magicDef;
	}

	public int getBonusDamage() {
		return bonusDamage;
	}
	
	public void equipItem(??? assignedCharacter) {
		assignedCharacter.increaseAttack(bonusDamage);
		assignedCharacter.increasePhysDef(physDef);
		assignedCharacter.increaseMagicDef(magicDef);
	}
	
	public String getBonusDamageText() {
		if (bonusDamage > 0) {
			return "\nBonusDamage: "+ bonusDamage;
		}
		return "";
	}
	
	public String getPhysDefText() {
		if (physDef > 0) {
			return "\nPhysDef: "+ physDef;
		}
		return " ";
	}
	
	public String getMagicDefText() {
		if (magicDef > 0) {
			return "\nMagicDef: "+ magicDef;
		}
		return " ";
	}
	
	public String toString() {
		return "You equip" + name + "already.";
	}

}
