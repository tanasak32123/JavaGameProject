package Monster;

import entity.Monster;
import logic.GamePlay;

public class Orc extends Monster {

	public Orc() {
		super("Orc", "This is monster.It so easy to kill him.", 80, 80, 0, 0, 50, 10,"res/gigi.png");
		// TODO Auto-generated constructor stub
	}

	public void playerGetMoneyFromKilled() {
		GamePlay.money += 25;
	}
	
}
