package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App {
	
	public HashMap<String, Controller> controllerMap;
	public HashMap<String, Pane> paneMap;
	public HashMap<String, Connection> connectionMap;
	public HashMap<String, Stage> stageMap;
	
	/**
	 * Load every window before the application start
	 * to earn time between windows
	 */
	public void preload() 
	{
		
	}
	
	/**
	 * Start : the main function in application
	 * to run and show the main windows
	 */
	public void start(Stage stage) 
	{
		
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(500, 500);
		
		Button b = new Button("Hola Mundo!");
		b.setOnAction( e -> JOptionPane.showMessageDialog(null, "Hola Mundo!"));
		
		pane.getChildren().add(b);
		
		Scene s = new Scene(pane);
		stage.setScene(s);
		
		stage.show();	
	}
	
	/**
	 * Finalize the application : connections and JavaFX engine
	 */
	public void end() 
	{
		connectionMap.forEach( 
			(key, connection) -> {
				try {
					connection.close();
				} catch(SQLException e) {}
			} );
		
		Platform.exit();
		System.exit(0);
	}
	
	/**
	 * Singleton: unique instance for app
	 */
	public static App getInstance() 
	{
		if (self == null)
			self = new App();
		return self;
	}
	
	/**
	 * App builder
	 */
	private App() 
	{
		controllerMap = new HashMap<String, Controller>();
		stageMap 	  = new HashMap<String, Stage>();
		paneMap 	  = new HashMap<String, Pane>();
		connectionMap = new HashMap<String, Connection>();
	}
	
	/**
	 * self : app instance object
	 */
	static App self;
}
