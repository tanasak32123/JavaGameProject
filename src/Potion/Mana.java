package Potion;


import entity.Maincharacter;

public abstract class Mana extends Potion implements Usable{
	private int mana;
	
	public Mana(String name, String description,int price,int mana) {
		super(name,description,price);
		this.mana = mana;
	}

	public int getMana() {
		return mana;
	}
	
	public void useItem(Maincharacter selectedCharacter) {
		selectedCharacter.setMana(selectedCharacter.getMana() + mana);
	}
	
	public String toString() {
		return "You gain " + mana + "mana.";
	}


}
