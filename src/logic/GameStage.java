package logic;

import Monster.ArmorOrc;
import Monster.BossOrc;
import Monster.Orc;
import character.CharacterData;
import character.MonsterData;
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
	
	public static void resetStage() {
		MonsterData.allMonsterInField.clear();
	}
	
}
