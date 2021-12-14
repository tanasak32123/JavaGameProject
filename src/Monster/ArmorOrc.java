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
		super("Armor Orc","It is bigger one but not the biggest one.", 150, 150, 0, 0, 70, 30,"res/miniboss.png");
	}

	public void playerGetMoneyFromKilled() {
		GamePlay.money += 50;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext p0) {
		Image img  ;
		try (InputStream is = Files.newInputStream(Paths.get("res/miniboss.png"))) {
			img = new Image(is) ;
			p0.drawImage(img, position.getX(),position.getY());
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		
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
