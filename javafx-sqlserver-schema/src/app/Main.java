package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	/**
	 * Start application
	 */
	@Override
	public void start(Stage primaryStage) {
		App.getInstance().start(primaryStage);
	}
	
	/**
	 * Initializacion with all args for the JavaFX platform starts
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
