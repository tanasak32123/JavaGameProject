package Potion;

public abstract class Potion {
	protected String name;
	protected String description;
	protected int price;
	
	Potion(String name, String description,int price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract String toString();
}
