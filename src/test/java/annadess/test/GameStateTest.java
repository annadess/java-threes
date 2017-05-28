package annadess.test;

import org.junit.Assert;
import org.junit.Test;

import annadess.model.GameState;

public class GameStateTest {

	@Test
	public void test() {

		GameState testGameState = new GameState();
		Assert.assertArrayEquals(new int[4][4], testGameState.getBoardElements());
		Assert.assertEquals(0, testGameState.getNextElement());

		int[][] m = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				m[i][j] = 1;
			}
		}
		testGameState.setBoardElements(m);
		testGameState.setNextElement(1);
		Assert.assertArrayEquals(m, testGameState.getBoardElements());
		Assert.assertEquals(1, testGameState.getNextElement());

		GameState testGameState2 = new GameState(m, 1);
		Assert.assertArrayEquals(testGameState2.getBoardElements(), testGameState.getBoardElements());
		Assert.assertEquals(testGameState2.getNextElement(), testGameState.getNextElement());

		try {
			testGameState = testGameState2.clone();
			testGameState2.setNextElement(0);
			Assert.assertNotEquals(testGameState2.getNextElement(), testGameState.getNextElement());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		testGameState = new GameState(testGameState2);
		testGameState2.setBoardElements(new int[4][4]);
		Assert.assertNotEquals(testGameState2.getBoardElements(), testGameState.getBoardElements());
	}

}
