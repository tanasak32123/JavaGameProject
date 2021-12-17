package Item;

import interfaces.InShop;

public abstract class Equipment implements InShop {
	protected String name;
	protected String description;
	protected int price;
	protected boolean soldOut;
	protected String image;

	public Equipment() {
		name = "";
		description = "";
		price = 0;
		soldOut = false;
		image = "res/white.jpg";
	}

	public Equipment(String name, String description, int price, String image) {
		this.name = name;
		this.description = description;
		this.price = price;
		soldOut = false;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public boolean isSoldOut() {
		return soldOut;
	}

	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public abstract String toString();

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
