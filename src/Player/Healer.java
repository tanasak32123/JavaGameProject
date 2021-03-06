package Player;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import character.MonsterData;
import entity.Monster;
import entity.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Healer extends Player {

	private String nameSkill1;
	private String nameSkill2;

	public Healer(int level) {
		super("Nami", "This character has ability to heal your team.", 170 * condi(level), 170 * condi(level),
				45 * condi(level), 45 * condi(level), 30 * condi(level), 10 * condi(level), level, "res/healer.png");
		// TODO Auto-generated constructor stub
		nameSkill1 = "Sympathy";
		nameSkill2 = "Revive";
		setPosition(new Point2D(100, 100));
	}

	public Healer(Point2D point) {
		setPosition(point);
	}

	public boolean canSkill1() {
		if (mana < 15)
			return false;
		else
			return true;
	}

	public boolean canSkill2() {
		if (mana < 30)
			return false;
		else
			return true;
	}

	@Override
	public boolean useSkill1(Object o1) {
		if (canSkill1()) {
			setMana(getMana() - 15);
			this.setHealth(Math.min(this.getMaxHealth(), this.getHealth() + 60));
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (canSkill2()) {
			for (Monster monster : MonsterData.allMonsterInField) {
				monster.setHealth(monster.getHealth() - 100);
			}
			mana -= 30;
			return true;
		}
		return false;
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

	@Override
	public void draw(GraphicsContext p0) {
		Image img;
		try (InputStream is = Files.newInputStream(Paths.get("res/healer.png"))) {
			img = new Image(is);
			p0.drawImage(img, position.getX(), position.getY());
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