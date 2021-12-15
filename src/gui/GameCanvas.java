package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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
		GameStage.updateGameStage() ;
		GameStage.duringStage();
		GameStage.changeturn(0);
		GameStage.updateturn();
		
		
	}
	
	
	public static void draw() {
		update();
		System.out.println(GameStage.turn);
		

		drawBackground();
		int x=0 ,y=0 ;
//		MonsterData.allMonsterInField.add(new Orc());
//		MonsterData.allMonsterInField.add(new Orc());
		GamePlay.myChar.setPosition(new Point2D(200, 325));
		RenderableHolder.getInstance().add((IRenderable) GamePlay.myChar);
		if (MonsterData.allMonsterInField!=null) {
			for (Monster e :MonsterData.allMonsterInField) {
				e.setPosition(new Point2D(600-x, 250-y));
				RenderableHolder.getInstance().add((IRenderable)e);
				x -= 100 ; y+= 100 ;
			}	
		}
	
	    if(RenderableHolder.getInstance().getEntities()!=null) {
	        for(IRenderable obj: RenderableHolder.getInstance().getEntities()) {
	            obj.draw(gc);
	        }
	    }
	    RenderableHolder.getInstance().getEntities().clear(); 
	}
	
	private static void update() {
		if (MonsterData.allMonsterInField!=null) {
			for (Monster e :MonsterData.allMonsterInField) {
			
			}	
		}
		SystemCache.fight.titt
    }
	
	private static void drawBackground() {
		try (InputStream is = Files.newInputStream(Paths.get("res/bg_all.png"))) {
			Image img = new Image(is,1050,600,false,false) ;
			gc.drawImage(img,0,0);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
	}
}
