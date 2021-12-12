package Monster;

import entity.Monster;
import entity.Player;

public class Gigi extends Monster {

	public Gigi(int level) {
		super("Gigi", "Monster but it so easy to kill him", 20* condi(level), 20 * condi(level), 20 * condi(level),
				40 * condi(level), 20* condi(level), 20 * condi(level), level);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean skill1(Monster mons, Player play) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean skill2(Monster mons, Player play) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
