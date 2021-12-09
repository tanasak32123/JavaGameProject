package Entity;

public abstract class Character {
	protected String name;
	protected String description;
	
	public Character(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}
