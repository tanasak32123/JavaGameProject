package gui;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import entity.Player;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GamePlay;

public class Fighting extends Pane  {
	
	public Fighting () {
		this.setPrefSize(1050, 600);
		try(InputStream is = Files.newInputStream(Paths.get("res/bg_all.png"))){
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		}
		catch(IOException e) {
			System.out.println("Couldn't load image");
		}
		ActionBox acbox = new ActionBox() ;
		acbox.setTranslateX(50) ;
		acbox.setTranslateY(440) ;
		
		getChildren().addAll(acbox);
	}
	
	private static class ActionBox extends Pane {
		private Button atkbutton ;
		private Button skillbutton ;
		private Button itembutton ;
		public ActionBox() {
			this.setPrefSize(230, 150);
			try(InputStream is = Files.newInputStream(Paths.get("res/d8un0f2-0bbc2229-4839-4936-86cf-b8652493c960.jpg"))){
				ImageView img = new ImageView(new Image(is));
				img.setFitWidth(230);
				img.setFitHeight(150);
				this.getChildren().add(img);
			}
			catch(IOException e) {
				System.out.println("Couldn't load image");
			}
			atkbutton = new Button("Attack") ;
			skillbutton = new Button("Skill") ;
			itembutton = new Button("Items") ;
			atkbutton.setPrefSize(80,20 );
			skillbutton.setPrefSize(80,20 );
			itembutton.setPrefSize(80,20 );
			atkbutton.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12)) ;
			skillbutton.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12)) ;
			itembutton.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12)) ;
			atkbutton.setTranslateX(15);
			skillbutton.setTranslateX(15);
			itembutton.setTranslateX(15);
			atkbutton.setTranslateY(15);
			skillbutton.setTranslateY(45);
			itembutton.setTranslateY(75);
			atkbutton.setStyle("-fx-background-color: #25ff50");
			skillbutton.setStyle("-fx-background-color: #25ff50");
			itembutton.setStyle("-fx-background-color: #25ff50");
			
			this.setCacheShape(true) ;
			getChildren().addAll(atkbutton,skillbutton,itembutton);
			
		}
		
	}
	
	private static class StatBox extends Pane {
		private ArrayList<Player> chararcter ;
		
		public StatBox() {
			this.setPrefSize(500, 150);
			try(InputStream is = Files.newInputStream(Paths.get("res/d8un0f2-0bbc2229-4839-4936-86cf-b8652493c960.jpg"))){
				ImageView img = new ImageView(new Image(is));
				img.setFitWidth(230);
				img.setFitHeight(150);
				this.getChildren().add(img);
			}
			catch(IOException e) {
				System.out.println("Couldn't load image");
			}
			this.chararcter = new ArrayList<>(GamePlay.getMyChar()) ;
			for (Player e : chararcter) {
				
			}
		}
	}
	 
	private static class PotionBox extends Pane {
		
		
	}
	
	
	
	
	
	
	
	

}
