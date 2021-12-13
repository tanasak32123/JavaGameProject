package entity;

import javafx.scene.control.ProgressBar;

public abstract class Monster extends Maincharacter {
	private ProgressBar healthBar;
	private int level;

	public Monster(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense, int level) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense);
		setLevel(level);
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

	public int getElementalAdvantage(Player play) {
		String player = Elemental.getType(play);
		String mos = Elemental.getType(this);
		if ((player.equals("F") && mos.equals("G")) || (player.equals("G") && mos.equals("W"))
				|| (player.equals("W") && mos.equals("F"))) {
			return -1;
		} else if ((player.equals("G") && mos.equals("F")) || (player.equals("W") && mos.equals("G"))
				|| (player.equals("G") && mos.equals("W"))) {
			return 1;
		}
		return 0;
	}

}
