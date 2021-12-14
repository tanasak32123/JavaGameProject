package Player;

import java.util.ArrayList;
import entity.Monster;
import entity.Player;

public class Archer extends Player {

	private String nameSkill1;
	private String nameSkill2;

	public Archer(int level) {
		super("Sylvanas", "This character has a lot of damge,but low hp and def.", 110 * condi(level),
				110 * condi(level), 30 * condi(level), 30 * condi(level), 40 * condi(level), 15 * condi(level), level);
		// TODO Auto-generated constructor stub
		nameSkill1 = "Make It Rain";
		nameSkill2 = "Hunt The Mark";
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
		// TODO Auto-generated method stub
		if (o1 instanceof ArrayList && canSkill1()) {
			@SuppressWarnings("unchecked")
			ArrayList<Monster> allMonster = (ArrayList<Monster>) o1;
			for (Monster monster : allMonster) {
				monster.setHealth(monster.getHealth() - 40);
			}
			mana -= 15;
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1 instanceof Monster && canSkill2()) {
			Monster monster = (Monster) o1;
			monster.setHealth(monster.getHealth() - 100);
			mana -= 30;
			return true;
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
