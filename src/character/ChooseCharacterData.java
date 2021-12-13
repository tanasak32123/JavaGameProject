package character;

import java.util.ArrayList;

import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import entity.Player;

public class ChooseCharacterData {

	public static ArrayList<Player> allChooseCharacter;
	
	public ChooseCharacterData() {
		Player tank = new Tank(1);
		Player archer = new Archer(1);
		Player healer = new Healer(1);
		Player assassin = new Assassin(1);
		
		allChooseCharacter.add(tank);
		allChooseCharacter.add(archer);
		allChooseCharacter.add(healer);
		allChooseCharacter.add(assassin);
	}
}
