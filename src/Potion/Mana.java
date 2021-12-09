package Potion;

public class Mana extends Potion implements Usable{
	private int mana;
	
	public Mana(String name, String description,int mana) {
		super(name,description);
		this.mana = mana;
	}

	public int getMana() {
		return mana;
	}
	
	public int useItem(??? assignedCharacter) {
		isUsed = true;
		assignedCharacter.refillMana(mana);
		return mana;
	}
	
	public String toString() {
		return "You gain " + mana + "mana.";
	}

}
