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
	

	public HighScoreController(HighScoreView highScoreView,HighScoreModel highScoreModel){
		this.highScoreView = highScoreView;
		this.highScoreModel = highScoreModel;
	}
	
	public void start(HighScoreController highScoreController) {
//		highScoreView.setHighScoreController(highScoreController);
		highScoreModel.setHighScoreVar();
		highScoreView.mainScreen(highScoreModel.getMainMenuButton(),highScoreController,highScoreModel.getScore(),highScoreModel.getMainMenu(),highScoreModel.getHighScoreScene());
		highScoreModel.start();
	}
	
	
	
	public void writeScore(int score, ObservableList<Node> addChildren, int x, int y) {
		highScoreModel.setNumber(score,addChildren,x,y);
	}
	
	public ArrayList<Integer> getHighScore() throws IOException{
		return highScoreModel.getHighScore();
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
}
