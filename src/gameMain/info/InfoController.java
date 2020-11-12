package gameMain.info;

import gameMain.SceneManager;
import gameMain.mvcInterfaces.ControllerInterface;
import javafx.stage.Stage;

public class InfoController implements ControllerInterface{
	
	private InfoView infoView;
	private InfoModel infoModel;
	private Stage primaryStage;
	private SceneManager sceneManager;
	

	public InfoController(InfoView infoView,InfoModel infoModel,Stage primaryStage, SceneManager sceneManager){
		this.infoView = infoView;
		this.infoModel = infoModel;
		this.primaryStage = primaryStage;
		this.sceneManager = sceneManager;
	}
	
	public void start() {
		infoView.mainScreen();
		highScoreButtonListener();
		primaryStage.setScene(infoView.getMainMenuScene());
		primaryStage.show();
	}
	
	public void highScoreButtonListener() {
		infoView.getMainMenuButton().setOnAction(e -> {
			sceneManager.getMainMenuScene(sceneManager);
		});
	}
	
	public InfoView getInfoView() {
		return infoView;
	}

	public void setInfoView(InfoView infoView) {
		this.infoView = infoView;
	}

	public InfoModel getInfoModel() {
		return infoModel;
	}

	public void setInfoModel(InfoModel infoModel) {
		this.infoModel = infoModel;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}
	
}
