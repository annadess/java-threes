package annadess.model;

import java.util.LinkedList;
import java.util.List;

public class GameSession {

	private List<GameState> gameStateList = new LinkedList<GameState>(); 
	
	public List<GameState> getGameStateList() {
		return gameStateList;
	}

	public void setGameStateList(List<GameState> gameSessionList) {
		this.gameStateList = gameSessionList;
	}

	public GameSession(GameState firstGameState){
		this.gameStateList.add(firstGameState);
	}

	public GameSession(List<GameState> gameSessionList) {
		super();
		this.gameStateList = gameSessionList;
	}
	
}
