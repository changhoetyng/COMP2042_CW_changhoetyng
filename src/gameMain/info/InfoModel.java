package gameMain.info;

import gameMain.SceneManager;
import gameMain.mvcInterface.MvcModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Model of the Info Screen
 * Responsible for all the data needed to run Info Screen
 *
 */

public class InfoModel implements MvcModel{
	
	private Stage primaryStage;
	private SceneManager sceneManager;
	private Button mainMenuButton;
	private Scene infoScene;
	private Pane info;
	
	/**
	 * 
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene
	 */
	
	public InfoModel(Stage primaryStage, SceneManager sceneManager){
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	public void setVar() {
		this.info = new Pane();
		this.infoScene = new Scene(info,600,800);
		this.mainMenuButton = new Button();
	}
	
	public void start() {
		mainMenuButtonListener();
		primaryStage.setScene(infoScene);
		primaryStage.show();
	}
	
	/**
	 * Navigate to main menu upon clicking mainMenuButton.
	 */
	
	public void mainMenuButtonListener() {
		mainMenuButton.setOnAction(e -> {
			sceneManager.getMainMenuScene(sceneManager);
		});
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
	 * sceneManager, Getter
	 * @return sceneManager
	 */
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}

	/**
	 * sceneMAnager, Setter
	 * @param sceneManager sceneManager
	 */
	
	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}
	
	/**
	 * mainMenuButton, Getter
	 * @return mainMenuButton
	 */
	
	public Button getMainMenuButton() {
		return mainMenuButton;
	}
	/**
	 * mainMenuButton, Setter
	 * @param mainMenuButton mainMenuButton
	 */
	
	public void setMainMenuButton(Button mainMenuButton) {
		this.mainMenuButton = mainMenuButton;
	}
	
	/**
	 * infoScene, Getter
	 * @return infoScene
	 */
	
	public Scene getInfoScene() {
		return infoScene;
	}
	
	/**
	 * infoScene, Setter
	 * @param infoScene infoScene
	 */
	
	public void setInfoScene(Scene infoScene) {
		this.infoScene = infoScene;
	}
	
	/**
	 * info, Getter
	 * @return info
	 */
	
	public Pane getInfo() {
		return info;
	}
	
	/**
	 * info, Setter
	 * @param info info
	 */
	
	public void setInfo(Pane info) {
		this.info = info;
	}
	
}
