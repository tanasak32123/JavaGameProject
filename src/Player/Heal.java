package Player;

import java.lang.annotation.Retention;



import entity.Player;

public class Heal extends Player {

	
	public Heal(int level) {
		super("Heal", "Suppurt your team", 10 * condi(level), 10 * condi(level), 140 * condi(level),
				140 * condi(level), 140 * condi(level), 60 * condi(level), level);
		// TODO Auto-generated constructor stub
	}
	
	public boolean skill1(Player play) {
		if (getMana()<30) return false ;
		setMana(getMana()-30);
		play.setHealth(Math.min(play.getMaxHealth(), play.getHealth()+60));
		return true ;
		
	}
	
	public boolean skill
	
	

}
