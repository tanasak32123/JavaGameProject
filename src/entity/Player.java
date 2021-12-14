package entity;

import Equipment.Accessory;
import Equipment.Armor;
import Equipment.Equipment;
import Equipment.Weapon;
import interfaces.Equipable;
import javafx.scene.control.ProgressBar;

public abstract class Player extends Maincharacter implements Equipable {
	private int lifesteal;
	private Weapon weapon;
	private Armor armor;
	private Accessory accessory;
	private ProgressBar healthBar;
	protected int level;

	public Player(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense, int level) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense);
		weapon = new Weapon();
		armor = new Armor();
		accessory = new Accessory();
		this.level = level;
		this.lifesteal = 0;
	}
	
	public void doAction() {
		
	}

	public void equipItem(Equipment equipment) {
		if (equipment instanceof Weapon) {
			setWeapon((Weapon) equipment);
		}
		if (equipment instanceof Armor) {
			setArmor((Armor) equipment);
		}
		if (equipment instanceof Accessory) {
			setAccessory((Accessory) equipment);
		}
	}

	public void setWeapon(Weapon weapon) {
		setAttack(attack + (weapon.getDamage() - this.weapon.getDamage()));
		setLifesteal(lifesteal + (weapon.getLifesteal() - this.weapon.getLifesteal()));
		this.weapon = weapon;
	}

	public void setArmor(Armor armor) {
		setAttack(attack + (armor.getBonusDamage() - this.armor.getBonusDamage()));
		setDefense(defense + (armor.getDefense() - this.armor.getDefense()));
		this.armor = armor;
	}

	public void setAccessory(Accessory accessory) {
		setAttack(attack + (accessory.getBonusDamage() - this.accessory.getBonusDamage()));
		setDefense(defense + (accessory.getBonusDamage() - this.accessory.getBonusDefense()));
		this.accessory = accessory;
	}

	public void leveup() {
		setAttack(getAttack() * 1.2);
		setDefense(getDefense() * 1.2);
		setHealth(getMaxHealth() * 1.2);
		setMaxHealth(getMaxHealth() * 1.2);
		setMaxMana(getMaxMana() * 1.2);
		setMana(getMaxMana());
		setLevel(level + 1);
	}

	public int getElementalAdvantage(Monster mon) {
		String player = Elemental.getType(this);
		String mons = Elemental.getType(mon);
		if ((player.equals("F") && mons.equals("G")) || (player.equals("G") && mons.equals("W"))
				|| (player.equals("W") && mons.equals("F"))) {
			return -1;
		} else if ((player.equals("G") && mons.equals("F")) || (player.equals("W") && mons.equals("G"))
				|| (player.equals("G") && mons.equals("W"))) {
			return 1;
		}
		return 0;
	};

	public abstract boolean useSkill1(Object o1);

	public abstract boolean useSkill2(Object o1);

	public int getLifesteal() {
		return lifesteal;
	}

	public void setLifesteal(int lifesteal) {
		if (lifesteal < 0) {
			this.lifesteal = 0;
		}
		else {
			this.lifesteal = lifesteal;
		}
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public ProgressBar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(ProgressBar healthBar) {
		this.healthBar = healthBar;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
