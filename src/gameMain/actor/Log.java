package gameMain.actor;

import javafx.scene.image.Image;

/**
 * Represents the log in the game which is
 * one of the platform for the frog to stand on it
 * without falling into the water.
 */

public class Log extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * Add new log into the game
	 * @param imageLink Directory of the log image file
	 * @param size Width and Height of the Log
	 * @param xpos X coordinates
	 * @param ypos Y coordinates
	 * @param s Speed of the log
	 */
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * Check if the log is moving left or right.
	 * @return True = if the log is moving right
	 * False = if the log is moving left
	 */
	
	public boolean getLeft() {
		return speed < 0;
	}
	
	/**
	 * speed, Getter
	 * @return speed
	 */
	
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * speed, Setter
	 * @param speed speed
	 */
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
}
