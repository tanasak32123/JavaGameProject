package Player;

import entity.Monster;
import entity.Player;

public class Heal extends Player {

	public Heal(int level) {
		super("Heal", "Suppurt your team", 140 * condi(level), 140 * condi(level), 140 * condi(level), 140 * condi(level),
				10 * condi(level), 60 * condi(level), level,"res/healer.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean skill1(Monster mons, Player play) {
		if (getMana() < 30)
			return false;
		setMana(getMana() - 30);
		play.setHealth(Math.min(play.getMaxHealth(), play.getHealth() + 60));
		return true;
	}

	@Override
	public boolean skill2(Monster mons, Player play) {
		// TODO Auto-generated method stub
		return false;
	}

}
