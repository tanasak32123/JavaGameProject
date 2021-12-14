package logic;

import java.util.ArrayList;

import Player.Assassin;
import Player.Tank;
import Potion.HealPotion;
import Potion.ManaPotion;
import Potion.Potion;
import entity.Player;
import character.CharacterData;

public class GamePlay {

	public static ArrayList<Player> myChar;
	public static ArrayList<Potion> myPotion;
	public static int money;
	public static int healPotion;
	public static int manaPotion;

	public static void createGamePlay() {
		myChar = new ArrayList<>();
		myPotion = new ArrayList<>();
		money = 0;
		healPotion = 1;
		manaPotion = 0;
		myPotion.add(new HealPotion());
	}

	public void addChooseCharacter(Player player) {
		myChar.add(player);
		CharacterData.updateAllChooseCharacter(player);
	}

	public static void addPotion(Potion potion) {
		updatePotion(potion);
		myPotion.add(potion);
	}
	
	public static void updateCharacterPerTurn() {
		for (Player player : myChar) {
			if (player instanceof Tank) {
				((Tank) player).updateIsTuant();
				((Tank) player).updateIsArmor();
			}
			if (player instanceof Assassin) {
				((Assassin) player).updateIsCheer();
			}
		}
	}
	
	public static void updatePotion(Potion potion) {
		if (potion instanceof HealPotion) {
			healPotion += 1;
		}
		if (potion instanceof ManaPotion) {
			manaPotion += 1;
		}
	}
	
	public static boolean isAllCharacterDead() {
		for (Player player : myChar) {
			if (player.isAlive()) {
				return false;
			}
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

	public static ArrayList<Player> getMyChar() {
		return myChar;
	}

}
