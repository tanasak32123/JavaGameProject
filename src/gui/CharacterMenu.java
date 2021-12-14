package gui;



import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.text.Highlighter.HighlightPainter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import entity.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.main;

public class CharacterMenu extends BorderPane {

	public CharacterMenu() {

		this.setPrefSize(1050, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/bg_all.png"))) {
			Image img = new Image(is) ;
			this.setBackground(new Background(new BackgroundImage(img, null, null, null,new BackgroundSize(1050,600, isFocusTraversable(), isDisabled(), isDisable(), isCache())))) ;
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}

		ChooseCharacter ch = new ChooseCharacter("Choose your character");
		ch.setTranslateX(220);
		ch.setTranslateY(100);
		ch.setMaxHeight(300);
		ch.setMaxWidth(200) ;
		
		ch.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY,new BorderWidths(25))));
		
		Rectangle r = new Rectangle() ;
		r.setX(20);
		r.setY(80);
		r.setWidth(1010);
		r.setHeight(350);
		r.setArcWidth(20);
		r.setArcHeight(20);
		r.setOpacity(0.7) ;
		r.setFill(Color.WHITE) ;
		

		this.getChildren().addAll(r,ch);

	}

	private static class ChooseCharacter extends Pane {
		public ChooseCharacter(String name) {
			
			
			Text text = new Text(name);
			text.setFill(Color.DARKBLUE);
			text.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 24));

			
			Character as = new Character(new Assassin(1));
			Character carry = new Character(new Archer(1));
			Character heal =  new Character(new Healer(1));
			Character tank =  new Character(new Tank(1));
			this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY,new BorderWidths(25))));
			as.setTranslateX(-150);
			tank.setTranslateX(600);
			carry.setTranslateX(100);
			heal.setTranslateX(350);
			this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			text.setTranslateX(150);
			text.setTranslateY(-50);

			this.getChildren().addAll(text,as, carry,heal,tank);
		}
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
