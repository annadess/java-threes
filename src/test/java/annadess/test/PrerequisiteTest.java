package annadess.test;

import org.junit.jupiter.api.Test;

import annadess.model.GameState;
import annadess.GameStateOperatorPrerequisites;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrerequisiteTest {

	@Test
	public void test() {
		int[][] m = new int[4][4];
		m[1][0] = 1;
		GameState testGameState;
		testGameState = new GameState(m, 0);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][1] = 1;
		m[0][1] = 2;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][2] = 3;
		m[0][2] = 3;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertEquals(false, GameStateOperatorPrerequisites.canMoveUp(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][0] = 1;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][1] = 1;
		m[3][1] = 2;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][2] = 3;
		m[3][2] = 3;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertEquals(false, GameStateOperatorPrerequisites.canMoveDown(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[0][1] = 1;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][1] = 1;
		m[1][0] = 2;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][1] = 3;
		m[2][0] = 3;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertEquals(false, GameStateOperatorPrerequisites.canMoveLeft(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[0][2] = 1;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[1][2] = 1;
		m[1][3] = 2;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		m[2][2] = 3;
		m[2][3] = 3;
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertEquals(false, GameStateOperatorPrerequisites.canMoveRight(testGameState));

		m = new int[4][4];
		testGameState.setBoardElements(new int[4][4]);
		testGameState.setBoardElements(m);
		assertEquals(true, GameStateOperatorPrerequisites.isGameOver(testGameState));
	}

}
