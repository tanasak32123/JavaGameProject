package logic;

import Player.Tank;
import character.MonsterData;
import entity.Monster;
import entity.Player;

public class GameLogic {

	public static boolean loser = false;
	public static boolean winner = false;
	public static boolean endStage = false;

	public static void actionInTurnPhase() {

		while (!(endStage) && !(MonsterData.isAllMonsterInFieldDead()) && !(GamePlay.isAllCharacterDead())) {

			for (Player player : GamePlay.myChar) {
				player.doAction();
				if (MonsterData.isAllMonsterInFieldDead()) {
					// go next stage
					GameStage.createGameStage();
					endStage = true;
					if (GameStage.stage == 10) {
						winner = true;
					}
					break;
					//
				}
			}
			if (endStage) {
				break;
			}
			for (Monster monster : MonsterData.allMonsterInField) {
				if (GamePlay.haveTank()) {
					Player tank = GamePlay.findTank();
					if (((Tank) tank).isTaunt()) {
						monster.attack(tank);
					}
					else {
						monster.attackRandom();
					}
				} else {
					monster.attackRandom();
				}
				if (GamePlay.isAllCharacterDead()) {
					// restart menu

					loser = true;
					endStage = true;
					//
					break;
				}
			}
			if (endStage) {
				break;
			}
			GamePlay.updateCharacterPerTurn();
			
		}
	}

	public static void isLoser() {
		if (loser) {
			// show restart menu;

			//
			GameStage.restartToNewBegin();
		}
	}

	public static void isWinner() {
		if (winner) {
			// show image congratulation and return to menu

			//
		}
	}

}
