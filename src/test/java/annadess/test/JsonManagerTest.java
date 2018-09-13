package annadess.test;

import org.junit.jupiter.api.Test;

import annadess.GameStateGenerator;
import annadess.model.GameSession;
import annadess.model.JsonManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class JsonManagerTest {
	@Test
	public void jsonTest() {
		GameSession gameSession = new GameSession(GameStateGenerator.generateGameState());
		assertArrayEquals(gameSession.getGameStateList().get(0).getBoardElements(),
				JsonManager.getGameSessionFromJson(JsonManager.getJsonFromGameSession(gameSession))
				.getGameStateList().get(0).getBoardElements());
	}

}
