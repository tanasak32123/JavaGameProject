package logic;

import character.MonsterData;
import entity.Monster;
import entity.Player;

public class GameLogic {
	
	public static void actionInTurnPhase() {
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
