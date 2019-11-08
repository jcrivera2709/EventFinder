package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * This class will allow the user to see the frequencies and the types of events.
 */
public class Graphs {

  // All the different Buttons
  public Button mapsButton;
  public Button mainMenuButton;
  public Button eventMenuButton;
  public Button graphsButton;

  // Bar chart
  public CategoryAxis xAxis = new CategoryAxis();
  public NumberAxis yAxis = new NumberAxis();
  public BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

  @FXML
  private WebView googleMaps = new WebView();

  /**
   * It initializes the behavior and data for the graphs.
   */
  public void initialize() {

    xAxis.setLabel("Categories");
    yAxis.setLabel("Number of Events");

    XYChart.Series group = new XYChart.Series();

    group.getData().add(new XYChart.Data(Categories.Pets, 100.34));
    group.getData().add(new XYChart.Data(Categories.Religion, 100.34));
    group.getData().add(new XYChart.Data(Categories.Cars, 100.34));
    group.getData().add(new XYChart.Data(Categories.Sport, 100.34));
    group.getData().add(new XYChart.Data(Categories.Fraternity, 100.34));
    group.getData().add(new XYChart.Data(Categories.Sorority, 100.34));
    group.getData().add(new XYChart.Data(Categories.School, 100.34));
    group.getData().add(new XYChart.Data(Categories.Adult, 100.34));
    group.getData().add(new XYChart.Data(Categories.Kids, 100.34));
    group.getData().add(new XYChart.Data(Categories.Kids, 100.34));
    group.getData().add(new XYChart.Data(Categories.Party, 100.34));

//            Pets,
//            Religion,
//            Cars,
//            Sport,
//            Fraternity,
//            Sorority,
//            School,
//            Adult,
//            Kids,
//            Party
    barChart.getData().addAll(group);

    //currently has hard coded long, lat, and zoom
    WebEngine engine = googleMaps.getEngine();
    double longitude = 26.4556419;
    double latitude = -81.768879;
    double zoom = 14;
    String zoomString = zoom + "z";
    engine.load("https://www.google.com/maps/@" + longitude + "," + latitude + "," + zoomString);
  }

  /**
   * This function handles every user event.
   * @param actionEvent
   * @throws Exception
   */
  public void handleButtonAction(ActionEvent actionEvent) throws Exception {

    Stage stage;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.
    if (actionEvent.getSource() == mapsButton) {
      stage = (Stage) mapsButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("map.fxml"));
    } else if (actionEvent.getSource() == graphsButton) {
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
