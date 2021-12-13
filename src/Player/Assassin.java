package Player;

import java.util.ArrayList;

import entity.Monster;
import entity.Player;
import javafx.scene.control.ProgressBar;

public class Assassin extends Player {
	private String nameSkill1;
	private String nameSkill2;
	private boolean canSkill1;
	private boolean canSkill2;

	public Assassin(int level) {
		super("Ghostpunch", "This character is good character to choose first.", 130 * condi(level), 130 * condi(level),
				35 * condi(level), 35 * condi(level), 30 * condi(level), 20 * condi(level), level,"res/assassin.png");
		// TODO Auto-generated constructor stub
		nameSkill1 = "Punch The Line";
		nameSkill2 = "Cheer Up";
		setCanSkill1();
		setCanSkill2();
	}

	@Override
	public String toString() {
		return "Assassin [nameSkill1=" + nameSkill1 + ", nameSkill2=" + nameSkill2 + ", canSkill1=" + canSkill1
				+ ", canSkill2=" + canSkill2 + "]";
	}

	public boolean isCanSkill1() {
		return canSkill1;
	}

	public void setCanSkill1() {
		if (mana < 15)
			canSkill2 = false;
		else
			canSkill2 = true;
	}

	public boolean isCanSkill2() {
		return canSkill2;
	}

	public void setCanSkill2() {
		if (level < 3 || mana < 20)
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
		if (o1 instanceof Monster) {
			Monster monster = (Monster) o1;
			setMana(getMana() - 15);
			monster.setHealth(monster.getHealth() - (this.getAttack() * ((int) (Math.random() * 3))));
			mana -= 15;
		}
	}

	@Override
	public void useSkill2(Object o1) {
		if (o1 instanceof ArrayList) {
			@SuppressWarnings("unchecked")
			ArrayList<Player> allPlayer = (ArrayList<Player>) o1;
			for (Player p : allPlayer) {
				p.setAttack(p.getAttack() + 25);
			}
			mana -= 20;
		}
		/*
		 * int ran = (int) Math.random() * 3; double damage; if (ran == 1) { damage =
		 * Math.max(0, this.getAttack() * 1.75 - mons.getDefense()); } else { damage =
		 * Math.max(0, this.getAttack() - mons.getDefense()); }
		 * mons.setHealth(getHealth() - damage);
		 */
	}
}
