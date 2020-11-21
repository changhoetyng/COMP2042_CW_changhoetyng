package gameMain.mainMenu;

/**
 * Controller of the Main Menu screen.
 * Responsible for all the logic needed to run the screen.
 */

public class MainMenuController{
	private MainMenuView mainMenuView;
	private MainMenuModel mainMenuModel;
	
	/**
	 * 
	 * @param mainMenuView Visuals of the Main Menu screen.
	 * @param mainMenuModel Data of the Main Menu screen.
	 */
	
	public MainMenuController(MainMenuView mainMenuView,MainMenuModel mainMenuModel){
		setMainMenuView(mainMenuView);
		setMainMenuModel(mainMenuModel);
	}
	
	/**
	 * Display the Main Menu screen.
	 */
	
	public void start() {
		mainMenuModel.setVar();
		mainMenuView.mainScreen(mainMenuModel.getStartButton(),mainMenuModel.getInfoButton(),mainMenuModel.getMainMenuScene(),mainMenuModel.getMainMenu());
		mainMenuModel.start();
	}
	
	/**
	 * mainMenuView, Getter
	 * @return mainMenuView
	 */
	
	public MainMenuView getMainMenuView() {
		return mainMenuView;
	}
	
	/**
	 * mainMenuView, Setter
	 * @param mainMenuView mainMenuView
	 */
	
	public void setMainMenuView(MainMenuView mainMenuView) {
		this.mainMenuView = mainMenuView;
	}
	
	/**
	 * mainMenuModel, Getter
	 * @return mainMenuModel
	 */
	
	public MainMenuModel getMainMenuModel() {
		return mainMenuModel;
	}
	
	/**
	 * mainMenuModel, Setter
	 * @param mainMenuModel mainMenuModel
	 */
	
	public void setMainMenuModel(MainMenuModel mainMenuModel) {
		this.mainMenuModel = mainMenuModel;
	}
}
