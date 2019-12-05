package application;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

  public PasswordField pwField;
  public TextField userField;
  public Button loginButton;

  public HashMap<String, String> admins = CsvToData.setData(true); // for admin accounts
  public HashMap<String, String> users = CsvToData.setData(false); // for user accounts

  public void initialize() {

  }

  /**
   * This function executes the login algo that will check the credentials, if false, nothing will
   * happen.
   *
   * @throws IOException
   */
  public void LogInButton() throws IOException {

    Stage stage = null;
    Parent root = null;

    // depending on the the username and password it will send you the either main menu or admin screen
    if (users.containsKey(userField.getText()) && users.get(userField.getText())
        .equals(users.get(userField.getText()))) {
      stage = (Stage) loginButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    } else if (admins.containsKey(userField.getText()) && admins.get(userField.getText())
        .equals(admins.get(userField.getText()))) {
      stage = (Stage) loginButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
    } else {
      stage = (Stage) loginButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    }

    // Gets root from if statement.
    // Scene width and height are both defined in main.
    assert root != null;
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    stage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();

  }

}