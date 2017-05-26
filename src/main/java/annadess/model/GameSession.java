package annadess.model;

import java.util.LinkedList;
import java.util.List;

public class GameSession {

	private List<GameState> gameStateList = new LinkedList<GameState>(); 
	private String playerName = null;
	
	public List<GameState> getGameStateList() {
		return gameStateList;
	}

	public void setGameStateList(List<GameState> gameSessionList) {
		this.gameStateList = gameSessionList;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public GameSession(GameState firstGameState){
		this.gameStateList.add(firstGameState);
	}

	public GameSession(List<GameState> gameSessionList) {
		super();
		this.gameStateList = gameSessionList;
	}
	
}
