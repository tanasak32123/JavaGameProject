package entity;

import Equipment.Accessory;
import Equipment.Armor;
import Equipment.Weapon;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;

public abstract class Player extends Maincharacter {
	private int lifesteal;
	private Weapon weapon;
	private Armor armor;
	private Accessory accessory;
	private ProgressBar healthBar;
	protected int level;
	


	public Player(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense, int level,String image) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense,image);
		(new Weapon()).equipItem(this);
		(new Accessory()).equipItem(this);
		(new Armor()).equipItem(this);
		this.level = level;
		this.lifesteal = 0;
	}

	public int getLifesteal() {
		return lifesteal;
	}

	public void setLifesteal(int lifesteal) {
		this.lifesteal = lifesteal;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
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

	public void leveup() {
		setAttack(getAttack() * 1.2);
		setDefense(getDefense() * 1.2);
		setHealth(getHealth() * 1.2);
		setMaxHealth(getMaxHealth() * 1.2);
		setMaxMana(getMaxMana() * 1.2);
		setMana(getMaxMana());
		setLevel(getLevel() + 1);
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

	public abstract void useSkill1(Object o1);

	public abstract void useSkill2(Object o1);

}
