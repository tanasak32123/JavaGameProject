package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Monster.Orc;
import Player.Archer;
import Player.Assassin;
import character.MonsterData;
import entity.Monster;
import entity.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.GamePlay;

public class Fighting extends Pane {
	public static Pane ch;
	public static ShopUi shop;
	public static Button selectedButton;
	public static tit titt;
	public static WinnerUi win;

	public Fighting() {
		win = new WinnerUi();
		ch = new ChooseMons();
		shop = new ShopUi();
		this.setPrefSize(1050, 600);
		ActionBox acbox = new ActionBox();
		acbox.setTranslateX(50);
		acbox.setTranslateY(440);
		ch.setTranslateX(275);
		ch.setTranslateY(205);
		Pane sta = new StatBox();
		sta.setTranslateX(525);
		sta.setTranslateY(440);
		getChildren().addAll(shop, acbox, ch, sta);
	}

	private static class ActionBox extends Pane {
		private Button atkbutton;
		private Button skill1button;
		private Button skill2button;
		private Button shopp;

		public ActionBox() {

			this.setPrefSize(200, 150);
			try (InputStream is = Files
					.newInputStream(Paths.get("res/d8un0f2-0bbc2229-4839-4936-86cf-b8652493c960.jpg"))) {
				ImageView img = new ImageView(new Image(is));
				img.setFitWidth(230);
				img.setFitHeight(150);
				this.getChildren().add(img);
			} catch (IOException e) {
				System.out.println("Couldn't load image");
			}
			atkbutton = new Button("Attack");
			skill1button = new Button("Skill1");
			skill2button = new Button("Skill2");
			shopp = new Button("Shopee");
			shopp.setPrefSize(80, 20);
			atkbutton.setPrefSize(80, 20);
			skill1button.setPrefSize(80, 20);
			skill2button.setPrefSize(80, 20);
			shopp.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12));
			atkbutton.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12));
			skill1button.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12));
			skill2button.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12));
			atkbutton.setTranslateX(15);
			shopp.setTranslateX(130);
			shopp.setTranslateY(110);
			skill1button.setTranslateX(15);
			skill2button.setTranslateX(15);
			atkbutton.setTranslateY(15);
			skill1button.setTranslateY(45);
			skill2button.setTranslateY(75);
			atkbutton.setStyle("-fx-background-color: #25ff50");
			skill1button.setStyle("-fx-background-color: #25ff50");
			skill2button.setStyle("-fx-background-color: #25ff50");
			shop.setStyle("-fx-background-color: #99ff99");
			atkbutton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					if (ch.isVisible()) {
						ch.setVisible(false);
					} else {
						selectedButton = atkbutton;
						ch.setVisible(true);
					}

				}
			});
			skill1button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					if (ch.isVisible()) {
						ch.setVisible(false);
					} else {
						selectedButton = skill1button;
						ch.setVisible(true);
					}

				}
			});
			skill2button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					if (ch.isVisible()) {
						ch.setVisible(false);
					} else {
						selectedButton = skill2button;
						ch.setVisible(true);
					}

				}
			});
			shopp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					if (shop.isVisible()) {
						shop.setVisible(false);
					} else {
						shop.setVisible(true);
					}
				}
			});

			this.setCacheShape(true);
			getChildren().addAll(atkbutton, skill1button, skill2button, shopp);

		}

	}

	private static class StatBox extends Pane {

		public StatBox() {
			this.setPrefSize(500, 150);
			try (InputStream is = Files
					.newInputStream(Paths.get("res/d8un0f2-0bbc2229-4839-4936-86cf-b8652493c960.jpg"))) {
				ImageView img = new ImageView(new Image(is));
				img.setFitWidth(460);
				img.setFitHeight(150);
				this.getChildren().add(img);
			} catch (IOException e) {
				System.out.println("Couldn't load image");
			}
			HBox ty = new HBox();
			Text g = new Text("Name          Health     Mana    Attack   Diffense");
			g.setFill(Color.WHITE);
			g.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
			g.setTranslateX(5);
			g.setTranslateY(20);
			ty.getChildren().add(g);
			titt = new tit(GamePlay.myChar);
			titt.setTranslateX(5);
			titt.setTranslateY(55);
			this.getChildren().addAll(ty, titt);

		}
	}

	public static class tit extends HBox {
		public static Text na;
		public static Text hp;
		public static Text ma;
		public static Text atk;
		public static Text def;

		public tit(Player o) {
			this.setPrefSize(400, 35);
			na = new Text(o.getName());
			hp = new Text((int) o.getHealth() + "/" + (int) o.getMaxHealth());
			ma = new Text((int) o.getMana() + "/" + (int) o.getMaxMana());
			atk = new Text(String.valueOf((int) o.getAttack()));
			def = new Text(String.valueOf((int) o.getDefense()));
			na.setFill(Color.WHITE);
			hp.setFill(Color.WHITE);
			ma.setFill(Color.WHITE);
			atk.setFill(Color.WHITE);
			def.setFill(Color.WHITE);
			atk.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
			def.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
			na.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
			hp.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
			ma.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
			this.setSpacing(25);
			this.getChildren().addAll(na, hp, ma, atk, def);
		}
	}

}
