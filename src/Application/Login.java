package Application;

import java.awt.Desktop;
import java.net.URI;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

  public PasswordField pwField;
  public TextField userField;
  public Button loginButton;

  public void initialize() {
  }

  public void LogInButton(ActionEvent actionEvent) {

    HashMap<String, String> username = new HashMap<>();

    username.put("user", "1234");
    username.put("admin", "password");

    if (username.containsKey(userField.getText())) {

    }
  }
}