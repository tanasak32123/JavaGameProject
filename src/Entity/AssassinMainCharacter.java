package Entity;

public class AssassinMainCharacter extends MainCharacter {
	
	public AssassinMainCharacter(String name,String description,int atk,int def,int crit,int mana,int hp) {
		super(name,description,atk,def,crit,mana,hp);
	}
	
	public void useSkill(Character chooseCharacter) {
		this.attackTarget(chooseCharacter);
	}
	
	public void attackTarget(Character chooseCharacter) {
		setCurrentHp(currentHp - ((MainCharacter) chooseCharacter).getAtk());
	}
	
}
