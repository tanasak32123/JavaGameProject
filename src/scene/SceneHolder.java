package scene;

import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.GamePlay;
import logic.GameStage;

public class SceneHolder {
	
	private Stage bindStage;
//    public CharaterMenuScene charactermenuscene;
    public MainMenuScene mainMenuScene;
    
    public SceneHolder(final Stage bindStage) {
        this.bindStage = bindStage;
    }
    
    public void initialize() {
        this.switchScene(this.mainMenuScene = new MainMenuScene());
//        this.switchScene(this.charactermenuscene = new CharaterMenuScene());
        
    }
    
    public void switchScene(final Scene nextScene) {
//    	GameStage.updateGameStage();
    	
		
        this.bindStage.setResizable(false);
        this.bindStage.setScene(nextScene);
        this.bindStage.sizeToScene();
    }
}
