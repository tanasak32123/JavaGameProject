package Equipment;

import Entity.MainCharacter;

public class Weapon extends Equipment implements Equipable{
	private int damage;
	private int lifesteal;
	private int crit;
	
	public Weapon() {
		damage = 0;
		lifesteal = 0;
		crit = 0;
	}
	
	public Weapon(String name,String description,int price,int damage,int lifesteal,int crit) {
		super(name,description,price);
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
	
	public void equipItem(MainCharacter selectedCharacter) {
		//set weapon to character 
		selectedCharacter.setAtk(selectedCharacter.getAtk() + (damage - selectedCharacter.getWeapon().getDamage()));
		selectedCharacter.setLifesteal(selectedCharacter.getLifesteal() + (lifesteal - selectedCharacter.getWeapon().getLifesteal()));
		selectedCharacter.setCrit(selectedCharacter.getCrit() + (crit - selectedCharacter.getWeapon().getCrit()));
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