package Entity;

public abstract class MainCharacter extends Character{
	protected int atk;
	protected int def;
	protected int crit;
	protected int currentMana;
	protected int maxMana;
	protected int currentHp;
	protected int maxHp;
	
	public MainCharacter(String name, String description,int atk,int def,int crit,int mana,int hp) {
		super(name,description);
		this.atk = atk;
		this.def = def;
		this.crit = crit;
		this.currentMana = mana;
		this.maxMana = mana;
		this.currentHp = hp;
		this.maxHp = hp;
	}
	
	public abstract void useSkill(Character chooseCharacter);
	
	public abstract void attackTarget(Character chooseCharacter);

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int mana) {
		this.currentMana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int hp) {
		this.currentHp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
}
