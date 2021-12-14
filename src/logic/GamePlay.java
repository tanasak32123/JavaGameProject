package logic;

import java.util.ArrayList;

import Player.Assassin;
import Player.Tank;
import Potion.HealPotion;
import Potion.ManaPotion;
import Potion.Potion;
import entity.Player;

public class GamePlay {

	public static ArrayList<Player> myChar;
	public static ArrayList<Potion> myPotion;
	public static int levelAllChar = 1;
	public static int money;
	public static int healPotion;
	public static int manaPotion;

	public GamePlay() {
		myChar = new ArrayList<>();
		myPotion = new ArrayList<>();
		money = 0;
		healPotion = 1;
		manaPotion = 0;
		myPotion.add(new HealPotion());
	}

	public void addCharacter(Player player) {
		myChar.add(player);
	}

	public void addPotion(Potion potion) {
		myPotion.add(potion);
	}

	public static void updateCharacter() {
		for (Player player : myChar) {
			if (player instanceof Tank) {
				((Tank) player).updateIsArmor();
			}
			if (player instanceof Assassin) {
				((Assassin) player).updateIsCheer();
			}
			player.updateIsAlive();
			if (!player.isAlive()) {
				//do something when character die
				
				
				
				//
			}
		}
	}
	
	public static void updatePotion() {
		int healPotion = 0;
		int manaPotion = 0;
		for (Potion potion : myPotion) {
			if (potion instanceof HealPotion) {
				healPotion += 1;
			}
			if (potion instanceof ManaPotion) {
				manaPotion += 1;
			}
		}
		GamePlay.healPotion = healPotion;
		GamePlay.manaPotion = manaPotion;
	}
	

	public static ArrayList<Player> getMyChar() {
		return myChar;
	}
	public static void setMyChar(ArrayList<Player> myChar) {
		GamePlay.myChar = myChar;
	}
	public static int getMoney() {
		return money;
	}
	public static void setMoney(int money) {
		GamePlay.money = money;
	}
	public static ArrayList<Potion> getMyPotion() {
		return myPotion;
	}
	public static void setMyPotion(ArrayList<Potion> myPotion) {
		GamePlay.myPotion = myPotion;
	}
	
	
	

	public static boolean isAllCharacterDead() {
		boolean allDead = true;
		for (Player player : myChar) {
			if (player.isAlive()) {
				allDead = false;
			}
		}
		return allDead;
	}

	public static int getHealPotion() {
		return healPotion;
	}

	public static int getManaPotion() {
		return manaPotion;
	}

	

	

	


}
