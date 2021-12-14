package Potion;

import entity.Maincharacter;
import interfaces.Usable;
import logic.GamePlay;

public class HealPotion extends Potion implements Usable{
	public static int heal;
	
	public HealPotion() {
		super("Healing Potion","This is heal your character 50 hp.",25);
		heal = 50;
	}

	public void useItem(Maincharacter selectedCharacter) {
		if (selectedCharacter.getHealth() < selectedCharacter.getMaxHealth()) {
			GamePlay.healPotion -= 1;
			selectedCharacter.setHealth(selectedCharacter.getHealth() + heal);
		}
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}
		
}
