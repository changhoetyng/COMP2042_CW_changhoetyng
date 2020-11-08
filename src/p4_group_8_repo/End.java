package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method 
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/Pictures/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/Pictures/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean getActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	

}
