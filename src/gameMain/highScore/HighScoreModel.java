package gameMain.highScore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import gameMain.SceneManager;
import gameMain.actor.Digit;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HighScoreModel {
	private Button mainMenuButton;//
	private int score;
	private Scene highScoreScene;
	private Stage primaryStage; //
	private SceneManager sceneManager;//
	private Pane mainMenu;//
	
	public HighScoreModel(Stage primaryStage, SceneManager sceneManager) {
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	public void setHighScoreVar() {
		this.mainMenu = new Pane();
		this.mainMenuButton = new Button();
		this.highScoreScene = new Scene(mainMenu,600,800);
		this.score = getCurrentHighScore();
	}
	
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
	
	public void highScoreButtonListener() {
		mainMenuButton.setOnAction(e -> {
			sceneManager.getMainMenuScene(sceneManager);
		});
	}
	
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

	public Button getMainMenuButton() {
		return mainMenuButton;
	}

	public void setMainMenuButton(Button mainMenuButton) {
		this.mainMenuButton = mainMenuButton;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public Pane getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(Pane mainMenu) {
		this.mainMenu = mainMenu;
	}

	public Scene getHighScoreScene() {
		return highScoreScene;
	}

	public void setHighScoreScene(Scene highScoreScene) {
		this.highScoreScene = highScoreScene;
	}
	
	
}
