package p4_group_8_repo;

import javafx.stage.Stage;

public class GameController {
	GameView gameView;
	GameModel gameModel;
	Stage primaryStage;
	GameController(GameView gameView,GameModel gameModel,Stage primaryStage) {
		this.gameView = gameView;
		this.gameModel = gameModel;
		this.primaryStage = primaryStage;
	}
	public void start(){
		primaryStage.setScene(gameView.scene);
		primaryStage.show();
		gameModel.start();
	}
}
