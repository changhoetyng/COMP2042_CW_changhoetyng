package p4_group_8_repo;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
	private MainMenuView mainMenuView;
	private MainMenuModel mainMenuModel;
	private Stage primaryStage;
	
	MainMenuController(MainMenuView mainMenuView,MainMenuModel mainMenuModel,Stage primaryStage){
		setMainMenuView(mainMenuView);
		setMainMenuModel(mainMenuModel);
		setPrimaryStage(primaryStage);
	}
	
	public void start() {
		mainMenuView.createMainMenu();
		startButtonListener();
		primaryStage.setScene(mainMenuView.getMainMenuScene());
		primaryStage.show();
	}
	
	public void startButtonListener() {
		mainMenuView.getStartButton().setOnAction(e -> {
			GameView gameView = new GameView();
			GameModel gameModel = new GameModel();
			GameController gameController = new GameController(gameView,gameModel,primaryStage);
			gameController.start();
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
}
