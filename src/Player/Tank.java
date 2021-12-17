package Player;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import character.MonsterData;
import entity.Monster;
import entity.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank extends Player {

	private String nameSkill1;
	private String nameSkill2;

	public Tank(int level) {
		super("Jotaro", "This is character is Big-Daddy.", 150 * condi(level), 150 * condi(level), 25 * condi(level),
				25 * condi(level), 30 * condi(level), 25 * condi(level), level, "res/Tank.png");
		nameSkill1 = "Swing";
		nameSkill2 = "Armor Up";
		setPosition(new Point2D(100, 100));
	}

	public Tank(Point2D point) {
		setPosition(point);
	}

	public boolean canSkill1() {
		if (mana < 10)
			return false;
		else
			return true;
	}

	public boolean canSkill2() {
		if (mana < 15)
			return false;
		else
			return true;
	}

	@Override
	public boolean useSkill1(Object o1) {
		// TODO Auto-generated method stub
		if (canSkill1()) {
			for (Monster monster : MonsterData.allMonsterInField) {
				monster.setHealth(monster.getHealth() - (attack * 2));
			}
			mana -= 10;
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1 instanceof Monster && canSkill2()) {
			Monster monster = (Monster) o1;
			monster.setHealth(monster.getHealth() - 40);
			for (Monster eachMonster : MonsterData.allMonsterInField) {
				eachMonster.setHealth(eachMonster.getHealth() - 60);
			}
			mana -= 15;
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
		try (InputStream is = Files.newInputStream(Paths.get("res/Tank.png"))) {
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