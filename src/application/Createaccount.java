package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Creates a new user account and adds it to the CSV file, only a normal user.
 *
 * @author Jose Ruiz-Ramon, José Rivera
 */
public class Createaccount {

  public TextField usernameField;
  public TextField confirmPassword;
  public TextField newPassword;
  public Button createAccountButton;
  public Button backButton;
  public Text usernameText;
  public Text newPasswordText;
  public Text confirmPasswordText;

  /**
   * This function creates user accounts.
   *
   * @param actionEvent gets the actions from the scenes.
   * @throws IOException throws ioexception.
   */
  public void createAccount(ActionEvent actionEvent) throws IOException {

    String fileUrl = "src/Application/userAccs.csv";
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileUrl, true));

    String username = usernameField.getText();
    String password = newPassword.getText();
    String confirmPass = confirmPassword.getText();

    if (isPasswordValid(password, confirmPass)) {

      String appendData = String
          .format("\n%s,%s", username, password);

      bw.write(appendData);
      bw.close();


    } else {
      Alert notSamePassword = new Alert(AlertType.ERROR);
      notSamePassword.setTitle("Password does not match!");
      notSamePassword.setContentText(null);
      notSamePassword.showAndWait();
    }

  }

  /**
   * This function checks if the password is valid.
   *
   * @param password    is the password the user wants
   * @param confirmPass is the confirmation password
   * @return true if the password is the same as confirm password.
   */
  private boolean isPasswordValid(String password, String confirmPass) {
    boolean match = false;
    if (password.equals(confirmPass)) {
      match = true;
    }
    return match;
  }

  /**
   * This function is the event handler for stage switching.
   *
   * @param actionEvent checks for action event on scene
   * @throws IOException throws ioexception.
   */
  public void handleButton(ActionEvent actionEvent) throws IOException {

    Stage stage = (Stage) backButton.getScene().getWindow();
    ;
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    ;

    // Gets root from if statement.
    // Scene width and height are both defined in main.
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    stage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();
  }
}
