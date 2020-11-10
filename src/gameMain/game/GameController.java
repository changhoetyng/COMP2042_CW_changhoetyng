package gameMain.game;

import gameMain.SceneManager;
import gameMain.mvcInterfaces.ControllerInterface;
import javafx.stage.Stage;

public class GameController implements ControllerInterface{
	private GameView gameView;
	private GameModel gameModel;
	private Stage primaryStage;
	private SceneManager sceneManager;
	GameController(GameView gameView,GameModel gameModel,Stage primaryStage,SceneManager sceneManager) {
		setGameView(gameView);
		setGameModel(gameModel);
		setPrimaryStage(primaryStage);
		setSceneManager(sceneManager);
	}
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public void setGameView(GameView gameView){
		this.gameView = gameView;
	}
	
	public void setGameModel(GameModel gameModel){
		this.gameModel = gameModel;
	}
	
	public void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	public GameView getGameView(){
		return gameView;
	}
	
	public GameModel getGameModel(){
		return gameModel;
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public void start(){
		gameView.mainScreen();
		gameModel.setGameModel(gameView.getBackground(),gameView.getAnimal(),sceneManager);
		primaryStage.setScene(gameView.getScene());
		gameModel.start();
	}
	
}
