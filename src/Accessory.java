
public class Accessory extends Equipment{
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
}
