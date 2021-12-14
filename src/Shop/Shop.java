package Shop;

import java.util.ArrayList;

import Item.Accessory;
import Item.Armor;
import Item.Equipment;
import Item.Weapon;
import Potion.HealPotion;
import Potion.ManaPotion;
import Potion.Potion;
import logic.GamePlay;
import logic.GameStage;

public class Shop {
	public static ArrayList<Equipment> EquipmentInShop;
	public static ArrayList<Potion> PotionInShop;
	public static int healPotion;
	public static int manaPotion;

	public static void openShop() {
		EquipmentInShop = new ArrayList<>();
		PotionInShop = new ArrayList<>();
		updateOpenShop();
	}

	public static void updateOpenShop() {

		switch (GameStage.stage) {
		case 3: {
			EquipmentInShop.add(new Weapon("Wooden Sword", "It is useful in early stage.", 50, 10, 0,"res/wooden_sword.png"));
			EquipmentInShop.add(new Armor("Wooden Sheild", "It is useful in early stage.", 50, 0, 10,"res/wooden_shield.png"));
			EquipmentInShop.add(new Accessory("Weak Amulet", "It is useful in early stage.", 25, 5, 5,"res/weak_amulet.png"));
			break;
		}
		case 6: {
			EquipmentInShop.add(new Weapon("Silver Sword", "It is useful in early stage.", 75, 15, 0,"res/Silver_sword.png"));
			EquipmentInShop.add(new Armor("Silver Sheild", "It is useful in early stage.", 75, 5, 10,"res/silver_shelid.png"));
			EquipmentInShop.add(new Accessory("Moderate Amulet", "It is useful in early stage.", 50, 10, 5,"res/moderate_amulet.png"));
			break;
		}
		case 9: {
			EquipmentInShop.add(new Weapon("Lifesteal Sword", "It is useful in early stage.", 100, 20, 20,"res/Lifesteal_sword.png"));
			EquipmentInShop.add(new Armor("Strong Sheild", "It is useful in early stage.", 75, 5, 20,"res/Strong_shelid.png"));
			EquipmentInShop.add(new Accessory("Strong Amulet", "It is useful in early stage.", 75, 10, 10,"res/Strong_amulet.png"));
			break;
		}
		}

		PotionInShop.add(new HealPotion());
		PotionInShop.add(new ManaPotion());

		healPotion = 2;
		manaPotion = 2;

	}

	public static void buyItem(Object o1) {
		if (o1 instanceof Equipment) {
			if (GamePlay.money >= ((Equipment) o1).getPrice()) {
				if (o1 instanceof Weapon) {
					//select to choose your character to get new weapon
					
					
					//
				}
				if (o1 instanceof Armor) {
					//select to choose your character to get new weapon
					
					
					//
				}
				if (o1 instanceof Accessory) {
					//select to choose your character to get new weapon
					
					
					//
				}
			}
		}
		if (o1 instanceof Potion) {
			if (GamePlay.money >= ((Potion) o1).getPrice()) {
				if (o1 instanceof HealPotion) {
					if (healPotion > 0) {
						healPotion -= 1;
						GamePlay.addPotion(new HealPotion());
					}
					if (healPotion == 0) {
						((HealPotion) o1).isSoldOut();
					}
				}
				if (o1 instanceof ManaPotion) {
					if (manaPotion > 0) {
						manaPotion -= 1;
						GamePlay.addPotion(new ManaPotion());
					}
					if (manaPotion == 0) {
						((ManaPotion) o1).isSoldOut();
					}
				}
			}
		}
	}

}
