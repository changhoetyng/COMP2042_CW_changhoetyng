package gameMain;

import javafx.stage.Stage;
import gameMain.mainMenu.*;
import javafx.application.Application;

public class FroggerApplication extends Application{
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	   primaryStage.setResizable(false);
//	   MainMenuView mainMenuView = MainMenuFactory.mainMenuViewFactory();
//		MainMenuModel mainMenuModel = MainMenuFactory.mainMenuModelFactory();
//		MainMenuController mainMenuController = MainMenuFactory.mainMenuControllerFactory(mainMenuView,mainMenuModel,primaryStage); 
//		mainMenuController.start();
	   SceneManager sceneManager = new SceneManager(primaryStage);
	   sceneManager.getMainMenuScene(sceneManager);
	}	
}
