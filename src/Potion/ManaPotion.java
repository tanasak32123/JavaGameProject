package Potion;


import entity.Maincharacter;
import logic.GamePlay;

<<<<<<< HEAD
public  class ManaPotion extends Potion implements Usable{
=======
public class ManaPotion extends Potion implements Usable{
>>>>>>> noon
	private int mana;
	
	public ManaPotion() {
		super("Mana Potion","This refill your character mana 25 units.",25);
		this.mana = 25;
	}

	public int getMana() {
		return mana;
	}
	
	public void useItem(Maincharacter selectedCharacter) {
		GamePlay.manaPotion -= 1;
		selectedCharacter.setMana(selectedCharacter.getMana() + mana);
	}
	
	public String toString() {
		return "You gain " + mana + "mana.";
	}

}
