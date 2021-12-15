package Monster;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import entity.Monster;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GamePlay;

public class Orc extends Monster {

	public Orc() {
		super("Orc", "This is monster.It so easy to kill him.", 80, 80, 0, 0, 50, 10,"res/gigi.png");
		setPosition(new Point2D(100, 100)) ;
	}

	public Orc(Point2D point) {
		setPosition(point);
	}
	public void playerGetMoneyFromKilled() {
		GamePlay.money += 25;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext p0) {
		Image img  ;
		try (InputStream is = Files.newInputStream(Paths.get("res/gigi.png"))) {
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
