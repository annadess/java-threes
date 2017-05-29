package annadess.view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import annadess.GameStateGenerator;
import annadess.GameStateOperator;
import annadess.GameStateOperatorPrerequisites;
import annadess.model.GameSession;
import annadess.model.GameState;
import annadess.model.JsonManager;
import annadess.model.PersistencyManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GameViewController {

	private static final Logger logger = LoggerFactory.getLogger(GameViewController.class);
	private Stage stage;
	private GameSession currentGameSession;
	private GameState currentGameState;
	private Integer score = 0;

	@FXML
	private Label gameOverLabel;

	@FXML
	private Label scoreLabel;

	@FXML
	private Label nextLabel;

	@FXML
	private GridPane gridPane;

	public void init(Stage stage) {
		this.stage = stage;
	}

	@FXML
	public void downButton(ActionEvent event) {
		if (GameStateOperatorPrerequisites.canMoveDown(currentGameState)) {
			score = score.intValue() + currentGameState.getNextElement();
			GameStateOperator.moveDown(currentGameState);
			updateGameSession();
			updateLabels();
		}
	}

	@FXML
	public void leftButton(ActionEvent event) {
		if (GameStateOperatorPrerequisites.canMoveLeft(currentGameState)) {
			score = score.intValue() + currentGameState.getNextElement();
			GameStateOperator.moveLeft(currentGameState);
			updateGameSession();
			updateLabels();
		}
	}

	@FXML
	public void rightButton(ActionEvent event) {
		if (GameStateOperatorPrerequisites.canMoveRight(currentGameState)) {
			score = score.intValue() + currentGameState.getNextElement();
			GameStateOperator.moveRight(currentGameState);
			updateGameSession();
			updateLabels();
		}
	}

	@FXML
	public void upButton(ActionEvent event) {
		if (GameStateOperatorPrerequisites.canMoveUp(currentGameState)) {
			score = score.intValue() + currentGameState.getNextElement();
			GameStateOperator.moveUp(currentGameState);
			updateGameSession();
			updateLabels();
		}
	}

	@FXML
	void newGameButton(ActionEvent event) {
		currentGameState = GameStateGenerator.generateGameState();
		initGameSession();
		updateLabels();
		logger.info("A new game has begun.");
	}

	@FXML
	void loadButton(ActionEvent event) {
		PersistencyManager.createSaveDir();
		FileChooser fileChooser = new FileChooser();
		configureFileChooser(fileChooser);
		File loadFile = fileChooser.showOpenDialog(stage);
		if (loadFile != null) {
			processLoading(loadFile);
			if(this.currentGameSession!=null){
				logger.info(new StringBuilder().append("Save file ").append(loadFile.toPath().toString()).append(" has been successfully loaded.").toString());
			}
		}
	}

	@FXML
	void saveButton(ActionEvent event) {
		PersistencyManager.createSaveDir();
		FileChooser fileChooser = new FileChooser();
		configureFileChooser(fileChooser);
		File saveFile = fileChooser.showSaveDialog(stage);
		if (saveFile != null) {
			PersistencyManager.saveToFile(saveFile, JsonManager.getJsonFromGameSession(currentGameSession));
			logger.info(new StringBuilder().append("New save has been successfully created at: ").append(saveFile.toPath().toString()).toString());
		}
	}

	@FXML
	void exitButton(ActionEvent event) {
		logger.info("Exiting...");
		Platform.exit();
	}

	@FXML
	void showHighScore(ActionEvent event) {
		try {
			loadAndShowHighScoreWindow();
		} catch (IOException e) {
			logger.debug("Can't find/load \"HighscoreView.fxml\" FXML file.");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
	}

	@FXML
	void undoButton(ActionEvent event) {
		List<GameState> tempSessionList = this.currentGameSession.getGameStateList();
		if (tempSessionList.size() > 1) {
			tempSessionList.remove(tempSessionList.size() - 1);
			this.currentGameState = tempSessionList.get(tempSessionList.size() - 1);
			this.score = 0;
			this.score = recalculateScore(tempSessionList, tempSessionList.size());
			updateLabels();
			logger.info("Latest move undone!");
		}
	}

	private void loadAndShowHighScoreWindow() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		FXMLLoader loader = new FXMLLoader(classLoader.getResource("HighscoreView.fxml"));
		Pane highScoreViewPane = (Pane) loader.load();
		Scene highScoreViewScene = new Scene(highScoreViewPane);
		Stage highScoreStage = new Stage();
		highScoreStage.setTitle("High-score");
		highScoreStage.setScene(highScoreViewScene);
		highScoreStage.setResizable(false);
		highScoreStage.show();
		((HighScoreController) loader.getController()).loadHighScores();
		logger.info("Opened High-score Window");
	}

	private void processLoading(File loadFile) {
		String jsonInfo = PersistencyManager.openFromFile(loadFile);
		try {
			this.currentGameSession = JsonManager.getGameSessionFromJson(jsonInfo);
			List<GameState> gameSessionList = currentGameSession.getGameStateList();
			int sessionLength = gameSessionList.size();
			this.currentGameState = gameSessionList.get(sessionLength - 1);
			this.score = recalculateScore(gameSessionList, sessionLength);
			updateLabels();
		} catch (Exception e) {
			logger.debug("Something went wrong while processing the JSON savefile");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
	}

	private void updateLabels() {
		int[][] boardElements = currentGameState.getBoardElements();
		Integer nextElement = currentGameState.getNextElement();
		for (Node child : gridPane.getChildren()) {
			Integer column = getCorrectIndex(GridPane.getColumnIndex(child));
			Integer row = getCorrectIndex(GridPane.getRowIndex(child));
			if (child instanceof Label) {
				Label label = (Label) child;
				Integer number = Integer.valueOf(boardElements[row][column]);
				label.setText(getCorrectStringFromNumber(number));
			}
		}
		nextLabel.setText(nextElement.toString());
		scoreLabel.setText(score.toString());
		if (GameStateOperatorPrerequisites.isGameOver(currentGameState)) {
			gameOverLabel.setText("Game Over!");
		} else {
			gameOverLabel.setText(null);
		}
	}

	public static Integer recalculateScore(List<GameState> gameSessionList, int sessionLength) {
		Integer returnScore = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				returnScore = returnScore.intValue() + gameSessionList.get(0).getBoardElements()[i][j];
			}
		}
		for (GameState iteratedGameState : gameSessionList) {
			if (iteratedGameState.equals(gameSessionList.get(sessionLength - 1))) {
				break;
			}
			returnScore += iteratedGameState.getNextElement();
		}
		return returnScore;
	}

	private void initGameSession() {
		try {
			currentGameSession = new GameSession(currentGameState.clone());
		} catch (CloneNotSupportedException e) {
			logger.debug("Failed to clone a Game State object while trying to create a new game");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
		score = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				score = score.intValue() + currentGameState.getBoardElements()[i][j];
			}
		}
	}

	private void updateGameSession() {
		try {
			currentGameSession.getGameStateList().add(currentGameState.clone());
		} catch (CloneNotSupportedException e) {
			logger.debug("Failed to clone a Game State object while trying to update current Game Session");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
	}

	private void configureFileChooser(FileChooser fileChooser) {
		fileChooser.setInitialDirectory(PersistencyManager.saveFolder);
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON Files", "*.json"),
				new FileChooser.ExtensionFilter("All Files", "*"));
	}

	private int getCorrectIndex(Integer mightBeNull) {
		return (mightBeNull == null) ? 0 : mightBeNull;
	}

	private String getCorrectStringFromNumber(Integer mightBeZero) {
		return (mightBeZero.equals(0)) ? "" : mightBeZero.toString();
	}

}