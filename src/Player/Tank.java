package Player;

import entity.Player;

public class Tank extends Player {

	private String nameSkill1;
	private String nameSkill2;
	private boolean canSkill1;
	private boolean canSkill2;
	private boolean isTaunt;
	private int cooldownTaunt;
	private boolean isArmor;
	private int cooldownArmor;

	public Tank(int level) {

		super("Jotaro", "This is character is Big-Daddy.", 150 * condi(level), 150 * condi(level), 25 * condi(level),
				25 * condi(level), 30 * condi(level), 30 * condi(level), level, "res/Tank.png");

		nameSkill1 = "Taunt";
		nameSkill2 = "Armor Up";
		isTaunt = false;
		cooldownTaunt = 0;
		isArmor = false;
		cooldownArmor = 0;
	}

	public void setCanSkill1() {
		if (mana < 10)
			canSkill1 = false;
		else
			canSkill1 = true;
	}

	public void setCanSkill2() {
		if (level < 3 || mana < 15)
			canSkill2 = false;
		else
			canSkill2 = true;

	}

	@Override
	public void useSkill1(Object o1) {
		// TODO Auto-generated method stub
		if (o1.equals(this)) {
			isTaunt = true;
			cooldownTaunt = 2;
			mana -= 10;
		}
	}

	@Override
	public void useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1.equals(this)) {
			isArmor = true;
			cooldownArmor = 2;
			setDefense(getDefense() + 50);
			mana -= 15;
		}
	}

	public void updateIsArmor() {
		if (cooldownArmor == 0) {
			if (isArmor) {
				setDefense(getDefense() - 50);
				isArmor = false;
			}
		} else {
			cooldownArmor -= 1;
		}
	}

	public void updateIsTuant() {
		if (cooldownTaunt == 0) {
			if (isTaunt) {
				isTaunt = false;
			}
		} else {
			cooldownTaunt -= 1;
		}
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

	public boolean isCanSkill1() {
		return canSkill1;
	}

	public boolean isCanSkill2() {
		return canSkill2;
	}

	public boolean isTaunt() {
		return isTaunt;
	}

	public int getCooldownTaunt() {
		return cooldownTaunt;
	}

	@Override
	public String toString() {
		return "Tank [nameSkill1=" + nameSkill1 + ", nameSkill2=" + nameSkill2 + ", canSkill1=" + canSkill1
				+ ", canSkill2=" + canSkill2 + ", isTaunt=" + isTaunt + ", cooldownTaunt=" + cooldownTaunt
				+ ", isArmor=" + isArmor + ", cooldownArmor=" + cooldownArmor + "]";
	}

}
