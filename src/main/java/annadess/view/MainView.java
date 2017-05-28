package annadess.view;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView extends Application {

	private static final Logger logger = LoggerFactory.getLogger(MainView.class);
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("JavaThrees");
		try {
			loadAndShowGameViewWindow(primaryStage);
		} catch (IOException e) {
			logger.debug("Can't find/load \"GameView.fxml\" FXML file.");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void loadAndShowGameViewWindow(Stage primaryStage) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		FXMLLoader gameViewLoader = new FXMLLoader(classLoader.getResource("GameView.fxml"));
		Pane gameViewPane = (Pane) gameViewLoader.load();
		Scene gameViewScene = new Scene(gameViewPane);
		GameViewController gameViewController = (GameViewController) gameViewLoader.getController();
		gameViewController.init(primaryStage);
		handleOnKeyPressedFunction(gameViewScene,gameViewController);
		gameViewScene.getStylesheets().add(classLoader.getResource("DefaultStyle.css").toExternalForm());
		primaryStage.setScene(gameViewScene);
	}

	private void handleOnKeyPressedFunction(Scene gameViewScene, GameViewController controller) {
		gameViewScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    controller.upButton(null); break;
                    case DOWN:  controller.downButton(null); break;
                    case LEFT:  controller.leftButton(null); break;
                    case RIGHT: controller.rightButton(null); break;
				default:
					break;
                }
            }
        });
	}
}
