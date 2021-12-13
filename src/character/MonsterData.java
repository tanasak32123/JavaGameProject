package character;

import java.util.ArrayList;
import entity.Monster;

public class MonsterData {

	public static ArrayList<Monster> allMonster;

	public static boolean isAllMonsterDead() {
		boolean allDeath = true;
		for (Monster monster : allMonster) {
			if (monster.isAlive()) {
				allDeath = false;
			}
		}
		return allDeath;
	}
	
	public static ArrayList<Monster> getAllMonster() {
		return allMonster;
	}

}
