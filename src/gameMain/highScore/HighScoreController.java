package gameMain.highScore;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * Controller of the High Score screen.
 * Responsible for all the logic needed to run the screen.
 */

public class HighScoreController{ 
	
	private HighScoreView highScoreView;
	private HighScoreModel highScoreModel;
	
	/**
	 * @param highScoreView Visuals of the high score screen.
	 * @param highScoreModel Data of the high score screen.
	 */
	
	public HighScoreController(HighScoreView highScoreView,HighScoreModel highScoreModel){
		this.highScoreView = highScoreView;
		this.highScoreModel = highScoreModel;
	}
	
	/**
	 * Display the high score screen.
	 * @param highScoreController The logic of the high score screen.
	 */
	
	public void start(HighScoreController highScoreController) {
		highScoreModel.setVar();
		highScoreView.mainScreen(highScoreModel.getMainMenuButton(),highScoreController,highScoreModel.getScore(),highScoreModel.getHighScorePane(),highScoreModel.getHighScoreScene());
		highScoreModel.start();
	}
	
	/**
	 * Write score onto the screen.
	 * @param score Score that need to be written.
	 * @param addChildren Pane.getChildren()
	 * @param x X coordinates
	 * @param y Y coordinates
	 */
	
	public void writeScore(int score, ObservableList<Node> addChildren, int x, int y) {
		highScoreModel.setNumber(score,addChildren,x,y);
	}
	
	/**
	 * highScore, Getter
	 * @return highScore
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */
	
	public ArrayList<Integer> getHighScore() throws IOException{
		return highScoreModel.getHighScore();
	}

	/**
	 * highScoreView, Getter
	 * @return highScoreView
	 */
	
	public HighScoreView getHighScoreView() {
		return highScoreView;
	}
	
	/**
	 * highScoreView, Setter
	 * @param highScoreView highScoreView
	 */
	
	public void setHighScoreView(HighScoreView highScoreView) {
		this.highScoreView = highScoreView;
	}
	
	/**
	 * highScoreModel, Getter
	 * @return highScoreModel
	 */
	
	public HighScoreModel getHighScoreModel() {
		return highScoreModel;
	}
	
	/**
	 * highScoreModel, Setter
	 * @param highScoreModel highScoreModel
	 */
	
	public void setHighScoreModel(HighScoreModel highScoreModel) {
		this.highScoreModel = highScoreModel;
	}
}
