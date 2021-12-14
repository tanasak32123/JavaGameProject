package Player;

import entity.Player;

public class Healer extends Player {

	private String nameSkill1;
	private String nameSkill2;

	public Healer(int level) {
		super("Nami", "This character has ability to heal your team.", 140 * condi(level), 140 * condi(level),
				140 * condi(level), 140 * condi(level), 10 * condi(level), 60 * condi(level), level);
		// TODO Auto-generated constructor stub
		nameSkill1 = "Sympathy";
		nameSkill2 = "Revive";
	}

	public boolean canSkill1() {
		if (mana < 15)
			return false;
		else
			return true;
	}

	public boolean canSkill2() {
		if (level < 3 || mana < 30)
			return false;
		else
			return true;
	}

	@Override
	public boolean useSkill1(Object o1) {
		if (o1 instanceof Player && canSkill1()) {
			Player player = (Player) o1;
			setMana(getMana() - 15);
			player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + 50));
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1 instanceof Player && canSkill2()) {
			Player player = (Player) o1;
			if (!player.isAlive()) {
				player.setHealth(player.getMaxHealth()*0.5);
				player.setMana(player.getMaxMana()*0.5);
				mana -= 30;
				return true;
			}
		}
		return false;
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

}
