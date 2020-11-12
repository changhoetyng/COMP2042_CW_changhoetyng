package gameMain.info;

import gameMain.actor.BackgroundImage;
import gameMain.mvcInterfaces.ViewInterface;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class InfoView implements ViewInterface{
		private Button mainMenuButton;
		private Scene mainMenuScene;
		public void mainScreen() {
			Pane mainMenu = new Pane();
			ObservableList<Node> addChildren = mainMenu.getChildren();
			mainMenuScene = new Scene(mainMenu,600,800);
			mainMenuScene.getStylesheets().add("file:src/gameMain/styleSheet/mainMenuStyle.css");
			
			BackgroundImage frog = new BackgroundImage("file:src/media/pictures/icon-frogger-pixel-512x512.png");
			frog.setFitWidth(50);
			frog.setPreserveRatio(true);
			frog.setLayoutY(180);
			frog.setLayoutX(70);
			
			BackgroundImage textOne = new BackgroundImage("file:src/media/pictures/infoTextOne.png");
			textOne.setFitWidth(400);
			textOne.setPreserveRatio(true);
			textOne.setLayoutY(192);
			textOne.setLayoutX(174);
			
			BackgroundImage textTwo = new BackgroundImage("file:src/media/pictures/infoTextTwo.png");
			textTwo.setFitWidth(250);
			textTwo.setPreserveRatio(true);
			textTwo.setLayoutY(258);
			textTwo.setLayoutX(178);
			
			BackgroundImage textThree = new BackgroundImage("file:src/media/pictures/infoTextThree.png");
			textThree.setFitWidth(360);
			textThree.setPreserveRatio(true);
			textThree.setLayoutY(316);
			textThree.setLayoutX(178);
			
			BackgroundImage textFour = new BackgroundImage("file:src/media/pictures/infoTextFour.png");
			textFour.setFitWidth(420);
			textFour.setPreserveRatio(true);
			textFour.setLayoutY(380);
			textFour.setLayoutX(172);
			
			BackgroundImage textFive = new BackgroundImage("file:src/media/pictures/infoTextFive.png");
			textFive.setFitWidth(380);
			textFive.setPreserveRatio(true);
			textFive.setLayoutY(435);
			textFive.setLayoutX(172);
			
			BackgroundImage textSix = new BackgroundImage("file:src/media/pictures/infoTextSix.png");
			textSix.setFitWidth(380);
			textSix.setPreserveRatio(true);
			textSix.setLayoutY(485);
			textSix.setLayoutX(172);
			
			BackgroundImage car = new BackgroundImage("file:src/media/pictures/car1right.png");
			car.setFitWidth(70);
			car.setPreserveRatio(true);
			car.setLayoutY(242);
			car.setLayoutX(60);
			
			BackgroundImage keyboard = new BackgroundImage("file:src/media/pictures/keyboard.png");
			keyboard.setFitWidth(70);
			keyboard.setPreserveRatio(true);
			keyboard.setLayoutY(302);
			keyboard.setLayoutX(60);
			
			BackgroundImage ten = new BackgroundImage("file:src/media/pictures/10.png");
			ten.setFitWidth(70);
			ten.setPreserveRatio(true);
			ten.setLayoutY(377);
			ten.setLayoutX(60);
			
			BackgroundImage fifty = new BackgroundImage("file:src/media/pictures/50.png");
			fifty.setFitWidth(70);
			fifty.setPreserveRatio(true);
			fifty.setLayoutY(432);
			fifty.setLayoutX(60);
			
			BackgroundImage nfifty = new BackgroundImage("file:src/media/pictures/n50.png");
			nfifty.setFitWidth(70);
			nfifty.setPreserveRatio(true);
			nfifty.setLayoutY(482);
			nfifty.setLayoutX(60);

			mainMenuButton = new Button();
			mainMenuButton.setLayoutX(180);
			mainMenuButton.setLayoutY(710);
			BackgroundImage mainMenuImg = new BackgroundImage("file:src/media/pictures/mainMenu.png");
			mainMenuImg.setFitWidth(215);
			mainMenuImg.setPreserveRatio(true);
			mainMenuButton.setGraphic(mainMenuImg);
			
			addChildren.add(new BackgroundImage("file:src/media/pictures/backImageEdit.jpg"));
			addChildren.add(frog);
			addChildren.add(car);
			addChildren.add(textOne);
			addChildren.add(textTwo);
			addChildren.add(textThree);
			addChildren.add(textFour);
			addChildren.add(textFive);
			addChildren.add(textSix);
			addChildren.add(keyboard);
			addChildren.add(ten);
			addChildren.add(fifty);
			addChildren.add(nfifty);
			addChildren.add(mainMenuButton);
		}
		
		public Button getMainMenuButton() {
			return mainMenuButton;
		}



		public void setMainMenuButton(Button mainMenuButton) {
			this.mainMenuButton = mainMenuButton;
		}



		public Scene getMainMenuScene() {
			return mainMenuScene;
		}
		public void setMainMenuScene(Scene mainMenuScene) {
			this.mainMenuScene = mainMenuScene;
		}
}
	
