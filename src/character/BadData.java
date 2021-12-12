package character;

public class BadData {
	
	public String imageID;
    public String name;
    public String description;
    public int maxHealth;
    public int attack;
    public int  defense;
    public int maxMana;
    public int skillManaUse;
    
    public BadData(final String[] data) {
    	this.imageID = data[0];
        this.name = data[1];
        this.description = data[2];
        this.maxHealth = Integer.parseInt(data[3]);
        this.attack = Integer.parseInt(data[4]);
        this.defense = Integer.parseInt(data[5]);
        this.maxMana = Integer.parseInt(data[6]);
        this.skillManaUse = Integer.parseInt(data[7]);
    }

}
