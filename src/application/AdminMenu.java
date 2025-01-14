package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Admin menu allows you to create/add/edit/remove events from the event list.
 *
 * @author Jose Rivera, Jose Ruiz-Ramon
 */

public class AdminMenu {

  public ComboBox categoryBox;

  // Buttons for the events
  public Button addEventButton;
  public Button eventsButton;
  public Button removeEventButton;
  public Button editEventButton;

  // Text for the events
  public Text eventLocationTxt;
  public Text eventIdText;
  public Text eventNameTxt;
  public Text addEventTxt;
  public Text eventDescTxt;
  public Text eventDateText;

  // Text fields and areas.
  public TextField eventIdField;
  public TextField eventNameField;
  public TextField eventLocationField;
  public TextField eventDateField;
  public TextArea eventDescription;

  /**
   * This function appends the Categories enums to the choiceBox.
   */
  public void initialize() {
    // clears items in choice box
    categoryBox.getItems().clear();
    // Goes through the enum named Categories and adds them to the combobox
    for (Categories item : Categories.values()) {
      categoryBox.getItems().add(item);
    } // for

  } // initialize

  /**
   * This function adds the events when the Add Event button is clicked.
   *
   * @throws IOException throws io exception.
   */
  public void addEvent() throws IOException {

    //  String id = eventId.getText();

    String id = eventIdField.getText();
    String eventDescriptionString = eventDescription.getText();
    String eventNameString = eventNameField.getText();
    String eventLocationString = eventLocationField.getText();

    //String eventDateString = eventDateField.getText(); // add text box for event date
    String eventDateString = "March 5, 2020";

    String eventType = categoryBox.getValue().toString();

    String appendData;
    String fileUrl = "src/Application/events.csv";

    BufferedWriter bw = new BufferedWriter(new FileWriter(fileUrl, true));

    appendData = String
        .format(
            "ID:%s\nEVENT NAME: %s\nEVENT DATE: %s\nEVENT LOCATION: %s\nEVENT DESCRIPTION: "
                + "%s\nEVENT TYPE: %s\n",
            id, eventNameString, eventDateString, eventLocationString, eventDescriptionString,
            eventType);

    bw.write(appendData);
    bw.close();

  } // addEvent()

  /**
   * This function removes the events when the Remove Event button is clicked. ()
   *
   * @throws IOException is thrown
   */
  public void removeEvent() throws IOException {
    /*
          WE NEED THE REMOVE BTN
    */

    String id = eventIdField.getText(); // we need a field for id
    String fileUrl = "src/Application/events.csv";
    List<String> linebyline = new ArrayList<String>();
    BufferedReader reader = new BufferedReader(new FileReader(fileUrl));

    File data = new File(fileUrl);

    // this objects read the csvs line-by-line
    Scanner fileReader = new Scanner(data);

    while (fileReader.hasNext()) {
      String line = fileReader.nextLine();
      linebyline.add(line);
    }

    fileReader.close();
    reader.close();

    for (int i = 0; i < linebyline.size(); i = i + 5) {
      if (linebyline.get(i).equals("ID:" + id)) {

        System.out.println(linebyline.get(i));
        System.out.println(linebyline.get(i + 1));
        System.out.println(linebyline.get(i + 2));
        System.out.println(linebyline.get(i + 3));
        System.out.println(linebyline.get(i + 4));
        System.out.println(linebyline.get(i + 5));

        linebyline.remove(i);   // id line
        linebyline.remove(i);   // event name line
        linebyline.remove(i);   // date line
        linebyline.remove(i);   // location line
        linebyline.remove(i);   // event desc line
        linebyline.remove(i);   // event type line
        break;
      }
    }

    StringBuilder finalSb = new StringBuilder("");
    for (String s : linebyline) {
      if (!s.equals("")) {
        finalSb.append(s + "\n");
      }
    }
    String finalString = finalSb.toString();

    //    System.out.println(finalString);

    BufferedWriter writer = new BufferedWriter(new FileWriter(fileUrl));

    writer.write(finalString);
    writer.close();

  } // removeEvent()

  /**
   * This function updates/edits the selected event by ID from textBox.
   *
   * @throws IOException is thrown
   */
  public void updateEvent() throws IOException {
    /*
            WE NEED THE UPDATE BTN
    */

    String id = eventIdField.getText();

    String fileUrl = "src/Application/events.csv";
    List<String> linebyline = new ArrayList<String>();
    BufferedReader reader = new BufferedReader(new FileReader(fileUrl));

    File data = new File(fileUrl);

    // this objects read the csvs line-by-line
    Scanner fileReader = new Scanner(data);

    while (fileReader.hasNext()) {
      String line = fileReader.nextLine();
      linebyline.add(line);
    }

    fileReader.close();
    reader.close();

    for (int i = 0; i < linebyline.size(); i = i + 5) {
      if (linebyline.get(i).equals("ID:" + id)) {

        System.out.println(linebyline.get(i));
        System.out.println(linebyline.get(i + 1));
        System.out.println(linebyline.get(i + 2));
        System.out.println(linebyline.get(i + 3));
        System.out.println(linebyline.get(i + 4));
        System.out.println(linebyline.get(i + 5));

        linebyline.remove(i);   // id line
        linebyline.remove(i);   // event name line
        linebyline.remove(i);   // date line
        linebyline.remove(i);   // location line
        linebyline.remove(i);   // event desc line
        linebyline.remove(i);   // event type line

        linebyline.add("ID:" + id);
        linebyline.add("EVENT NAME: " + eventNameField.getText());
        linebyline.add("EVENT DATE: " + eventDateField.getText());
        linebyline.add("EVENT LOCATION: " + eventLocationField.getText());
        linebyline.add("EVENT DESCRIPTION: " + eventDescription.getText());
        linebyline.add("EVENT TYPE: " + categoryBox.getValue().toString());

        break;
      }
    }

    StringBuilder finalSb = new StringBuilder("");
    for (String s : linebyline) {
      if (!s.equals("")) {
        finalSb.append(s + "\n");
      }
    }
    String finalString = finalSb.toString();

    //    System.out.println(finalString);

    BufferedWriter writer = new BufferedWriter(new FileWriter(fileUrl));

    writer.write(finalString);
    writer.close();


  } // removeEvent()

  /**
   * This method handles the buttons of the scene, it will change the scene depending on what button
   * is pressed.
   *
   * @param actionEvent gets the action from the scene.
   * @throws IOException throws exception.
   */
  public void handleButtonAction(ActionEvent actionEvent) throws IOException {

    Stage stage = null;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.
    if (actionEvent.getSource() == eventsButton) {
      stage = (Stage) eventsButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("bulletinAdmin.fxml"));
    } else {
      root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
    }
    // Gets root from if statement.
    // Scene width and height are both defined in main.
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    assert stage != null;
    stage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    stage.show();
  } // handleButtonAction()
} // class

