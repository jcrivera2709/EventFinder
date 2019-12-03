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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
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
  public Text eventIDText;
  public Text eventNameTxt;
  public Text addEventTxt;
  public Text eventDescTxt;
  public Text eventDateText;

  // Text fields and areas.
  public TextField eventIDField;
  public TextField eventNameField;
  public TextField eventLocationField;
  public TextField eventDateField;
  public TextArea eventDescription;

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

    //  String id = eventId.getText();

    String id = eventIDField.getText();
    String eventDescriptionString = eventDescription.getText();
    String eventNameString = eventNameField.getText();
    String eventLocationString = eventLocationField.getText();

    //String eventDateString = eventDateField.getText(); // add textbox for eventdate
    String eventDateString = "March 5, 2020";

    String eventType = categoryBox.getValue().toString();

    String appendData;
    String fileUrl = "src/Application/events.csv";

    BufferedWriter bw = new BufferedWriter(new FileWriter(fileUrl, true));

    appendData = String
        .format("ID:%s\nEVENT NAME: %s\nEVENT DATE: %s\nEVENT LOCATION: %s\nEVENT DESCRIPTION: %s\nEVENT TYPE: %s\n",
            id, eventNameString, eventDateString, eventLocationString, eventDescriptionString, eventType);

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

  /**
   * This function removes the events when the Remove Event button is clicked. ()
   *
   * @throws IOException
   */
  public void removeEvent() throws IOException {
    /*
        WE NEED THE REMOVE BTN
     */

    String id = eventIDField.getText(); // we need a field for id
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
   * @throws IOException
   */
  public void updateEvent() throws IOException {
    /*
          WE NEED THE UPDATE BTN
     */

    String id = eventIDField.getText();

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

