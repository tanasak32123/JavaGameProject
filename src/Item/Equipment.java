package Item;

public abstract class Equipment {
	protected String name;
	protected String description;
	protected int price;
	protected boolean isEmpty;
	
	public Equipment() {
		name = "";
		description = "";
		price = 0;
		isEmpty = false;
	}
	
	public Equipment(String name,String description,int price) {
		this.name = name;
		this.description = description;
		this.price = price;
		isEmpty = false;
	}
	
	public String getName() {
		return name;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract String toString();

}
