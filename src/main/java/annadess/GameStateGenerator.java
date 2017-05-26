package annadess;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import annadess.model.GameState;

/**
 * Class containing the methods that are used to generate new values for each {@code GameState}.
 * 
 * @author annadess
 */
public class GameStateGenerator {
	
	/**
	 * Returns a new {@code GameState} object with a randomized board, and a random "next" value from 1 to 3.
	 * The stored "next" value represents the next number which will appear on the board.
	 * 
	 * @return a new {@code GameState} object with a randomized board, and a random "next" value from 1 to 3
	 */
	public static GameState generateGameState(){
		
		int[][] returnMatrix = new int[4][4];
		Random randGen = ThreadLocalRandom.current();
		
		for (int i=0; i<9; i++){
			returnMatrix[i/4][i%4] = randGen.nextInt(3)+1;
		}
		
		for (int i = 15; i > 0; i--){
			int index = randGen.nextInt(i + 1);
			// Simple swap
			int tempInt = returnMatrix[index/4][index%4];
			returnMatrix[index/4][index%4] = returnMatrix[i/4][i%4];
			returnMatrix[i/4][i%4] = tempInt;
		}
		
		GameState gs = new GameState(returnMatrix,0);
		gs.setNextValue(generateNextValue(gs));
		
		return gs;
	}
	
	/**
	 * Returns a number between 1 to 3.
	 * Intended to be used as a new stored next value for the {@code GameState} object passed as the parameter,
	 * since the value returned depends on the game board's contents. 
	 * (a design decision to make the game feel fairer and more accessible)
	 * 
	 * @param currentGameState the {@code GameState} object that the returned value depends on
	 * @return returns a number between 1 to 3
	 */
	public static int generateNextValue(GameState currentGameState){
		
		int[][] matrix = currentGameState.getArrayValue();
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<4;i++){
			for (int j=0;j<4; j++) {
				if (matrix[i][j] == 1) {
					sum1++;
				} else if(matrix[i][j] == 2) {
					sum2++;
				}
			}
		}
		
		if (sum1 > sum2*3){
			return 2;
		}else if(sum2 > sum1*3){
			return 1;
		}else{
			Random randGen = ThreadLocalRandom.current();
			return randGen.nextInt(3)+1;
		}
	}
}
