package Monster;

import entity.Monster;
import entity.Player;
import javafx.scene.control.ProgressBar;

public class Boss extends Monster {

	public Boss() {
		super("Boss", "This guy so over power, kill him and get win",120,120, 200,200, 200,120, 1) ;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean skill1(Monster mons, Player play) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean skill2(Monster mons, Player play) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
