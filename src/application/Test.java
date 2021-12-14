package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.FightingScene;
import scene.SceneHolder;

public class Test extends Application {
public static SceneHolder sceneHolder ;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setScene(new FightingScene());
		primaryStage.show();
	}
	
	

	public static void main(String[] args) {
        launch((String[])args);
    }
}
