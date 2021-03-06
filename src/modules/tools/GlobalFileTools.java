package modules.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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

    //return specific user information
    public String[] returnSpecificUserInformation(String username) {
        int usernameIndex = 0;
        //array length is 5 because we have 5 lines of data for each customer
        String[] data = new String[5];
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\src\\files\\data\\userInformation.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return information of current customer
                if (username.equals(user)) {
                    String[] files = fileAllRead("D:\\project final\\src\\files\\data\\userInformation.txt");
                    data[0] = files[usernameIndex-2]; //return fullName
                    data[1] = files[usernameIndex-1]; //return username
                    data[2] = files[usernameIndex+1]; //return email
                    data[3] = files[usernameIndex+2]; //return phone number
                    data[4] = files[usernameIndex+3]; //return address
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return data;
    }

    //return current customer wallet balance
    public String returnWalletBalance(String username) {
        int usernameIndex = 0;
        String walletBalance = "0";
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\src\\files\\data\\userWalletBalance.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return wallet balance current customer
                if (user.equals(username)) {
                    String[] files = fileAllRead("D:\\project final\\src\\files\\data\\userWalletBalance.txt");
                    walletBalance = files[usernameIndex];
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return walletBalance;
    }

    //return current user profile image path for set in image view in profile
    public String userImageProfilePath(String username) {
        int usernameIndex = 0;

        //this is default image path for show in image view
        String imagePath = "D:\\project final\\src\\files\\image\\profile image\\Man-16-icon.png";
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\src\\files\\data\\userProfileImage.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return wallet balance current customer
                if (username.equals(user)) {
                    String[] files = fileAllRead("D:\\project final\\src\\files\\data\\userProfileImage.txt");
                    imagePath = files[usernameIndex];
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return imagePath;
    }

    //update image path in file with current information
    public void updateUserProfileImage(String username, String imagePath) throws FileNotFoundException {
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userProfileImage.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userProfileImage.txt");

        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username)) {
                counter[i+1] = imagePath;
                break;
            }
        }
        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userProfileImage.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userProfileImage.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //set default image path for new customer when sign in
    public void addNewUserProfileImage(String username) throws FileNotFoundException {
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userProfileImage.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userProfileImage.txt");

        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userProfileImage.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userProfileImage.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
            Library.writeBytes(username + "\n");
            Library.writeBytes("D:\\project final\\src\\files\\image\\profile image\\Man-16-icon.png"+ "\n");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //set default wallet balance for new customer when sign in
    public void addNewWalletBalance(String username) throws FileNotFoundException {
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userWalletBalance.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userWalletBalance.txt");

        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userWalletBalance.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userWalletBalance.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
            Library.writeBytes(username + "\n");
            Library.writeBytes("0"+ "\n");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //update wallet balance in file
    public void updateWalletBalance(String username, String amount) throws FileNotFoundException {

        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userWalletBalance.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userWalletBalance.txt");

        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username)) {
                //give before balance and + it with new charge value
                double beforeAmount = Double.parseDouble(counter[i+1]);
                double newAmount = Double.parseDouble(amount);
                //round the wallet value
                String finalResult = Double.toString(Math.floor(beforeAmount + newAmount));
                counter[i+1] = finalResult;
                break;
            }
        }
        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userWalletBalance.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userWalletBalance.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //update new personal information
    public void updatePersonalInformation(String username, String fullName, String email, String phoneNumber, String address) throws FileNotFoundException {

        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userInformation.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userInformation.txt");

        for (int i = 1; i < lineCount; i++) {
            if (counter[i].equals(username)) {
                counter[i-1] = fullName; //set fullName
                counter[i+2] = email; //set email
                counter[i+3] = phoneNumber; //set phoneNumber
                counter[i+4] = address; //set address
                break;
            }
        }
        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userInformation.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userInformation.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //this method add payment to history table
    public void addToHistoryPayment(ArrayList<String> array) throws FileNotFoundException {
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userPaymentHistory.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userPaymentHistory.txt");

        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userPaymentHistory.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userPaymentHistory.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
            for(int i = 0; i < array.size(); i++) {
                //write data format (data) \n
                Library.writeBytes(array.get(i) + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //update new product count
    public void updateProductCount(ArrayList<String> array) throws FileNotFoundException {

        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        for(int j = 1; j < array.size(); j= j+3) {
            for (int i = 0; i < lineCount; i++) {
                if (counter[i].equals(array.get(j))) {

                    int before = Integer.parseInt(counter[i+3]) - Integer.parseInt(array.get(j+1));
                    counter[i+3] = Integer.toString(before);
                    break;
                }
            }
        }

        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\ProductInformation.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\ProductInformation.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

}
