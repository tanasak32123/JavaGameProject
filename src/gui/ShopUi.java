package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import entity.Player;
import gui.CharacterMenu.Title;
import javafx.geometry.Pos;
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
		this.setVisible(false);
		this.showing = false;
		final Label header = new Label("Shop");
		header.setTextFill((Paint) Color.WHITE);
		header.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 36));
		HBox allproduct = new HBox() ;
		VBox charac = new Character(random(1)) ;
		
		
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

	public Player random(int k) {
		int i = (int) Math.random() * 3;
		switch (i) {
		case 0:
			return new Assassin(k);
		case 1:
			return new Healer(k);
		case 2:
			return new Archer(k);
		case 3:
			return new Tank(k);
		}
		return null;
	}
	
	private static class Character extends VBox {
		private Image image;

		public Character(Player play) {
			setImage(play.getImage());
			ImageView imagee = new ImageView(image);
			imagee.setFitWidth(150);
			imagee.setFitHeight(180);
			Button button = new Button() ;
			button.setGraphic(imagee);
//			button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
//			button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
//					CornerRadii.EMPTY,new BorderWidths(1))));

			getChildren().addAll(button, new Title(play));
		}

		public void setImage(String im) {
			try (InputStream is = Files.newInputStream(Paths.get(im))) {
				this.image = new Image(is);
			} catch (IOException e) {
				System.out.println("Couldn't load image");
			}
		}
	} 
	
	private static class Title extends VBox {
		public Title(Player play) {
			Text name = new Text(play.getName());
			Text atk = new Text("ATK : " + String.valueOf(play.getAttack()));
			Text def = new Text("DEF : " + String.valueOf(play.getDefense()));
			Text hp = new Text("HP : " + String.valueOf(play.getMaxHealth()));
			Text mana = new Text("MANA : " + String.valueOf(play.getMaxMana()));
			Text type = new Text("TYPE : " + String.valueOf(play.getType()));
			name.setFill(Color.BLACK);
			atk.setFill(Color.BLACK);
			def.setFill(Color.BLACK);
			hp.setFill(Color.BLACK);
			mana.setFill(Color.BLACK);
			type.setFill(Color.BLACK);
			name.setFont(Font.font("Helvetica", FontWeight.BLACK, 14));
			atk.setFont(Font.font("Helvetica", FontWeight.BLACK, 14));
			def.setFont(Font.font("Helvetica", FontWeight.BLACK, 14));
			hp.setFont(Font.font("Helvetica", FontWeight.BLACK, 14));
			mana.setFont(Font.font("Helvetica", FontWeight.BLACK, 14));
			type.setFont(Font.font("Helvetica", FontWeight.BLACK, 14));
			name.setTranslateX(40);
			atk.setTranslateX(5);
			def.setTranslateX(5);
			mana.setTranslateX(5);
			hp.setTranslateX(5);
			type.setTranslateX(5);
			
			
			this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			try (InputStream is = Files.newInputStream(Paths.get("res/depositphotos_82698376-stock-photo-watercolor-purple-background-for-text.jpg"))) {
				Image img = new Image(is) ;
				this.setBackground(new Background(new BackgroundImage(img, null, null, null,new BackgroundSize(300,120, isFocusTraversable(), isDisabled(), isDisable(), isCache())))) ;
			} catch (IOException e) {
				System.out.println("Couldn't load image");
			}
			getChildren().addAll(name, atk, def, hp, mana, type);

		}

	}
	
	

	
}
