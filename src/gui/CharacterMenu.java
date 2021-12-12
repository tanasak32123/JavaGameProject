package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Player.Assasin;
import Player.Carry;
import Player.Heal;
import Player.Tank;
import entity.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.main;

public class CharacterMenu extends BorderPane {

	public CharacterMenu() {

		this.setPrefSize(1050, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/bg_all.png"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}

		ChooseCharacter ch = new ChooseCharacter("Choose your character");
		ch.setTranslateX(550);
		ch.setTranslateY(200);

		this.getChildren().addAll(ch);

	}

	private static class ChooseCharacter extends HBox {
		public ChooseCharacter(String name) {
			Text text = new Text(name);
			text.setFill(Color.DARKBLUE);
			text.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 24));

			setAlignment(Pos.TOP_CENTER);
			Character as = new Character(new Assasin(1));
			Character carry = new Character(new Carry(1));
			Character heal =  new Character(new Heal(1));
			Character tank =  new Character(new Tank(1));
			as.setTranslateX(10);

			getChildren().addAll( as, carry,text,heal,tank);
		}
	}

	private static class Statshow extends HBox {
		public Statshow() {

		}
	}

	private static class Character extends VBox {
		private Image image;

		public Character(Player play) {
			setImage(play.getImage());
			ImageView imagee = new ImageView(image);
			imagee.setFitWidth(150);
			imagee.setFitHeight(180);
			getChildren().addAll(imagee, new Title(play));
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
			name.setTranslateX(30);

			getChildren().addAll(name, atk, def, hp, mana, type);

		}

	}

}
