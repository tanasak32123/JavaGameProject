package Item;

public abstract class Equipment {
	protected String name;
	protected String description;
	protected int price;
	protected boolean isEmpty;
	protected String image ;
	
	
	public Equipment() {
		name = "";
		description = "";
		price = 0;
		isEmpty = false;
		image =  "res/white.jpg";
	}
	
	public Equipment(String name,String description,int price,String image) {
		this.name = name;
		this.description = description;
		this.price = price;
		isEmpty = false;
		this.image = image ;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
