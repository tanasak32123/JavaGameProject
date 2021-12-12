package Equipment;

public abstract class Equipment {
	protected String name;
	protected String description;
	protected int price;
	
	public Equipment() {
		name = "";
		description = "";
		price = 0;
	}
	
	public Equipment(String name,String description,int price) {
		this.name = name;
		this.description = description;
		this.price = price;
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
