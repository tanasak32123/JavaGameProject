package Potion;

import interfaces.InShop;

public abstract class Potion implements InShop {
	protected String name;
	protected String description;
	protected int price;
	protected boolean soldOut;
	protected String image;

	Potion(String name, String description, int price, String image) {
		this.name = name;
		this.description = description;
		this.price = price;
		soldOut = false;
		this.image = image;
	}

	public boolean isSoldOut() {
		return soldOut;
	}

	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public abstract String toString();
}
