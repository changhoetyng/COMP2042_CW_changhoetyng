package gameMain.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import gameMain.mvcInterface.*;
import java.util.*;

import gameMain.SceneManager;
import gameMain.actor.Animal;
import gameMain.actor.Digit;
import gameMain.world.MyStage;

import java.io.*;

/**
 * Model of the game.
 * Responsible for all the data needed to run the game.
 */

public class GameModel implements MvcModel{
	private MyStage background;
	private AnimationTimer timer;
	private Animal animal;
	private SceneManager sceneManager;
	private Scene scene;
	private Stage primaryStage;
	
	/**
	 * @param sceneManager For changing scene
	 * @param primaryStage The primaryStage of the javafx.
	 */
	
	public GameModel(SceneManager sceneManager,Stage primaryStage) {
		this.sceneManager = sceneManager;
		this.primaryStage = primaryStage;
	}
	
	public void setVar() {
		this.background = new MyStage();
		this.scene  = new Scene(background,600,800);
		this.animal = new Animal("file:src/media/pictures/froggerUp.png");
	}
	
	public void start() {
		primaryStage.setScene(scene);
        primaryStage.show();
		background.playMusic();
    	createTimer();
        timer.start();
	}
	
	/**
	 * Create timer when the game starts so that
	 * every actors in the game will start acting
	 * based on their act function.
	 */
	
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
            			ArrayList<Integer> list=new ArrayList<Integer>();
						createFileScore(list);
						Alert alert = new Alert(AlertType.INFORMATION);
	            		alert.setTitle("You Have Won The Game!");
	            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
	            		alert.setContentText("Top 5 Score\n1." + list.get(0) + "\n2." + list.get(1)+ "\n3." + list.get(2)+ "\n4." + list.get(3)+ "\n5." + list.get(4));
	            		alert.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
            		sceneManager.getHighScoreScene(sceneManager);
            	}
            }
        };
    }
	
	/**
	 * Read score from text file and store it in a list.
	 * @param A newly initialized list that are going to store
	 * the top 5 high score from a text file after this method was called.
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */
	
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
	
	/**
	 * Write newly rearranged scores into the score file.
	 * @param list An arraylist that contains top 5 scores of all time.
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */
	
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
	
	/**
	 * Write the current score into the current score file.
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */
	
	public void writeCurrentScore() throws IOException {
		FileWriter writer = new FileWriter("src/media/text/currentScore.txt");
        writer.write(Integer.toString(animal.getPoints()));
        writer.close();
	}
	
	/**
	 * Process the read score before writing the new one into the file.
	 * @param list A newly initialized list.
	 * @return A list that contains the top 5 scores.
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations. 
	 */
	
	public ArrayList<Integer> createFileScore(ArrayList<Integer> list) throws IOException{
		 readScore(list);
		 list.add(animal.getPoints());
         Collections.sort(list);
         Collections.reverse(list);
         writeScore(list);
         writeCurrentScore();
         return list;
	}
	
	/**
	 * Stop backgroundtimer
	 */
	
	public void stop() {
        timer.stop();
    }
    
	/**
	 * Set a new number for the score in game if change score is needed.
	 * @param n The current score.
	 */
	
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
    
    /**
     * background, Getter
     * @return background
     */
    
	public MyStage getBackground() {
		return background;
	}
	
	/**
	 * background, Setter
	 * @param background background
	 */
	
	public void setBackground(MyStage background) {
		this.background = background;
	}
	
	/**
	 * timer, Getter
	 * @return timer
	 */
	
	public AnimationTimer getTimer() {
		return timer;
	}
	
	/**
	 * timer, Setter
	 * @param timer timer
	 */
	
	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}

	/**
	 * animal, Getter
	 * @return animal
	 */
	
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * animal, Setter
	 * @param animal animal
	 */
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * sceneManager, Getter
	 * @return sceneManager
	 */
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}
	
	/**
	 * sceneManager, Setter
	 * @param sceneManager sceneManager
	 */
	
	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}
	
	/**
	 * scene, Getter
	 * @return scene
	 */
	
	public Scene getScene() {
		return scene;
	}

	/**
	 * scene, Setter
	 * @param scene scene
	 */
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * primaryStage, Getter
	 * @return primaryStage
	 */
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * primaryStage, Setter
	 * @param primaryStage primaryStage
	 */
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
    
}
