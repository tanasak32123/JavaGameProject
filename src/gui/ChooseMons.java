package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Monster.Orc;
import character.MonsterData;
import entity.Monster;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameLogic;
import logic.GamePlay;
import logic.GameStage;

public class ChooseMons extends Pane {

	public ChooseMons() {
		this.setVisible(false);
		try (InputStream is = Files.newInputStream(Paths.get("res/d8un0f2-0bbc2229-4839-4936-86cf-b8652493c960.jpg"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(500);
			img.setFitHeight(150);
			this.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		this.setPrefSize(500, 150);
		int c = 0;
		for (Monster e : MonsterData.allMonsterInField) {
			Button g = new Button(e.getName() + " No : " + c);
			g.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 12));
			g.setPrefSize(100, 30);
			g.setTranslateX(30 + c * 120);
			g.setTranslateY(60);
			g.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {

					if (Fighting.selectedButton.getText().equals("Attack")) {
						GamePlay.myChar.attack(e);
						Fighting.ch.setVisible(false);
					} else if (Fighting.selectedButton.getText().equals("Skill1")) {
						GamePlay.myChar.useSkill1(e);
						Fighting.ch.setVisible(false);

					} else {
						GamePlay.myChar.useSkill2(e);
						Fighting.ch.setVisible(false);
					}
					if (!e.isAlive()) {
						g.setVisible(false);
					}
					GameStage.changeturn(2);
					GameStage.updateturn();
				}
			});
			this.getChildren().add(g);
			c++;
		}
	}

}
