package annadess.test;

import org.junit.Assert;
import org.junit.Test;

import annadess.model.GameState;

public class GameStateTest {

	@Test
	public void test() {

		GameState testGameState = new GameState();
		Assert.assertArrayEquals(new int[4][4], testGameState.getArrayValue());
		Assert.assertEquals(0, testGameState.getNextValue());
		
		int[][] m = new int[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				m[i][j]=1;
			}
		}
		testGameState.setArrayValue(m);
		testGameState.setNextValue(1);
		Assert.assertArrayEquals(m, testGameState.getArrayValue());
		Assert.assertEquals(1, testGameState.getNextValue());
		
		GameState testGameState2 = new GameState(m,1);
		Assert.assertArrayEquals(testGameState2.getArrayValue(), testGameState.getArrayValue());
		Assert.assertEquals(testGameState2.getNextValue(), testGameState.getNextValue());
		
		try {
			testGameState = testGameState2.clone();
			testGameState2.setNextValue(0);
			Assert.assertNotEquals(testGameState2.getNextValue(), testGameState.getNextValue());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		testGameState = new GameState(testGameState2);
		testGameState2.setArrayValue(new int[4][4]);
		Assert.assertNotEquals(testGameState2.getArrayValue(), testGameState.getArrayValue());
	}

}
