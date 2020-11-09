package p4_group_8_repo;

import javafx.scene.Scene;


public class GameView implements ViewInterface{
	private MyStage background;
	private Animal animal;
	private Scene scene;
	
	public void mainScreen() {
	 	background = new MyStage();
	    scene  = new Scene(background,600,800);
	    
		//Obstacle obstacle = new Obstacle("file:src/Pictures/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/Pictures/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/Pictures/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage("file:src/Pictures/backImageEdit.jpg");
	    
		background.add(froggerback);
		
		background.add(new Log("file:src/Pictures/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/Pictures/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/Pictures/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/Pictures/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/Pictures/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/Pictures/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/Pictures/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/Pictures/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/Pictures/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/Pictures/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/Pictures/log3.png", 150, 570, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/Pictures/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/Pictures/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/Pictures/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/Pictures/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/Pictures/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/Pictures/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/Pictures/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/Pictures/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/Pictures/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("file:src/Pictures/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/Pictures/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/Pictures/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/Pictures/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/Pictures/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Pictures/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Pictures/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Pictures/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/Pictures/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/Pictures/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/Pictures/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 360, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		background.start();
	}
	public Scene getScene() {
		return this.scene;
	}
	
	public MyStage getBackground() {
		return this.background;
	}
	
	public Animal getAnimal() {
		return this.animal;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void setBackground(MyStage background) {
		this.background = background;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
