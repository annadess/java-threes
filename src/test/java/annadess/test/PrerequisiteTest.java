package annadess.test;

import org.junit.jupiter.api.Test;

import annadess.model.GameState;
import annadess.GameStateOperatorPrerequisites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrerequisiteTest {

	@Test
	public void upTest() {
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);
		m[1][0] = 1;
		assertTrue(GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][1] = 1;
		m[0][1] = 2;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][2] = 3;
		m[0][2] = 3;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertFalse(GameStateOperatorPrerequisites.canMoveUp(testGameState));
	}

	@Test
	public void downTest() {
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);
		m[2][0] = 1;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][1] = 1;
		m[3][1] = 2;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][2] = 3;
		m[3][2] = 3;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertFalse(GameStateOperatorPrerequisites.canMoveDown(testGameState));
	}

	@Test
	public void leftTest() {
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);
		m[0][1] = 1;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][1] = 1;
		m[1][0] = 2;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][1] = 3;
		m[2][0] = 3;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertFalse(GameStateOperatorPrerequisites.canMoveLeft(testGameState));
	}

	@Test
	public void rightTest() {
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);
		m[0][2] = 1;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][2] = 1;
		m[1][3] = 2;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][2] = 3;
		m[2][3] = 3;
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertFalse(GameStateOperatorPrerequisites.canMoveRight(testGameState));
	}
	@Test
	public void gameOverTest(){
		int[][] m = new int[4][4];
		GameState testGameState = new GameState(m, 0);
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertTrue(GameStateOperatorPrerequisites.isGameOver(testGameState));
	}

}
