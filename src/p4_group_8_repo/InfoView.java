package p4_group_8_repo;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class InfoView {
	public class MainMenuView {
		
		private Button startButton;
		private Button infoButton;
		private Scene mainMenuScene;
		public void createMainMenu() {
			Pane mainMenu = new Pane();
			ObservableList<Node> addChildren = mainMenu.getChildren();
			mainMenuScene = new Scene(mainMenu,600,800);
			mainMenuScene.getStylesheets().add("file:src/p4_group_8_repo/mainMenuStyle.css");
			
			BackgroundImage logo = new BackgroundImage("file:src/Pictures/gameLogo.png");
			logo.setFitWidth(450);
			logo.setPreserveRatio(true);
			logo.setLayoutY(180);
			logo.setLayoutX(70);
			
			startButton = new Button();
			startButton.setLayoutX(215);
			startButton.setLayoutY(480);
			BackgroundImage startImg = new BackgroundImage("file:src/Pictures/start.png");
			startImg.setFitWidth(150);
			startImg.setPreserveRatio(true);
			startButton.setGraphic(startImg);
			
			infoButton = new Button();
			infoButton.setLayoutX(228);
			infoButton.setLayoutY(525);
			BackgroundImage infoImg = new BackgroundImage("file:src/Pictures/info.png");
			infoImg.setFitWidth(115);
			infoImg.setPreserveRatio(true);
			infoButton.setGraphic(infoImg);
			
			addChildren.add(new BackgroundImage("file:src/Pictures/backImageEdit.jpg"));
			addChildren.add(logo);
			addChildren.add(startButton);
			addChildren.add(infoButton);
	
		}
	}
}
	
