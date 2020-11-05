package p4_group_8_repo;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainMenuView {
	
	private Button startButton;
	private Scene mainMenuScene;
	public void createMainMenu() {
		Pane mainMenu = new Pane();
		ObservableList<Node> addChildren = mainMenu.getChildren();
		mainMenuScene = new Scene(mainMenu,600,800);
		mainMenuScene.getStylesheets().add("file:src/p4_group_8_repo/mainMenuStyle.css");
		
		BackgroundImage logo = new BackgroundImage("file:src/Pictures/gameLogo.png");
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutY(180);
		logo.setLayoutX(70);
		
		startButton = new Button();
		startButton.setLayoutX(215);
		startButton.setLayoutY(480);
		BackgroundImage startImg = new BackgroundImage("file:src/Pictures/start.png");
		startImg.setFitWidth(150);
		startImg.setPreserveRatio(true);
		startButton.setGraphic(startImg);
		
		addChildren.add(new BackgroundImage("file:src/Pictures/backImageEdit.jpg"));
		addChildren.add(logo);
		addChildren.add(startButton);
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
