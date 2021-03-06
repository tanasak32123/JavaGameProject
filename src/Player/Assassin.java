package Player;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import entity.Monster;
import entity.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GamePlay;

public class Assassin extends Player {
	private String nameSkill1;
	private String nameSkill2;

	public Assassin(int level) {
		super("Ghostpunch", "This character is good character to choose first.", 130 * condi(level), 130 * condi(level),
				35 * condi(level), 35 * condi(level), 30 * condi(level), 20 * condi(level), level, "res/assassin3.png");
		// TODO Auto-generated constructor stub
		nameSkill1 = "Punch The Line";
		nameSkill2 = "Cheer Up";
		setPosition(new Point2D(400, 325));
	}

	public Assassin(Point2D point) {
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
		if (o1 instanceof Monster && canSkill1()) {
			Monster monster = (Monster) o1;
			setMana(getMana() - 15);
			int damage = (int) (this.getAttack() * ((Math.random() * 3)));
			if (damage > monster.getDefense()) {
				monster.setHealth(monster.getHealth() + monster.getDefense() - damage);
			}
			mana -= 15;
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		if (o1 instanceof Monster && canSkill2()) {
			Monster monster = (Monster) o1;
			monster.setHealth(monster.getHealth() - 150);
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
		try (InputStream is = Files.newInputStream(Paths.get("res/assassin3.png"))) {
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