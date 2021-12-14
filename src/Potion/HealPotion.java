package Potion;

public class HealPotion extends Potion{
	public static int heal;
	
	public HealPotion() {
		super("Healing Potion","This is heal your character 50 hp.",25);
		heal = 50;
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}
		
}
