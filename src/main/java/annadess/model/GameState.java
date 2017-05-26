package annadess.model;

/**
 * A model class that represents a current state in the game.
 * 	
 * @author annadess
 */
public class GameState implements Cloneable{
	
	private int[][] arrayValue;
	private int nextValue;
	
	/**
	 * Class constructor specified by the {@code gameState} parameter passed.
	 * 
	 * @param gameStateVaule The gameState which values will be used to create the object
	 */
	public GameState(GameState gameStateVaule) {
		super();
		this.arrayValue = gameStateVaule.getArrayValue();
		this.nextValue = gameStateVaule.getNextValue();
	}

	/**
	 * Class constructor specified by the parameters passed.
	 * 
	 * @param matrixValue The matrix which will be used to create the object
	 * @param nextValue The next number which will appear on the board
	 */
	public GameState(int[][] matrixValue, int nextValue) {
		super();
		this.arrayValue = matrixValue.clone();
		this.nextValue = nextValue;
	}
	
	/**
	 * Returns a new instance of the {@code GameState} object.
	 */
	public GameState clone() throws CloneNotSupportedException {
		super.clone();
		int newNextValue = 0;
		int[][] newArrayValue = new int[4][4];
		
		newNextValue = this.nextValue;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				newArrayValue[i][j] = this.arrayValue[i][j];
			}
		}
		
		return new GameState(newArrayValue, newNextValue);
	}
	
	/**
	 * Returns the next number in line that will appear on the board when it updates
	 * 
	 * @return the next number that will appear on the board
	 */
	public int getNextValue() {
		return nextValue;
	}

	/**
	 * Sets a new number that will appear next on the board when it updates. (Using the parameter passed)
	 * 
	 * @param nextValue the next number that will appear on the board
	 */
	public void setNextValue(int nextValue) {
		this.nextValue = nextValue;
	}

	/**
	 * Default constructor for this class.
	 */
	public GameState() {
		super();
		this.arrayValue = new int[4][4];	
	}
	
	/**
	 * Returns the current numbers on the board as a matrix.
	 * 
	 * @return the current numbers on the board as a matrix
	 */
	public int[][] getArrayValue() {
		return arrayValue.clone();
	}

	/**
	 * Sets a new matrix as the state of the game board.
	 * 
	 * @param arrayValue the new matrix as the state of the game board
	 */
	public void setArrayValue(int[][] arrayValue) {
		this.arrayValue = arrayValue.clone();
	}
	
	/**
	 * Returns a {@code String} from the object's state. Not used anymore anywhere in the actual code.
	 */
	@Deprecated
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(48);
		int[][] tempMatrix = this.getArrayValue();
		for (int i = 0; i < 4; i++){ 
			sb.append(tempMatrix[i][0]);
			for (int j = 1; j < 4; j++) {
		    	sb.append(' ');
		    	sb.append(tempMatrix[i][j]);
		    }
			sb.append('\n');
		}
		return sb.toString();
	}
	
}
