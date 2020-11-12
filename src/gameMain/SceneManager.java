package gameMain;

import gameMain.game.GameController;
import gameMain.game.GameFactory;
import gameMain.game.GameModel;
import gameMain.game.GameView;
import gameMain.highScore.HighScoreController;
import gameMain.highScore.HighScoreFactory;
import gameMain.highScore.HighScoreModel;
import gameMain.highScore.HighScoreView;
import gameMain.info.InfoController;
import gameMain.info.InfoFactory;
import gameMain.info.InfoModel;
import gameMain.info.InfoView;
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
	
	public void getHighScoreScene(SceneManager sceneManager, int score) {
		HighScoreView highScoreView = HighScoreFactory.highScoreViewFactory(score);
		HighScoreModel highScoreModel = HighScoreFactory.highScoreModelFactory();
		HighScoreController highScoreController = HighScoreFactory.highScoreControllerFactory(highScoreView, highScoreModel, primaryStage, sceneManager);
		highScoreController.start(highScoreController);
	}
	
	public void getInfoScene(SceneManager sceneManager) {
		InfoView infoView = InfoFactory.infoViewFactory();
		InfoModel infoModel = InfoFactory.infoModelFactory();
		InfoController infoController = InfoFactory.infoControllerFactory(infoView, infoModel, primaryStage, sceneManager);
		infoController.start();
	}
}
