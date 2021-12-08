
public class Armor extends Equipment{
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
}
