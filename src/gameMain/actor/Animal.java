package gameMain.actor;

import java.util.ArrayList;



import gameMain.world.World;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This is the class for the main character in the game
 * which is the frog.
 */

public class Animal extends Actor {
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	private int points = 0;
	private int end = 0;
	// private boolean second = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	/**
	 * Initialized animal with his default position
	 * and import all the image of the frog when the frog is moving.
	 * @param imageLink Image of the frog.
	 */
	
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/media/pictures/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/media/pictures/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/media/pictures/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/media/pictures/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/media/pictures/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/media/pictures/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/media/pictures/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/media/pictures/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				onKeyPressed(event);
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				onKeyReleased(event);
			}
			
		});
	}
	
	/**
	 * Method is called when the keyboard key is released after a pressed.
	 * @param event The event which occurred.
	 */
	
	public void onKeyReleased(KeyEvent event) {
		if (noMove) {}
		else {
		if (event.getCode() == KeyCode.W) {	  
			if (getY() < w) {
				changeScore = true;
				w = getY();
				points+=10;
			}
            move(0, -movement);
            setImage(imgW1);
            // second = false;
        }
        else if (event.getCode() == KeyCode.A) {	            	
        	 move(-movementX, 0);
        	 setImage(imgA1);
        	//  second = false;
        }
        else if (event.getCode() == KeyCode.S) {	            	
        	 move(0, movement);
        	 setImage(imgS1);
        	//  second = false;
        }
        else if (event.getCode() == KeyCode.D) {	            	
        	 move(movementX, 0);
        	 setImage(imgD1);
        	//  second = false;
        }
    }
	}
	
	/**
	 * Method is called when the keyboard key is pressed.
	 * @param event The event which occurred.
	 */
	
	public void onKeyPressed(KeyEvent event) {
		if (noMove) {
			
		}
		else {
		 if (event.getCode() == KeyCode.W) {	            	
            move(0, -movement);
            setImage(imgW2);
            // second = true;
        }
        else if (event.getCode() == KeyCode.A) {	            	
        	 move(-movementX, 0);
        	 setImage(imgA2);
        	//  second = true;
        }
        else if (event.getCode() == KeyCode.S) {	            	
        	 move(0, movement);
        	 setImage(imgS2);
        	//  second = true;
        }
        else if (event.getCode() == KeyCode.D) {	            	
        	 move(movementX, 0);
        	 setImage(imgD2);
        	//  second = true;
        }
    }
	}
	
	/**
     * Let the actor act accordingly when the timer starts.
     * @param now The timestamp of the current frame given in nanoseconds. 
     * This value will be the same for all AnimationTimers called during one frame.
     */
	
	@Override
	public void act(long now) {
		if (isStop()) {
			ArrayList<End> actorIntersects = new ArrayList<End>();
			actorIntersects = getObject(End.class);
			actorIntersects.get(0).beforeEnd(13,96);
			actorIntersects.get(1).beforeEnd(141,96);
			actorIntersects.get(2).beforeEnd(141 + 141-13,96);
			actorIntersects.get(3).beforeEnd(141 + 141-13+141-13+1,96);
			actorIntersects.get(4).beforeEnd(141 + 141-13+141-13+141-13+3,96);
			end = 0;
		}
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			carDeath(now);
		}
		if (waterDeath) {
			waterDeath(now);
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).getSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).getActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	
	/**
     * Method is called if the frog fell into the water.
     * @param now The timestamp of the current frame given in nanoseconds. 
     * This value will be the same for all AnimationTimers called during one frame.
     */
	
	public void waterDeath(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(new Image("file:src/media/pictures/waterdeath1.png", imgSize,imgSize , true, true));
		}
		if (carD==2) {
			setImage(new Image("file:src/media/pictures/waterdeath2.png", imgSize,imgSize , true, true));
		}
		if (carD==3) {
			setImage(new Image("file:src/media/pictures/waterdeath3.png", imgSize,imgSize , true, true));
		}
		if (carD == 4) {
			setImage(new Image("file:src/media/pictures/waterdeath4.png", imgSize,imgSize , true, true));
		}
		if (carD == 5) {
			setX(300);
			setY(679.8+movement);
			waterDeath = false;
			carD = 0;
			setImage(new Image("file:src/media/pictures/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			} else {
				points = 0;
				changeScore = true;
			}
		}
	}
	
	/**
     * Method is called if the frog is hit by the car.
     * @param now The timestamp of the current frame given in nanoseconds. 
     * This value will be the same for all AnimationTimers called during one frame.
     */
	
	public void carDeath(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(new Image("file:src/media/pictures/cardeath1.png", imgSize, imgSize, true, true));
		}
		if (carD==2) {
			setImage(new Image("file:src/media/pictures/cardeath2.png", imgSize, imgSize, true, true));
		}
		if (carD==3) {
			setImage(new Image("file:src/media/pictures/cardeath3.png", imgSize, imgSize, true, true));
		}
		if (carD == 4) {
			setX(300);
			setY(679.8+movement);
			carDeath = false;
			carD = 0;
			setImage(new Image("file:src/media/pictures/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			} else {
				points = 0;
				changeScore = true;
			}
		}
	}
	
	public World getWorld() {
        return (World) getParent();
    }
	
	/**
	 * Determines if the score needed to be changed.
	 * @return True = If score change is needed.
	 * False = If score change is not needed.
	 */
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/**
	 * The winning threshold for the amount of frogs that 
	 * successfully returned to their home (Maximum 5).
	 * @return The winning threshold.
	 */
	
	public boolean isStop() {
		return end==2;
	}
	
	/**
	 * Points, Getter
	 * @return points
	 */
	
	public int getPoints() {
		return points;
	}
	
	/**
	 * imgW1, Getter
	 * @return imgW1
	 */
	
	public Image getImgW1() {
		return imgW1;
	}
	
	/**
	 * imgW1, Setter
	 * @param imgW1 imgw1
	 */
	
	public void setImgW1(Image imgW1) {
		this.imgW1 = imgW1;
	}
	
	/**
	 * imgA1, Getter
	 * @return imgA1
	 */
	
	public Image getImgA1() {
		return imgA1;
	}

	/**
	 * imgA1, Setter
	 * @param imgA1 imgA1
	 */
	
	public void setImgA1(Image imgA1) {
		this.imgA1 = imgA1;
	}
	
	/**
	 * imgS1, Getter
	 * @return imgS1
	 */
	
	public Image getImgS1() {
		return imgS1;
	}

	/**
	 * imgS1, Setter
	 * @param imgS1 imgS1
	 */
	
	public void setImgS1(Image imgS1) {
		this.imgS1 = imgS1;
	}
	
	/**
	 * imgD1, Getter
	 * @return imgD1
	 */
	
	public Image getImgD1() {
		return imgD1;
	}

	/**
	 * imgD1, Setter
	 * @param imgD1 imgD1
	 */
	
	public void setImgD1(Image imgD1) {
		this.imgD1 = imgD1;
	}

	/**
	 * imgW2, Getter
	 * @return imgW2
	 */
	
	public Image getImgW2() {
		return imgW2;
	}

	/**
	 * imgW2, Setter
	 * @param imgW2 imgW2
	 */
	
	public void setImgW2(Image imgW2) {
		this.imgW2 = imgW2;
	}

	/**
	 * imgA2, Getter
	 * @return imgA2
	 */
	
	public Image getImgA2() {
		return imgA2;
	}

	/**
	 * imgA2, Setter
	 * @param imgA2 imgA2
	 */
	
	public void setImgA2(Image imgA2) {
		this.imgA2 = imgA2;
	}

	/**
	 * imgS2, Getter
	 * @return imgS2
	 */
	
	public Image getImgS2() {
		return imgS2;
	}

	/**
	 * imgS2, Setter
	 * @param imgS2 imgS2
	 */
	
	public void setImgS2(Image imgS2) {
		this.imgS2 = imgS2;
	}
	
	/**
	 * imgD2, Getter
	 * @return imgD2
	 */
	
	public Image getImgD2() {
		return imgD2;
	}

	/**
	 * imgD2, Setter
	 * @param imgD2 imgD2
	 */
	
	public void setImgD2(Image imgD2) {
		this.imgD2 = imgD2;
	}

	/**
	 * end, Getter
	 * @return end
	 */
	
	public int getEnd() {
		return end;
	}

	/**
	 * end, Setter
	 * @param end end
	 */
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	/**
	 * noMove, Getter
	 * @return noMove
	 */
	
	public boolean getNoMove() {
		return noMove;
	}

	/**
	 * noMove, Setter
	 * @param noMove noMove
	 */
	
	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}
	
	/**
	 * movement, Getter
	 * @return movement
	 */
	
	public double getMovement() {
		return movement;
	}

	/**
	 * movement, Setter
	 * @param movement movement
	 */
	
	public void setMovement(double movement) {
		this.movement = movement;
	}
	
	/**
	 * movementX, Getter
	 * @return movementX
	 */
	
	public double getMovementX() {
		return movementX;
	}

	/**
	 * movementX, Setter
	 * @param movementX movementX
	 */
	
	public void setMovementX(double movementX) {
		this.movementX = movementX;
	}

	/**
	 * imgSize, Getter
	 * @return imgSize
	 */
	
	public int getImgSize() {
		return imgSize;
	}

	/**
	 * imgSize, Setter
	 * @param imgSize imgSize
	 */
	
	public void setImgSize(int imgSize) {
		this.imgSize = imgSize;
	}
	
	/**
	 * carDeath, Getter
	 * @return carDeath
	 */
	
	public boolean getCarDeath() {
		return carDeath;
	}
	
	/**
	 * carDeath, Setter
	 * @param carDeath carDeath
	 */
	
	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}
	
	/**
	 * waterDeath, Getter
	 * @return waterDeath
	 */
	
	public boolean getWaterDeath() {
		return waterDeath;
	}
	
	/**
	 * waterDeath, Setter
	 * @param waterDeath waterDeath
	 */
	
	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}
	
	/**
	 * changeScore, Getter
	 * @return changeScore
	 */
	
	public boolean getChangeScore() {
		return changeScore;
	}
	
	/**
	 * changeScore, Setter
	 * @param changeScore changeScore
	 */
	
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}
	
	/**
	 * carD, Getter
	 * @return carD
	 */
	
	public int getCarD() {
		return carD;
	}

	/**
	 * carD, Setter
	 * @param carD carD
	 */
	
	public void setCarD(int carD) {
		this.carD = carD;
	}

	/**
	 * w, Getter
	 * @return w
	 */
	
	public double getW() {
		return w;
	}

	/**
	 * w, Setter
	 * @param w w
	 */
	
	public void setW(double w) {
		this.w = w;
	}

	/**
	 * inter, Getter
	 * @return inter
	 */
	
	public ArrayList<End> getInter() {
		return inter;
	}

	/**
	 * inter, Setter
	 * @param inter inter
	 */
	
	public void setInter(ArrayList<End> inter) {
		this.inter = inter;
	}
	
	/**
	 * points, Setter
	 * @param points points
	 */
	
	public void setPoints(int points) {
		this.points = points;
	}
}
