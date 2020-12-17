package gameMain;

import gameMain.difficulty.DifficultyController;
import gameMain.difficulty.DifficultyFactory;
import gameMain.difficulty.DifficultyModel;
import gameMain.difficulty.DifficultyView;
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

/**
 * Manage scene between screens.
 */

public class SceneManager {
	private Stage primaryStage;
	
	/**
	 * Passed in Primary Stage during initialization for
	 * the model of the respective scene.
	 * @param primaryStage The primary stage for this application
	 */
	
	public SceneManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/**
	 * Swap stage into Main Menu upon calling this method.
	 * @param sceneManager Passed in SceneManager for the Main Menu to 
	 * call other scenes if needed.
	 */
	
	public void getMainMenuScene(SceneManager sceneManager) {
		MainMenuView mainMenuView = MainMenuFactory.mainMenuViewFactory();
		MainMenuModel mainMenuModel = MainMenuFactory.mainMenuModelFactory(primaryStage,sceneManager);
		MainMenuController mainMenuController = MainMenuFactory.mainMenuControllerFactory(mainMenuView,mainMenuModel); 
		mainMenuController.start();
	}
	
	/**
	 * Swap stage into Game upon calling this method.
	 * @param sceneManager Passed in SceneManager for the Game to 
	 * call other scenes if needed.
	 * @param difficulty The difficulty of the level.
	 */
	
	public void getGameScene(SceneManager sceneManager, int difficulty) {
		GameModel gameModel = GameFactory.gameModelFactory(sceneManager,primaryStage);
		GameView gameView = GameFactory.gameViewFactory();
		GameController gameController = GameFactory.gameControllerFactory(gameView,gameModel,primaryStage,sceneManager,difficulty);
		gameController.start();
	}
	
	/**
	 * Swap stage into High Score upon calling this method.
	 * @param sceneManager Passed in SceneManager for the High Score to 
	 * call other scenes if needed.
	 */
	
	public void getHighScoreScene(SceneManager sceneManager) {
		HighScoreView highScoreView = HighScoreFactory.highScoreViewFactory();
		HighScoreModel highScoreModel = HighScoreFactory.highScoreModelFactory(primaryStage,sceneManager);
		HighScoreController highScoreController = HighScoreFactory.highScoreControllerFactory(highScoreView, highScoreModel);
		highScoreController.start(highScoreController);
	}
	
	/**
	 * Swap stage into Info upon calling this method.
	 * @param sceneManager Passed in SceneManager for the Info to 
	 * call other scenes if needed.
	 */
	
	public void getInfoScene(SceneManager sceneManager) {
		InfoView infoView = InfoFactory.infoViewFactory();
		InfoModel infoModel = InfoFactory.infoModelFactory(primaryStage, sceneManager);
		InfoController infoController = InfoFactory.infoControllerFactory(infoView, infoModel);
		infoController.start();
	}
	
	/**
	 * Swap stage into difficulty selection page upon calling this method.
	 * @param sceneManager Passed in SceneManager for the Info to 
	 * call other scenes if needed.
	 */
	
	public void getDifficultyScene(SceneManager sceneManager) {
		DifficultyView difficultyView = DifficultyFactory.difficultyViewFactory();
		DifficultyModel difficultyModel = DifficultyFactory.difficultyModelFactory(sceneManager, primaryStage);
		DifficultyController difficultyController = DifficultyFactory.difficultyControllerFactory(difficultyView, difficultyModel);
		difficultyController.start();
	}
}
