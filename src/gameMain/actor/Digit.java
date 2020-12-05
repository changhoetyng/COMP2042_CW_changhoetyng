package gameMain.actor;

import javafx.scene.image.Image;

/**
 * Represents the number character in the game.
 */

public class Digit extends Actor{
	private int dim;
	private Image im1;
	@Override
	
	
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * For JUnit tests.
	 */
	
	public Digit() {
		
	}
	/**
	 * Add new number in the game
	 * @param n Number that are to be added (0-9)
	 * @param dim Width and Length of the picture
	 * @param x X coordinates
	 * @param y Y coordinates
	 */
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/media/pictures/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
	/**
	 * dim, Getter
	 * @return dim
	 */
	
	public int getDim() {
		return dim;
	}

	/**
	 * dim, Setter
	 * @param dim dim
	 */
	
	public void setDim(int dim) {
		this.dim = dim;
	}

	/**
	 * im1, Getter
	 * @return im1
	 */
	
	public Image getIm1() {
		return im1;
	}

	/**
	 * im1, Setter
	 * @param im1 im1
	 */
	
	public void setIm1(Image im1) {
		this.im1 = im1;
	}
	
}
