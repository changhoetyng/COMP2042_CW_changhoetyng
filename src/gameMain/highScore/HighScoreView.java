package gameMain.highScore;

import gameMain.actor.BackgroundImage;
import gameMain.mvcInterfaces.ViewInterface;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HighScoreView implements ViewInterface{
	private Button startButton;
	private Scene highScoreScene;
	
	public void mainScreen() {
		Pane mainMenu = new Pane();
		ObservableList<Node> addChildren = mainMenu.getChildren();
		highScoreScene = new Scene(mainMenu,600,800);
		highScoreScene.getStylesheets().add("file:src/gameMain/mainMenuStyle.css");
		
		startButton = new Button();
		startButton.setLayoutX(215);
		startButton.setLayoutY(650);
		BackgroundImage startImg = new BackgroundImage("file:src/media/pictures/start.png");
		startImg.setFitWidth(150);
		startImg.setPreserveRatio(true);
		startButton.setGraphic(startImg);
		
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
		
		addChildren.add(new BackgroundImage("file:src/media/pictures/backImageEdit.jpg"));
		addChildren.add(startButton);
		addChildren.add(hiScore);
		addChildren.add(yourScoreTitle);
	}
	
	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public Scene getHighScoreScene() {
		return highScoreScene;
	}

	public void setHighScoreScene(Scene highScoreScene) {
		this.highScoreScene = highScoreScene;
	}
	
	

	
}
