package gameMain.game;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

/**
 * Factory of the game (FlyWeight Pattern).
 * Responsible for reducing the number of objects by 
 * only creating the MVC of the game if there isn't any duplicated.
 */


public class GameFactory {
	private static final HashMap<String, Object>gameMap = new HashMap<String, Object>();
	
	/**
	 * Create gameView if the hashmap doesn't contain GameView.
	 * @return gameView
	 */
	
	public static GameView gameViewFactory() {
		GameView gameView = (GameView)gameMap.get("gameView");
		
		if(gameView == null) {
			gameView = new GameView();
			gameMap.put("gameView", gameView);
		}
		return gameView;
	}
	
	/**
	 * Create gameModel if the hashmap doesn't contain gameModel. 
	 * @param sceneManager For changing scene.
	 * @param primaryStage The primaryStage of the javafx.
	 * @return gameModel
	 */
	
	public static GameModel gameModelFactory(SceneManager sceneManager,Stage primaryStage) {
		GameModel gameModel = (GameModel)gameMap.get("gameModel");
		
		if(gameModel == null) {
			gameModel = new GameModel(sceneManager,primaryStage);
			gameMap.put("gamemodel", gameModel);
		}
		return gameModel;
	}
	
	/**
	 * Create gameController if the hashmap doesn't contain gameController.
	 * @param gameView View of the game.
	 * @param gameModel Model of the game.
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene.
	 * @return gameController
	 */
	
	public static GameController gameControllerFactory(GameView gameView,GameModel gameModel,Stage primaryStage,SceneManager sceneManager) {
		GameController gameController = (GameController)gameMap.get("gameController");
		
		if(gameController == null) {
			gameController = new GameController(gameView,gameModel,primaryStage,sceneManager);
			gameMap.put("gameController", gameController);
		}
		return gameController;
	}
}
