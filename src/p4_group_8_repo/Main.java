package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

public class Main {
	private AnimationTimer timer;
	private MyStage background;
	private Animal animal;
	public static void main(String[] args) {
		Application.launch(FroggerApplication.class,args);
	}
	public AnimationTimer getTimer() {
		return timer;
	}
	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}
	public MyStage getBackground() {
		return background;
	}
	public void setBackground(MyStage background) {
		this.background = background;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
	
}
