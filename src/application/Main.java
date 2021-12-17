package application;

import gui.ChooseMons;
import gui.Fighting;
import gui.GameOver;
import gui.ShopUi;
import gui.WinnerUi;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.*;
import scene.SceneHolder;

public class Main extends Application {
	public static SceneHolder sceneHolder;

	@Override
	public void start(Stage primaryStage) throws Exception {

		new SystemCache();
		(this.sceneHolder = new SceneHolder(primaryStage)).initialize();
		primaryStage.setTitle("POD AND NOON");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch((String[]) args);
	}
}
