package Player;

import java.util.ArrayList;
import entity.Monster;
import entity.Player;
import logic.GamePlay;

public class Assassin extends Player {
	private String nameSkill1;
	private String nameSkill2;
	private boolean canSkill1;
	private boolean canSkill2;
	private boolean isCheer;
	private int cooldownCheer;

	public Assassin(int level) {
		super("Ghostpunch", "This character is good character to choose first.", 130 * condi(level), 130 * condi(level),
				35 * condi(level), 35 * condi(level), 30 * condi(level), 20 * condi(level), level);
		// TODO Auto-generated constructor stub
		nameSkill1 = "Punch The Line";
		nameSkill2 = "Cheer Up";
		setCanSkill1();
		setCanSkill2();
		isCheer = false;
		cooldownCheer = 0;
	}

	public void setCanSkill1() {
		if (mana < 15)
			canSkill2 = false;
		else
			canSkill2 = true;
	}

	public void setCanSkill2() {
		if (level < 3 || mana < 20)
			canSkill2 = false;
		else
			canSkill2 = true;
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
			isCheer = true;
			cooldownCheer = 2;
			mana -= 20;
		}
	}

	public void updateIsCheer() {
		if (cooldownCheer == 0) {
			if (isCheer) {
				for (Player player : GamePlay.getMyChar()) {
					player.setAttack(player.getAttack() - 25);
				}
				isCheer = false;
			}
		}
		else {
			cooldownCheer -= 1;
		}
	}
	
	public boolean isCanSkill1() {
		return canSkill1;
	}

	public boolean isCanSkill2() {
		return canSkill2;
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

	public boolean isCheer() {
		return isCheer;
	}

	public int getCooldownCheer() {
		return cooldownCheer;
	}

}
