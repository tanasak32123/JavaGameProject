package gui;



import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import Shop.Shop;
import javax.management.InstanceAlreadyExistsException;

import Item.Accessory;
import Item.Armor;
import Item.Equipment;
import Item.Weapon;
import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import Potion.HealPotion;
import Potion.ManaPotion;
import entity.Player;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ShopUi extends StackPane {

	private boolean showing;
	

	public ShopUi() {
		this.setPrefSize(700, 300);
//		this.setVisible(true);
//		this.showing = true;
//		final Label header = new Label("Shop");
//		header.setTextFill((Paint) Color.WHITE);
//		header.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 36));
		HBox allproduct = new HBox() ;
		//heal
		VBox heal = new VBox() ;
		Button healb = new Button() ;
		HealPotion heao = new HealPotion();
		try (InputStream is = Files.newInputStream(Paths.get(heao.getImage()))) {
			ImageView imagr = new ImageView(new Image(is));
			imagr.setFitHeight(90);
			imagr.setFitWidth(60);
			healb.setGraphic(imagr);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}Text name_h = new Text("  Efect : "+heao.toString()+"\n  Price : 25 coin");
		heal.getChildren().addAll(healb,name_h); 
		//mana
		VBox manal = new VBox() ;
		Button manab = new Button() ;
		ManaPotion manao = new ManaPotion() ;
		try (InputStream is = Files.newInputStream(Paths.get(manao.getImage()))) {
			ImageView imagr = new ImageView(new Image(is));
			imagr.setFitHeight(90);
			imagr.setFitWidth(60);
			manab.setGraphic(imagr);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}Text name_m = new Text("  Efect : "+manao.toString()+"\n  Price : 25 coin");
		manal.getChildren().addAll(manab,name_m); 
		//
		Shop.openShop();
		Shop.EquipmentInShop.add(new Weapon("Wooden Sword", "It is useful in early stage.", 50, 10, 0,"res/wooden_sword.png"));
		Shop.EquipmentInShop.add(new Armor("Wooden Sheild", "It is useful in early stage.", 50, 0, 10,"res/wooden_shield.png"));
		Shop.EquipmentInShop.add(new Accessory("Weak Amulet", "It is useful in early stage.", 25, 5, 5,"res/weak_amulet.png"));
		for (Equipment e : Shop.EquipmentInShop) {
			allproduct.getChildren().add(new slotshop(e)) ;
		}
		allproduct.getChildren().addAll(manal,heal) ;
		this.getChildren().add(allproduct) ;
	}

	public void show() {
		if (this.showing) {
			return;
		}
		this.showing = true;
		this.setCursor(Cursor.DEFAULT);
		this.setVisible(true);
	}

	public void hide() {
		if (!this.showing) {
			return;
		}
		this.showing = false;
		this.setVisible(false);
	}

	private static class slotshop extends VBox {
		public slotshop(Equipment eqm) {
			Button slot = new Button() ;
			try (InputStream is = Files.newInputStream(Paths.get(eqm.getImage()))) {
				Image img = new Image(is) ;
				slot.setGraphic(new ImageView(img));
			} catch (IOException e) {
				System.out.println("Couldn't load image");
			}this.getChildren().addAll(slot,new Title(eqm)) ;
		}
	}
	
	private static class Title extends VBox {
		public Title(Equipment eqm) {
			Text stat1 = new Text() ;
			Text stat2 = new Text() ;
			Text name = new Text(eqm.getName()) ;
			Text price = new Text("Price : "+String.valueOf(eqm.getPrice()));
			if (eqm instanceof Weapon) {
				Weapon wea = (Weapon) eqm ;
				stat1.setText("BonusDamage : "+String.valueOf(wea.getDamage()));
				stat2.setText("HealthIncrease : "+String.valueOf(wea.getLifesteal()));
			}else if (eqm instanceof Accessory) {
				Accessory ace = (Accessory) eqm ;
				stat1.setText("BonusDamage : "+String.valueOf(ace.getBonusDamage()));
				stat2.setText("BonusDefense : "+String.valueOf(ace.getBonusDefense()));
			}else if (eqm instanceof Armor) {
				Armor ar = (Armor) eqm ;
				stat1.setText("BonusDamage : "+String.valueOf(ar.getBonusDamage()));
				stat2.setText("BonusDefense : "+String.valueOf(ar.getDefense()));
			}name.setTranslateX(20);
			stat1.setTranslateX(5);
			stat2.setTranslateX(5);
			name.setFont(Font.font("Helvetica", FontWeight.BLACK, 10));
			stat1.setFont(Font.font("Helvetica", FontWeight.BLACK, 10));
			stat2.setFont(Font.font("Helvetica", FontWeight.BLACK, 10));
			price.setFont(Font.font("Helvetica", FontWeight.BLACK, 10));
			this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			try (InputStream is = Files.newInputStream(Paths.get("res/depositphotos_82698376-stock-photo-watercolor-purple-background-for-text.jpg"))) {
				Image img = new Image(is) ;
				this.setBackground(new Background(new BackgroundImage(img, null, null, null,new BackgroundSize(90,50, isFocusTraversable(), isDisabled(), isDisable(), isCache())))) ;
			} catch (IOException e) {
				System.out.println("Couldn't load image");
			}
			getChildren().addAll(name,stat1,stat2,price);

		}

	}
	
	
		
	
	
	

	
}
