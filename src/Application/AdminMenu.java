package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


public class AdminMenu {

    private static HashMap<String,String> adminDataHashMap = new HashMap<>();


    public static void setData()
    {

        try {

            File data = new File("src\\Application\\data.csv");
            Scanner fileReader = new Scanner(data);

            int dataNo = 0;

            while(fileReader.hasNext())
            {
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
