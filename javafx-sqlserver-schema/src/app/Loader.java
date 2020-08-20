package app;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Loader {

	/**
	 * Create a stage with scene, with a pane inside of a .fxml file 
	 * @param app : application object for controller and pane mapping
	 * @param path : use for load the component from a .fxml file
	 * @param tag : used to get access to this component and his children
	 * @param windowTitle : title for the stage returned
	 * @return
	 */
	public static Stage preloadWindow(App app, String path, String tag, String windowTitle) 
	{	
		
		Stage stage = null;
		try 
		{
			stage = new Stage();
			stage.setOnCloseRequest( e -> app.end() );
			Scene scene = preloadPanel(app, path, tag);
			
			if (scene != null) {
				
				stage.setTitle(windowTitle);
				stage.setResizable(false);
				stage.setScene(scene);
				
			} else 
				throw new Exception("Archivo .FXML no encontrado");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return stage;
	}
	
	/**
	 * Load a panel given a route to .fxml file
	 * @param app : app object for controller and pane mapping
	 * @param path : use for load the component from a .fxml file
	 * @param tag : used to get access to this component and his children
	 * @return
	 */
	public static Scene preloadPanel(App app, String path, String tag) {
		
		Pane mainRoot = null;
		Scene scene = null;
		
		try 
		{
			FXMLLoader loader = new FXMLLoader(Loader.class.getResource(path));
			mainRoot = loader.load();
			
			Controller controller = loader.<Controller> getController();
			scene = new Scene(mainRoot);
			
			// add pane and controller for application handler use
			app.controllerMap.put(tag, controller);
			app.paneMap.put(tag, mainRoot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return scene;
	}
	
	/**
	 * Wrap a pane into a stage and return it
	 * @param pane 
	 * @return stage
	 */
	public static Stage wrapPane(Pane pane) {
		
		Stage stage = new Stage();
		Scene mainScene = new Scene(pane);
		stage.setResizable(false);
		stage.setScene(mainScene);
		
		return stage;
	}
}
