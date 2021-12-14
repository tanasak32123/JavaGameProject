package character;

import java.util.ArrayList;

import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import entity.Player;

public class CharacterData {

	public static ArrayList<Player> allCharacter;
	public static ArrayList<Player> allChooseCharacter;
	
	public CharacterData() {
		Player tank = new Tank(1);
		Player archer = new Archer(1);
		Player healer = new Healer(1);
		Player assassin = new Assassin(1);
		
		allCharacter.add(tank);
		allCharacter.add(archer);
		allCharacter.add(healer);
		allCharacter.add(assassin);
	}
	
	public void addChooseCharacter(Player player) {
		allChooseCharacter.add(player);
		
	}
	
	
}
