package Monster;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import entity.Monster;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BossOrc extends Monster {

	public BossOrc() {
		super("Durotan", "This guy so over power, kill him and you will be the winner.",300,300, 0,0, 70,40,"res/boss1.png") ;
		// TODO Auto-generated constructor stub
	}
	
	public void playerGetMoneyFromKilled() {
		
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext p0) {
		Image img  ;
		try (InputStream is = Files.newInputStream(Paths.get("res/boss1.png"))) {
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
