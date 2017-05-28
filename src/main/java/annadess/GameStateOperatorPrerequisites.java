package annadess;

import annadess.model.GameState;

/**
 * Class containing methods for each movement to see, if that operation is possible or not.
 * 
 * @author annadess
 */
public class GameStateOperatorPrerequisites {
	
	/**
	 * Returns {@code true} if any of the numbers on the board can be moved upwards, else {@code false}.
	 * 
	 * @param gs the {@code GameState} that contains the numbers of the board
	 * @return {@code true} if any of the numbers on the board can be moved upwards, else {@code false}
	 */
	public static boolean canMoveUp(GameState gs){
		
		int[][] tempMatrix = gs.getBoardElements();
		boolean condition;
		
		for (int i=1;i<4;i++){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[i-1][j]==0 && tempMatrix[i][j]!=0;
				boolean are1And2 = tempMatrix[i-1][j] + tempMatrix[i][j] == 3 && tempMatrix[i-1][j] * tempMatrix[i][j] !=0;
				boolean areBothTheSame = tempMatrix[i][j] == tempMatrix[i-1][j] && tempMatrix[i][j] + tempMatrix[i-1][j]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					return true;
				}
			}
		}
	
		return false;
		
	}
	
	/**
	 * Returns {@code true} if any of the numbers on the board can be moved downwards, else {@code false}.
	 * 
	 * @param gs the {@code GameState} that contains the numbers of the board
	 * @return {@code true} if any of the numbers on the board can be moved downwards, else {@code false}
	 */
	public static boolean canMoveDown(GameState gs){
		
		int[][] tempMatrix = gs.getBoardElements();
		boolean condition;
		
		for (int i=2;i>=0;i--){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[i+1][j]==0 && tempMatrix[i][j]!=0;
				boolean are1And2 = tempMatrix[i+1][j] + tempMatrix[i][j] == 3 && tempMatrix[i+1][j] * tempMatrix[i][j] !=0;
				boolean areBothTheSame = tempMatrix[i][j] == tempMatrix[i+1][j] && tempMatrix[i][j] + tempMatrix[i+1][j]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					return true;
				}
			}
		}
	
		return false;
		
	}
	
	/**
	 * Returns {@code true} if any of the numbers on the board can be moved to the left, else {@code false}.
	 * 
	 * @param gs the {@code GameState} that contains the numbers of the board
	 * @return {@code true} if any of the numbers on the board can be moved to the left, else {@code false}
	 */
	public static boolean canMoveLeft(GameState gs){
		
		int[][] tempMatrix = gs.getBoardElements();
		boolean condition;
		
		for (int i=1;i<4;i++){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[j][i-1]==0 && tempMatrix[j][i]!=0;
				boolean are1And2 = tempMatrix[j][i-1] + tempMatrix[j][i] == 3 && tempMatrix[j][i-1] * tempMatrix[j][i] !=0;
				boolean areBothTheSame = tempMatrix[j][i] == tempMatrix[j][i-1] && tempMatrix[j][i] + tempMatrix[j][i-1]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					return true;
				}
			}
		}
	
		return false;
		
	}
	
	/**
	 * Returns {@code true} if any of the numbers on the board can be moved to the right, else {@code false}.
	 * 
	 * @param gs the {@code GameState} that contains the numbers of the board
	 * @return {@code true} if any of the numbers on the board can be moved to the right, else {@code false}
	 */
	public static boolean canMoveRight(GameState gs){
		
		int[][] tempMatrix = gs.getBoardElements();
		boolean condition;
		
		for (int i=2;i>=0;i--){
			for (int j=0;j<4;j++){
				boolean canBeMoved =tempMatrix[j][i+1]==0 && tempMatrix[j][i]!=0;
				boolean are1And2 = tempMatrix[j][i+1] + tempMatrix[j][i] == 3 && tempMatrix[j][i+1] * tempMatrix[j][i] !=0;
				boolean areBothTheSame = tempMatrix[j][i] == tempMatrix[j][i+1] && tempMatrix[j][i] + tempMatrix[j][i+1]>=6;
				
				condition = canBeMoved || are1And2 || areBothTheSame;
				
				if(condition){
					return true;
				}
			}
		}
	
		return false;
		
	}
	
	/**
	 * Returns {@code true} if the player can't move any number on the board to either direction, else {@code false}.
	 * 
	 * @param gs the {@code GameState} that contains the numbers of the board
	 * @return {@code true} if the player can't move any number on the board to either direction, else {@code false}
	 */
	public static boolean isGameOver(GameState gs){
		boolean ableToMove = canMoveUp(gs) || canMoveDown(gs) || canMoveLeft(gs) || canMoveRight(gs);
		return !ableToMove;
	}
}
