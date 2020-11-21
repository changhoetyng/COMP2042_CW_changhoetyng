package gameMain.highScore;

import java.io.IOException;
import java.util.ArrayList;

import gameMain.actor.BackgroundImage;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * View of the High Score screen.
 * Responsible for all the visuals of the screen.
 */

public class HighScoreView{
	
	/**
	 * All the visuals in the Main Menu Screen are created here.
	 * @param mainMenuButton Button that leads to main menu upon clicking.
	 * @param highScoreController High Score Controller
	 * @param score Current score
	 * @param highScore Pane for the High Score Screen
	 * @param highScoreScene Represents the physical contents of High Score Screen.
	 */
	
	public void mainScreen(Button mainMenuButton, HighScoreController highScoreController, int score, Pane highScore, Scene highScoreScene) {
		ObservableList<Node> addChildren = highScore.getChildren();
		highScoreScene.getStylesheets().add("file:src/gameMain/styleSheet/mainMenuStyle.css");
		
		mainMenuButton.setLayoutX(215);
		mainMenuButton.setLayoutY(650);
		BackgroundImage startImg = new BackgroundImage("file:src/media/pictures/mainMenu.png");
		startImg.setFitWidth(150);
		startImg.setPreserveRatio(true);
		mainMenuButton.setGraphic(startImg);
		
		BackgroundImage hiScore = new BackgroundImage("file:src/media/pictures/hiScoreTitle.png");
		hiScore.setFitWidth(450);
		hiScore.setPreserveRatio(true);
		hiScore.setLayoutY(180);
		hiScore.setLayoutX(70);
		
		BackgroundImage yourScoreTitle = new BackgroundImage("file:src/media/pictures/yourScoreTitle.png");
		yourScoreTitle.setFitWidth(250);
		yourScoreTitle.setPreserveRatio(true);
		yourScoreTitle.setLayoutY(30);
		yourScoreTitle.setLayoutX(45);
		
		BackgroundImage one = new BackgroundImage("file:src/media/pictures/one.png");
		one.setFitWidth(50);
		one.setPreserveRatio(true);
		one.setLayoutY(240);
		one.setLayoutX(70);
		
		BackgroundImage two = new BackgroundImage("file:src/media/pictures/two.png");
		two.setFitWidth(50);
		two.setPreserveRatio(true);
		two.setLayoutY(300);
		two.setLayoutX(70);
		
		BackgroundImage three = new BackgroundImage("file:src/media/pictures/three.png");
		three.setFitWidth(50);
		three.setPreserveRatio(true);
		three.setLayoutY(365);
		three.setLayoutX(70);
		
		BackgroundImage four = new BackgroundImage("file:src/media/pictures/four.png");
		four.setFitWidth(50);
		four.setPreserveRatio(true);
		four.setLayoutY(425);
		four.setLayoutX(70);
		
		BackgroundImage five = new BackgroundImage("file:src/media/pictures/five.png");
		five.setFitWidth(50);
		five.setPreserveRatio(true);
		five.setLayoutY(485);
		five.setLayoutX(70);

		addChildren.add(new BackgroundImage("file:src/media/pictures/backImageEdit.jpg"));
		addChildren.add(mainMenuButton);
		addChildren.add(hiScore);
		addChildren.add(yourScoreTitle);
		addChildren.add(one);
		addChildren.add(two);
		addChildren.add(three);
		addChildren.add(four);
		addChildren.add(five);
		highScoreController.writeScore(score,addChildren,360,30);
		try {
			ArrayList<Integer> list;
			list = highScoreController.getHighScore();
			int yShift = 0;
			for(Integer scored: list) {
				highScoreController.writeScore(scored,addChildren,200,245 + yShift);
				yShift += 62;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
