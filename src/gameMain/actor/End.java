package gameMain.actor;

import javafx.scene.image.Image;

/**
 * Represents the home of the frog which is the 
 * 5 platforms above. The user will won the game if 
 * 5 of them are filled with frogs.
 */

public class End extends Actor{
	private boolean activated = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method 
	}
	
	/**
	 * Add platform into the game.
	 * @param x X coordinates
	 * @param y Y coordinates
	 */
	
	public End(int x, int y) {
		beforeEnd(x,y);
	}
	
	/**
	 * Add platform without frog in it into the game
	 * @param x X coordinates
	 * @param y Y coordinates
	 */
	
	public void beforeEnd(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/media/pictures/End.png", 60, 60, true, true));
		activated = false;
	}
	
	/**
	 * Add platform with a frog in it into the game
	 */
	
	public void setEnd() {
		setImage(new Image("file:src/media/pictures/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/**
	 * activated, Getter
	 * @return activated
	 */
	
	public boolean getActivated() {
		return activated;
	}
	
	
	 /**
	  * activated, Setter
	  * @param activated activated
	  */
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	

}
