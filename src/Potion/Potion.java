package Potion;

public abstract class Potion {
	protected String name;
	protected String description;
	protected int price;
	protected boolean isEmpty;
	
	Potion(String name, String description,int price) {
		this.name = name;
		this.description = description;
		this.price = price;
		isEmpty = false;
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

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public abstract String toString();
}
