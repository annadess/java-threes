package annadess.test;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import annadess.GameStateGenerator;
import annadess.model.GameSession;
import annadess.model.JsonManager;
import annadess.model.PersistencyManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistencyManagerTest {

	private File savePath = new File(PersistencyManager.saveFolder, "JUnitTestingFile.json");
	@Test
	public void test() {
		PersistencyManager.createSaveDir();
		assertEquals(true, PersistencyManager.saveFolder.exists());
		int numOfSaves = PersistencyManager.getAllSaveFiles().size();
		GameSession initialGameSession = new GameSession(GameStateGenerator.generateGameState());
		PersistencyManager.saveToFile(savePath, JsonManager.getJsonFromGameSession(initialGameSession));
		assertEquals(numOfSaves+1, PersistencyManager.getAllSaveFiles().size());
		GameSession loadedGameSession = JsonManager.getGameSessionFromJson(PersistencyManager.openFromFile(savePath));
		assertArrayEquals(initialGameSession.getGameStateList().get(0).getBoardElements(), loadedGameSession.getGameStateList().get(0).getBoardElements());
	}

	@AfterEach
	public void afterTest(){
		savePath.delete();
	}
}
