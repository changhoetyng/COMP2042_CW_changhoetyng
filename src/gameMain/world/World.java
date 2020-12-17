package gameMain.world;


import java.util.ArrayList;
import java.util.List;

import gameMain.actor.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * Layout panes for the game.
 */

public abstract class World extends Pane {
    private AnimationTimer timer;
    
    /**
     * Initialized world for the game
     */
    
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {
    		
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							onKeyReleased(event);
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							onKeyPressed(event);
						}
						
					});
				}
				
			}
    		
		});
    }
    
    /**
     * When a key are pressed on the keyboard.
     * @param event An event which indicates that a keystroke occurred in a component.
     */
    
    public void onKeyPressed(KeyEvent event) {
    	if(getOnKeyPressed() != null) 
			getOnKeyPressed().handle(event);
		List<Actor> myActors = getObjects(Actor.class);
		for (Actor anActor: myActors) {
			if (anActor.getOnKeyPressed() != null) {
				anActor.getOnKeyPressed().handle(event);
			}
		}
    }
    
    /**
     * When a key are released on the keyboard.
     * @param event An event which indicates that a keystroke occurred in a component.
     */
    
    public void onKeyReleased(KeyEvent event) {
    	if(getOnKeyReleased() != null) 
			getOnKeyReleased().handle(event);
		List<Actor> myActors = getObjects(Actor.class);
		for (Actor anActor: myActors) {
			if (anActor.getOnKeyReleased() != null) {
				anActor.getOnKeyReleased().handle(event);
			}
		}
    }
    
    /**
     * Create timer for the game
     */
    
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	actorStart(now);
      
            }
        };
    }
    
    /**
     * Actor start acting when the timer starts
     * @param now The timestamp of the current frame given in nanoseconds. 
     * This value will be the same for all AnimationTimers called during one frame.
     */
    
    public void actorStart(long now) {
        act(now);
        List<Actor> actors = getObjects(Actor.class);
        
        for (Actor anActor: actors) {
        	anActor.act(now);
        }
    }
    
    /**
     * Start the Animation timer
     */
    
    public void start() {
    	createTimer();
        timer.start();
    }
    
    /**
     * Stop the Animation timer
     */
    
    public void stop() {
        timer.stop();
    }
    
    /**
     * add actor into the game
     * @param actor Actor from the game
     */
    
    public void add(Actor actor) {
        getChildren().add(actor);
    }
    
    /**
     * Remove actor into the game
     * @param actor Actor from the game
     */
    
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }
    
    
    /**
     * Find the actor located in world and store it in an array
     * @param <A> Actor
     * @param cls Actor.class
     * @return Array containing the actor in World.
     */
    
    @SuppressWarnings("unchecked")
	public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
    
    /**
     * Abstract class for the actor to act accordingly
     * when the timer starts
     * @param now The timestamp of the current frame given in nanoseconds. 
     * This value will be the same for all AnimationTimers called during one frame.
     */
    
    public abstract void act(long now);
}
