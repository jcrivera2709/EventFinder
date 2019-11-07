package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdminMenu {

  private static HashMap<String, String> adminDataHashMap = new HashMap<>();
  public ComboBox categoryBox;
  public Button addEventButton;
  public TextField eventNameField;
  public TextArea eventDescription;

  public void initialize(){
    // clears items in choice box
    categoryBox.getItems().clear();
    // Goes through the enum named Categories and adds them to the combobox
    for (Categories item : Categories.values()) {
      categoryBox.getItems().add(item);
    }
  }

  public void addEvent(){

  }


  public static void setData() {

    try {

      File data = new File("src\\Application\\data.csv");
      Scanner fileReader = new Scanner(data);

      int dataNo = 0;

      while (fileReader.hasNext()) {
        String line = fileReader.nextLine();
        String[] dataLine = line.split(",");

        adminDataHashMap.put(dataLine[0], dataLine[1]);
        System.out.println(dataLine[0] + dataLine[1]);
        dataLine = null;

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    for (String name : adminDataHashMap.values()) {
      System.out.println(adminDataHashMap.values());
    }

  }

}