package entity;

import javafx.scene.control.ProgressBar;
import logic.GamePlay;

public abstract class Monster extends Maincharacter {
	private ProgressBar healthBar;

	public Monster(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense);
	}

	public int attack(Maincharacter character) {
		if (character instanceof Player) {
			if (attack <= character.getDefense()) {
				return 0;
			}
			int damage = (int) (attack - character.getDefense());
			if (getElementalAdvantage((Player) character) == 1) {
				damage *= 1.3;
				character.setHealth(character.getHealth() - damage);
			}
			else if (getElementalAdvantage((Player) character) == -1) {
				damage *= 0.7;
				character.setHealth(character.getHealth() - damage);
			}
			else {
				character.setHealth(character.getHealth() - damage);
			}
			return damage;
		}
		return 0;
	}

	public void attackRandom() {
		int choose = (int) (Math.random() * (GamePlay.myChar.size()));
		attack(GamePlay.myChar.get(choose));
	}

	public int getElementalAdvantage(Player play) {
		String player = Elemental.getType(play);
		String mos = Elemental.getType(this);
		if ((player.equals("F") && mos.equals("G")) || (player.equals("G") && mos.equals("W"))
				|| (player.equals("W") && mos.equals("F"))) {
			return -1;
		} else if ((player.equals("G") && mos.equals("F")) || (player.equals("W") && mos.equals("G"))
				|| (player.equals("F") && mos.equals("W"))) {
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
