package Monster;

import entity.Monster;

public class MiniBoss extends Monster {

	public MiniBoss(int level) {
		super("MiniBoss", "", 180 * condi(level), 180 * condi(level), 180 * condi(level), 180 * condi(level),
				120 * condi(level), 100 * condi(level), level,"res/miniboss.png");
	}

}
