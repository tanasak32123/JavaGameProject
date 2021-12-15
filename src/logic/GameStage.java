package logic;

import Monster.ArmorOrc;
import Monster.BossOrc;
import Monster.Orc;
import Player.Assassin;
import Player.Tank;
import character.CharacterData;
import character.MonsterData;
import entity.Player;
import gui.GameCanvas;
import javafx.animation.AnimationTimer;
import Shop.Shop;

public class GameStage {

	public static int stage = 1;

//	public static void runGameStage() {
//		while (!GameLogic.winner && !GameLogic.loser) {
//			createGameStage();
//		}
//	}

//	public static void createGameStage() {
//		updateGameStage();
//		duringStage(stage);
//		if (GameLogic.winner) {
//			GameLogic.isWinner();
//		}
//		else {
//			GameLogic.endStage = false;
//			resetToNewStage();
//			stage += 1;
//		}
//	}

	public static void updateGameStage() {
		System.out.println(stage);
		switch (stage) {
//		case 0: {
//			// choose first character
//		
//			//
//			break;
//		}
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
			// choose character and open shop
			GamePlay.myChar.leveup();
			Shop.openShop();
			//
			break;
		}
		case 4: {
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
			MonsterData.allMonsterInField.add(new Orc());
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
		stage++;

	}

	public static void duringStage(int stage) {
		(new AnimationTimer() {
            public void handle(final long now) {
            	System.out.println("dqdqq");
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
    				this.stop();
    			}
    			}
    			System.out.println("fagfagaad122gag");
            }
        }).start();
		
		GameLogic.endStage = false;

		resetToNewStage();
	}

//	public static void resetPlayerToNewStage() {
//		if (GamePlay.myChar != null) {
//			for (Player player : GamePlay.myChar) {
//				if (!player.isAlive()) {
//					player.setHealth(player.getMaxHealth() * 0.2);
//					player.setMana(player.getMaxMana() * 0.5);
//				}
//				resetAbility(player);
//			}
//		}
//	}

	public static void resetAbility(Player player) {
		if (player instanceof Tank) {
			if (((Tank) player).isArmor()) {
				((Tank) player).setCooldownArmor(0);
				((Tank) player).updateIsArmor();
			}
			if (((Tank) player).isTaunt()) {
				((Tank) player).setTaunt(false);
				((Tank) player).setCooldownTaunt(0);
			}
		}
		if (player instanceof Assassin) {
			if (((Assassin) player).isCheer()) {
				((Assassin) player).setCooldownCheer(0);
				((Assassin) player).updateIsCheer();
			}
		}
	}

	public static void resetToNewStage() {
		resetAbility(GamePlay.myChar) ;
		MonsterData.allMonsterInField.clear();
	}

	public static void clearAllData() {
		MonsterData.allMonsterInField.clear();
//		CharacterData.allChooseCharacter.clear();
		GamePlay.createGamePlay();
	}

	public static void restartToNewBegin() {
		// restart everything
		clearAllData();
		GameLogic.loser = false;
		GameLogic.endStage = false;
	}

}
