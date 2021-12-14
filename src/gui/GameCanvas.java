package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Player.Archer;
import interfaces.IRenderable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import logic.RenderableHolder;


public class GameCanvas extends Canvas {
	private GraphicsContext gc;
	
	public GameCanvas() {
	        super();
	        this.gc = this.getGraphicsContext2D();
	        this.setWidth(1050);
	        this.setHeight(600); 
	        this.setup();
	        loop(0) ;
	    }
	
	public void setup() {
		Archer ard = new Archer(new Point2D(100,100)) ;
		RenderableHolder.getInstance().add(ard); 
	}
	
	public void loop (int stage) {
		
		draw() ;
	}
	
	private void draw() {
		drawBackground();
	    if(RenderableHolder.getInstance().getEntities()!=null) {
	        for(IRenderable obj: RenderableHolder.getInstance().getEntities()) {
	            obj.draw(this.gc);
	        }
	    }
	}
	
	private void update() {
//        if(RenderableHolder.getInstance().getGameObjects()!=null) {
//            for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
//                
//            }
//        }
    }
	
	private void drawBackground() {
		try (InputStream is = Files.newInputStream(Paths.get("res/bg_all.png"))) {
			Image img = new Image(is) ;
			img.re
			gc.drawImage(img,0,0);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
	}
}
