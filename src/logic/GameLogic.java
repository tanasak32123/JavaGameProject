package logic;

import character.MonsterData;
import entity.Maincharacter;
import entity.Monster;
import entity.Player;

public class GameLogic {
	
	public static int attack(Maincharacter character) {
	
		return 0;
	}

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
