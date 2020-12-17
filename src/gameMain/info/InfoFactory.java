package gameMain.info;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

/**
 * Factory of the Info Screen (FlyWeight Pattern).
 * Responsible for reducing the number of objects by 
 * only creating the MVC of the game if there isn't any duplicated.
 */

public class InfoFactory {
	
	private static final HashMap<String, Object>infoMap = new HashMap<String, Object>();
	
	/**
	 * Create infoView if the hashmap doesn't contain infoView.
	 * @return infoView
	 */
	
	public static InfoView infoViewFactory() {
		InfoView infoView = (InfoView)infoMap.get("infoView");
		
		if(infoView == null) {
			infoView = new InfoView();
			infoMap.put("infoView", infoView);
		}
		return infoView;
	}
	
	/**
	 * Create infoModel if the hashmap doesn't contain infoModel.
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene.
	 * @return infoModel
	 */
	
	public static InfoModel infoModelFactory(Stage primaryStage, SceneManager sceneManager) {
		InfoModel infoModel = (InfoModel)infoMap.get("infoModel");
		
		if(infoModel == null) {
			infoModel = new InfoModel(primaryStage,sceneManager);
			infoMap.put("infoModel",infoModel);
		}
		return infoModel;
	}
	
	/**
	 * Create infoController if the hashmap doesn't contain infoController.
	 * @param infoView View of the info Screen.
	 * @param infoModel Model of the info Screen
	 * @return infoController
	 */
	
	public static InfoController infoControllerFactory(InfoView infoView, InfoModel infoModel) {
		InfoController infoController = (InfoController)infoMap.get("infoController");
		
		if(infoController == null) {
			infoController = new InfoController(infoView,infoModel);
			infoMap.put("infoController",infoController);
		}
		return infoController;
	}
}
