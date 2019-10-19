package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller {

  public Button mapsButton;
  public Button mainMenuButton;
  public int sceneWidth = 700;
  public int sceneHeight = 600;

  @FXML
  private WebView googleMaps = new WebView();

  public void initialize() {

    WebEngine engine = googleMaps.getEngine();
    double longitude = 26.4556419;
    double latitude = -81.768879;
    double zoom = 14;
    String zoomString = zoom + "z";
    engine.load("https://www.google.com/maps/@" + longitude + "," + latitude + "," + zoomString);
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
    scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();
  }
}
