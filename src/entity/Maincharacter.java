package entity;

import javax.lang.model.type.NullType;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Maincharacter {

	protected String name;
	protected String description;
	protected double health;
	protected double maxHealth;
	protected double mana;
	protected double maxMana;
	protected double attack;
	protected double defense;
	protected PlayType type;
	protected String image;
	protected boolean isAlive;
	protected Point2D position;

	public Maincharacter() {
		setName("Unknown");
		this.description = "Unknown";
		this.health = 0;
		this.maxHealth = 0;
		this.mana = 0;
		this.maxMana = 0;
		this.attack = 0;
		this.defense = 0;
		this.image = "UNKnow";
		isAlive = false;
		setType(PlayType.values()[(int) (Math.random() * PlayType.values().length)]);
		position = new Point2D(300, 425);

	}

	public Maincharacter(Point2D position) {
		this();
		this.position = position;

	}

	public Maincharacter(String name, String description, double health, double maxHealth, double mana, double maxMana,
			double attack, double defense, String image) {

		this.name = name;
		this.description = description;
		this.health = health;
		this.maxHealth = maxHealth;
		this.mana = mana;
		this.maxMana = maxMana;
		this.attack = attack;
		this.defense = defense;
		isAlive = true;
		this.type = PlayType.values()[(int) (Math.random() * PlayType.values().length)];
		setImage(image);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image2) {
		this.image = image2;
	}

	public void updateIsAlive() {
		if (health > 0) {
			isAlive = true;
		} else
			isAlive = false;
	}

	public boolean isAlive() {
		updateIsAlive();
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
		if (health < 0) {
			this.health = 0;
		} else if (health > maxHealth) {
			this.health = maxHealth;
		} else {
			this.health = health;
		}
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		if (maxHealth < 0) {
			this.maxMana = 0;
			health = 0;
		} else if (maxMana < health){
			health = maxMana;
			this.maxHealth = maxHealth;
		} else {
			this.maxHealth = maxHealth;
		}
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		if (mana < 0) {
			this.mana = 0;
		} else if (mana > maxMana) {
			this.mana = maxMana;
		} else {
			this.mana = mana;
		}
	}

	public double getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(double maxMana) {
		if (maxMana < 0) {
			this.maxMana = 0;
			mana = 0;
		} else if (maxMana < mana){
			mana = maxMana;
			this.maxMana = maxMana;
		} else {
			this.maxMana = maxMana;
		}
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		if (attack < 0) {
			this.attack = 0;
		} else {
			this.attack = attack;
		}
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		if (defense < 0) {
			this.defense = 0;
		} else {
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

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

}
