package logic;

import Monster.ArmorOrc;
import Monster.BossOrc;
import Monster.Orc;
import Player.Assassin;
import Player.Tank;
import character.CharacterData;
import character.MonsterData;
import entity.Player;
import Shop.Shop;

public class GameStage {
	
	public static int stage = 0;
	
	public static void createGameStage() {
		updateGameStage();
	}
	
	public static void updateGameStage() {
		
		switch (stage) {
			case 0:
				//choose first character
				CharacterData.createChooseCharacterData();
				//
				break;
			case 1: 
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new Orc());
				break;
			case 2: 
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new Orc());
				break;
			case 3: 
				//choose character and open shop
				CharacterData.levelAllChar(GamePlay.myChar);
				Shop.openShop();
				//
				break;
			case 4: 
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new Orc());
				break;
			case 5: 
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new ArmorOrc());
				break;
			case 6: 
				//choose character and open shop
				CharacterData.levelAllChar(GamePlay.myChar);
				Shop.openShop();
				//
				break;
			case 7: 
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new Orc());
				MonsterData.allMonsterInField.add(new ArmorOrc());
				break;
			case 8: 
				MonsterData.allMonsterInField.add(new ArmorOrc());
				MonsterData.allMonsterInField.add(new ArmorOrc());
				break;
			case 9: 
				//choose character and open shop
				CharacterData.levelAllChar(GamePlay.myChar);
				Shop.openShop();
				//
				break;
			case 10: 
				MonsterData.allMonsterInField.add(new BossOrc());
				break;
			default:
				stage += 1;
				resetStage();
		}
		
	}
	
	public static void resetPlayerToNewStage() {
		for (Player player : GamePlay.myChar) {
			if (!player.isAlive()) {
				player.setHealth(player.getMaxHealth()*0.2);
				player.setMana(player.getMaxMana()*0.5);
			}
			resetAbility(player);
		}
	}
	
	public static void resetAbility(Player player) {
		if (player instanceof Tank) {
			if (((Tank) player).isArmor()) {
				((Tank) player).setArmor(false);
				((Tank) player).setCooldownArmor(0);
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
	
	public static void resetStage() {
		resetPlayerToNewStage();
		MonsterData.allMonsterInField.clear();
	}
	
}
