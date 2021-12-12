package Monster;

import entity.Monster;
import entity.Player;

public class MiniBoss extends Monster {

	public MiniBoss(int level) {
		super("MiniBoss", "", 180* condi(level), 180 * condi(level), 180* condi(level),
				180* condi(level), 120* condi(level), 100 * condi(level), level);
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
