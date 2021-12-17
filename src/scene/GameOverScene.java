package scene;

import gui.GameOver;
import gui.MainMenu;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class GameOverScene extends Scene {

	private StackPane stackPane;

	private GameOverScene(final Parent root) {
		super(root);
	}

	public GameOverScene() {
		this((Parent) new StackPane());
		this.initialize();
	}

	private void initialize() {
		// this.setCursor(Cursor.NONE);
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.setPrefSize(700, 500);
		this.stackPane.getChildren().add(new GameOver());
	}
}
