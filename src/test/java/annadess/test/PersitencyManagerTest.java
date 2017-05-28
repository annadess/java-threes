package annadess.test;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import annadess.GameStateGenerator;
import annadess.model.GameSession;
import annadess.model.JsonManager;
import annadess.model.PersistencyManager;

public class PersitencyManagerTest {

	private File savePath = new File(PersistencyManager.saveFolder, "JUnitTestingFile.json");
	@Test
	public void test() {
		PersistencyManager.createSaveDir();
		Assert.assertEquals(true, PersistencyManager.saveFolder.exists());
		int numOfSaves = PersistencyManager.getAllSaveFiles().size();
		GameSession initialGameSession = new GameSession(GameStateGenerator.generateGameState());
		PersistencyManager.saveToFile(savePath, JsonManager.getJsonFromGameSession(initialGameSession));
		Assert.assertEquals(numOfSaves+1, PersistencyManager.getAllSaveFiles().size());
		GameSession loadedGameSession = JsonManager.getGameSessionFromJson(PersistencyManager.openFromFile(savePath));
		Assert.assertArrayEquals(initialGameSession.getGameStateList().get(0).getBoardElements(), loadedGameSession.getGameStateList().get(0).getBoardElements());
	}

	@After
	public void afterTest(){
		savePath.delete();
	}
}
