package gameMain;

import javafx.stage.Stage;
import gameMain.mainMenu.*;
import javafx.application.Application;

public class FroggerApplication extends Application{
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	   primaryStage.setResizable(false);
	   SceneManager sceneManager = new SceneManager(primaryStage);
	   sceneManager.getHighScoreScene(sceneManager);
	}	
}
