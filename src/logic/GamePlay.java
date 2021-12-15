package logic;

import java.util.ArrayList;

import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import Potion.HealPotion;
import Potion.ManaPotion;
import Potion.Potion;
import entity.Player;
import character.CharacterData;

public class GamePlay {

	public static Player myChar ;
	public static ArrayList<Potion> myPotion = new ArrayList<>();
	public static int money;
	public static int healPotion;
	public static int manaPotion;

	public static void createGamePlay() {
		myChar = null ;
		myPotion = new ArrayList<>();
		money = 0;
		healPotion = 1;
		manaPotion = 0;
		myPotion.add(new HealPotion());
	}
	
//	public static boolean haveTank() {
//		if (myChar instanceof Tank) {
//			return true;
//		}
//		return false;
//	}
//	
//	public static Player findTank() {
//		if (myChar instanceof Tank) {
//			return myChar;
//		}
//		return null;
//	}
	
//	public static void addChooseCharacter(Player player) {
//		myChar = player ;
//		
//		CharacterData.updateAllChooseCharacter(player);
//	}
	
	public static void addPotion(Potion potion) {
		updateAddPotion(potion);
		myPotion.add(potion);
	}
	
	public static void updateCharacterPerTurn() {
		if (myChar instanceof Tank) {
			((Tank) myChar).updateIsTuant();
			((Tank) myChar).updateIsArmor();
		}
		if (myChar instanceof Assassin) {
			((Assassin) myChar).updateIsCheer();
		}
	}
	
	public static void updateAddPotion(Potion potion) {
		if (potion instanceof HealPotion) {
			healPotion += 1;
		}
		if (potion instanceof ManaPotion) {
			manaPotion += 1;
		}
	}
	
	public static boolean isAllCharacterDead() {
		myChar.updateIsAlive();
		if (myChar.isAlive()) {
			return false;
		}
		return true;
	}

	public static int getHealPotion() {
		return healPotion;
	}

	public static int getManaPotion() {
		return manaPotion;
	}

	public static int getMoney() {
		return money;
	}

	public static ArrayList<Potion> getMyPotion() {
		return myPotion;
	}

	public static Player getMyChar() {
		return myChar;
	}

}
