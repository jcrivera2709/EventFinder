package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdminMenu {

  public ComboBox categoryBox;
  public Button addEventButton;
  public TextField eventNameField;
  public TextArea eventDescription;

  public void initialize()
  {
    // clears items in choice box
    categoryBox.getItems().clear();
    // Goes through the enum named Categories and adds them to the combobox
    for (Categories item : Categories.values()) {
      categoryBox.getItems().add(item);
    }


  }


  public void addEvent()
  {
    String eventDescriptionString = eventDescription.getText();
    String eventNameFieldString = eventNameField.getText();



  }


}
