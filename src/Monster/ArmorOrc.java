package Monster;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import entity.Monster;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GamePlay;

public class ArmorOrc extends Monster {

	public ArmorOrc() {
		super("Armor Orc", "It is bigger one but not the biggest one.", 100, 100, 0, 0, 50, 15, "res/miniboss.png");
	}

	public void playerGetMoneyFromKilled() {
		GamePlay.money += 50;
	}

	@Override
	public void draw(GraphicsContext p0) {
		Image img;
		try (InputStream is = Files.newInputStream(Paths.get("res/miniboss.png"))) {
			img = new Image(is);
			p0.drawImage(img, position.getX(), position.getY());
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		p0.fillText(String.valueOf(this.getHealth()), position.getX(), position.getY());
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDestroy() {
		// TODO Auto-generated method stub
		return false;
	}

}
