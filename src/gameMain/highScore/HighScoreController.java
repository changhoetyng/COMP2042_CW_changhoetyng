package gameMain.highScore;

import java.io.IOException;
import java.util.ArrayList;
import gameMain.SceneManager;
import gameMain.mvcInterfaces.ControllerInterface;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.stage.Stage;

public class HighScoreController implements ControllerInterface{ 
	
	private HighScoreView highScoreView;
	private HighScoreModel highScoreModel;
	private Stage primaryStage;
	private SceneManager sceneManager;
	

	public HighScoreController(HighScoreView highScoreView,HighScoreModel highScoreModel,Stage primaryStage, SceneManager sceneManager){
		this.highScoreView = highScoreView;
		this.highScoreModel = highScoreModel;
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	public void start(HighScoreController highScoreController) {
		highScoreView.setHighScoreController(highScoreController);
		highScoreView.mainScreen();
		highScoreButtonListener();
		primaryStage.setScene(highScoreView.getHighScoreScene());
		primaryStage.show();
	}
	
	public void highScoreButtonListener() {
		highScoreView.getMainMenuButton().setOnAction(e -> {
			sceneManager.getMainMenuScene(sceneManager);
		});
	}
	
	public void writeScore(int score, ObservableList<Node> addChildren, int x, int y) {
		highScoreModel.setNumber(score,addChildren,x,y);
	}
	
	public ArrayList<Integer> getHighScore() throws IOException{
		return highScoreModel.getHighScore();
	}
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public HighScoreView getHighScoreView() {
		return highScoreView;
	}

	public void setHighScoreView(HighScoreView highScoreView) {
		this.highScoreView = highScoreView;
	}

	public HighScoreModel getHighScoreModel() {
		return highScoreModel;
	}

	public void setHighScoreModel(HighScoreModel highScoreModel) {
		this.highScoreModel = highScoreModel;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
}
