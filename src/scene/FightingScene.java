package scene;


import application.SystemCache;
import character.MonsterData;
import gui.Fighting;
import gui.GameCanvas;

import gui.MainMenu;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import logic.GameLogic;

public class FightingScene extends Scene {
	
	private StackPane stackPane;
    
    private FightingScene(final Parent root) {
        super(root);
    }
    
    public FightingScene() {
        this((Parent)new StackPane());
        this.initialize();
    }
    
    private void initialize() {
        //this.setCursor(Cursor.NONE);
    	new MonsterData() ;
		new GameLogic() ;
	    this.setRoot((Parent)(this.stackPane = new StackPane()));
	    this.stackPane.setPrefSize(1050, 600); 
	    application.SystemCache.fight = new Fighting() ;
	    this.stackPane.getChildren().addAll(new GameCanvas(),SystemCache.fight);
    }
}
