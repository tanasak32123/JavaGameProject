package scene;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import gui.CharacterMenu;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

public class CharaterMenuScene extends Scene {

	private StackPane stackPane;

	private CharaterMenuScene(final Parent root) {
		super(root);
	}

	public CharaterMenuScene() {
		this((Parent) new StackPane());
		this.initialize();
	}

	private void initialize() {
		// this.setCursor(Cursor.NONE);
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.setPrefSize(1050, 600);
		this.stackPane.getChildren().add(new CharacterMenu());
	}

}
