package character;

import java.util.ArrayList;

import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import entity.Player;

public class CharacterData {

	public static ArrayList<Player> allChooseCharacter;
	
	public static void createChooseCharacterData() {
		Player tank = new Tank(1);
		Player archer = new Archer(1);
		Player healer = new Healer(1);
		Player assassin = new Assassin(1);
		
		allChooseCharacter = new ArrayList<>();
		
		allChooseCharacter.add(tank);
		allChooseCharacter.add(archer);
		allChooseCharacter.add(healer);
		allChooseCharacter.add(assassin);
	}
	
	public static void updateAllChooseCharacter(Player player) {
		allChooseCharacter.remove(player);
		levelAllChar(allChooseCharacter);
	}
	
	public static void levelAllChar(ArrayList<Player> allChar) {
		for (Player player : allChar) {
			player.leveup();
		}
	}
}
