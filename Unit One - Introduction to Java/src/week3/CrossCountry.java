package week3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 

        prompt(in); //Runner 1
        promptTwo(in); //Runner 2
        promptThree(in); //Runner 3

        in.close();
    }

    private static double convertToSeconds(String timeString) {
        
        int colon = timeString.indexOf(":");
        int minutesAsSeconds = Integer.parseInt(timeString.substring(0,colon)) * 60;
        double seconds = Double.parseDouble(timeString.substring(colon+1));

        return minutesAsSeconds + seconds;
    }

    private static double convertToSeconds2(String timeString2) {
        
        int colon = timeString2.indexOf(":");
        int minutesAsSeconds = Integer.parseInt(timeString2.substring(0,colon)) * 60;
        double seconds = Double.parseDouble(timeString2.substring(colon+1));

        return minutesAsSeconds + seconds;
    }

    private static double convertToSeconds3(String timeString3) {
        
        int colon = timeString3.indexOf(":");
        int minutesAsSeconds = Integer.parseInt(timeString3.substring(0,colon)) * 60;
        double seconds = Double.parseDouble(timeString3.substring(colon+1));

        return minutesAsSeconds + seconds;
    }

    private static void prompt(Scanner in) {
        
        System.out.print("Runner one, please enter your first name: ");
        String fname = in.nextLine();

        System.out.print("Runner one, please enter your last name: ");
        String lname = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to the first mile (all times are reported in minutes, seconds, and milliseconds): ");
        String splitOne = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to the end of the second mile: ");
        String splitTwo = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to complete the 5 kms: ");
        String SplitThree = in.nextLine();

        System.out.println(fname + " " + lname + ", thank you for the information, here us your run summary: ");

        String timeString = (splitOne);
        double timeOne = convertToSeconds(timeString);

        
        String timeString2 = (splitTwo);
        double timeInSeconds2 = convertToSeconds2(timeString2);
        
        double timeTwo = timeInSeconds2 - timeOne;

        
        String timeString3 = (SplitThree);
        double timeInSeconds3 = convertToSeconds3(timeString3);
        
        double timeThree = timeInSeconds3 - timeInSeconds2;


        double totalSeconds = timeTwo;
        int minutes = ((int)totalSeconds) / 60;
        double seconds = totalSeconds % 60;

        double totalSeconds2 = timeThree;
        int minutes2 = ((int)totalSeconds2) / 60;
        double seconds2 = totalSeconds2 % 60;


        System.out.println("Split one: " + splitOne + " was your time.");

        System.out.println("Split two: " + minutes +":" + new DecimalFormat("00.000").format(seconds) + " was your time.");

        System.out.println("Split three: " + minutes2 +":" + new DecimalFormat("00.000").format(seconds2) + " was your time.");
        
    }

    private static void promptTwo(Scanner in) {
        
        
        System.out.print("Runner two, please enter your first name: ");
        String fname = in.nextLine();

        System.out.print("Runner two, please enter your last name: ");
        String lname = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to the first mile (all times are reported in minutes, seconds, and milliseconds): ");
        String splitOne = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to the end of the second mile: ");
        String splitTwo = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to complete the 5 kms: ");
        String SplitThree = in.nextLine();

        System.out.println(fname + " " + lname + ", thank you for the information, here us your run summary: ");

        String timeString = (splitOne);
        double timeOne = convertToSeconds(timeString);

        
        String timeString2 = (splitTwo);
        double timeInSeconds2 = convertToSeconds2(timeString2);
        
        double timeTwo = timeInSeconds2 - timeOne;

        
        String timeString3 = (SplitThree);
        double timeInSeconds3 = convertToSeconds3(timeString3);
        
        double timeThree = timeInSeconds3 - timeInSeconds2;


        double totalSeconds = timeTwo;
        int minutes = ((int)totalSeconds) / 60;
        double seconds = totalSeconds % 60;

        double totalSeconds2 = timeThree;
        int minutes2 = ((int)totalSeconds2) / 60;
        double seconds2 = totalSeconds2 % 60;


        System.out.println("Split one: " + splitOne + " was your time.");

        System.out.println("Split two: " + minutes +":" + new DecimalFormat("00.000").format(seconds) + " was your time.");

        System.out.println("Split three: " + minutes2 +":" + new DecimalFormat("00.000").format(seconds2) + " was your time.");

    }

    private static void promptThree(Scanner in) {
         
        
        System.out.print("Runner three, please enter your first name: ");
        String fname = in.nextLine();

        System.out.print("Runner three, please enter your last name: ");
        String lname = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to the first mile (all times are reported in minutes, seconds, and milliseconds): ");
        String splitOne = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to the end of the second mile: ");
        String splitTwo = in.nextLine();

        System.out.println(fname + " " + lname + ", please enter your time to complete the 5 kms: ");
        String SplitThree = in.nextLine();

        System.out.println(fname + " " + lname + ", thank you for the information, here us your run summary: ");

        String timeString = (splitOne);
        double timeOne = convertToSeconds(timeString);

        
        String timeString2 = (splitTwo);
        double timeInSeconds2 = convertToSeconds2(timeString2);
        
        double timeTwo = timeInSeconds2 - timeOne;

        
        String timeString3 = (SplitThree);
        double timeInSeconds3 = convertToSeconds3(timeString3);
        
        double timeThree = timeInSeconds3 - timeInSeconds2;


        double totalSeconds = timeTwo;
        int minutes = ((int)totalSeconds) / 60;
        double seconds = totalSeconds % 60;

        double totalSeconds2 = timeThree;
        int minutes2 = ((int)totalSeconds2) / 60;
        double seconds2 = totalSeconds2 % 60;


        System.out.println("Split one: " + splitOne + " was your time.");

        System.out.println("Split two: " + minutes +":" + new DecimalFormat("00.000").format(seconds) + " was your time.");

        System.out.println("Split three: " + minutes2 +":" + new DecimalFormat("00.000").format(seconds2) + " was your time.");
        
    }
    
}
