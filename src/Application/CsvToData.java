package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CsvToData {

    public static HashMap<String,String> setData(boolean isAdmin)
    {
        HashMap<String,String> dataHashMap = new HashMap<>();

        File data = new File("src\\Application\\emptyFile.csv");

        try {

            if(isAdmin == true){
                data = new File("src\\Application\\adminAccs.csv");
            } else if (isAdmin == false){
                data = new File("src\\Application\\userAccs.csv");

            }

            Scanner fileReader = new Scanner(data);
            int dataNo = 0;

            while(fileReader.hasNext())
            {
                String line = fileReader.nextLine();
                String[] dataLine = line.split(",");

                dataHashMap.put(dataLine[0], dataLine[1]);
                System.out.println(dataLine[0] + dataLine[1]);
                dataLine = null;

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String name : dataHashMap.values()) {
            System.out.println(dataHashMap.values());
        }

        return dataHashMap;

    }



}
