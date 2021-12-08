
public class Weapon extends Equipment{
	private int damage;
	private int lifesteal;
	private int crit;
	
	Weapon(String name,String description,int damage,int lifesteal,int crit) {
		super(name,description);
		this.damage = damage;
		this.lifesteal = lifesteal;
		this.crit = crit;
	}
	
	public int getDamage() {
		return damage;
	}

	public int getLifesteal() {
		return lifesteal;
	}

	public int getCrit() {
		return crit;
	}
}
