package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import scene.MainMenuScene;

public class GameOver extends Pane {
	public GameOver() {
		this.setPrefSize(700, 500);
		Button goMenu = new Button("Back to MENU");
		try (InputStream is = Files.newInputStream(Paths.get("res/gameover.jpg"));
				InputStream ia = Files.newInputStream(Paths.get("res/CleanBlackground.jpg"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(700);
			img.setFitHeight(500);
			this.getChildren().add(img);
			goMenu.setBackground(new Background(new BackgroundImage(new Image(ia), null, null, null, null)));
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		goMenu.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 16));
		goMenu.setPrefSize(300, 60);
		goMenu.setTranslateX(200);
		goMenu.setTranslateY(400);
		goMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Main.sceneHolder.switchScene(new MainMenuScene());
			}
		});
		this.getChildren().add(goMenu);

	}

}
