package gameMain.game;

import gameMain.SceneManager;
import javafx.stage.Stage;

/**
 * Controller of the game.
 * Responsible for all the logic needed to run the game.
 */

public class GameController{
	private GameView gameView;
	private GameModel gameModel;
	private Stage primaryStage;
	private SceneManager sceneManager;
	
	/**
	 * @param gameView Visuals of the game
	 * @param gameModel Data of the game.
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene
	 */
	
	GameController(GameView gameView,GameModel gameModel,Stage primaryStage,SceneManager sceneManager) {
		setGameView(gameView);
		setGameModel(gameModel);
		setPrimaryStage(primaryStage);
		setSceneManager(sceneManager);
	}
	
	/**
	 * Start the game.
	 */
	
	public void start(){
		gameModel.setVar();
		gameView.mainScreen(gameModel.getBackground(),gameModel.getAnimal());
		gameModel.start();
	}
	
	/**
	 * sceneManager, Getter
	 * @return sceneManager
	 */
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}
	
	/**
	 * sceneManager, Setter
	 * @param sceneManager sceneManager
	 */

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	/**
	 * gameView, Setter
	 * @param gameView gameView
	 */
	
	public void setGameView(GameView gameView){
		this.gameView = gameView;
	}
	
	/**
	 * gameModel, Setter 
	 * @param gameModel gameModel
	 */
	
	public void setGameModel(GameModel gameModel){
		this.gameModel = gameModel;
	}
	
	/**
	 * primaryStage, Setter
	 * @param primaryStage primaryStage
	 */
	
	public void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	/**
	 * gameView, Getter
	 * @return gameView
	 */
	
	public GameView getGameView(){
		return gameView;
	}
	
	/**
	 * gameModel, Getter
	 * @return gameModel
	 */
	
	public GameModel getGameModel(){
		return gameModel;
	}
	
	/**
	 * primaryStage, Getter
	 * @return primaryStage
	 */
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}	
}
