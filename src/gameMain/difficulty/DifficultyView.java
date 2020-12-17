package gameMain.difficulty;

import gameMain.actor.BackgroundImage;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * View of the Difficulty screen.
 * Responsible for all the visuals of the screen.
 */

public class DifficultyView {
	
	/**
	 * All the visuals in the Difficulty Screen are created here.
	 * @param easyButton Easy mode for the game.
	 * @param mediumButton Medium mode for the game.
	 * @param hardButton Hard mode for the game.
	 * @param difficultyScene Represents the physical contents of Difficulty Screen.
	 * @param difficulty Pane for the DifficultyScreen
	 */
	
	public void mainScreen(Button easyButton, Button mediumButton, Button hardButton, Scene difficultyScene, Pane difficulty) {
		ObservableList<Node> addChildren = difficulty.getChildren();
		difficultyScene.getStylesheets().add("file:src/gameMain/styleSheet/mainMenuStyle.css");
		
		BackgroundImage logo = new BackgroundImage("file:src/media/pictures/gameLogo.png");
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutY(180);
		logo.setLayoutX(70);
		
		easyButton.setLayoutX(217);
		easyButton.setLayoutY(480);
		BackgroundImage easyImg = new BackgroundImage("file:src/media/pictures/easy.png");
		easyImg.setFitWidth(120);
		easyImg.setPreserveRatio(true);
		easyButton.setGraphic(easyImg);
		
		mediumButton.setLayoutX(215);
		mediumButton.setLayoutY(525);
		BackgroundImage mediumImg = new BackgroundImage("file:src/media/pictures/medium.png");
		mediumImg.setFitWidth(135);
		mediumImg.setPreserveRatio(true);
		mediumButton.setGraphic(mediumImg);
		
		hardButton.setLayoutX(217);
		hardButton.setLayoutY(570);
		BackgroundImage hardImg = new BackgroundImage("file:src/media/pictures/hard.png");
		hardImg.setFitWidth(115);
		hardImg.setPreserveRatio(true);
		hardButton.setGraphic(hardImg);

		addChildren.add(new BackgroundImage("file:src/media/pictures/backImageEdit.jpg"));
		addChildren.add(logo);
		addChildren.add(easyButton);
		addChildren.add(mediumButton);
		addChildren.add(hardButton);
	}
}
