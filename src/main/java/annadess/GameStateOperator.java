package annadess;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import annadess.model.GameState;

/**
 * Class that contains operators for transforming the {@code GameState}s.
 * These are used when the player moves the numbers of the board up, down, left or right.
 * With each new movement another number is added and another is generated for the next move.
 * 
 * @author annadess
 */
public class GameStateOperator {
	
	/**
	 * Moves the numbers on the board of the specified {@code GameState} to the right.
	 * 
	 * @param gs the specified {@code GameState}
	 */
	public static void moveRight(GameState gs){
		
		int[][] tempMatrix = gs.getArrayValue();
		boolean condition;
		
		for (int i=2;i>=0;i--){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[j][i+1]==0 && tempMatrix[j][i]!=0;
				boolean are1And2 = tempMatrix[j][i+1] + tempMatrix[j][i] == 3 && tempMatrix[j][i+1] * tempMatrix[j][i] !=0;
				boolean areBothTheSame = tempMatrix[j][i] == tempMatrix[j][i+1] && tempMatrix[j][i] + tempMatrix[j][i+1]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					tempMatrix[j][i+1]+=tempMatrix[j][i];
					tempMatrix[j][i]=0; 
				}
			}
		}
		
		Random randGen = ThreadLocalRandom.current();
		int randomIndex = randGen.nextInt(4);
		
		while(tempMatrix[randomIndex][0] !=0){
			randomIndex = randGen.nextInt(4);
		}
		
		tempMatrix[randomIndex][0] = gs.getNextValue();
		
		gs.setNextValue(GameStateGenerator.generateNextValue(gs));
		gs.setArrayValue(tempMatrix);
		
	}
	
	/**
	 * Moves the numbers on the board of the specified {@code GameState} to the left.
	 * 
	 * @param gs the specified {@code GameState}
	 */
	public static void moveLeft(GameState gs){
		
		int[][] tempMatrix = gs.getArrayValue();
		boolean condition;
		
		for (int i=1;i<4;i++){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[j][i-1]==0 && tempMatrix[j][i]!=0;
				boolean are1And2 = tempMatrix[j][i-1] + tempMatrix[j][i] == 3 && tempMatrix[j][i-1] * tempMatrix[j][i] !=0;
				boolean areBothTheSame = tempMatrix[j][i] == tempMatrix[j][i-1] && tempMatrix[j][i] + tempMatrix[j][i-1]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					tempMatrix[j][i-1]+=tempMatrix[j][i];
					tempMatrix[j][i]=0; 
				}
			}
		}
		
		Random randGen = ThreadLocalRandom.current();
		int randomIndex = randGen.nextInt(4);
		
		while(tempMatrix[randomIndex][3] !=0){
			randomIndex = randGen.nextInt(4);
		}
		
		tempMatrix[randomIndex][3] = gs.getNextValue();
		
		gs.setNextValue(GameStateGenerator.generateNextValue(gs));
		gs.setArrayValue(tempMatrix);
		
	}
	
	/**
	 * Moves the numbers on the board of the specified {@code GameState} downwards.
	 * 
	 * @param gs the specified {@code GameState}
	 */
	public static void moveDown(GameState gs){
		
		int[][] tempMatrix = gs.getArrayValue();
		boolean condition;
		
		for (int i=2;i>=0;i--){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[i+1][j]==0 && tempMatrix[i][j]!=0;
				boolean are1And2 = tempMatrix[i+1][j] + tempMatrix[i][j] == 3 && tempMatrix[i+1][j] * tempMatrix[i][j] !=0;
				boolean areBothTheSame = tempMatrix[i][j] == tempMatrix[i+1][j] && tempMatrix[i][j] + tempMatrix[i+1][j]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					tempMatrix[i+1][j]+=tempMatrix[i][j];
					tempMatrix[i][j]=0; 
				}
			}
		}
		
		Random randGen = ThreadLocalRandom.current();
		int randomIndex = randGen.nextInt(4);
		
		while(tempMatrix[0][randomIndex] !=0){
			randomIndex = randGen.nextInt(4);
		}
		
		tempMatrix[0][randomIndex] = gs.getNextValue();
		
		gs.setNextValue(GameStateGenerator.generateNextValue(gs));
		gs.setArrayValue(tempMatrix);
		
	}
	
	/**
	 * Moves the numbers on the board of the specified {@code GameState} upwards.
	 * 
	 * @param gs the specified {@code GameState}
	 */
	public static void moveUp(GameState gs){
		
		int[][] tempMatrix = gs.getArrayValue();
		boolean condition;
		
		for (int i=1;i<4;i++){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[i-1][j]==0 && tempMatrix[i][j]!=0;
				boolean are1And2 = tempMatrix[i-1][j] + tempMatrix[i][j] == 3 && tempMatrix[i-1][j] * tempMatrix[i][j] !=0;
				boolean areBothTheSame = tempMatrix[i][j] == tempMatrix[i-1][j] && tempMatrix[i][j] + tempMatrix[i-1][j]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					tempMatrix[i-1][j]+=tempMatrix[i][j];
					tempMatrix[i][j]=0; 
				}
			}
		}
		
		Random randGen = ThreadLocalRandom.current();
		int randomIndex = randGen.nextInt(4);
		
		while(tempMatrix[3][randomIndex] !=0){
			randomIndex = randGen.nextInt(4);
		}
		
		tempMatrix[3][randomIndex] = gs.getNextValue();
		
		gs.setNextValue(GameStateGenerator.generateNextValue(gs));
		gs.setArrayValue(tempMatrix);
		
	}
	
}
