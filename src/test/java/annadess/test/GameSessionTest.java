package annadess.test;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import annadess.GameStateGenerator;
import annadess.GameStateOperator;
import annadess.GameStateOperatorPrerequisites;
import annadess.model.GameSession;
import annadess.model.GameState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GameSessionTest {

	private static final Logger logger = LoggerFactory.getLogger(GameSessionTest.class);
	@Test
	public void gameSessionTest() {
		GameState initialGameState = GameStateGenerator.generateGameState();
		try {
			GameSession testedGameSession = new GameSession(initialGameState.clone());
			assertArrayEquals(initialGameState.getBoardElements(), testedGameSession.getGameStateList().get(0).getBoardElements());
			List<GameState> gameStateList = new LinkedList<GameState>();
			gameStateList.add(initialGameState);
			GameSession secondTestGameSession = new GameSession(gameStateList);
			assertArrayEquals(testedGameSession.getGameStateList().get(0).getBoardElements(), secondTestGameSession.getGameStateList().get(0).getBoardElements());
			if(GameStateOperatorPrerequisites.canMoveDown(initialGameState)){
				GameStateOperator.moveDown(initialGameState);
			}else{
				GameStateOperator.moveLeft(initialGameState);
			}
			gameStateList.add(initialGameState);
			testedGameSession.setGameStateList(gameStateList);
			assertEquals(testedGameSession.getGameStateList(), gameStateList);
		} catch (CloneNotSupportedException e) {
			logger.error("Failed to clone a Game State object while trying to create a new game");
			logger.error(ExceptionUtils.getStackTrace(e));
			fail();
		}
		
	}

}
