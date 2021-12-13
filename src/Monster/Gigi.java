package Monster;

import entity.Monster;

public class Gigi extends Monster {

	public Gigi(int level) {
		super("Gigi", "Monster but it so easy to kill him", 20 * condi(level), 20 * condi(level), 20 * condi(level),
				40 * condi(level), 20 * condi(level), 20 * condi(level), level);
		// TODO Auto-generated constructor stub
	}

}
