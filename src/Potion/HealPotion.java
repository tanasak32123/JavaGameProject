package Potion;


public class HealPotion extends Potion {
	public static int heal;

	
	public HealPotion() {
		super("Healing Potion","This is heal your character 50 hp.",25,"res/healpotion.png");
		heal = 50;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "You gain " + heal + "hp.";
	}


		
}
