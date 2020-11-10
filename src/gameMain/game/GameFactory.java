package gameMain.game;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

public class GameFactory {
	private static final HashMap<String, Object>gameMap = new HashMap<String, Object>();
	
	public static GameView gameViewFactory() {
		GameView gameView = (GameView)gameMap.get("gameView");
		
		if(gameView == null) {
			gameView = new GameView();
			gameMap.put("gameView", gameView);
		}
		return gameView;
	}
	
	public static GameModel gameModelFactory() {
		GameModel gameModel = (GameModel)gameMap.get("gameModel");
		
		if(gameModel == null) {
			gameModel = new GameModel();
			gameMap.put("gamemodel", gameModel);
		}
		return gameModel;
	}
	
	public static GameController gameControllerFactory(GameView gameView,GameModel gameModel,Stage primaryStage,SceneManager sceneManager) {
		GameController gameController = (GameController)gameMap.get("gameController");
		
		if(gameController == null) {
			gameController = new GameController(gameView,gameModel,primaryStage,sceneManager);
			gameMap.put("gameController", gameController);
		}
		return gameController;
	}
}
