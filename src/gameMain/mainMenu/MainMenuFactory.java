package gameMain.mainMenu;

import java.util.HashMap;

import gameMain.SceneManager;
import javafx.stage.Stage;

public class MainMenuFactory {
	private static final HashMap<String, Object>mainMenuMap = new HashMap<String, Object>();
	
	public static MainMenuView mainMenuViewFactory() {
		MainMenuView mainMenuView = (MainMenuView)mainMenuMap.get("mainMenuView");
		
		if(mainMenuView == null) {
			mainMenuView = new MainMenuView();
			mainMenuMap.put("mainMenuView", mainMenuView);
		}
		return mainMenuView;
	}
	
	public static MainMenuModel mainMenuModelFactory(Stage primaryStage, SceneManager sceneManager) {
		MainMenuModel mainMenuModel = (MainMenuModel)mainMenuMap.get("mainMenuModel");
		
		if(mainMenuModel == null) {
			mainMenuModel = new MainMenuModel(primaryStage,sceneManager);
			mainMenuMap.put("mainMenuModel",mainMenuModel);
		}
		return mainMenuModel;
	}
	
	public static MainMenuController mainMenuControllerFactory(MainMenuView mainMenuView, MainMenuModel mainMenuModel) {
		MainMenuController mainMenuController = (MainMenuController)mainMenuMap.get("mainMenuController");
		
		if(mainMenuController == null) {
			mainMenuController = new MainMenuController(mainMenuView,mainMenuModel);
			mainMenuMap.put("mainMenuController",mainMenuController);
		}
		return mainMenuController;
	}
}
