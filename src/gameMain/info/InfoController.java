package gameMain.info;

import gameMain.mvcInterfaces.ControllerInterface;


public class InfoController implements ControllerInterface{
	
	private InfoView infoView;
	private InfoModel infoModel;
	

	public InfoController(InfoView infoView,InfoModel infoModel){
		this.infoView = infoView;
		this.infoModel = infoModel;
	}
	
	public void start() {
		infoModel.setInfoModelVar();
		infoView.mainScreen(infoModel.getInfoScene(),infoModel.getMainMenuButton(), infoModel.getInfo());
		infoModel.start();
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
}
