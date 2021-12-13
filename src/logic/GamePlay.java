package logic;

import java.util.ArrayList;

import Player.Assassin;
import Player.Tank;
import Potion.Potion;
import entity.Player;

public class GamePlay {

	protected static ArrayList<Player> myChar;
	protected static ArrayList<Potion> myPotion;
	protected static int money;

	public GamePlay() {
		myChar = new ArrayList<>();
		myPotion = new ArrayList<>();
		money = 0;
	}

	public void addCharacter(Player player) {
		myChar.add(player);
	}

	public void addPotion(Potion potion) {
		myPotion.add(potion);
	}

	public void updateCharacter() {
		for (Player player : myChar) {
			if (player instanceof Tank) {
				((Tank) player).updateIsArmor();
			}
			if (player instanceof Assassin) {
				((Assassin) player).updateIsCheer();
			}
		}
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
