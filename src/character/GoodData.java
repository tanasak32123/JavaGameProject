package character;

public class GoodData {
	
	public String imageID;
    public String name;
    public String description;
    public int maxHealth;
    public int curHealth ;
    public int attack;
    public double defense;
    public int maxMana;
    public int skillManaUse;
    public int curMana ;
    
    public GoodData(final String[] data) {
        this.imageID = data[0];
        this.name = data[1];
        this.description = data[2];
        this.maxHealth = Integer.parseInt(data[3]);
        this.curHealth = Integer.parseInt(data[4]);
        this.attack = Integer.parseInt(data[5]);
        this.defense = Double.parseDouble(data[6]);
        this.maxMana = Integer.parseInt(data[7]);
        this.skillManaUse = Integer.parseInt(data[8]);
        this.curHealth = Integer.parseInt(data[9]);
    }

}
