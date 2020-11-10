package gameMain.actor;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private int speed;
	private boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/media/pictures/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/media/pictures/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/media/pictures/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/media/pictures/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean getSunk() {
		return sunk;
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
	public Image getTurtle4() {
		return turtle4;
	}
	public void setTurtle4(Image turtle4) {
		this.turtle4 = turtle4;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}
}
