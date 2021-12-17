package entity;

import Item.Accessory;
import Item.Armor;
import Item.Equipment;
import Item.Weapon;
import Potion.HealPotion;
import Potion.ManaPotion;
import Potion.Potion;
import interfaces.Equipable;
import interfaces.IRenderable;
import interfaces.Usable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import logic.GamePlay;

public abstract class Player extends Maincharacter implements Equipable, Usable, IRenderable {
	private int lifesteal;
	private Weapon weapon;
	private Armor armor;
	private Accessory accessory;
	private ProgressBar healthBar;
	protected int level;
	protected Point2D position;

	public Player() {
		super();
		position = new Point2D(100, 250);
	}

	public Player(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense, int level, String image) {
		super(name, description, health, maxHealth, mana, maxMana, attack, defense, image);
		weapon = new Weapon();
		armor = new Armor();
		accessory = new Accessory();
		this.level = level;
		this.lifesteal = 0;
		position = new Point2D(100, 250);
	}

	public int attack(Maincharacter character) {
		if (character instanceof Monster) {
			if (attack <= character.getDefense()) {
				return 0;
			}
			int damage = (int) (attack - character.getDefense());
			if (getElementalAdvantage((Monster) character) == 1) {
				damage *= 1.3;
				character.setHealth(character.getHealth() - damage);
			} else if (getElementalAdvantage((Monster) character) == -1) {
				damage *= 0.7;
				character.setHealth(character.getHealth() - damage);
			} else {
				character.setHealth(character.getHealth() - damage);
			}
			if (lifesteal > 0) {
				setHealth(health + lifesteal);
			}
			return damage;
		}
		return 0;
	}

	public void useItem(Potion potion) {
		if (potion instanceof HealPotion) {
			if (health < maxHealth) {
				setHealth(health + HealPotion.heal);
			}
		}
		if (potion instanceof ManaPotion) {
			if (mana < maxMana) {
				setMana(mana + ManaPotion.mana);
			}
		}
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
		setAttack(getAttack() * 1.1);
		setDefense(getDefense() * 1.1);
		setHealth(getMaxHealth() * 1.1);
		setMaxHealth(getMaxHealth() * 1.1);
		setMaxMana(getMaxMana() * 1.1);
		setMana(getMaxMana());
		setLevel(level + 1);
	}

	public int getElementalAdvantage(Monster mon) {
		String player = Elemental.getType(this);
		String mons = Elemental.getType(mon);
		if ((player.equals("F") && mons.equals("G")) || (player.equals("G") && mons.equals("W"))
				|| (player.equals("W") && mons.equals("F"))) {
			return 1;
		} else if ((player.equals("G") && mons.equals("F")) || (player.equals("W") && mons.equals("G"))
				|| (player.equals("F") && mons.equals("W"))) {
			return -1;
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
		} else {
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