package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.StringBuilder;

public class Main extends Application {

  final static int LAST_ELEM = 250;
  private static StringBuilder sb = new StringBuilder();
  static final int SCENE_WIDTH = 652;
  static final int SCENE_HEIGHT = 500;

  @Override
  public void start(Stage stage) throws Exception {

    // Main menu scene using bulletin.fxml and style.css
    // Sets the first scene for the program the following scenes are found in the controller
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Scene mainMenu = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    stage.setTitle("B U L L E T I N");
    stage.setScene(mainMenu);
    mainMenu.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
    stage.show();
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
    while (atEndOfPage) {
      // Selenium algo that will load BS4 data
      System.out.println("click");
      pause(2);

    }

    // BS algo for eventTitle
    // BS algo for eventDate
    // BS algo for eventLocation
    // BS algo for eventHost

    for (int i = 1; i <= LAST_ELEM; i++) {

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