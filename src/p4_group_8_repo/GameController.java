package p4_group_8_repo;

import javafx.stage.Stage;

public class GameController {
	private GameView gameView;
	private GameModel gameModel;
	private Stage primaryStage;
	GameController(GameView gameView,GameModel gameModel,Stage primaryStage) {
		setGameView(gameView);
		setGameModel(gameModel);
		setPrimaryStage(primaryStage);
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
		gameView.createGameScene();
//		gameView.createMainMenu();
		gameModel.setGameModel(gameView.getBackground(),gameView.getAnimal());
		primaryStage.setScene(gameView.getScene());
		primaryStage.show();
//		gameView.button1.setOnAction(e -> primaryStage.setScene(gameView.scene));
		gameModel.start();
	}
}
