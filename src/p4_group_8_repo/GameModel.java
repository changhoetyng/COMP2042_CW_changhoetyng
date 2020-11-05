package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GameModel {
	private MyStage background;
	private AnimationTimer timer;
	private Animal animal;
	
	public void setGameModel(MyStage background, Animal animal) {
		this.background = background;
		this.animal = animal;
	}
	
	
	
	public MyStage getBackground() {
		return background;
	}



	public void setBackground(MyStage background) {
		this.background = background;
	}



	public AnimationTimer getTimer() {
		return timer;
	}



	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}



	public Animal getAnimal() {
		return animal;
	}



	public void setAnimal(Animal animal) {
		this.animal = animal;
	}



	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	
	public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
