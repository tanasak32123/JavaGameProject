package Player;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import entity.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank extends Player {

	private String nameSkill1;
	private String nameSkill2;
	private boolean isTaunt;
	private int cooldownTaunt;
	private boolean isArmor;
	private int cooldownArmor;

	public Tank(int level) {
		super("Jotaro", "This is character is Big-Daddy.", 150 * condi(level), 150 * condi(level), 25 * condi(level),
				25 * condi(level), 30 * condi(level), 25 * condi(level), level, "res/Tank.png");
		nameSkill1 = "Taunt";
		nameSkill2 = "Armor Up";
		isTaunt = false;
		cooldownTaunt = 0;
		isArmor = false;
		cooldownArmor = 0;
		setPosition(new Point2D(100, 100)) ;
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
		if (level < 3 || mana < 15)
			return false;
		else
			return true;
	}

	@Override
	public boolean useSkill1(Object o1) {
		// TODO Auto-generated method stub
		if (o1.equals(this) && canSkill1()) {
			isTaunt = true;
			cooldownTaunt = 2;
			mana -= 10;
			return true;
		}
		return false;
	}

	@Override
	public boolean useSkill2(Object o1) {
		// TODO Auto-generated method stub
		if (o1.equals(this) && canSkill2()) {
			isArmor = true;
			cooldownArmor = 2;
			setDefense(getDefense() + 15);
			mana -= 15;
			return true;
		}
		return false;
	}

	public void updateIsArmor() {
		if (cooldownArmor == 0) {
			if (isArmor) {
				setDefense(getDefense() - 50);
				isArmor = false;
			}
		} else {
			cooldownArmor -= 1;
		}
	}

	public void updateIsTuant() {
		if (cooldownTaunt == 0) {
			if (isTaunt) {
				isTaunt = false;
			}
		} else {
			cooldownTaunt -= 1;
		}
	}

	public String getNameSkill1() {
		return nameSkill1;
	}

	public String getNameSkill2() {
		return nameSkill2;
	}

	public boolean isTaunt() {
		return isTaunt;
	}

	public int getCooldownTaunt() {
		return cooldownTaunt;
	}

	public boolean isArmor() {
		return isArmor;
	}

	public void setArmor(boolean isArmor) {
		this.isArmor = isArmor;
	}

	public int getCooldownArmor() {
		return cooldownArmor;
	}

	public void setCooldownArmor(int cooldownArmor) {
		this.cooldownArmor = cooldownArmor;
	}

	public void setTaunt(boolean isTaunt) {
		this.isTaunt = isTaunt;
	}

	public void setCooldownTaunt(int cooldownTaunt) {
		this.cooldownTaunt = cooldownTaunt;
	}

	@Override
	public void draw(GraphicsContext p0) {
		Image img  ;
		try (InputStream is = Files.newInputStream(Paths.get("res/Tank.png"))) {
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