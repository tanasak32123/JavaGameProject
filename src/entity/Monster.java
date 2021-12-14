package entity;

import javafx.scene.control.ProgressBar;

public abstract class Monster extends Maincharacter{
	private ProgressBar healthBar;

	public Monster(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense);
	}

	public void attackRandom() {
		
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

	public abstract void playerGetMoneyFromKilled();
	
	public ProgressBar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(ProgressBar healthBar) {
		this.healthBar = healthBar;
	}
	
}
