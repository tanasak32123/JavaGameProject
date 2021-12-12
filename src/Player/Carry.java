package Player;

import entity.Monster;
import entity.Player;

public class Carry extends Player {
	
	
	public Carry(int level) {
		super("Carry","Have a lot of damge,but low Hp and def.",70*condi(level),70*condi(level),120*condi(level),120*condi(level),120*condi(level),30*condi(level),level);
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
