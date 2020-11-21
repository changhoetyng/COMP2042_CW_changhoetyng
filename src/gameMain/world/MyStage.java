package gameMain.world;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Background for the game .
 */

public class MyStage extends World{
	private MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * Play background music when the game starts.
	 */
	
	public void playMusic() {
		String musicFile = "src/media/audio/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * Stop the background music when the game ends.
	 */
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	/**
	 * mediaPlayer, Getter
	 * @return mediaPlayer
	 */
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	/**
	 * mediaPlayer, Setter
	 * @param mediaPlayer mediaPlayer
	 */
	
	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

}
