package annadess.view;

import java.io.IOException;

import annadess.GameViewController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) {   

		primaryStage.setTitle("JavaThrees");
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			FXMLLoader loader = new FXMLLoader(classLoader.getResource("GameView.fxml"));
			Pane gameViewPane = (Pane) loader.load();
			GameViewController controller = (GameViewController) loader.getController();
			Scene gameViewScene = new Scene(gameViewPane);
			controller.init(primaryStage);
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
			gameViewScene.getStylesheets().add(classLoader.getResource("DefaultStyle.css").toExternalForm());
			primaryStage.setScene(gameViewScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	

}