package Potion;


import entity.Maincharacter;

public  class ManaPotion extends Potion implements Usable{
	private int mana;
	
	public ManaPotion(String name, String description,int price,int mana) {
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
