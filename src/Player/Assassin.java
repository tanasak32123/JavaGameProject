package Player;

import java.util.ArrayList;
import entity.Monster;
import entity.Player;
import logic.GamePlay;

public class Assassin extends Player {
	private String nameSkill1;
	private String nameSkill2;
	private boolean isCheer;
	private int cooldownCheer;

	public Assassin(int level) {
		super("Ghostpunch", "This character is good character to choose first.", 130 * condi(level), 130 * condi(level),
				35 * condi(level), 35 * condi(level), 30 * condi(level), 20 * condi(level), level);
		// TODO Auto-generated constructor stub
		nameSkill1 = "Punch The Line";
		nameSkill2 = "Cheer Up";
		isCheer = false;
		cooldownCheer = 0;
	}

	public boolean canSkill1() {
		if (mana < 15)
			return false;
		else
			return true;
	}

	
	public boolean canSkill2() {
		if (level < 3 || mana < 20)
			return false;
		else
			return true;
	}

	@Override
	public boolean useSkill1(Object o1) {
		if (o1 instanceof Monster && canSkill1()) {
			Monster monster = (Monster) o1;
			setMana(getMana() - 15);
			int damage = (int)(this.getAttack() * ((Math.random() * 3)));
			if (damage > monster.getDefense()) {
				monster.setHealth(monster.getHealth() + monster.getDefense() - damage);
			}
			mana -= 15;
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		if (o1 instanceof ArrayList && canSkill2()) {
			@SuppressWarnings("unchecked")
			ArrayList<Player> allPlayer = (ArrayList<Player>) o1;
			for (Player p : allPlayer) {
				p.setAttack(p.getAttack() + 25);
			}
			isCheer = true;
			cooldownCheer = 2;
			mana -= 20;
			return true;
		}
		return false;
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
	
	public void setCheer(boolean isCheer) {
		this.isCheer = isCheer;
	}

	public void setCooldownCheer(int cooldownCheer) {
		this.cooldownCheer = cooldownCheer;
	}

}
