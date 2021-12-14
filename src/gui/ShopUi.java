package gui;


import Player.Archer;
import Player.Assassin;
import Player.Healer;
import Player.Tank;
import entity.Player;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ShopUi extends StackPane {

	private boolean showing;
	

	public ShopUi() {
		this.setVisible(false);
		this.showing = false;
		final Label header = new Label("Shop");
		header.setTextFill((Paint) Color.WHITE);
		header.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 36));
		HBox allproduct = new HBox() ;
		
		
		
	}

	public void show() {
		if (this.showing) {
			return;
		}
		this.showing = true;
		this.setCursor(Cursor.DEFAULT);
		this.setVisible(true);
	}

	public void hide() {
		if (!this.showing) {
			return;
		}
		this.showing = false;
		this.setVisible(false);
	}

	public Player random(int k) {
		int i = (int) Math.random() * 3;
		switch (i) {
		case 0:
			return new Assassin(k);
		case 1:
			return new Healer(k);
		case 2:
			return new Archer(k);
		case 3:
			return new Tank(k);
		}
		return null;
	}
	
	
	
	

	
}
