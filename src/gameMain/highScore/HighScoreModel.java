package gameMain.highScore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import gameMain.SceneManager;
import gameMain.actor.Digit;
import gameMain.mvcInterface.MvcModel;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Model of the High Score Screen
 * Responsible for all the data needed to run High Score Screen.
 */

public class HighScoreModel implements MvcModel{
	private Button mainMenuButton;//
	private int score;
	private Scene highScoreScene;
	private Stage primaryStage; //
	private SceneManager sceneManager;//
	private Pane highScorePane;//
	
	/**
	 * 
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene
	 */
	
	public HighScoreModel(Stage primaryStage, SceneManager sceneManager) {
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	/**
	 * Initialized variable for other HighScore.
	 */
	
	public void setVar() {
		this.highScorePane = new Pane();
		this.mainMenuButton = new Button();
		this.highScoreScene = new Scene(highScorePane,600,800);
		this.score = getCurrentHighScore();
	}
	
	/**
	 * Read current score.
	 * @return The latest score.
	 */
	
	public int getCurrentHighScore(){
		try {
			FileReader reader = new FileReader("src/media/text/currentScore.txt");
			BufferedReader br=new BufferedReader(reader);
			int currentScore;
			try {
				currentScore = Integer.parseInt(br.readLine());
				br.close();
				return currentScore;
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void start() {
		highScoreButtonListener();
		primaryStage.setScene(highScoreScene);
		primaryStage.show();
	}
	
	/**
	 * Navigate to main menu upon clicking mainMenuButton.
	 */
	
	public void highScoreButtonListener() {
		mainMenuButton.setOnAction(e -> {
			sceneManager.getMainMenuScene(sceneManager);
		});
	}
	
	/**
	 * Write a new number into the screen.
	 * @param score Score
	 * @param addChildren Pane.getChildren()
	 * @param x X coordinates
	 * @param y Y coordinates.
	 */
	
	public void setNumber(int score, ObservableList<Node> addChildren, int x, int y) {
		int shift = 0;
		int dim = 30;
    	while (score > 0) {
    		  int d = score / 10;
    		  int k = score - d * 10;
    		  score = d; 
    		  addChildren.add(new Digit(k, dim, x - shift, y));
    		  shift+=30;
    		}
    	
    }
	
	/**
	 * Read score from text file and store it in a list.
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 * @return An ArrayList of high score.
	 */
	
	public ArrayList<Integer> getHighScore() throws IOException{
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(new File("src/media/text/score.txt").isFile()) { 
			FileReader reader = new FileReader("src/media/text/score.txt");
			BufferedReader br=new BufferedReader(reader);
			String line;
		    for(int i=0;i<5;i++) {
		    	
		    	line = br.readLine();
		    	
		    	if (line == null) {
		    		break;
		    	}
		    	
		        list.add(Integer.parseInt(line));
		    }
		         br.close();
		}
		return list;
	}
	
	/**
	 * mainMenuButton, Getter
	 * @return mainMenuButton
	 */
	
	public Button getMainMenuButton() {
		return mainMenuButton;
	}
	
	/**
	 * mainMenuButton,Setter
	 * @param mainMenuButton mainMenuButton
	 */
	
	public void setMainMenuButton(Button mainMenuButton) {
		this.mainMenuButton = mainMenuButton;
	}
	
	/**
	 * score, Getter
	 * @return score
	 */
	
	public int getScore() {
		return score;
	}
	
	/**
	 * score, Setter
	 * @param score score
	 */
	
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * primaryStage, Getter
	 * @return primaryStage
	 */
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * primaryStage, Setter
	 * @param primaryStage primaryStage
	 */
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
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
	 * highScorePane, Getter
	 * @return highScorePane
	 */

	public Pane getHighScorePane() {
		return highScorePane;
	}
	
	/**
	 * highScorePane, Setter
	 * @param mainMenu mainMenu
	 */
	
	public void setHighScorePane(Pane mainMenu) {
		this.highScorePane = mainMenu;
	}
	
	/**
	 * highScoreScene, Getter
	 * @return highScoreScene
	 */
	
	public Scene getHighScoreScene() {
		return highScoreScene;
	}
	
	/**
	 * highScoreScene, Setter
	 * @param highScoreScene highScoreScene
	 */
	
	public void setHighScoreScene(Scene highScoreScene) {
		this.highScoreScene = highScoreScene;
	}
	
	
}
