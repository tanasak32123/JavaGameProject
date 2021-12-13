package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Fighting extends Pane  {
	
	public Fighting () {
		this.setPrefSize(1050, 600);
		try(InputStream is = Files.newInputStream(Paths.get("res/1-4-1024x576.jpg"))){
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		}
		catch(IOException e) {
			System.out.println("Couldn't load image");
		}
	}
	
	
	
	

}
