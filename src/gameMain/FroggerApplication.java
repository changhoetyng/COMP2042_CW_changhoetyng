package gameMain;


import javafx.stage.Stage;
import javafx.application.Application;

/**
 * A separate class that contains the start function
 * which is used by the launch function in main.
 */

public class FroggerApplication extends Application{
	
	/**
	 * The main entry point for all JavaFX applications.
	 * @param primaryStage The primary stage for this application, onto which the application scene can be set.
	 * @throws Exception Everyone that calls the start must be prepared to catch the exception.
	 */
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	   primaryStage.setResizable(false);
	   SceneManager sceneManager = new SceneManager(primaryStage);
	   sceneManager.getMainMenuScene(sceneManager);
	}	
}
