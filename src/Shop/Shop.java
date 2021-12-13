package Shop;

import java.util.ArrayList;
import Equipment.Accessory;
import Equipment.Armor;
import Equipment.Equipment;
import Equipment.Weapon;
import Potion.HealPotion;
import Potion.ManaPotion;
import Potion.Potion;
import logic.GamePlay;
import logic.GameStage;

public class Shop {
	private ArrayList<Equipment> EquipmentInShop;
	private ArrayList<Potion> PotionInShop;
	private int healPotion;
	private boolean hPotionEmpty;
	private int manaPotion;
	private boolean mPotionEmpty;
	
	public Shop() {
		EquipmentInShop = new ArrayList<>();
		PotionInShop = new ArrayList<>();
		
		switch (GameStage.stage) {
			case 1:
				Equipment weapon1 = new Weapon("Wooden Sword","It is useful in early stage.",50,15,0);
				Equipment armor1 = new Armor("Wooden Sheild","It is useful in early stage.",50,0,10);
				Equipment accessory1 = new Accessory("Amulet","It is useful in early stage.",50,10,5);
				break;
			case 2:	
				Equipment weapon2 = new Weapon("Wooden Sword","It is useful in early stage.",50,15,0);
				Equipment armor2 = new Armor("Wooden Sheild","It is useful in early stage.",50,0,10);
				Equipment accessory2 = new Accessory("Amulet","It is useful in early stage.",50,10,5);
				break;
			case 3:
				Equipment weapon3 = new Weapon("Wooden Sword","It is useful in early stage.",50,15,0);
				Equipment armor3 = new Armor("Wooden Sheild","It is useful in early stage.",50,0,10);
				Equipment accessory3 = new Accessory("Amulet","It is useful in early stage.",50,10,5);
				break;
		}
			
		Potion healPotion = new HealPotion();
		Potion manaPotion = new ManaPotion();
		
		EquipmentInShop.add(weapon1);
		EquipmentInShop.add(armor1);
		EquipmentInShop.add(accessory1);
		
		PotionInShop.add(healPotion);
		PotionInShop.add(manaPotion);
		
		this.healPotion = 2;
		this.manaPotion = 2;
		hPotionEmpty = false;
		mPotionEmpty = false;
	}
	
	public Shop(ArrayList<Equipment> EquipmentInShop,ArrayList<Potion> PotionInShop) {
		this.EquipmentInShop = EquipmentInShop;
		this.PotionInShop = PotionInShop;
	}
	
	public void buyItem(Object o1) {
		if (o1 instanceof Equipment) {
			Equipment equipment = (Equipment) o1;
			if (GamePlay.money >= equipment.getPrice()) {
				//do something more
				
				
				//
				GamePlay.money -= equipment.getPrice();
				removeItem(equipment);
			}
		}
		if (o1 instanceof Potion) {
			Potion potion = (Potion) o1;
			if (GamePlay.money >= potion.getPrice()) {
				GamePlay.myPotion.add(potion);
				GamePlay.money -= potion.getPrice();
				removeItem(potion);
			}
		}
		GamePlay.updatePotion();
	}
	
	public void addItem(Object ob) {
		if (ob instanceof Equipment) {
			EquipmentInShop.add((Equipment) ob);
		}
		if (ob instanceof Potion) {
			PotionInShop.add((Potion) ob);
		}
	}
	
	public void removeItem(Object o1) {
		if (o1 instanceof Equipment) {
			Equipment equipment = (Equipment) o1;
			equipment.setIsEmpty(true);
		}
		if (o1 instanceof Potion) {
			if (o1 instanceof HealPotion) {
				healPotion -= 1;
			}
			if (o1 instanceof ManaPotion) {
				healPotion -= 1;
			}
			updatePotionEmpty();
		}
	}

	public void updatePotionEmpty() {
		if (healPotion == 0) hPotionEmpty = true;
		if (manaPotion == 0) mPotionEmpty = true;
	}
	
	public ArrayList<Equipment> getEquipmentInShop() {
		return EquipmentInShop;
	}

	public ArrayList<Potion> getPotionInShop() {
		return PotionInShop;
	}

	public int getHealPotion() {
		return healPotion;
	}

	public int getManaPotion() {
		return manaPotion;
	}

	public boolean ishPotionEmpty() {
		return hPotionEmpty;
	}

	public boolean ismPotionEmpty() {
		return mPotionEmpty;
	}
	
}
