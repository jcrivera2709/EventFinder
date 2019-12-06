package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BulletinAdmin {

  // All the different Buttons
  public Button webButton;
  public Button mainMenuButton;
  public Button graphsButton;
  public TextArea dataArea;
  public Text bulletinTxt;
  public Button adminMenu;

  /**
   * Runs immediately on scene start up.
   */
  public void initialize() {
    try {

      File data = new File("src\\Application\\events.csv");
      StringBuilder sb = new StringBuilder();

      // this objects read the csvs line-by-line
      Scanner fileReader = new Scanner(data);

      while (fileReader.hasNext()) {
        String line = fileReader.nextLine();
        sb.append(line).append("\n");
      }

      String output = sb.toString();
      dataArea.appendText(output);


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Handles the buttons that changes scenes.
   *
   * @param actionEvent takes in actions from scene
   * @throws Exception throws exception
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
    } else if (actionEvent.getSource() == adminMenu) {
      stage = (Stage) adminMenu.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
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
