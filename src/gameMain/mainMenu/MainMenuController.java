package gameMain.mainMenu;

import gameMain.game.GameController;
import gameMain.game.GameFactory;
import gameMain.game.GameModel;
import gameMain.game.GameView;
import gameMain.mvcInterfaces.ControllerInterface;
import javafx.stage.Stage;

public class MainMenuController implements ControllerInterface{
	private MainMenuView mainMenuView;
	private MainMenuModel mainMenuModel;
	private Stage primaryStage;
	
	public MainMenuController(MainMenuView mainMenuView,MainMenuModel mainMenuModel,Stage primaryStage){
		setMainMenuView(mainMenuView);
		setMainMenuModel(mainMenuModel);
		setPrimaryStage(primaryStage);
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
			GameView gameView = GameFactory.gameViewFactory();
			GameModel gameModel = GameFactory.gameModelFactory();
			GameController gameController = GameFactory.gameControllerFactory(gameView,gameModel,primaryStage);
			gameController.start();
		});
	}
	
	public void infoButtonListener() {
		mainMenuView.getInfoButton().setOnAction(e -> {
			GameView gameView = GameFactory.gameViewFactory();
			GameModel gameModel = GameFactory.gameModelFactory();
			GameController gameController = GameFactory.gameControllerFactory(gameView,gameModel,primaryStage);
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
