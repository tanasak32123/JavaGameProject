package Monster;

import entity.Monster;
import logic.GamePlay;

public class ArmorOrc extends Monster {

	public ArmorOrc() {
		super("Armor Orc","It is bigger one but not the biggest one.", 150, 150, 0, 0, 70, 30);
	}

	public void playerGetMoneyFromKilled() {
		GamePlay.money += 50;
	}
	
}
