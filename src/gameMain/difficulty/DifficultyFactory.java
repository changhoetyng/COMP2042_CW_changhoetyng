package gameMain.difficulty;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

/**
 * Factory of the Difficulty Screen (FlyWeight Pattern).
 * Responsible for reducing the number of objects by 
 * only creating the MVC of the game if there isn't any duplicated.
 */


public class DifficultyFactory {
	private static final HashMap<String, Object>difficultyMap = new HashMap<String, Object>();
	
	/**
	 * Create DifficultyView if the hashmap doesn't contain DifficultyView.
	 * @return difficultyView
	 */
	
	public static DifficultyView difficultyViewFactory() {
		DifficultyView difficultyView = (DifficultyView)difficultyMap.get("difficultyView");
		
		if(difficultyView == null) {
			difficultyView = new DifficultyView();
			difficultyMap.put("difficultyView", difficultyView);
		}
		return difficultyView;
	}
	
	/**
	 * Create DifficultyModel if the hashmap doesn't contain DifficultyModel. 
	 * @param sceneManager For changing scene.
	 * @param primaryStage The primaryStage of the javafx.
	 * @return difficultyModel
	 */
	
	public static DifficultyModel difficultyModelFactory(SceneManager sceneManager,Stage primaryStage) {
		DifficultyModel difficultyModel = (DifficultyModel)difficultyMap.get("difficultyModel");
		
		if(difficultyModel == null) {
			difficultyModel = new DifficultyModel(sceneManager,primaryStage);
			difficultyMap.put("gamemodel", difficultyModel);
		}
		return difficultyModel;
	}
	
	/**
	 * Create DifficultyController if the hashmap doesn't contain DifficultyController.
	 * @param difficultyView View of the game.
	 * @param difficultyModel Model of the game.
	 * @return difficultyController
	 */
	
	public static DifficultyController difficultyControllerFactory(DifficultyView difficultyView,DifficultyModel difficultyModel) {
		DifficultyController difficultyController = (DifficultyController)difficultyMap.get("difficultyController");
		
		if(difficultyController == null) {
			difficultyController = new DifficultyController(difficultyView, difficultyModel);
			difficultyMap.put("difficultyController", difficultyController);
		}
		return difficultyController;
	}
}
