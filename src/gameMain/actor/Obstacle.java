package gameMain.actor;

import javafx.scene.image.Image;

/**
 * Represent obstacles such as the truck and lorry which
 * had to be avoided by the frog.
 */

public class Obstacle extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
	 * Add new obstacle into the game
	 * @param imageLink Directory of the obstacle image file
	 * @param xpos X coordinates
	 * @param ypos Y coordinates
	 * @param s Speed of the obstacle
	 * @param w Width of the obstacle
	 * @param h	Height of the obstacle
	 */
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * speed, Getter
	 * @return speed
	 */
	
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * speed, Setter
	 * @param speed speed
	 */
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
