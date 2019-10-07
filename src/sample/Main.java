package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.StringBuilder;

public class Main extends Application {

  final static int LAST_ELEM = 250; // Jose Ruiz-Ramon
  public static StringBuilder sb = new StringBuilder(); // Jose Ruiz-Ramon

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }


  public static void main(String[] args) {

    launch(args);
    String dataChunk = getEventData();
    System.out.print(dataChunk);
  }

  public static String getEventData() // Jose Ruiz-Ramon
  {
    //launch Selenium Driver
    //declare BeautifulSoup object

    String eventTitle = null; // Jose Ruiz-Ramon
    String eventDate = null; // Jose Ruiz-Ramon
    String eventLocation = null; // Jose Ruiz-Ramon
    String eventHost = null; // Jose Ruiz-Ramon
    String bigString = null; // Jose Ruiz-Ramon

    boolean atEndOfPage = false; // Jose Ruiz-Ramon
    while (atEndOfPage) // Jose Ruiz-Ramon
    {
      // Selenium algo that will load BS4 data
      System.out.println("click"); // Jose Ruiz-Ramon
      pause(2); // Jose Ruiz-Ramon

    }

    // BS algo for eventTitle
    // BS algo for eventDate
    // BS algo for eventLocation
    // BS algo for eventHost

    for (int i = 1; i <= LAST_ELEM; i++) // Jose Ruiz-Ramon
    {

      eventTitle = "eventTitle"; // Jose Ruiz-Ramon
      sb.append(String.format("%s, ", eventTitle)); // Jose Ruiz-Ramon

      eventDate = "eventDate"; // Jose Ruiz-Ramon
      sb.append(String.format("%s, ", eventDate)); // Jose Ruiz-Ramon;

      eventLocation = "eventLocation"; // Jose Ruiz-Ramon
      sb.append(String.format("%s, ", eventLocation)); // Jose Ruiz-Ramon

      eventHost = "eventHost"; // Jose Ruiz-Ramon
      sb.append(String.format("%s\n ", eventHost)); // Jose Ruiz-Ramon

    }

    bigString = sb.toString(); // Jose Ruiz-Ramon

    return bigString; // Jose Ruiz-Ramon
  }

  public static void pause(double seconds) {
    try {
      Thread.sleep((long) (seconds * 1000));
    } catch (InterruptedException e) {
    }

  }


}


