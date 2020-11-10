package gameMain;

import javafx.stage.Stage;
import gameMain.mainMenu.MainMenuController;
import gameMain.mainMenu.MainMenuModel;
import gameMain.mainMenu.MainMenuView;
import javafx.application.Application;

public class FroggerApplication extends Application{
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	   primaryStage.setResizable(false);
	   
	   MainMenuView mainMenuView = new MainMenuView();
	   MainMenuModel mainMenuModel = new MainMenuModel();
	   MainMenuController mainMenuController = new MainMenuController(mainMenuView,mainMenuModel,primaryStage); 
	   
	   mainMenuController.start(); 
	   
//	   HighScoreView highScoreView = new HighScoreView();
//	   HighScoreModel highScoreModel = new HighScoreModel();
//	   HighScoreController highScoreController = new HighScoreController(highScoreView,highScoreModel,primaryStage);
//	   highScoreController.start();
	   
	}	
}
