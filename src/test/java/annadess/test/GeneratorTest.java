package annadess.test;

import org.junit.Assert;
import org.junit.Test;

import annadess.model.GameState;
import annadess.GameStateGenerator;

public class GeneratorTest {

	@Test
	public void test() {
		GameState testGameState = GameStateGenerator.generateGameState();
		int[][] m = testGameState.getArrayValue();
		int sum=0;
		for(int i=0; i<4; i++){
			for(int j=0;j<4;j++){
				if(m[i][j]!=0)
					sum++;
			}
		}
		Assert.assertEquals(9, sum);
		Assert.assertEquals(true, testGameState.getNextValue() > 0 && testGameState.getNextValue() <4);
	}
}
