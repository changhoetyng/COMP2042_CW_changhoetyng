package gameMain.difficulty;

import gameMain.SceneManager;
import gameMain.mvcInterface.MvcModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Model of the Difficulty Screen
 * Responsible for all the data needed to run Main Menu Screen.
 */

public class DifficultyModel implements MvcModel{
	private Pane difficulty;
	private SceneManager sceneManager;
	private Scene difficultyScene;
	private Stage primaryStage;
	private Button easyButton;
	private Button mediumButton;
	private Button hardButton;

	/**
	 * 
	 * @param sceneManager For changing scene
	 * @param primaryStage The primaryStage of the javafx.
	 */
	
	public DifficultyModel(SceneManager sceneManager,Stage primaryStage) {
		this.sceneManager = sceneManager;
		this.primaryStage = primaryStage;
	}
	
	public void setVar() {
		this.difficulty = new Pane();
		this.easyButton = new Button();
		this.mediumButton = new Button();
		this.hardButton = new Button();
		this.difficultyScene = new Scene(difficulty,600,800);
	}
	
	public void start() {
		startButtonListener();
		mediumButtonListener();
		hardButtonListener();
		primaryStage.setScene(difficultyScene);
		primaryStage.show();
	}
	
	/**
	 * Navigate to game scene with easy difficulty.
	 */
	
	public void startButtonListener() {
		easyButton.setOnAction(e -> {
			sceneManager.getGameScene(sceneManager,1);
		});
	}
	
	/**
	 * Navigate to game scene with medium difficulty.
	 */
	
	public void mediumButtonListener() {
		mediumButton.setOnAction(e -> {
			sceneManager.getGameScene(sceneManager,2);
		});
	}
	
	/**
	 * Navigate to game scene with hard difficulty.
	 */
	
	public void hardButtonListener() {
		hardButton.setOnAction(e -> {
			sceneManager.getGameScene(sceneManager,3);
		});
	}
	
	/**
	 * difficulty, Getter
	 * @return difficulty
	 */
	
	public Pane getDifficulty() {
		return difficulty;
	}

	/**
	 * difficulty, Setter
	 * @param difficulty difficulty
	 */
	
	public void setDifficulty(Pane difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * sceneManager, Getter
	 * @return sceneManager
	 */
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}

	/**
	 * sceneManager, Setter
	 * @param sceneManager sceneManager
	 */
	
	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	/**
	 * difficultyScene, Getter
	 * @return difficultyScene
	 */
	
	public Scene getDifficultyScene() {
		return difficultyScene;
	}
	
	/**
	 * difficultyScene, Setter
	 * @param difficultyScene difficultyScene
	 */
	
	public void setDifficultyScene(Scene difficultyScene) {
		this.difficultyScene = difficultyScene;
	}

	/**
	 * primaryStage, Getter
	 * @return primaryStage
	 */
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * primaryStage, Setter
	 * @param primaryStage primaryStage
	 */
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * easyButton, Getter
	 * @return easyButton
	 */
	
	public Button getEasyButton() {
		return easyButton;
	}

	/**
	 * easyButton, Setter
	 * @param easyButton easyButton
	 */
	
	public void setEasyButton(Button easyButton) {
		this.easyButton = easyButton;
	}

	/**
	 * mediumButton, Getter
	 * @return mediumButton
	 */
	
	public Button getMediumButton() {
		return mediumButton;
	}
	
	/**
	 * mediumButton, Setter
	 * @param mediumButton mediumButton
	 */
	
	public void setMediumButton(Button mediumButton) {
		this.mediumButton = mediumButton;
	}
	
	/**
	 * hardButton, Getter
	 * @return hardButton
	 */
	
	public Button getHardButton() {
		return hardButton;
	}
	
	/**
	 * hardButton, Setter
	 * @param hardButton hardButton
	 */
	
	public void setHardButton(Button hardButton) {
		this.hardButton = hardButton;
	}
}
