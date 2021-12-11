package Player;

import entity.Monster;
import entity.Player;
import javafx.scene.control.ProgressBar;

public class Assasin extends Player {
	private boolean isAlive ;
	private boolean isActive ;
	
	

	public Assasin(int level) {
		super("Assasin","Have a lot of damge,but low Hp.",40*condi(level),40*condi(level),100*condi(level),100*condi(level),100*condi(level),70*condi(level),level);
		// TODO Auto-generated constructor stub
	}
	
	public boolean skill1(Monster mons) {//µ’∑–≈ÿ‡°√“– damage
		if (getMana()<50) return false ;
		setMana(getMana()-50);
		if 
		return true;
		
	}
	
	public boolean skill2(Monster mons) { //µ’∏√√¡¥“¡’‚Õ°“ µ‘¥§√‘50%
		return true
		
	}
	
	
	
	
	
	
	

}
