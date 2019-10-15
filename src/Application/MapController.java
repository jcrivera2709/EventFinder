package Application;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MapController {

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
}
