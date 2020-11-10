package gameMain;

import gameMain.game.GameController;
import gameMain.game.GameFactory;
import gameMain.game.GameModel;
import gameMain.game.GameView;
import gameMain.mainMenu.MainMenuController;
import gameMain.mainMenu.MainMenuFactory;
import gameMain.mainMenu.MainMenuModel;
import gameMain.mainMenu.MainMenuView;
import javafx.stage.Stage;

public class SceneManager {
	private Stage primaryStage;
	
	public SceneManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void getMainMenuScene(SceneManager sceneManager) {
		MainMenuView mainMenuView = MainMenuFactory.mainMenuViewFactory();
		MainMenuModel mainMenuModel = MainMenuFactory.mainMenuModelFactory();
		MainMenuController mainMenuController = MainMenuFactory.mainMenuControllerFactory(mainMenuView,mainMenuModel,primaryStage,sceneManager); 
		mainMenuController.start();
	}
	
	public void getGameScene(SceneManager sceneManager) {
		GameView gameView = GameFactory.gameViewFactory();
		GameModel gameModel = GameFactory.gameModelFactory();
		GameController gameController = GameFactory.gameControllerFactory(gameView,gameModel,primaryStage,sceneManager);
		gameController.start();
	}
}
