package gameMain.actor;

import java.util.ArrayList;

import gameMain.game.GameController;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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
				if (noMove) {
					
				}
				else {
				// if (second) {
				// 	if (event.getCode() == KeyCode.W) {	  
		        //         move(0, -movement);
		        //         changeScore = false;
		        //         setImage(imgW1);
		        //         second = false;
		        //     }
		        //     else if (event.getCode() == KeyCode.A) {	            	
		        //     	 move(-movementX, 0);
		        //     	 setImage(imgA1);
		        //     	 second = false;
		        //     }
		        //     else if (event.getCode() == KeyCode.S) {	            	
		        //     	 move(0, movement);
		        //     	 setImage(imgS1);
		        //     	 second = false;
		        //     }
		        //     else if (event.getCode() == KeyCode.D) {	            	
		        //     	 move(movementX, 0);
		        //     	 setImage(imgD1);
		        //     	 second = false;
		        //     }
					
				// }
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
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
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
			
		});
	}
	
	@Override
	public void act(long now) {
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
			}
		}
	}
	
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
			}
		}
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	public boolean isStop() {
		return end==2;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Image getImgW1() {
		return imgW1;
	}

	public void setImgW1(Image imgW1) {
		this.imgW1 = imgW1;
	}

	public Image getImgA1() {
		return imgA1;
	}

	public void setImgA1(Image imgA1) {
		this.imgA1 = imgA1;
	}

	public Image getImgS1() {
		return imgS1;
	}

	public void setImgS1(Image imgS1) {
		this.imgS1 = imgS1;
	}

	public Image getImgD1() {
		return imgD1;
	}

	public void setImgD1(Image imgD1) {
		this.imgD1 = imgD1;
	}

	public Image getImgW2() {
		return imgW2;
	}

	public void setImgW2(Image imgW2) {
		this.imgW2 = imgW2;
	}

	public Image getImgA2() {
		return imgA2;
	}

	public void setImgA2(Image imgA2) {
		this.imgA2 = imgA2;
	}

	public Image getImgS2() {
		return imgS2;
	}

	public void setImgS2(Image imgS2) {
		this.imgS2 = imgS2;
	}

	public Image getImgD2() {
		return imgD2;
	}

	public void setImgD2(Image imgD2) {
		this.imgD2 = imgD2;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	// public boolean isSecond() {
	// 	return second;
	// }

	// public void setSecond(boolean second) {
	// 	this.second = second;
	// }

	public boolean isNoMove() {
		return noMove;
	}

	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	public double getMovement() {
		return movement;
	}

	public void setMovement(double movement) {
		this.movement = movement;
	}

	public double getMovementX() {
		return movementX;
	}

	public void setMovementX(double movementX) {
		this.movementX = movementX;
	}

	public int getImgSize() {
		return imgSize;
	}

	public void setImgSize(int imgSize) {
		this.imgSize = imgSize;
	}

	public boolean isCarDeath() {
		return carDeath;
	}

	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}

	public boolean isWaterDeath() {
		return waterDeath;
	}

	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

	public boolean isChangeScore() {
		return changeScore;
	}

	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}

	public int getCarD() {
		return carD;
	}

	public void setCarD(int carD) {
		this.carD = carD;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public ArrayList<End> getInter() {
		return inter;
	}

	public void setInter(ArrayList<End> inter) {
		this.inter = inter;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
