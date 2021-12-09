package Entity;

public abstract class MainCharacter extends Character{
	protected int atk;
	protected int def;
	protected int crit;
	protected int mana;
	
	public MainCharacter(String name, String description,int atk,int def,int crit,int mana) {
		super(name,description);
		this.atk = atk;
		this.def = def;
		this.crit = crit;
		this.mana = mana;
	}
	
	public abstract void useSkill(Character chooseCharacter);
	
}
