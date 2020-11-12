package gameMain.info;

import java.util.HashMap;

import gameMain.SceneManager;
import gameMain.highScore.HighScoreController;
import gameMain.highScore.HighScoreModel;
import gameMain.highScore.HighScoreView;
import javafx.stage.Stage;

public class InfoFactory {
	
	private static final HashMap<String, Object>infoMap = new HashMap<String, Object>();
	
	public static InfoView infoViewFactory() {
		InfoView infoView = (InfoView)infoMap.get("infoView");
		
		if(infoView == null) {
			infoView = new InfoView();
			infoMap.put("infoView", infoView);
		}
		return infoView;
	}
	
	public static InfoModel infoModelFactory() {
		InfoModel infoModel = (InfoModel)infoMap.get("infoModel");
		
		if(infoModel == null) {
			infoModel = new InfoModel();
			infoMap.put("infoModel",infoModel);
		}
		return infoModel;
	}
	
	public static InfoController infoControllerFactory(InfoView infoView, InfoModel infoModel, Stage primaryStage, SceneManager sceneManager) {
		InfoController infoController = (InfoController)infoMap.get("infoController");
		
		if(infoController == null) {
			infoController = new InfoController(infoView,infoModel,primaryStage,sceneManager);
			infoMap.put("infoController",infoController);
		}
		return infoController;
	}
}
