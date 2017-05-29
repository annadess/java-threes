package annadess.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A model class that represents a game session.
 * 
 * @author annadess
 */
public class GameSession {

	private List<GameState> gameStateList = new LinkedList<GameState>();

	/**
	 * Returns the list of {@code GameState} objects that have been present in the game session this object represents.
	 * 
	 * @return the list of {@code GameState} objects that have been present in the game session this object represents
	 */
	public List<GameState> getGameStateList() {
		return gameStateList;
	}

	/**
	 * Sets a new list of {@code GameState} objects as the game states that are present in this session.
	 * 
	 * @param gameSessionList the new list of {@code GameState} objects
	 */
	public void setGameStateList(List<GameState> gameSessionList) {
		this.gameStateList = gameSessionList;
	}

	/**
	 * Class constructor using the {@code GameState} passed as the first element in the {@code GameSession}.
	 * 
	 * @param firstGameState
	 * 				the {@code GameState} that is going to be the starting element of the new {@code GameSession}
	 */
	public GameSession(GameState firstGameState) {
		this.gameStateList.add(firstGameState);
	}

	/**
	 * Class constructor specified by the list of {@code GameState}s passed.
	 * 
	 * @param gameSessionList
	 * 				the list of {@code GameState}s that will create the new {@code GameSession}
	 */
	public GameSession(List<GameState> gameSessionList) {
		super();
		this.gameStateList = gameSessionList;
	}

}
