package test;

import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gameMain.actor.Animal;
import gameMain.game.GameModel;

public class Testing{
	private GameModel gameModel;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() {
		gameModel = new GameModel();
	}
	
	@Test
	public void scoreNegativeTest() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Score cannot be negative");
		gameModel.setNumber(-3);
	}
	
	@Test
	public void invalidImageLinkTest() {
		thrown.expect(IllegalArgumentException.class);
		new Animal("randomValue");
	}

}
