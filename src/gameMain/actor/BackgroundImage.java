package gameMain.actor;

import javafx.scene.image.Image;

/**
 * Add image into the game.
 */

public class BackgroundImage extends Actor{
	
	@Override
	public void act(long now) {
		
		
	}
	
	/**
	 * Set a new image into the game.
	 * @param imageLink Directory of the image.
	 */
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
