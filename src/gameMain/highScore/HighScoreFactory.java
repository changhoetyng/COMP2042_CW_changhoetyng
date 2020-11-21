package gameMain.highScore;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

/**
 * Factory of the High Score Screen (FlyWeight Pattern).
 * Responsible for reducing the number of objects by 
 * only creating the MVC of the game if there isn't any duplicated.
 */


public class HighScoreFactory {
private static final HashMap<String, Object>highScoreMap = new HashMap<String, Object>();
	
/**
 * Create highScoreView if the hashmap doesn't contain highScoreView.
 * @return highScoreView
 */

	public static HighScoreView highScoreViewFactory() {
		HighScoreView highScoreView = (HighScoreView)highScoreMap.get("highScoreView");
		
		if(highScoreView == null) {
			highScoreView = new HighScoreView();
			highScoreMap.put("highScoreView", highScoreView);
		}
		return highScoreView;
	}
	
	/**
	 * Create highScoreModel if the hashmap doesn't contain highScoreModel.
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene.
	 * @return highScoreModel 
	 */
	
	public static HighScoreModel highScoreModelFactory(Stage primaryStage, SceneManager sceneManager) {
		HighScoreModel highScoreModel = (HighScoreModel)highScoreMap.get("highScoreModel");
		
		if(highScoreModel == null) {
			highScoreModel = new HighScoreModel(primaryStage,sceneManager);
			highScoreMap.put("highScoreModel",highScoreModel);
		}
		return highScoreModel;
	}
	
	/**
	 * Create highScoreController if the hashmap doesn't contain highScoreController.
	 * @param highScoreView View of the High Score screen.
	 * @param highScoreModel Model of the High Score Screen.
	 * @return highScoreController
	 */
	
	public static HighScoreController highScoreControllerFactory(HighScoreView highScoreView, HighScoreModel highScoreModel) {
		HighScoreController highScoreController = (HighScoreController)highScoreMap.get("highScoreController");
		
		if(highScoreController == null) {
			highScoreController = new HighScoreController(highScoreView,highScoreModel);
			highScoreMap.put("highScoreController",highScoreController);
		}
		return highScoreController;
	}
}
