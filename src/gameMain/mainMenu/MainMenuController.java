package gameMain.mainMenu;


import gameMain.mvcInterfaces.ControllerInterface;

public class MainMenuController implements ControllerInterface{
	private MainMenuView mainMenuView;
	private MainMenuModel mainMenuModel;
	
	public MainMenuController(MainMenuView mainMenuView,MainMenuModel mainMenuModel){
		setMainMenuView(mainMenuView);
		setMainMenuModel(mainMenuModel);
	}
	
	public void start() {
		mainMenuModel.setMainMenuVar();
		mainMenuView.mainScreen(mainMenuModel.getStartButton(),mainMenuModel.getInfoButton(),mainMenuModel.getMainMenuScene(),mainMenuModel.getMainMenu());
		mainMenuModel.start();
	}
	
	public MainMenuView getMainMenuView() {
		return mainMenuView;
	}
	public void setMainMenuView(MainMenuView mainMenuView) {
		this.mainMenuView = mainMenuView;
	}
	public MainMenuModel getMainMenuModel() {
		return mainMenuModel;
	}
	public void setMainMenuModel(MainMenuModel mainMenuModel) {
		this.mainMenuModel = mainMenuModel;
	}
}
