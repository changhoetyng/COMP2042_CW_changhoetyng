package gameMain.mainMenu;
import gameMain.actor.BackgroundImage;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * View of the Main Menu screen.
 * Responsible for all the visuals of the screen.
 */

public class MainMenuView{
	
	/**
	 * All the visuals in the Info Screen are created here.A\
	 * @param startButton Navigate to game upon clicking startButton.
	 * @param infoButton Navigate to info screen upon clicking infoButton.
	 * @param mainMenuScene Represents the physical contents of Main Menu Screen.
	 * @param mainMenu Pane for the Main Menu Screen
	 */
	
	public void mainScreen(Button startButton, Button infoButton, Scene mainMenuScene, Pane mainMenu) {
		ObservableList<Node> addChildren = mainMenu.getChildren();
		mainMenuScene.getStylesheets().add("file:src/gameMain/styleSheet/mainMenuStyle.css");
		
		BackgroundImage logo = new BackgroundImage("file:src/media/pictures/gameLogo.png");
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutY(180);
		logo.setLayoutX(70);
		
		startButton.setLayoutX(215);
		startButton.setLayoutY(480);
		BackgroundImage startImg = new BackgroundImage("file:src/media/pictures/start.png");
		startImg.setFitWidth(150);
		startImg.setPreserveRatio(true);
		startButton.setGraphic(startImg);
		
		infoButton.setLayoutX(230);
		infoButton.setLayoutY(525);
		BackgroundImage infoImg = new BackgroundImage("file:src/media/pictures/info.png");
		infoImg.setFitWidth(115);
		infoImg.setPreserveRatio(true);
		infoButton.setGraphic(infoImg);

		addChildren.add(new BackgroundImage("file:src/media/pictures/backImageEdit.jpg"));
		addChildren.add(logo);
		addChildren.add(startButton);
		addChildren.add(infoButton);
	}
}
