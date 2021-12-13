package Player;

import java.util.ArrayList;
import entity.Monster;
import entity.Player;

public class Archer extends Player {

	private String nameSkill1;
	private String nameSkill2;
	private boolean canSkill1;
	private boolean canSkill2;

	public Archer(int level) {
		super("Sylvanas", "This character has a lot of damge,but low hp and def.", 110 * condi(level),
				110 * condi(level), 30 * condi(level), 30 * condi(level), 40 * condi(level), 15 * condi(level), level);
		// TODO Auto-generated constructor stub
		nameSkill1 = "Make It Rain";
		nameSkill2 = "Hunt The Mark";
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

	@Override
	public void useSkill1(Object o1) {
		// TODO Auto-generated method stub
		if (o1 instanceof ArrayList) {
			@SuppressWarnings("unchecked")
			ArrayList<Monster> allMonster = (ArrayList<Monster>) o1;
			for (Monster monster : allMonster) {
				monster.setHealth(monster.getHealth() - 40);
			}
			mana -= 15;
		}
	}

	@Override
	public void useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1 instanceof Monster) {
			Monster monster = (Monster) o1;
			monster.setHealth(monster.getHealth() - 100);
			mana -= 30;
		}
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

}
