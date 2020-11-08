package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	private int dim;
	private Image im1;
	@Override
	
	
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	public Image getIm1() {
		return im1;
	}

	public void setIm1(Image im1) {
		this.im1 = im1;
	}

	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/Pictures/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
