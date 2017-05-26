package annadess.test;

import org.junit.Assert;
import org.junit.Test;

import annadess.model.GameState;
import annadess.GameStateOperator;

public class OperatorTest {

	@Test
	public void test() {
		
		int[][] m = new int[4][4];
		m[1][0] =1;
		GameState testGameState;
		testGameState = new GameState(m,0);
		GameStateOperator.moveUp(testGameState);
		Assert.assertEquals(1, testGameState.getArrayValue()[0][0]);
		
		m[1][1] =1;
		m[0][1] =2;
		GameStateOperator.moveUp(testGameState);
		Assert.assertEquals(3, testGameState.getArrayValue()[0][1]);
		
		m[1][2] =3;
		m[0][2] =3;
		GameStateOperator.moveUp(testGameState);
		Assert.assertEquals(6, testGameState.getArrayValue()[0][2]);
		
		
		m = new int[4][4];
		testGameState.setArrayValue(new int[4][4]);
		m[2][0] =1;
		testGameState.setArrayValue(m);
		GameStateOperator.moveDown(testGameState);
		Assert.assertEquals(1, testGameState.getArrayValue()[3][0]);
		
		m[2][1] =1;
		m[3][1] =2;
		GameStateOperator.moveDown(testGameState);
		Assert.assertEquals(3, testGameState.getArrayValue()[3][1]);
		
		m[2][2] =3;
		m[3][2] =3;
		GameStateOperator.moveDown(testGameState);
		Assert.assertEquals(6, testGameState.getArrayValue()[3][2]);
		
		
		m = new int[4][4];
		testGameState.setArrayValue(new int[4][4]);
		m[0][1] =1;
		testGameState.setArrayValue(m);
		GameStateOperator.moveLeft(testGameState);
		Assert.assertEquals(1, testGameState.getArrayValue()[0][0]);
		
		m[1][1] =1;
		m[1][0] =2;
		GameStateOperator.moveLeft(testGameState);
		Assert.assertEquals(3, testGameState.getArrayValue()[1][0]);
		
		m[2][1] =3;
		m[2][0] =3;
		GameStateOperator.moveLeft(testGameState);
		Assert.assertEquals(6, testGameState.getArrayValue()[2][0]);
		
		
		m = new int[4][4];
		testGameState.setArrayValue(new int[4][4]);
		m[0][2] =1;
		testGameState.setArrayValue(m);
		GameStateOperator.moveRight(testGameState);
		Assert.assertEquals(1, testGameState.getArrayValue()[0][3]);
		
		m[1][2] =1;
		m[1][3] =2;
		GameStateOperator.moveRight(testGameState);
		Assert.assertEquals(3, testGameState.getArrayValue()[1][3]);
		
		m[2][2] =3;
		m[2][3] =3;
		GameStateOperator.moveRight(testGameState);
		Assert.assertEquals(6, testGameState.getArrayValue()[2][3]);
	}

}
