package Potion;

import entity.Maincharacter;
import logic.GamePlay;

public class HealPotion extends Potion implements Usable{
	private int heal;
	
	public HealPotion() {
		super("Healing Potion","This is heal your character 50 hp.",25);
		this.heal = 50;
	}

	public int getHeal() {
		return heal;
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}

	@Override
	public void useItem(Maincharacter selectededCharacter) {
		// TODO Auto-generated method stub
		
	}

	
		
}
