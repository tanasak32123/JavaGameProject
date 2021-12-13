package Potion;

import entity.MainCharacter;

public class Heal extends Potion implements Usable{
	private int heal;
	
	public Heal(String name,String description,int price,int heal) {
		super(name,description,price);
		this.heal = heal;
	}

	public int getHeal() {
		return heal;
	}
	
	public void useItem(MainCharacter selectedCharacter) {
		selectedCharacter.setCurrentHp(selectedCharacter.getCurrentHp() + heal);
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}
		
}
