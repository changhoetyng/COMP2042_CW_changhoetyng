package gameMain.highScore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import gameMain.actor.Digit;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class HighScoreModel {
	public void setNumber(int score, ObservableList<Node> addChildren, int x, int y) {
		int shift = 0;
		int dim = 30;
    	while (score > 0) {
    		  int d = score / 10;
    		  int k = score - d * 10;
    		  score = d; 
    		  System.out.println("worm");
    		  addChildren.add(new Digit(k, dim, x - shift, y));
    		  shift+=30;
    		}
    	
    }
	
	public ArrayList<Integer> getHighScore() throws IOException{
		ArrayList<Integer> list=new ArrayList<Integer>();
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
		return list;
	}
}
