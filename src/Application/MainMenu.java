package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This is the user's menu when he or she logs in from Main.java.
 */
public class MainMenu {

  // All the different Buttons
  public Button webButton;
  public Button mainMenuButton;
  public Button eventMenuButton;
  public Button graphsButton;
  public Button loginMenuButton;

  /**
   * This function handles the events inside this window.
   * @param actionEvent
   * @throws Exception
   */
  public void handleButtonAction(ActionEvent actionEvent) throws Exception {

    Stage stage;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.
    if (actionEvent.getSource() == webButton) {
      stage = (Stage) webButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("WebEngine.fxml"));
    } else if (actionEvent.getSource() == graphsButton) {
      stage = (Stage) graphsButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("Graphs.fxml"));
    } else if (actionEvent.getSource() == eventMenuButton) {
      stage = (Stage) eventMenuButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("bulletin.fxml"));
    } else if (actionEvent.getSource() == loginMenuButton) {
      stage = (Stage) eventMenuButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    } else {
      stage = (Stage) mainMenuButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
    } // last else

    // Gets root from if statement.
    // Scene width and height are both defined in main.
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    stage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    stage.show();
  } // handleButtonAction()

} // class
