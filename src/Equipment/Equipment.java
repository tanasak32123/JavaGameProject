package Equipment;

public abstract class Equipment {
	protected String name;
	protected String description;
	
	public Equipment() {
		name = "";
		description = "";
	}
	
	public Equipment(String name,String description) {
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
