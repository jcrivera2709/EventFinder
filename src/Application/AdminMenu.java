package Application;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

/**
 * @author Jose Rivera, Jose Ruiz-Ramon
 */

public class AdminMenu {

  public ComboBox categoryBox;
  public Button addEventButton;
  public TextField eventNameField;
  public TextArea eventDescription;

  /**
   * This function appends the Categories enums to the choiceBox.
   */
  public void initialize()
  {
    // clears items in choice box
    categoryBox.getItems().clear();
    // Goes through the enum named Categories and adds them to the combobox
    for (Categories item : Categories.values()) {
      categoryBox.getItems().add(item);
    } // for

  } // initialize

  /**
   * This function adds the events when the Add Event button is clicked.
   * @throws IOException
   */
  public void addEvent() throws IOException {

    String eventDescriptionString = eventDescription.getText();
    String eventNameString = eventNameField.getText();

    String enumEvent = "EVENT"; // lol I need help to make the choiceBox pull the selected type from the enum lol
    String appendData = null;
    String fileUrl = "src/Application/events.csv";

    BufferedWriter bw = new BufferedWriter(new FileWriter(fileUrl, true));

    appendData = String.format("EVENT NAME: %s\nEVENT DESCRIPTION: %s\nEVENT TYPE: %s\n\n",
            eventNameString, eventDescriptionString, enumEvent);

    bw.write(appendData);
    bw.close();


  } // addEvent()


} // class
