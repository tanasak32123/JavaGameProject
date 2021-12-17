package scene;

import gui.MainMenu;
import gui.WinnerUi;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class WinnerScene extends Scene {
	private StackPane stackPane;

	private WinnerScene(final Parent root) {
		super(root);
	}

	public WinnerScene() {
		this((Parent) new StackPane());
		this.initialize();
	}

	private void initialize() {
		// this.setCursor(Cursor.NONE);
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.setPrefSize(700, 500);
		this.stackPane.getChildren().add(new WinnerUi());
	}
}
