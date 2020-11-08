package p4_group_8_repo;

import javafx.scene.image.Image;

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
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/Pictures/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/Pictures/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/Pictures/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public Image getTurtle1() {
		return turtle1;
	}
	public void setTurtle1(Image turtle1) {
		this.turtle1 = turtle1;
	}
	public Image getTurtle2() {
		return turtle2;
	}
	public void setTurtle2(Image turtle2) {
		this.turtle2 = turtle2;
	}
	public Image getTurtle3() {
		return turtle3;
	}
	public void setTurtle3(Image turtle3) {
		this.turtle3 = turtle3;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
