package entity;

import interfaces.IsAlive;

public class Maincharacter implements IsAlive{

	protected String name;
	protected String description;
	protected double health;
	protected double maxHealth;
	protected double mana;
	protected double maxMana;
	protected double attack;
	protected double defense;
	protected PlayType type;

	public Maincharacter() {
		setName("Unknown");
		this.description = "Unknown";
		this.health = 0;
		this.maxHealth = 0;
		this.mana = 0;
		this.maxMana = 0;
		this.attack = 0;
		this.defense = 0;
		setType(PlayType.values()[(int) (Math.random() * PlayType.values().length)]);
	}

	public Maincharacter(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.maxHealth = maxHealth;
		this.mana = mana;
		this.maxMana = maxMana;
		this.attack = attack;
		this.defense = defense;
		this.type = PlayType.values()[(int) (Math.random() * PlayType.values().length)];
	}

	public boolean isAlive() {
		if (health <= 0) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		if (health < maxHealth) {
			if (health < 0) {
				this.health = 0;
			}
			else {
				this.health = health;
			}
		} else
			this.health = maxHealth;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		if (mana < maxMana) {
			this.mana = mana;
		}
		else if (mana < 0){
			this.mana = 0;
		} else {
			this.mana = maxMana;
		}
	}

	public double getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(double maxMana) {
		this.maxMana = maxMana;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		if (attack < 0) {
			this.attack = 0;
		}
		else {
			this.attack = attack;
		}
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		if (defense < 0) {
			this.defense = 0;
		}
		else {
			this.defense = defense;
		}
	}

	public PlayType getType() {
		return type;
	}

	public void setType(PlayType type) {
		this.type = type;
	}

	public static double condi(int level) {
		return Math.pow(1.2, level - 1);
	}

}
