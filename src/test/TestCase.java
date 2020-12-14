package test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import gameMain.actor.Animal;
import gameMain.actor.BackgroundImage;
import gameMain.actor.Digit;
import gameMain.game.GameModel;
import gameMain.info.InfoModel;

/**
 * JUnit Testing
 */

public class TestCase{
	
	/**
	 * Score cannot be negative.
	 */
	
	@Test
	public void scoreNegativeTest() {
		GameModel gameModel = new GameModel();
		Assertions.assertThrows(ArithmeticException.class, () -> {
			gameModel.setNumber(-3);
		 });
	}
	
	/**
	 * Getter will get the same value that Setter sets.
	 */
	
	@Test
	public void setterGetterTest() {
		int test = 10;
		Digit digit = new Digit();
		digit.setDim(test);
		Assertions.assertEquals(test, digit.getDim());
	}
	
	/**
	 * Invalid Image URL for BackgroundImage throws IllegalArgumentException.
	 */
	
	@Test
	public void invalidBackgroundImage() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new BackgroundImage("randomValue");
		 });
	}
	
	/**
	 * Invalid Image URL throws IllegalArgumentException.
	 */
	
	@Test
	public void invalidImageLinkTest() {	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Animal("randomValue");
		 });
	}
	
	/**
	 * Button need to be initialized before calling it.
	 */
	@Test
	public void buttonNotInitialized() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			InfoModel infoModel = new InfoModel();
			infoModel.mainMenuButtonListener();
		 });
	}
	
}
