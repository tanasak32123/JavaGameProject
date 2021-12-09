package Potion;

public class Heal extends Potion implements Usable{
	private int heal;
	
	public Heal(String name,String description,int heal) {
		super(name,description);
		this.heal = heal;
	}

	public int getHeal() {
		return heal;
	}
	
	public int useItem(??? assignedCharacter) {
		isUsed = true;
		assignedCharacter.healPlayer(heal);
		return heal;
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}
		
}
