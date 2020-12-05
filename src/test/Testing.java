package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

import gameMain.actor.Animal;
import gameMain.actor.BackgroundImage;
import gameMain.actor.Digit;
import gameMain.game.GameModel;
import gameMain.info.InfoModel;

/**
 * JUnit Testing
 */

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
	 * Getter will get the same value that Setter sets.
	 */
	
	@Test
	public void setterGetterTest() {
		int test = 10;
		Digit digit = new Digit();
		digit.setDim(test);
		assertEquals(test, digit.getDim());
	}
	
	/**
	 * Invalid Image URL for BackgroundImage throws IllegalArgumentException.
	 */
	
	@Test
	public void invalidBackgroundImage() {
		thrown.expect(IllegalArgumentException.class);
		new BackgroundImage("randomValue");
	}
	
	/**
	 * Invalid Image URL throws IllegalArgumentException.
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
