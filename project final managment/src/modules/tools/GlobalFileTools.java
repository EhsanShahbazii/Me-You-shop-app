package modules.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GlobalFileTools {

    //this method count number of lines in files
    public int fileLengthCounter(String path) {
        int lineCount = 0;
        try {
            //count lines of files in userInformation file
            Scanner scanner1 = new Scanner(new File(path));
            while (scanner1.hasNextLine()) {
                lineCount++;
                scanner1.nextLine();
            }
            scanner1.close();
        }catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return lineCount;
    }

    //this method get all data of any files in array list
    public String[] fileAllRead(String path) {
        int index = 0;
        //count lines of files in userInformation file
        int lineCount = fileLengthCounter(path);
        String[] counter = new String[lineCount];
        try {
            int correctIndex = 0;
            Scanner scanner2 = new Scanner(new File(path));
            //push all data in array
            while (scanner2.hasNextLine()) {
                counter[index] = scanner2.nextLine();
                index++;
            }
            scanner2.close();
        }catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return counter;
    }
}