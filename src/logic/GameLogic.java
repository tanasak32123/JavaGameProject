package logic;

import character.MonsterData;
import entity.Monster;
import entity.Player;

public class GameLogic {
	
	public static int attackMonster(Player player,Monster monster) {
		
		return 0;
	}

	public static void turnPhase() {
		while (!(MonsterData.isAllMonsterInFieldDead()) || !(GamePlay.isAllCharacterDead())) {
			for (Player player : GamePlay.myChar) {
				player.doAction();
			}
			
			for (Monster monster : MonsterData.allMonsterInField) {
				monster.attackRandom();
			}
		}

		if (MonsterData.isAllMonsterInFieldDead()) {
				
		}

		if (GamePlay.isAllCharacterDead()) {
			
		}
	}

}
