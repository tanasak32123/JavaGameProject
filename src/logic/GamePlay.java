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

	public static Player myChar;
	public static int money;

	public static void createGamePlay() {
		money = 0;
	}

	public static boolean isAllCharacterDead() {
		myChar.updateIsAlive();
		if (myChar.isAlive()) {
			return false;
		}
		return true;
	}

	public static void setMyChar(Player myChar) {
		GamePlay.myChar = myChar;
	}

	public static void setMoney(int money) {
		GamePlay.money = money;
	}

	public static int getMoney() {
		return money;
	}

	public static Player getMyChar() {
		return myChar;
	}

}
