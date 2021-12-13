package main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import gui.CharacterMenu;
import gui.Fighting;
import gui.MainMenu;
import javafx.application.*;
import javafx.stage.*;
import scene.SceneHolder;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;

public class main extends Application{
	public static SceneHolder sceneHolder ;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Scene scene = new Scene(new Fighting());
//		(this.sceneHolder = new SceneHolder(primaryStage)).initialize(); 
		primaryStage.setTitle("POD AND NOON");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	public static void main(String[] args) {
		
		launch(args);
	}
}
