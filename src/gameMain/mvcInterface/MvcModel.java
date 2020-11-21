package gameMain.mvcInterface;

/**
 * Interface for all the models in Frogger.
 */

public interface MvcModel {
	/**
	 * Create the scene by setting it to stage.
	 */
	public void start();
	/**
	 * Initialize new data for the View
	 */
	public void setVar();
}
