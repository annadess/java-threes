package annadess.test;

import org.junit.jupiter.api.Test;

import annadess.model.GameState;
import annadess.GameStateGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorTest {

	@Test
	public void test() {
		GameState testGameState = GameStateGenerator.generateGameState();
		int[][] m = testGameState.getBoardElements();
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (m[i][j] != 0)
					sum++;
			}
		}
		assertEquals(9, sum);
		assertEquals(true, testGameState.getNextElement() > 0 && testGameState.getNextElement() < 4);
	}
}
