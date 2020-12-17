package gameMain.difficulty;

/**
 * Controller of the Difficulty screen.
 * Responsible for all the logic needed to run the screen.
 */

public class DifficultyController {
	private DifficultyView difficultyView;
	private DifficultyModel difficultyModel;
	
	/**
	 * 
	 * @param difficultyView Visuals of the Difficulty screen.
	 * @param difficultyModel Data of the Difficulty screen.
	 */
	
	public DifficultyController(DifficultyView difficultyView,DifficultyModel difficultyModel){
		this.difficultyView = difficultyView;
		this.difficultyModel = difficultyModel;
	}
	
	/**
	 * Display the Difficulty screen.
	 */
	
	public void start() {
		difficultyModel.setVar();
		difficultyView.mainScreen(difficultyModel.getEasyButton(),difficultyModel.getMediumButton(),difficultyModel.getHardButton(),difficultyModel.getDifficultyScene(),difficultyModel.getDifficulty());
		difficultyModel.start();
	}
	
	/**
	 * difficultyView, Getter.
	 * @return difficultyView
	 */
	
	public DifficultyView getDifficultyView() {
		return difficultyView;
	}
	
	/**
	 * difficultyView, Setter
	 * @param difficultyView difficultyView
	 */
	
	public void setDifficultyView(DifficultyView difficultyView) {
		this.difficultyView = difficultyView;
	}
	
	/**
	 * difficultyModel, Getter
	 * @return difficultyModel
	 */
	
	public DifficultyModel getDifficultyModel() {
		return difficultyModel;
	}

	/**
	 * difficultyModel, Setter
	 * @param difficultyModel difficultyModel
	 */
	
	public void setDifficultyModel(DifficultyModel difficultyModel) {
		this.difficultyModel = difficultyModel;
	}
	
}
