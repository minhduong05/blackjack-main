package app.backend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCombination;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class App extends Application{

	@Override
	public void start(final Stage primaryStage) throws Exception {

		Image icon = new Image(App.class.getResourceAsStream("/app/icon.png"));
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();


		Scene scene = new Scene(FXMLLoader.load(App.class.getResource("App.fxml")));
		scene.setFill(Color.BLACK);
		primaryStage.setTitle("Blackjack");
		primaryStage.getIcons().add(icon);
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(false);
		primaryStage.setX(screenBounds.getMinX());
		primaryStage.setY(screenBounds.getMinY());
		primaryStage.setWidth(screenBounds.getWidth());
		primaryStage.setHeight(screenBounds.getHeight());
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ESC"));
		scene.setOnKeyPressed(event -> {
			switch (event.getCode()) {
				case F11: // Khi nhấn F11
					primaryStage.setFullScreen(!primaryStage.isFullScreen());
					break;
				default:
					break;
			}
		});
		primaryStage.show();
	}

	public static void main(final String[] args) {
		App.launch(args);
	}
}