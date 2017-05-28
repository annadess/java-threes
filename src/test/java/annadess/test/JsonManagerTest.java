package annadess.test;

import org.junit.Assert;
import org.junit.Test;

import annadess.GameStateGenerator;
import annadess.model.GameSession;
import annadess.model.JsonManager;

public class JsonManagerTest {
	@Test
	public void test() {
		GameSession gameSession = new GameSession(GameStateGenerator.generateGameState());
		Assert.assertArrayEquals(gameSession.getGameStateList().get(0).getBoardElements(), 
				JsonManager.getGameSessionFromJson(JsonManager.getJsonFromGameSession(gameSession))
				.getGameStateList().get(0).getBoardElements());
	}

}
