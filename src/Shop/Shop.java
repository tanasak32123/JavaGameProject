package Shop;

import java.util.ArrayList;
import Equipment.Equipment;
import Potion.Potion;

public class Shop {
	private ArrayList<Equipment> EquipmentInShop;
	private ArrayList<Potion> PotionInShop;
	
	public Shop() {
		EquipmentInShop = new ArrayList<>();
		PotionInShop = new ArrayList<>();
	}
	
	public Shop(ArrayList<Equipment> EquipmentInShop,ArrayList<Potion> PotionInShop) {
		this.EquipmentInShop = EquipmentInShop;
		this.PotionInShop = PotionInShop;
	}
	
	public void addItem(Object ob) {
		if (ob instanceof Equipment) {
			EquipmentInShop.add((Equipment) ob);
		}
		if (ob instanceof Potion) {
			PotionInShop.add((Potion) ob);
		}
	}

	public ArrayList<Equipment> getEquipmentInShop() {
		return EquipmentInShop;
	}

	public ArrayList<Potion> getPotionInShop() {
		return PotionInShop;
	}
	
}
