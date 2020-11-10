package gameMain.highScore;

import gameMain.mvcInterfaces.ControllerInterface;
import javafx.stage.Stage;

public class HighScoreController implements ControllerInterface{ 
	
	HighScoreView highScoreView;
	HighScoreModel highScoreModel;
	Stage primaryStage;

	HighScoreController(HighScoreView highScoreView,HighScoreModel highScoreModel,Stage primaryStage){
		setHighScoreView(highScoreView);
		setHighScoreModel(highScoreModel);
		setPrimaryStage(primaryStage);
	}
	
	public void start() {
		highScoreView.mainScreen();
		primaryStage.setScene(highScoreView.getHighScoreScene());
		primaryStage.show();
	}
	
	public HighScoreView getHighScoreView() {
		return highScoreView;
	}

	public void setHighScoreView(HighScoreView highScoreView) {
		this.highScoreView = highScoreView;
	}

	public HighScoreModel getHighScoreModel() {
		return highScoreModel;
	}

	public void setHighScoreModel(HighScoreModel highScoreModel) {
		this.highScoreModel = highScoreModel;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
