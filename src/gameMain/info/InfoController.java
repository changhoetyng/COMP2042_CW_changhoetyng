package gameMain.info;

/**
 * Controller of the Info screen.
 * Responsible for all the logic needed to run the screen.
 */

public class InfoController{
	
	private InfoView infoView;
	private InfoModel infoModel;
	
	/**
	 * 
	 * @param infoView Visuals of the info screen.
	 * @param infoModel Data of the info screen.
	 */

	public InfoController(InfoView infoView,InfoModel infoModel){
		this.infoView = infoView;
		this.infoModel = infoModel;
	}
	
	/**
	 * Display the info screen.
	 */
	
	public void start() {
		infoModel.setVar();
		infoView.mainScreen(infoModel.getInfoScene(),infoModel.getMainMenuButton(), infoModel.getInfo());
		infoModel.start();
	}
	
	/**
	 * infoView, Getter
	 * @return infoView
	 */
	
	public InfoView getInfoView() {
		return infoView;
	}

	/**
	 * infoView, Setter
	 * @param infoView infoView
	 */
	
	public void setInfoView(InfoView infoView) {
		this.infoView = infoView;
	}
	
	/**
	 * infoModel, Getter
	 * @return infoModel
	 */
	
	public InfoModel getInfoModel() {
		return infoModel;
	}
	
	/**
	 * infoModel, Setter
	 * @param infoModel infoModel
	 */
	
	public void setInfoModel(InfoModel infoModel) {
		this.infoModel = infoModel;
	}
}
