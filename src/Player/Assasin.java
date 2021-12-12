package Player;

import entity.Monster;
import entity.Player;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;

public class Assasin extends Player {
	private boolean isAlive;
	private boolean isActive;
	
	
	public Assasin(int level) {
		super("Assasin", "Have a lot of damge,but low Hp.", 40 * condi(level), 40 * condi(level), 100 * condi(level),
				100 * condi(level), 100 * condi(level), 70 * condi(level), level,"res/assassin3.png");
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public boolean skill1(Monster mons, Player play) {
		if (getMana() < 50)
			return false;
		setMana(getMana() - 50);
		mons.setHealth(mons.getHealth() - this.getAttack());
		return true;
	}


	@Override
	public boolean skill2(Monster mons, Player play) {
		if (getMana()<10) return false ;
		int ran = (int) Math.random()*3 ;
		double damage ;
		if (ran==1) {
			damage = Math.max(0,this.getAttack()*1.75-mons.getDefense()) ;
		}else {
			damage = Math.max(0,this.getAttack()-mons.getDefense()) ;
		}mons.setHealth(getHealth()-damage);
		return true ;
	}
	
	

	
}
