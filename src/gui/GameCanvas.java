package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import Monster.Orc;
import Player.Archer;
import Player.Assassin;
import application.SystemCache;
import character.MonsterData;
import entity.Monster;
import entity.Player;

import interfaces.IRenderable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.GamePlay;
import logic.GameStage;
import logic.RenderableHolder;

public class GameCanvas extends Canvas {
	public static GraphicsContext gc;

	public GameCanvas() {
		super();
		gc = this.getGraphicsContext2D();
		this.setWidth(1050);
		this.setHeight(600);
		this.setup();

	}

	public void setup() {
		GameStage.stage++;
		GameStage.updateGameStage();
		GameStage.changeturn(0);
		GameStage.updateturn();
	}

	public static void draw() {
		update();
		drawBackground();
		int x = 0, y = 0;
		GamePlay.myChar.setPosition(new Point2D(-50, 900));
		RenderableHolder.getInstance().add((IRenderable) GamePlay.myChar);
		if (MonsterData.allMonsterInField != null) {
			for (Monster e : MonsterData.allMonsterInField) {
				if (e.isAlive()) {
					e.setPosition(new Point2D(700 - x, 50 - y));
					RenderableHolder.getInstance().add((IRenderable) e);
					x += 100;
					y -= 100;
				}
			}
		}
		gc.setFill(Color.ALICEBLUE);
		gc.fillText("My Wallet : " + GamePlay.getMoney(), 10, 50);
		gc.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 24));

		if (RenderableHolder.getInstance().getEntities() != null) {
			for (IRenderable obj : RenderableHolder.getInstance().getEntities()) {
				obj.draw(gc);
			}
		}
		RenderableHolder.getInstance().getEntities().clear();
	}

	private static void update() {
		for (Iterator<Monster> iterator = MonsterData.allMonsterInField.iterator(); iterator.hasNext();) {
			Monster mons = iterator.next();
			if (!mons.isAlive()) {
				iterator.remove();
				mons.playerGetMoneyFromKilled();
			}
		}
		if (SystemCache.fight.titt != null) {
			SystemCache.fight.titt.hp
					.setText((int) GamePlay.myChar.getHealth() + "/" + (int) GamePlay.myChar.getMaxHealth());
			SystemCache.fight.titt.ma
					.setText((int) GamePlay.myChar.getMana() + "/" + (int) GamePlay.myChar.getMaxMana());
			SystemCache.fight.titt.na.setText(GamePlay.myChar.getName());
			SystemCache.fight.titt.atk.setText(String.valueOf((int) GamePlay.myChar.getAttack()));
			SystemCache.fight.titt.def.setText(String.valueOf((int) GamePlay.myChar.getDefense()));
		}

	}

	private static void drawBackground() {
		try (InputStream is = Files.newInputStream(Paths.get("res/bg_all.png"))) {
			Image img = new Image(is, 1050, 600, false, false);
			gc.drawImage(img, 0, 0);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
	}

}
