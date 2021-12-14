package Player;

import entity.Player;

public class Healer extends Player {

	private String nameSkill1;
	private String nameSkill2;
	private boolean canSkill1;
	private boolean canSkill2;

	public Healer(int level) {
		super("Nami", "This character has ability to heal your team.", 140 * condi(level), 140 * condi(level),
				140 * condi(level), 140 * condi(level), 10 * condi(level), 60 * condi(level), level);
		// TODO Auto-generated constructor stub
		nameSkill1 = "Sympathy";
		nameSkill2 = "Revive";
		setCanSkill1();
		setCanSkill2();
	}

	public boolean isCanSkill1() {
		return canSkill1;
	}

	public void setCanSkill1() {
		if (mana < 15)
			canSkill1 = false;
		else
			canSkill1 = true;
	}

	public boolean isCanSkill2() {
		return canSkill2;
	}

	public void setCanSkill2() {
		if (level < 3 || mana < 30)
			canSkill2 = false;
		else
			canSkill2 = true;
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

	@Override
	public void useSkill1(Object o1) {
		if (o1 instanceof Player) {
			Player player = (Player) o1;
			setMana(getMana() - 15);
			player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + 50));
		}
	}

	@Override
	public void useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1 instanceof Player) {
			Player player = (Player) o1;
			player.setAlive(true);
			mana -= 30;
		}
	}

}
