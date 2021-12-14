package Equipment;

import interfaces.InShop;

public abstract class Equipment implements InShop{
	protected String name;
	protected String description;
	protected int price;
	protected boolean soldOut;
	
	public Equipment() {
		name = "";
		description = "";
		price = 0;
		soldOut = false;
	}
	
	public Equipment(String name,String description,int price) {
		this.name = name;
		this.description = description;
		this.price = price;
		soldOut = false;
	}
	
	public void isSoldOut() {
		soldOut = true;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract String toString();

}
