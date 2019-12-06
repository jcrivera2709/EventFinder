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
import javafx.stage.Stage;

/**
 * @author Jose Ruiz-Ramon, Jose Rivera
 */
public class Createaccount {

  public TextField usernameField;
  public TextField confirmPassword;
  public TextField newPassword;
  public Button createAccountButton;
  public Button backButton;

  /**
   *
   * @param actionEvent
   * @throws IOException
   *
   * This function creates user accounts.
   */
  public void createAccount(ActionEvent actionEvent) throws IOException {

    String fileUrl = "src/Application/userAccs.csv";
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileUrl, true));

    String username = usernameField.getText();
    String password = newPassword.getText();
    String confirmPass = confirmPassword.getText();

    if (isPasswordValid(password, confirmPass)) {

        String appendData = String
                .format("\n%s,%s" , username, password);

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
   * @param password
   * @param confirmPass
   * @return
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
   * @param actionEvent
   * @throws IOException
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
