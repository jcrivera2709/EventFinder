package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author José Rivera, Jose Ruiz-Ramon, Neel Patel, Carolina Bado-Cortes, Jaisson Lazo.
 */

public class Main extends Application {

  static final int SCENE_WIDTH = 652;
  static final int SCENE_HEIGHT = 500;

  /**
   * @param stage is the scene that the will load when the program runs.
   * @throws Exception the exception is attributed to the possibility of GUI failure.
   */
  @Override
  public void start(Stage stage) throws Exception {

    // Main menu scene using bulletin.fxml and style.css
    // Sets the first scene for the program the following scenes are found in the controller
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Scene mainMenu = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    stage.setTitle("BULLETIN");
    stage.setScene(mainMenu);
    mainMenu.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();
  }

  /**
   * Launches the csv database from class CsvToData.
   *
   * @param args are arguments that are in a string array.
   */
  public static void main(String[] args) {

    launch(args);

  }

}