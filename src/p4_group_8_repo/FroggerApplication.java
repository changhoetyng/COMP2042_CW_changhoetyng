package p4_group_8_repo;

import javafx.stage.Stage;

import javafx.application.Application;

public class FroggerApplication extends Application{
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	   GameView gameView = new GameView();
	   GameModel gameModel = new GameModel();
	   GameController gameController = new GameController(gameView,gameModel,primaryStage);
	   gameController.start(); 
	}	
}
