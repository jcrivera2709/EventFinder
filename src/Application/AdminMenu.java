package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import javafx.stage.Stage;

/**
 * @author Jose Rivera, Jose Ruiz-Ramon
 */

public class AdminMenu {

  public ComboBox categoryBox;
  public Button addEventButton;
  public TextField eventNameField;
  public TextArea eventDescription;
  public Button eventsButton;
  private int petValue;
  private int partyValue;
  private int sportValue;
  private int relValue;
  private int adultValue;
  private int carValue;
  private int fratValue;
  private int sorValue;
  private int kidValue;
  private int schoolValue;

  int getPetValue() {
    return petValue;
  }

  private void setPetValue(int petValue) {
    this.petValue = petValue;
  }

  int getPartyValue() {
    return partyValue;
  }

  private void setPartyValue(int partyValue) {
    this.partyValue = partyValue;
  }

  int getSportValue() {
    return sportValue;
  }

  private void setSportValue(int sportValue) {
    this.sportValue = sportValue;
  }

  int getRelValue() {
    return relValue;
  }

  private void setRelValue(int relValue) {
    this.relValue = relValue;
  }

  int getAdultValue() {
    return adultValue;
  }

  private void setAdultValue(int adultValue) {
    this.adultValue = adultValue;
  }

  int getCarValue() {
    return carValue;
  }

  private void setCarValue(int carValue) {
    this.carValue = carValue;
  }

  int getFratValue() {
    return fratValue;
  }

  private void setFratValue(int fratValue) {
    this.fratValue = fratValue;
  }

  int getSorValue() {
    return sorValue;
  }

  private void setSorValue(int sorValue) {
    this.sorValue = sorValue;
  }

  int getKidValue() {
    return kidValue;
  }

  private void setKidValue(int kidValue) {
    this.kidValue = kidValue;
  }

  int getSchoolValue() {
    return schoolValue;
  }

  private void setSchoolValue(int schoolValue) {
    this.schoolValue = schoolValue;
  }

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
   * @throws IOException
   */
  public void addEvent() throws IOException {

    String eventDescriptionString = eventDescription.getText();
    String eventNameString = eventNameField.getText();
    String eventType = categoryBox.getValue().toString();

    String appendData;
    String fileUrl = "src/Application/events.csv";

    BufferedWriter bw = new BufferedWriter(new FileWriter(fileUrl, true));

    appendData = String.format("EVENT NAME: %s\nEVENT DESCRIPTION: %s\nEVENT TYPE: %s\n\n",
        eventNameString, eventDescriptionString, eventType);

    bw.write(appendData);
    bw.close();

    if (categoryBox.getValue().toString().equalsIgnoreCase("Pets")) {
      setPetValue(petValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Religion")) {
      setRelValue(relValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Cars")) {
      setCarValue(carValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Sport")) {
      setSportValue(sportValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Fraternity")) {
      setFratValue(fratValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Sorority")) {
      setSorValue(sorValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("School")) {
      setSchoolValue(schoolValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Adult")) {
      setAdultValue(adultValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Kids")) {
      setKidValue(kidValue++);
    } else if (categoryBox.getValue().toString().equalsIgnoreCase("Party")) {
      setPartyValue(partyValue++);
    }

  } // addEvent()

  public void handleButtonAction(ActionEvent actionEvent) throws IOException {

    Stage stage = null;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.
    if (actionEvent.getSource() == eventsButton) {
      stage = (Stage) eventsButton.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("bulletin.fxml"));
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

