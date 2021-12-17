package logic;

import Monster.ArmorOrc;
import Monster.BossOrc;
import Monster.Orc;
import Player.Assassin;
import Player.Tank;
import character.CharacterData;
import character.MonsterData;
import entity.Player;
import gui.ChooseMons;
import gui.Fighting;
import gui.GameCanvas;
import gui.WinnerUi;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import scene.FightingScene;
import scene.GameOverScene;
import scene.SceneHolder;
import scene.WinnerScene;
import Shop.Shop;
import application.Main;

public class GameStage {

	public static int stage = 0;
	public static int turn = 0;

	public static void changeturn(int t) {
		turn = t;
	}

	public static void updateturn() {
		switch (turn) {
		case 0: {
			changeturn(1);
			updateturn();
			break;

		}
		case 1: {
			(new AnimationTimer() {
				public void handle(final long now) {
					if (stage >= 10) {
						if (MonsterData.isAllMonsterInFieldDead()) {
							Main.sceneHolder.switchScene(new WinnerScene());
							this.stop();
						}
					} else if (MonsterData.isAllMonsterInFieldDead()) {
						updateGameStage();
						Main.sceneHolder.switchScene(new FightingScene());
					} else if (GameLogic.isselectemonster) {
						GameLogic.isselectemonster = false;
						this.stop();
					} else if (!GamePlay.myChar.isAlive()) {
						Main.sceneHolder.switchScene(new GameOverScene());
						this.stop();
					}

				}

			}).start();
			break;
		}
		case 2: {
			GameLogic.actionmons();
			changeturn(1);
			updateturn();
			break;
		}
		}
		if (GameCanvas.gc != null)
			GameCanvas.draw();
	}

	public static void updateGameStage() {
		GameLogic.endStage = false;
		resetToNewStage();
		switch (stage) {
		case 0: {

			break;
		}
		case 1: {
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
			break;
		}
		case 2: {
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
			break;
		}
		case 3: {
			resetToNewStage();
			// choose character and open shop
			GamePlay.myChar.leveup();

			//
			break;
		}
		case 4: {
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
//			Fighting.shop.show();
			break;
		}
		case 5: {
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new ArmorOrc());
			break;
		}
		case 6: {
			// choose character and open shop
			GamePlay.myChar.leveup();
			Shop.openShop();
			//
			break;
		}
		case 7: {
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new ArmorOrc());
			break;
		}
		case 8: {
			MonsterData.allMonsterInField.add(new ArmorOrc());
			MonsterData.allMonsterInField.add(new ArmorOrc());
			break;
		}
		case 9: {
			// choose character and open shop
			GamePlay.myChar.leveup();
			Shop.openShop();
			//
			break;
		}
		case 10: {
			MonsterData.allMonsterInField.add(new BossOrc());
			break;
		}
		}
	}

	public static void duringStage() {
		switch (stage) {
		case 1:
		case 2: {
			GameCanvas.draw();
			GameLogic.actionInTurnPhase();
		}
		case 3: {
			// enter finish button

			GameLogic.endStage = true;
		}
		case 4:
		case 5: {
			GameCanvas.draw();
			GameLogic.actionInTurnPhase();
		}
		case 6: {
			// enter finish button

			//
			GameLogic.endStage = true;
		}
		case 7:
		case 8: {
			GameCanvas.draw();
			GameLogic.actionInTurnPhase();
		}
		case 9: {
			// enter finish button

			//
			GameLogic.endStage = true;
		}
		case 10: {
			GameLogic.actionInTurnPhase();
		}
		}
	}

	public static void resetToNewStage() {
		MonsterData.allMonsterInField.clear();
	}

	public static void clearAllData() {
		MonsterData.allMonsterInField.clear();
		GamePlay.createGamePlay();
	}

	public static void restartToNewBegin() {
		// restart everything
		clearAllData();
		GameLogic.loser = false;
		GameLogic.endStage = false;
	}

}
