package gameMain.mainMenu;

import gameMain.actor.BackgroundImage;
import gameMain.mvcInterfaces.ViewInterface;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainMenuView implements ViewInterface{
	
	private Button startButton;
	private Button infoButton;
	private Scene mainMenuScene;
	public void mainScreen() {
		Pane mainMenu = new Pane();
		ObservableList<Node> addChildren = mainMenu.getChildren();
		mainMenuScene = new Scene(mainMenu,600,800);
		mainMenuScene.getStylesheets().add("file:src/gameMain/styleSheet/mainMenuStyle.css");
		
		BackgroundImage logo = new BackgroundImage("file:src/media/pictures/gameLogo.png");
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutY(180);
		logo.setLayoutX(70);
		
		startButton = new Button();
		startButton.setLayoutX(215);
		startButton.setLayoutY(480);
		BackgroundImage startImg = new BackgroundImage("file:src/media/pictures/start.png");
		startImg.setFitWidth(150);
		startImg.setPreserveRatio(true);
		startButton.setGraphic(startImg);
		
		infoButton = new Button();
		infoButton.setLayoutX(230);
		infoButton.setLayoutY(525);
		BackgroundImage infoImg = new BackgroundImage("file:src/media/pictures/info.png");
		infoImg.setFitWidth(115);
		infoImg.setPreserveRatio(true);
		infoButton.setGraphic(infoImg);
		
		addChildren.add(new BackgroundImage("file:src/media/pictures/backImageEdit.jpg"));
		addChildren.add(logo);
		addChildren.add(startButton);
		addChildren.add(infoButton);
	}
	
	public Button getInfoButton() {
		return infoButton;
	}

	public void setInfoButton(Button infoButton) {
		this.infoButton = infoButton;
	}

	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public Scene getMainMenuScene() {
		return mainMenuScene;
	}

	public void setMainMenuScene(Scene mainMenuScene) {
		this.mainMenuScene = mainMenuScene;
	}
	
	
}
