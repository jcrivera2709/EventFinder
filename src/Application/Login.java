package Application;

import java.awt.Desktop;
import java.net.URI;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

  public PasswordField pwField;
  public TextField userField;
  public Button loginButton;

  private boolean correctPw(String password) {
    boolean pw = false;
    String correct = "password";
    if (password.equals(correct)) {
      pw = true;
    }
    return pw;
  }

  public void LogInButton(ActionEvent actionEvent) {
    if (correctPw(pwField.getText())) {
      try {
        Desktop desktop = java.awt.Desktop.getDesktop();
        URI oURL = new URI("http://www.youtube.edu");
        desktop.browse(oURL);
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    }
  }
}