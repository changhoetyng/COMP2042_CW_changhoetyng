package gameMain.actor;

import javafx.scene.image.Image;

/**
 * Represents the turtle in the game which is
 * one of the platform for the frog to stand on it
 * without falling into the water.
 */

public class Turtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private int speed;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * Add new turtle into the game with animation.
	 * @param xpos X coordinate
	 * @param ypos Y coordinate
	 * @param s Speed of the turtle
	 * @param w Width of the turtle
	 * @param h Height of the turtle
	 */
	
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/media/pictures/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/media/pictures/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/media/pictures/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * turtle1, Getter
	 * @return turtle1
	 */
	
	public Image getTurtle1() {
		return turtle1;
	}
	
	/**
	 * turtle1, Setter
	 * @param turtle1 turtle1
	 */
	
	public void setTurtle1(Image turtle1) {
		this.turtle1 = turtle1;
	}
	
	/**
	 * turtle2, Getter
	 * @return turtle2
	 */
	
	public Image getTurtle2() {
		return turtle2;
	}
	
	/**
	 * turtle2, Setter
	 * @param turtle2 turtle2
	 */
	
	public void setTurtle2(Image turtle2) {
		this.turtle2 = turtle2;
	}
	
	/**
	 * turtle3, Getter
	 * @return turtle3
	 */
	
	public Image getTurtle3() {
		return turtle3;
	}
	
	/**
	 * turtle3, Setter
	 * @param turtle3 turtle3
	 */
	
	public void setTurtle3(Image turtle3) {
		this.turtle3 = turtle3;
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
