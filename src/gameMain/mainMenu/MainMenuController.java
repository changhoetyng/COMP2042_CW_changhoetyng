package gameMain.mainMenu;


import gameMain.SceneManager;
import gameMain.mvcInterfaces.ControllerInterface;
import javafx.stage.Stage;

public class MainMenuController implements ControllerInterface{
	private MainMenuView mainMenuView;
	private MainMenuModel mainMenuModel;
	private Stage primaryStage;
	private SceneManager sceneManager;
	
	public MainMenuController(MainMenuView mainMenuView,MainMenuModel mainMenuModel,Stage primaryStage, SceneManager sceneManager){
		setMainMenuView(mainMenuView);
		setMainMenuModel(mainMenuModel);
		setPrimaryStage(primaryStage);
		setSceneManager(sceneManager);
	}
	
	public void start() {
		mainMenuView.mainScreen();
		startButtonListener();
		infoButtonListener();
		primaryStage.setScene(mainMenuView.getMainMenuScene());
		primaryStage.show();
	}
	
	public void startButtonListener() {
		mainMenuView.getStartButton().setOnAction(e -> {
			sceneManager.getGameScene(sceneManager);
		});
	}
	
	public void infoButtonListener() {
		mainMenuView.getInfoButton().setOnAction(e -> {
			sceneManager.getGameScene(sceneManager);
		});
	}
	
	public MainMenuView getMainMenuView() {
		return mainMenuView;
	}
	public void setMainMenuView(MainMenuView mainMenuView) {
		this.mainMenuView = mainMenuView;
	}
	public MainMenuModel getMainMenuModel() {
		return mainMenuModel;
	}
	public void setMainMenuModel(MainMenuModel mainMenuModel) {
		this.mainMenuModel = mainMenuModel;
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
	
}
