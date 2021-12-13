package Potion;

import entity.Maincharacter;

public class HealPotion extends Potion implements Usable{
	private int heal;
	
	public HealPotion(String name,String description,int price,int heal) {
		super(name,description,price);
		this.heal = heal;
	}

	public int getHeal() {
		return heal;
	}
	
	public void useItem(Maincharacter selectedCharacter) {
		selectedCharacter.setHealth(selectedCharacter.getHealth() + heal);
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}
		
}
