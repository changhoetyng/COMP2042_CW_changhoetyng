package p4_group_8_repo;

public class GameController {
	GameView gameView;
	GameModel gameModel;
	GameController(GameView gameView,GameModel gameModel) {
		this.gameView = gameView;
		this.gameModel = gameModel;
	}
	public void start(){
		gameModel.start();
	}
}
