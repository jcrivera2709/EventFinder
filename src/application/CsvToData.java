package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Jose Ruiz-Ramon This class is the fake-database loader for both user and admin accounts.
 */
public class CsvToData {

  /**
   * This static function sets up the fake database as called from Login class.
   *
   * @param isAdmin true for admin accounts, false for user accounts.
   * @return hashmap
   */
  public static HashMap<String, String> setData(boolean isAdmin) {
    HashMap<String, String> dataHashMap = new HashMap<>();

    File data = new File("src\\Application\\emptyFile.csv");

    try {

      if (isAdmin) {
        data = new File("src\\Application\\adminAccs.csv");
      } else {
        data = new File("src\\Application\\userAccs.csv");

      }

      // this objects read the csvs line-by-line
      Scanner fileReader = new Scanner(data);
      int dataNo = 0;

      while (fileReader.hasNext()) {
        String line = fileReader.nextLine();
        String[] dataLine = line.split(","); // split strings to add as key, value into hashmap

        dataHashMap.put(dataLine[0].trim(), dataLine[1].trim()); // append to hashmap
        System.out.println(dataLine[0].trim() + dataLine[1].trim());
        dataLine = null; // restart String splitter.

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    for (String name : dataHashMap.values()) {
      System.out.println(dataHashMap.values());
    }

    return dataHashMap;

  } // set data

} // class
