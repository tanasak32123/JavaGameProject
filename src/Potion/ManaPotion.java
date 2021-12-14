package Potion;


import entity.Maincharacter;
import interfaces.Usable;
import logic.GamePlay;

public class ManaPotion extends Potion implements Usable{
	public static int mana;
	
	public ManaPotion() {
		super("Mana Potion","This refill your character mana 25 units.",25);
		ManaPotion.mana = 25;
	}

	public void useItem(Maincharacter selectedCharacter) {
		if (selectedCharacter.getMana() < selectedCharacter.getMaxMana()) {
			GamePlay.manaPotion -= 1;
			selectedCharacter.setMana(selectedCharacter.getMana() + ManaPotion.mana);
		}
	}
	
	public String toString() {
		return "You gain " + mana + "mana.";
	}

}
