package gameMain.highScore;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

public class HighScoreFactory {
private static final HashMap<String, Object>highScoreMap = new HashMap<String, Object>();
	
	public static HighScoreView highScoreViewFactory() {
		HighScoreView highScoreView = (HighScoreView)highScoreMap.get("highScoreView");
		
		if(highScoreView == null) {
			highScoreView = new HighScoreView();
			highScoreMap.put("highScoreView", highScoreView);
		}
		return highScoreView;
	}
	
	public static HighScoreModel highScoreModelFactory() {
		HighScoreModel highScoreModel = (HighScoreModel)highScoreMap.get("highScoreModel");
		
		if(highScoreModel == null) {
			highScoreModel = new HighScoreModel();
			highScoreMap.put("highScoreModel",highScoreModel);
		}
		return highScoreModel;
	}
	
	public static HighScoreController highScoreControllerFactory(HighScoreView highScoreView, HighScoreModel highScoreModel, Stage primaryStage, SceneManager sceneManager) {
		HighScoreController highScoreController = (HighScoreController)highScoreMap.get("highScoreController");
		
		if(highScoreController == null) {
			highScoreController = new HighScoreController(highScoreView,highScoreModel,primaryStage,sceneManager);
			highScoreMap.put("highScoreController",highScoreController);
		}
		return highScoreController;
	}
}
