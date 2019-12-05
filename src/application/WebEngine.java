package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebEngine {

  public Button mainMenuButton;
  public Button eventMenuButton;
  public Button graphsButton;

  @FXML
  private WebView webPage = new WebView();

  /**
   * Runs web engine on start up.
   */
  public void initialize() {

    //currently sends you to the FGCU organizations website
    javafx.scene.web.WebEngine engine = webPage.getEngine();
    engine.load("https://fgcu.campuslabs.com/engage/organizations");
  }

  /**
   * Handle button exceptions to change scenes when the button is pressed.
   *
   * @param actionEvent gets the action event from the current scene.
   * @throws Exception throws exception.
   */
  public void handleButtonAction(ActionEvent actionEvent) throws Exception {

    Stage stage;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.
    if (actionEvent.getSource() == graphsButton) {
      stage = (Stage) graphsButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("Graphs.fxml"));
    } else if (actionEvent.getSource() == eventMenuButton) {
      stage = (Stage) eventMenuButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("bulletin.fxml"));
    } else {
      stage = (Stage) mainMenuButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
    }

    // Gets root from if statement.
    // Scene width and height are both defined in main.
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    stage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();
  }

}
