package Application;

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

  public void initialize() {
  }

  public void LogInButton() throws IOException {

    Stage stage = null;
    Parent root = null;

    HashMap<String, String> username = new HashMap<>();

    // list of user names and passwords that are acceptable in the pwField and userField
    // using HashMap
    username.put("user", "1234");
    username.put("admin", "password");

    // depending on the the username and password it will send you the either main menu or admin screen
    if (username.containsKey(userField.getText())) {
      if (username.get(userField.getText()).equals("password")) {
        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
      } else if (username.get(userField.getText()).equals("1234")) {
        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
      } else {
        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
      }
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