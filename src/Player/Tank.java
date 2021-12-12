package Player;

import entity.Monster;
import entity.Player;

public class Tank extends Player {

	public Tank(int level) {
		super("Tank", "Big dady",120* condi(level), 120 * condi(level), 100 * condi(level),
				100 * condi(level), 20 * condi(level), 120 * condi(level), level);
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
