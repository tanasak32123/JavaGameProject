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
	private static GraphicsContext gc;
	
	public GameCanvas() {
	        super();
	        gc = this.getGraphicsContext2D();
	        this.setWidth(1050);
	        this.setHeight(600); 
	        this.setup();
	        
	    }
	
	public void setup() {
//		GameStage.updateGameStage() ;
//		Archer ard = new Archer(new Point2D(100,100)) ;

//		RenderableHolder.getInstance().add(ard); 
		GameStage.duringStage(GameStage.stage);
		
	}
	
	
	public static void draw() {
		drawBackground();
		int x=0 ,y=0 ;
//		MonsterData.allMonsterInField.add(new Orc());
//		MonsterData.allMonsterInField.add(new Orc());
		GamePlay.myChar.setPosition(new Point2D(200, 325));
		RenderableHolder.getInstance().add((IRenderable) GamePlay.myChar);
		if (MonsterData.allMonsterInField!=null) {
			for (Monster e :MonsterData.allMonsterInField) {
				e.setPosition(new Point2D(725-x, 325-y));
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
	
	private void update() {
//        if(RenderableHolder.getInstance().getGameObjects()!=null) {
//            for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
//                
//            }
//        }
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
