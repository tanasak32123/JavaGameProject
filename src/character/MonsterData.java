package character;

import java.util.ArrayList;
import entity.Monster;

public class MonsterData {
	
	public static ArrayList<Monster> allMonsterInField;
	
	public static boolean isAllMonsterInFieldDead() {
		boolean allDeath = true;
		for (Monster monster : allMonsterInField) {
			if (monster.isAlive()) {
				allDeath = false;
			}
		}
		return allDeath;
	}

	public static ArrayList<Monster> getAllMonsterInField() {
		return allMonsterInField;
	}

}
