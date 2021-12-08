package Item;

public class Heal extends Potion implements Usable{
	private boolean isUsed;
	private int heal;
	
	public Heal(String name,String description,int heal) {
		super(name,description);
		this.heal = heal;
	}

	public int getHeal() {
		return heal;
	}
	
	public int useItem(Player player) {
		isUsed = true;
		player.healPlayer(heal);
		return heal;
	}
	
	public String toString() {
		return "You gain " + heal + "hp.";
	}
		
}
