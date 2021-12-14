package application;

import gui.Fighting;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.*;
import scene.SceneHolder;


public class Main extends Application{
	public static SceneHolder sceneHolder ;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
//		Scene scene = new Scene(new Fighting());
		(this.sceneHolder = new SceneHolder(primaryStage)).initialize(); 
		primaryStage.setTitle("POD AND NOON");
//		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	public static void main(String[] args) {
        launch((String[])args);
    }
}
