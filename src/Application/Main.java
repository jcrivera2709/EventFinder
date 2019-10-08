package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.StringBuilder;

public class Main extends Application {

  final static int LAST_ELEM = 250;
  public static StringBuilder sb = new StringBuilder();

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("bulletin.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 500, 600));
    primaryStage.show();
  }


  public static void main(String[] args) {

    launch(args);

    String dataChunk = getEventData();
    System.out.print(dataChunk);
  }

  public static String getEventData() // method developed by Jose Ruiz-Ramon
  {
    //launch Selenium Driver
    //declare BeautifulSoup object

    String eventTitle = null;
    String eventDate = null;
    String eventLocation = null;
    String eventHost = null;
    String bigString = null;

    boolean atEndOfPage = false;
    while (atEndOfPage)
    {
      // Selenium algo that will load BS4 data
      System.out.println("click");
      pause(2);

    }

    // BS algo for eventTitle
    // BS algo for eventDate
    // BS algo for eventLocation
    // BS algo for eventHost

    for (int i = 1; i <= LAST_ELEM; i++)
    {

      eventTitle = "eventTitle";
      sb.append(String.format("%s, ", eventTitle));

      eventDate = "eventDate";
      sb.append(String.format("%s, ", eventDate));

      eventLocation = "eventLocation";
      sb.append(String.format("%s, ", eventLocation));

      eventHost = "eventHost";
      sb.append(String.format("%s\n ", eventHost));

    }

    bigString = sb.toString();

    return bigString;
  }

  public static void pause(double seconds) {
    try {
      Thread.sleep((long) (seconds * 1000));
    } catch (InterruptedException e) {
    }

  }


}


