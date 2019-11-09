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

  /**
   * It initializes the behavior and data for the graphs.
   */
  public void initialize() {


    barChart.getData().clear();

    xAxis.setLabel("Categories");
    yAxis.setLabel("Number of Events");

    XYChart.Series series1 = new XYChart.Series();
    series1.getData().add(new XYChart.Data("Pets", 100.34));
    series1.getData().add(new XYChart.Data("Religion", 50.82));
    series1.getData().add(new XYChart.Data("Cars", 35));
    series1.getData().add(new XYChart.Data("Sport", 66));
    series1.getData().add(new XYChart.Data("Fraternity", 12));
    series1.getData().add(new XYChart.Data("Sorority", 12));
    series1.getData().add(new XYChart.Data("School", 12));
    series1.getData().add(new XYChart.Data("Adult", 12));
    series1.getData().add(new XYChart.Data("Kids", 12));
    series1.getData().add(new XYChart.Data("Party", 12));

    barChart.getData().addAll(series1);
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
      root = FXMLLoader.load(getClass().getResource("WebEngine.fxml"));
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
