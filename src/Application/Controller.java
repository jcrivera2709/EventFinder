package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

  public Button mapsButton;
  public Button mainMenuButton;
  public int sceneWidth = 700;
  public int sceneHeight = 600;

  public void initialize() {

  }

  public void handleButtonAction(ActionEvent actionEvent) throws Exception {

    Stage stage;
    Parent root;

    // if user presses 'Go to Maps' with fx:id mapsButton it will remove previous scene and load
    // the maps.fxml file
    if (actionEvent.getSource() == mapsButton) {
      stage = (Stage) mapsButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("map.fxml"));
    } else {
      stage = (Stage) mainMenuButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("bulletin.fxml"));
    }
    Scene scene = new Scene(root, sceneWidth, sceneHeight);
    stage.setScene(scene);
    stage.show();
  }
}
