package gameMain.game;

import gameMain.SceneManager;
import gameMain.actor.Animal;
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
	private int difficulty;
	
	/**
	 * @param gameView Visuals of the game
	 * @param gameModel Data of the game.
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene
	 */
	
	GameController(GameView gameView,GameModel gameModel,Stage primaryStage,SceneManager sceneManager,int difficulty) {
		setGameView(gameView);
		setGameModel(gameModel);
		setPrimaryStage(primaryStage);
		setSceneManager(sceneManager);
		this.difficulty = difficulty;
	}
	
	/**
	 * Start the game.
	 */
	
	public void start(){
		gameModel.setVar();
		double speed1 = 0;
		int speed2 = 0;
		double speed3 = 0;
		int speed4 = 0;
		int speed5 = 0;
				
		if(difficulty == 1) {
			speed1 = 0.75;
			speed2 = -1;
			speed3 = -2;
			speed4 = -5;
			speed5 = 1;
		}
		if(difficulty == 2) {
			speed1 = 1.25;
			speed2 = -2;
			speed3 = -2.5;
			speed4 = -6;
			speed5 = 2;
		}
		if(difficulty == 3) {
			speed1 = 2.25;
			speed2 = -3;
			speed3 = -3.5;
			speed4 = -7;
			speed5 = 3;
		}
		gameView.mainScreen(gameModel.getBackground(),gameModel.getAnimal(),speed1,speed2,speed3,speed4,speed5);
		Animal.setIntersectSpeed(speed1, speed2, speed3);
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
