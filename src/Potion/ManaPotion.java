package Potion;

public class ManaPotion extends Potion{
	public static int mana;
	
	public ManaPotion() {
		super("Mana Potion","This refill your character mana 25 units.",25);
		ManaPotion.mana = 25;
	}

	public String toString() {
		return "You gain " + mana + "mana.";
	}

}
