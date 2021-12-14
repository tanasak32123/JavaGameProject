package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import application.Main;
import constant.SoundHolder;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scene.CharaterMenuScene;



public class MainMenu extends Pane {
	
	private static Stage primaryStage ;

	public MainMenu () {
		this.setPrefSize(1050, 600);
		if(!SoundHolder.getInstance().bgm.isPlaying()) {
            SoundHolder.getInstance().bgm.play(0.2);
            SoundHolder.getInstance().bgm.setCycleCount(MediaPlayer.INDEFINITE);
        }

		
		
		try(InputStream is = Files.newInputStream(Paths.get("res/1-4-1024x576.jpg"))){
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		}
		catch(IOException e) {
			System.out.println("Couldn't load image");
		}
		
		Title title = new Title ("POD & NOON");
		title.setTranslateX(337.5);
		title.setTranslateY(100);
		
		MenuItem play = new MenuItem("PLAY" ) ;
		MenuItem exit = new MenuItem("EXIT") ;
		play.setOnMousePressed(event -> {
			 Scene choosechar = new CharaterMenuScene() ;
			 Main.sceneHolder.switchScene(choosechar);
			 
		});
		exit.setOnMousePressed(event -> {
			System.exit(99) ; 
		});
		MenuBox vbox = new MenuBox(play,exit);
	
		vbox.setTranslateX(420);
		vbox.setTranslateY(350);
		
		
		
		this.getChildren().addAll(title,vbox);
	}
	
	
	

	private static class Title extends StackPane{
		public Title(String name) {
			Rectangle bg = new Rectangle(375, 60);
			bg.setStroke(Color.BLACK);
			bg.setStrokeWidth(2);
			bg.setFill(null);
			
			Text text = new Text(name);
			text.setFill(Color.LIGHTBLUE);
			text.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 50));
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg,text);
		}
	}
	
	private static class MenuBox extends VBox{
		public MenuBox(MenuItem...items) {
			getChildren().add(createSeperator());
			
			for(MenuItem item : items) {
				getChildren().addAll(item, createSeperator());
			}
		}
		
		private Line createSeperator() {
			Line sep = new Line();
			sep.setEndX(210);
			sep.setStroke(Color.DARKGREY);
			return sep;
		}
		
	}
	

	private static class MenuItem extends StackPane{
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] { 
				new Stop(0, Color.DARKBLUE),
				new Stop(0.1, Color.BLACK),
				new Stop(0.9, Color.BLACK),
				new Stop(1, Color.DARKBLUE)
				
			});
			
			Rectangle bg = new Rectangle(200,30);
			bg.setOpacity(0.4);
			
			Text text = new Text(name);
			text.setFill(Color.DARKGREY);
			text.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD,20));
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
				
			});
			
			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.DARKGREY);
			});
			setOnMousePressed(event -> {
				bg.setFill(Color.DARKVIOLET);
				
			});
			
			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});
			
			}
		}

}
