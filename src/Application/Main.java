package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.StringBuilder;
import java.util.HashMap;

public class Main extends Application {

  final static int LAST_ELEM = 250;
  private static StringBuilder sb = new StringBuilder();
  public static final int SCENE_WIDTH = 652;
  public static final int SCENE_HEIGHT = 500;

  @Override
  public void start(Stage stage) throws Exception {

    // Main menu scene using bulletin.fxml and style.css
    // Sets the first scene for the program the following scenes are found in the controller
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Scene mainMenu = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    stage.setTitle("B U L L E T I N");
    stage.setScene(mainMenu);
    mainMenu.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();
  }

  public static void main(String[] args) {

    HashMap<String,String> admins = CsvToData.setData(true);  // for admins
    HashMap<String,String> users = CsvToData.setData(false); // for users

    launch(args);

  }

}