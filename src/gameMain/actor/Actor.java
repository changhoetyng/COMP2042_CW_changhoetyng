package gameMain.actor;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

import gameMain.world.World;

/**
 * This is the abstract class for all the objects
 * in the game which includes the frog, background image
 * scores and etc.
 */

public abstract class Actor extends ImageView{
	
	/**
	 * Move the actor by getting the current coordinates
	 * and move it using the parameter dx and dy.
	 * @param dx The value of extra X coordinates that will move the current actor horizontally
	 * when added to the current X coordinates.
	 * @param dy The value of extra Y coordinates that will move the current actor vertically
	 * when added to the current Y coordinates.
	 */
	
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * Retrieves the value of the World's parent.
     * @return Gets the value of the property's parent.
     */
    
    public World getWorld() {
        return (World) getParent();
    }
    
    /**
     * Import an actor to find an array of imported actor 
     * that intersects with the current actor.
     * @return An array of the imported actor that intersects
     * with the actor.
     * @param cls Import an actor.
     * @param <A> Actor	 
     */
    
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> actorIntersects = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
            	actorIntersects.add(actor);
            }
        }
        return actorIntersects;
    }
    
    /**
     * Import an actor to find the first imported actor 
     * that intersects with the current actor.
     * @return The first imported actor that intersects
     * with the actor.
     * @param cls Import an actor.
     * @param <A> Actor
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> actorIntersects = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
            	actorIntersects.add(actor);
                break;
            }
        }
        return actorIntersects.get(0);
    }
    
    /**
     * Abstract class for the actor to act accordingly
     * when the timer starts
     * @param now The timestamp of the current frame given in nanoseconds. 
     * This value will be the same for all AnimationTimers called during one frame.
     */
    public abstract void act(long now);

}
