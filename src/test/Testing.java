package test;

import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gameMain.actor.Animal;
import gameMain.game.GameModel;
import gameMain.info.InfoModel;
import gameMain.world.World;

public class Testing{
	private GameModel gameModel;
	
	/**
	 * The ExpectedException rule allows you to verify that your code throws a specific exception.
	 */
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Setup Before the testing
	 */
	
	@Before
	public void setup() {
		gameModel = new GameModel();
	}
	
	/**
	 * Score cannot be negative.
	 */
	
	@Test
	public void scoreNegativeTest() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Score cannot be negative");
		gameModel.setNumber(-3);
	}
	
	/**
	 * Image URL cannot be invalid.
	 */
	
	@Test
	public void invalidImageLinkTest() {
		thrown.expect(IllegalArgumentException.class);
		new Animal("randomValue");
	}
	
	/**
	 * Button need to be initialized before calling it.
	 */
	@Test
	public void buttonNotInitialized() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Button is not initialized");
		InfoModel infoModel = new InfoModel();
		infoModel.mainMenuButtonListener();
	}
	
}
