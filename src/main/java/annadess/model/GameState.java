package annadess.model;

/**
 * A model class that represents a current state in the game.
 * 
 * @author annadess
 */
public class GameState implements Cloneable {

	private int[][] boardElements;
	private int nextElement;

	/**
	 * Class constructor specified by the {@code gameState} parameter passed.
	 * 
	 * @param gameStateVaule
	 *            The gameState which values will be used to create the object
	 */
	public GameState(GameState gameStateVaule) {
		super();
		this.boardElements = gameStateVaule.getBoardElements();
		this.nextElement = gameStateVaule.getNextElement();
	}

	/**
	 * Class constructor specified by the parameters passed.
	 * 
	 * @param matrix
	 *            The matrix which will be used to create the object
	 * @param next
	 *            The next number which will appear on the board
	 */
	public GameState(int[][] matrix, int next) {
		super();
		this.boardElements = matrix.clone();
		this.nextElement = next;
	}

	/**
	 * Returns a new instance of the {@code GameState} object.
	 */
	public GameState clone() throws CloneNotSupportedException {
		super.clone();
		int newNextElement = 0;
		int[][] newMatrix = new int[4][4];

		newNextElement = this.nextElement;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newMatrix[i][j] = this.boardElements[i][j];
			}
		}

		return new GameState(newMatrix, newNextElement);
	}

	/**
	 * Returns the next number in line that will appear on the board when it
	 * updates
	 * 
	 * @return the next number that will appear on the board
	 */
	public int getNextElement() {
		return nextElement;
	}

	/**
	 * Sets a new number that will appear next on the board when it updates.
	 * (Using the parameter passed)
	 * 
	 * @param nextElement
	 *            the next number that will appear on the board
	 */
	public void setNextElement(int nextElement) {
		this.nextElement = nextElement;
	}

	/**
	 * Default constructor for this class.
	 */
	public GameState() {
		super();
		this.boardElements = new int[4][4];
	}

	/**
	 * Returns the current numbers on the board as a matrix.
	 * 
	 * @return the current numbers on the board as a matrix
	 */
	public int[][] getBoardElements() {
		return boardElements.clone();
	}

	/**
	 * Sets a new matrix as the state of the game board.
	 * 
	 * @param boardElements
	 *            the new matrix as the state of the game board
	 */
	public void setBoardElements(int[][] boardElements) {
		this.boardElements = boardElements.clone();
	}

	/**
	 * Returns a {@code String} from the object's state. Not used anymore
	 * anywhere in the actual code.
	 */
	@Deprecated
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(48);
		int[][] tempMatrix = this.getBoardElements();
		for (int i = 0; i < 4; i++) {
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
