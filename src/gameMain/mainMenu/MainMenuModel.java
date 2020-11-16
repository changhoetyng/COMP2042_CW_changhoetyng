package gameMain.mainMenu;

import gameMain.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenuModel {
	private Button startButton;
	private Button infoButton;
	private Scene mainMenuScene;
	private Pane mainMenu;
	private Stage primaryStage;
	private SceneManager sceneManager;
	
	public MainMenuModel(Stage primaryStage, SceneManager sceneManager) {
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	public void setMainMenuVar() {
		this.mainMenu = new Pane();
		this.startButton = new Button();
		this.infoButton = new Button();
		this.mainMenuScene = new Scene(mainMenu,600,800);
	}
	
	public void start() {
		startButtonListener();
		infoButtonListener();
		primaryStage.setScene(mainMenuScene);
		primaryStage.show();
	}
	
	public void startButtonListener() {
		startButton.setOnAction(e -> {
			sceneManager.getGameScene(sceneManager);
		});
	}
	
	public void infoButtonListener() {
		infoButton.setOnAction(e -> {
			sceneManager.getInfoScene(sceneManager);
		});
	}
	
	
	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public Button getInfoButton() {
		return infoButton;
	}

	public void setInfoButton(Button infoButton) {
		this.infoButton = infoButton;
	}

	public Scene getMainMenuScene() {
		return mainMenuScene;
	}

	public void setMainMenuScene(Scene mainMenuScene) {
		this.mainMenuScene = mainMenuScene;
	}

	public Pane getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(Pane mainMenu) {
		this.mainMenu = mainMenu;
	}
	
	
}
