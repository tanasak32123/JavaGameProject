package Item;

public abstract class Potion {
	protected String name;
	protected String description;
	protected boolean isUsed;
	
	Potion(String name, String description) {
		this.name = name;
		this.description = description;
		isUsed = false;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract String toString();
}
