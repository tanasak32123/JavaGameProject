package Equipment;

public abstract class Item {
	protected String name;
	protected String description;
	
	Item(String name,String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public abstract String toString();
}
