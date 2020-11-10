package gameMain.game;

import java.util.HashMap;

import javafx.stage.Stage;

public class GameFactory {
	private static final HashMap<String, Object>gameMap = new HashMap<String, Object>();
	
	public static GameView gameViewFactory() {
		GameView gameView = (GameView)gameMap.get("gameview");
		
		if(gameView == null) {
			gameView = new GameView();
			gameMap.put("gameview", gameView);
		}
		return gameView;
	}
	
	public static GameModel gameModelFactory() {
		GameModel gameModel = (GameModel)gameMap.get("gamemodel");
		
		if(gameModel == null) {
			gameModel = new GameModel();
			gameMap.put("gamemodel", gameModel);
		}
		return gameModel;
	}
	
	public static GameController gameControllerFactory(GameView gameView,GameModel gameModel,Stage primaryStage) {
		GameController gameController = (GameController)gameMap.get("gamecontroller");
		
		if(gameController == null) {
			gameController = new GameController(gameView,gameModel,primaryStage);
			gameMap.put("gamecontroller", gameController);
		}
		return gameController;
	}
}
