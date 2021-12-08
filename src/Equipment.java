
public class Equipment {
	protected String name;
	protected String description;
	
	Equipment(String name,String description) {
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
