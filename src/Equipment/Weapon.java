package Equipment;

public class Weapon extends Equipment implements Equipable{
	private int damage;
	private int lifesteal;
	private int crit;
	
	public Weapon() {
		damage = 0;
		lifesteal = 0;
		crit = 0;
	}
	
	public Weapon(String name,String description,int damage,int lifesteal,int crit) {
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
	
	public void equipItem(??? assignedCharacter) {
		//set weapon to character 
		//assignedCharacter.increaseAttack(damage);
		//assignedCharacter.increaseLifesteal(lifesteal);
		//assignedCharacter.increaseCritical(crit);
		assignedCharacter.setWeapon(this);
	}
	
	public String getDamageText() {
		if (damage > 0) {
			return "\nDamage: "+ damage;
		}
		return "";
	}
	
	public String getLifestealText() {
		if (lifesteal > 0) {
			return "\nLifesteal: "+ lifesteal;
		}
		return " ";
	}
	
	public String getCritText() {
		if (crit > 0) {
			return "\nCritical: "+ crit + " %";
		}
		return " ";
	}
	
	public String toString() {
		return "You equip" + name + "already.";
	}
	
}