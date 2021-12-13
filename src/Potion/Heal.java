package Potion;


import entity.Maincharacter;

public class Heal extends Potion implements Usable{
	private int heal;
	
	public Heal(String name,String description,int price,int heal) {
		super(name,description,price);
		this.heal = heal;
	}

	public int getHeal() {
		return heal;
	}
	
	@Override
	public void useItem(Maincharacter selectedCharacter) {
		selectedCharacter.setHealth(Math.max(selectedCharacter.getHealth() + heal,selectedCharacter.getMaxHealth()));
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}

		
}
