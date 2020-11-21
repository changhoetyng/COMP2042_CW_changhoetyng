package gameMain.mainMenu;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

/**
 * Factory of the Main Menu Screen (FlyWeight Pattern).
 * Responsible for reducing the number of objects by 
 * only creating the MVC of the game if there isn't any duplicated.
 */

public class MainMenuFactory {
	private static final HashMap<String, Object>mainMenuMap = new HashMap<String, Object>();
	
	/**
	 * Create mainMenuView if the hashmap doesn't contain mainMenuView.
	 * @return mainMenuView
	 */
	
	public static MainMenuView mainMenuViewFactory() {
		MainMenuView mainMenuView = (MainMenuView)mainMenuMap.get("mainMenuView");
		
		if(mainMenuView == null) {
			mainMenuView = new MainMenuView();
			mainMenuMap.put("mainMenuView", mainMenuView);
		}
		return mainMenuView;
	}
	
	/**
	 * Create mainMenuModel if the hashmap doesn't contain mainMenuModel.
	 * @param primaryStage The primaryStage of the javafx.
	 * @param sceneManager For changing scene.
	 * @return mainMenuModel
	 */
	
	public static MainMenuModel mainMenuModelFactory(Stage primaryStage, SceneManager sceneManager) {
		MainMenuModel mainMenuModel = (MainMenuModel)mainMenuMap.get("mainMenuModel");
		
		if(mainMenuModel == null) {
			mainMenuModel = new MainMenuModel(primaryStage,sceneManager);
			mainMenuMap.put("mainMenuModel",mainMenuModel);
		}
		return mainMenuModel;
	}
	
	/**
	 * Create mainMenuController if the hashmap doesn't contain mainMenuController.
	 * @param mainMenuView View of the info Screen.
	 * @param mainMenuModel Model of the info Screen
	 * @return mainMenuController
	 */
	
	public static MainMenuController mainMenuControllerFactory(MainMenuView mainMenuView, MainMenuModel mainMenuModel) {
		MainMenuController mainMenuController = (MainMenuController)mainMenuMap.get("mainMenuController");
		
		if(mainMenuController == null) {
			mainMenuController = new MainMenuController(mainMenuView,mainMenuModel);
			mainMenuMap.put("mainMenuController",mainMenuController);
		}
		return mainMenuController;
	}
}
