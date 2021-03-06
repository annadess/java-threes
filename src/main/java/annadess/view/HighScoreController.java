package annadess.view;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import annadess.model.GameSession;
import annadess.model.JsonManager;
import annadess.model.PersistencyManager;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HighScoreController {

	private List<GameSession> gameSessions = new LinkedList<GameSession>();
	private List<Integer> scoresUnordered = new LinkedList<Integer>();
	private List<String> names = new LinkedList<String>();

	@FXML
	private GridPane gridPane;

	public void loadHighScores() {

		setGameSessionsAndNames();

		setUnorderedScores();

		List<Integer> scoresOrdered = getScoresOrdered();

		for (Node child : gridPane.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(child);
			if (rowIndex == null) {
				rowIndex = 0;
			}

			if (rowIndex > scoresOrdered.size() - 1) {
				continue;
			}

			updateRowElements(child, rowIndex, scoresOrdered);
		}
	}

	private void updateRowElements(Node child, Integer rowIndex, List<Integer> scoresOrdered) {
		if (GridPane.getColumnIndex(child) == null) {
			Integer position = rowIndex + 1;
			StringBuilder positionString = new StringBuilder();
			positionString.append(position.toString()).append(". ");
			((Label) child).setText(positionString.toString());
		} else if (GridPane.getColumnIndex(child) == 1) {
			((Label) child).setText(names.get(scoresUnordered.indexOf(scoresOrdered.get(rowIndex))));
		} else {
			((Label) child).setText(scoresOrdered.get(rowIndex).toString());
		}
	}

	private List<Integer> getScoresOrdered() {
		List<Integer> scoresOrdered = new LinkedList<Integer>();
		scoresOrdered.addAll(scoresUnordered);
		Collections.sort(scoresOrdered, Collections.reverseOrder());
		return scoresOrdered;
	}

	private void setUnorderedScores() {
		for (GameSession iterateGameSession : gameSessions) {
			scoresUnordered.add(GameViewController.recalculateScore(iterateGameSession.getGameStateList(),
					iterateGameSession.getGameStateList().size()));
		}
	}

	private void setGameSessionsAndNames() {
		for (File jsonFile : PersistencyManager.getAllSaveFiles()) {
			gameSessions.add(JsonManager.getGameSessionFromJson(PersistencyManager.openFromFile(jsonFile)));
			names.add(jsonFile.getName().replaceAll(".json", ""));
		}
	}

}
