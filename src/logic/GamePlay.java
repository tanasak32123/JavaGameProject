package logic;

import java.util.ArrayList;

import Potion.Potion;
import entity.Player;

public class GamePlay {
	
	protected static ArrayList<Player> myChar ;
	protected static int money ;
	protected static ArrayList<Potion> myPotion ;
	
	
	
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
	
	
	

	
}
