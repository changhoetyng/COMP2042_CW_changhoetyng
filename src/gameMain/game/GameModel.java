package gameMain.game;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.*;

import gameMain.SceneManager;
import gameMain.actor.Animal;
import gameMain.actor.Digit;
import gameMain.world.MyStage;

import java.io.*;

public class GameModel {
	private MyStage background;
	private AnimationTimer timer;
	private Animal animal;
	private SceneManager sceneManager;
	
	public void setGameModel(MyStage background, Animal animal,SceneManager sceneManager) {
		setBackground(background);
		setAnimal(animal);
		setSceneManager(sceneManager);
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
            	if (animal.isStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		try {
						createFileScore();
					} catch (IOException e) {
						e.printStackTrace();
					}
            		sceneManager.getHighScoreScene(sceneManager,animal.getPoints());
            	}
            }
        };
    }
	
	public void readScore(ArrayList<Integer> list) throws IOException{
		if(new File("src/media/text/score.txt").isFile()) { 
			FileReader reader = new FileReader("src/media/text/score.txt");
			BufferedReader br=new BufferedReader(reader);
			String line;
		    for(int i=0;i<5;i++) {
		    	
		    	line = br.readLine();
		    	
		    	if (line == null) {
		    		break;
		    	}
		    	
		        list.add(Integer.parseInt(line));
		    }
		         br.close();
		}
	}
	
	public void writeScore(ArrayList<Integer> list) throws IOException{
		FileWriter writer = new FileWriter("src/media/text/score.txt");
		int counter = 0;
        for(int i=0;i<list.size();i++) {  
        if(counter == 5) {
          break;
        }
        writer.write(Integer.toString(list.get(i)));
        writer.write('\n');    
        counter++;
       }  

        writer.close();
	}
	
	public void createFileScore() throws IOException{
		 ArrayList<Integer> list=new ArrayList<Integer>();
		 readScore(list);
		 list.add(animal.getPoints());
         Collections.sort(list);
         Collections.reverse(list);
         writeScore(list);
	}
	
	public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	background.getChildren().removeAll(background.lookupAll("Digit"));
    	if (n == 0) {
    		background.add(new Digit(0, 30, 360, 25));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d; 
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
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

	

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
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
}
