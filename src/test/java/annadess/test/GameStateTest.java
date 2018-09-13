package annadess.test;

import org.junit.jupiter.api.Test;

import annadess.model.GameState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameStateTest {

	@Test
	public void initTest() {

		GameState testGameState = new GameState();
		assertArrayEquals(new int[4][4], testGameState.getBoardElements());
		assertEquals(0, testGameState.getNextElement());
	}

	@Test
	public void setBoardTest() {

		GameState testGameState = new GameState();
		int[][] m = getExampleBoard();
		testGameState.setBoardElements(m);
		testGameState.setNextElement(1);
		assertArrayEquals(m, testGameState.getBoardElements());
		assertEquals(1, testGameState.getNextElement());
	}

	@Test
	public void constructorTest(){
		int[][] m = getExampleBoard();
		GameState testGameState = new GameState(m, 1);
		GameState testGameState2 = new GameState(m, 1);
		assertArrayEquals(testGameState2.getBoardElements(), testGameState.getBoardElements());
		assertEquals(testGameState2.getNextElement(), testGameState.getNextElement());

		testGameState = new GameState(testGameState2);
		testGameState2.setBoardElements(new int[4][4]);
		assertNotEquals(testGameState2.getBoardElements(), testGameState.getBoardElements());
	}

	@Test
	public void cloneTest(){
		int[][] m = getExampleBoard();
		GameState testGameState2 = new GameState(m, 1);
		try {
			GameState testGameState = testGameState2.clone();
			assertArrayEquals(testGameState2.getBoardElements(), testGameState.getBoardElements());
			assertEquals(testGameState2.getNextElement(), testGameState.getNextElement());
			testGameState2.setNextElement(0);
			assertArrayEquals(testGameState2.getBoardElements(), testGameState.getBoardElements());
			assertNotEquals(testGameState2.getNextElement(), testGameState.getNextElement());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private int[][] getExampleBoard(){
		int[][] m = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				m[i][j] = 1;
			}
		}
		return m;
	}

}
