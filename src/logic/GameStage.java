package logic;

import Monster.ArmorOrc;
import Monster.BossOrc;
import Monster.Orc;
import character.MonsterData;

public class GameStage {
	
	public static int stage = 0;
	
	public GameStage() {
		switch (stage) {
			case 0:
				//choose first character
				
				
				 
				//
				break;
			case 1: 
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new Orc());
				break;
			case 2: 
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new Orc());
				break;
			case 3: 
				//choose character and open shop
				
				
				GamePlay.levelAllChar += 1;
				//
				break;
			case 4: 
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new Orc());
				break;
			case 5: 
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new ArmorOrc());
				break;
			case 6: 
				//choose character and open shop
				
				
				
				GamePlay.levelAllChar += 1;
				//
				break;
			case 7: 
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new Orc());
				MonsterData.allMonster.add(new ArmorOrc());
				break;
			case 8: 
				MonsterData.allMonster.add(new ArmorOrc());
				MonsterData.allMonster.add(new ArmorOrc());
				break;
			case 9: 
				//choose character and open shop
				
				
				
				GamePlay.levelAllChar += 1;
				//
				break;
			case 10: 
				MonsterData.allMonster.add(new BossOrc());
				break;
			default:
				stage += 1;
				resetStage();
		}
	}
	
	public void resetStage() {
		MonsterData.allMonster.clear();
	}
	
}
