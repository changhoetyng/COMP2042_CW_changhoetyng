package gameMain.mainMenu;

import gameMain.SceneManager;
import gameMain.mvcInterface.MvcModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Model of the Main Menu Screen
 * Responsible for all the data needed to run Main Menu Screen.
 */

public class MainMenuModel implements MvcModel{
	private Button startButton;
	private Button infoButton;
	private Scene mainMenuScene;
	private Pane mainMenu;
	private Stage primaryStage;
	private SceneManager sceneManager;
	
	/**
	 * 
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene
	 */
	
	public MainMenuModel(Stage primaryStage, SceneManager sceneManager) {
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}

	public void setVar() {
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
	
	/**
	 * Navigate to difficulty upon clicking startButton.
	 */
	
	public void startButtonListener() {
		startButton.setOnAction(e -> {
			sceneManager.getDifficultyScene(sceneManager);
		});
	}
	
	/**
	 * Navigate to info Screen upon clicking infoButton.
	 */
	
	public void infoButtonListener() {
		infoButton.setOnAction(e -> {
			sceneManager.getInfoScene(sceneManager);
		});
	}
	
	/**
	 * startButton, Getter
	 * @return startButton
	 */
	
	public Button getStartButton() {
		return startButton;
	}
	
	/**
	 * startButton, Setter
	 * @param startButton startButton
	 */
	
	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	/**
	 * infoButton, Getter
	 * @return infoButton
	 */
	
	public Button getInfoButton() {
		return infoButton;
	}

	/**
	 * infoButton, Setter
	 * @param infoButton infoButton
	 */
	
	public void setInfoButton(Button infoButton) {
		this.infoButton = infoButton;
	}

	/**
	 * mainMenuScene, Getter
	 * @return mainMenuScene
	 */
	
	public Scene getMainMenuScene() {
		return mainMenuScene;
	}
	
	/**
	 * mainMenuscene, Setter
	 * @param mainMenuScene mainMenuScene
	 */
	
	public void setMainMenuScene(Scene mainMenuScene) {
		this.mainMenuScene = mainMenuScene;
	}
	
	/**
	 * mainMenu, Getter
	 * @return mainMenu
	 */
	
	public Pane getMainMenu() {
		return mainMenu;
	}
	
	/**
	 * mainMenu, Setter
	 * @param mainMenu mainMenu
	 */
	
	public void setMainMenu(Pane mainMenu) {
		this.mainMenu = mainMenu;
	}
	
	
}
