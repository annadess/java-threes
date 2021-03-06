package annadess.test;

import org.junit.jupiter.api.Test;

import annadess.model.GameState;
import annadess.GameStateOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

	@Test
	public void upTest() {

		int[][] m = new int[4][4];
		m[1][0] = 1;
		GameState testGameState;
		testGameState = new GameState(m, 0);
		GameStateOperator.moveUp(testGameState);
		assertEquals(1, testGameState.getBoardElements()[0][0]);

		m[1][1] = 1;
		m[0][1] = 2;
		GameStateOperator.moveUp(testGameState);
		assertEquals(3, testGameState.getBoardElements()[0][1]);

		m[1][2] = 3;
		m[0][2] = 3;
		GameStateOperator.moveUp(testGameState);
		assertEquals(6, testGameState.getBoardElements()[0][2]);

	}

	@Test
	public void downTest() {
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);

		testGameState.setBoardElements(new int[4][4]);
		m[2][0] = 1;
		testGameState.setBoardElements(m);
		GameStateOperator.moveDown(testGameState);
		assertEquals(1, testGameState.getBoardElements()[3][0]);

		m[2][1] = 1;
		m[3][1] = 2;
		GameStateOperator.moveDown(testGameState);
		assertEquals(3, testGameState.getBoardElements()[3][1]);

		m[2][2] = 3;
		m[3][2] = 3;
		GameStateOperator.moveDown(testGameState);
		assertEquals(6, testGameState.getBoardElements()[3][2]);

	}

	@Test
	public void leftTest() {
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);

		testGameState.setBoardElements(new int[4][4]);
		m[0][1] = 1;
		testGameState.setBoardElements(m);
		GameStateOperator.moveLeft(testGameState);
		assertEquals(1, testGameState.getBoardElements()[0][0]);

		m[1][1] = 1;
		m[1][0] = 2;
		GameStateOperator.moveLeft(testGameState);
		assertEquals(3, testGameState.getBoardElements()[1][0]);

		m[2][1] = 3;
		m[2][0] = 3;
		GameStateOperator.moveLeft(testGameState);
		assertEquals(6, testGameState.getBoardElements()[2][0]);
	}

	@Test
	public void rightTest(){
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);
		testGameState.setBoardElements(new int[4][4]);
		m[0][2] = 1;
		testGameState.setBoardElements(m);
		GameStateOperator.moveRight(testGameState);
		assertEquals(1, testGameState.getBoardElements()[0][3]);

		m[1][2] = 1;
		m[1][3] = 2;
		GameStateOperator.moveRight(testGameState);
		assertEquals(3, testGameState.getBoardElements()[1][3]);

		m[2][2] = 3;
		m[2][3] = 3;
		GameStateOperator.moveRight(testGameState);
		assertEquals(6, testGameState.getBoardElements()[2][3]);
	}

}
