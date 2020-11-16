package gameMain.info;

import gameMain.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InfoModel {
	
	private Stage primaryStage;
	private SceneManager sceneManager;
	private Button mainMenuButton;
	private Scene infoScene;
	private Pane info;
	
	public InfoModel(Stage primaryStage, SceneManager sceneManager){
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	public void setInfoModelVar() {
		this.info = new Pane();
		this.infoScene = new Scene(info,600,800);
		this.mainMenuButton = new Button();
	}
	
	public void start() {
		mainMenuButtonListener();
		primaryStage.setScene(infoScene);
		primaryStage.show();
	}
	
	public void mainMenuButtonListener() {
		mainMenuButton.setOnAction(e -> {
			sceneManager.getMainMenuScene(sceneManager);
		});
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public Button getMainMenuButton() {
		return mainMenuButton;
	}

	public void setMainMenuButton(Button mainMenuButton) {
		this.mainMenuButton = mainMenuButton;
	}

	public Scene getInfoScene() {
		return infoScene;
	}

	public void setInfoScene(Scene infoScene) {
		this.infoScene = infoScene;
	}

	public Pane getInfo() {
		return info;
	}

	public void setInfo(Pane info) {
		this.info = info;
	}
	
}
