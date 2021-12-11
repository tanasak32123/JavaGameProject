package entity;

import javafx.scene.control.ProgressBar;

public class Player extends Maincharacter {
	private ProgressBar healthBar;
	private int money ;
	private int level ;
	
	
	public Player(String name, String description, double health, double maxHealth, double mana, double maxMana, double attack,
			double defense,int level) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense) ;
		this.money = 0;
		this.level = level;
	}


	public ProgressBar getHealthBar() {
		return healthBar;
	}


	public void setHealthBar(ProgressBar healthBar) {
		this.healthBar = healthBar;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
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
	}
	
	
}

