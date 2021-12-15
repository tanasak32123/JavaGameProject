package character;

import java.util.ArrayList;
import entity.Monster;

public class MonsterData {
	
	public static ArrayList<Monster> allMonsterInField = new ArrayList<>();
	
	public static boolean isAllMonsterInFieldDead() {
		for (Monster monster : allMonsterInField) {
			if (monster.isAlive()) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Monster> getAllMonsterInField() {
		return allMonsterInField;
	}

}
