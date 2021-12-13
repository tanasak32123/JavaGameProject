package gui;


import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class ShopUi extends StackPane{
	
	private boolean showing;
    private VBox shopVBox;

    public ShopUi() {
    	this.shopVBox = new VBox();
        this.setVisible(false);
        this.showing = false;
        this.shopVBox.setAlignment(Pos.CENTER);
        final Label header = new Label("Shop");
        header.setTextFill((Paint)Color.WHITE);
        header.setFont();
        
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

}
