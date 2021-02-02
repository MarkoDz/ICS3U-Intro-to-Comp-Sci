package week2;

public class StringExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
    }

    private static void exampleThree() {
        String s1 = new String("Steve");    // it is going to build a new String EVERYTIME
        String s2 = new String("Steve");
        String s3 = "Steve";    // if you declare a String like we did for s3 or s4 using String a = "blah blah" (we don't use the constructor) it reuses the existing Steve it is already there.
        String s4 = "Steve";    // String literal - Java stores all the String literals in a table and reuses them

        System.out.println(s1 == s2);   // == equality operator = assignment operator (never use == to compare strings)
        System.out.println(s1 == s3);

        System.out.println(s1.equals(s2));   // to check if 2 strings are equal then use the equals method!!!!
        System.out.println(s3 == s4);   // using == to compare String literals returns true.
    }

    private static void exampleTwo() {
        String courseCode = "ICS3U AP3U";
        int x = courseCode.length();
        String sub = courseCode.substring(2, 5); // "SCU" (starts at index 2 and ends at index 4) [2,5)   2 <= x < 5

        String sub2 = courseCode.substring(2); // "SCU AP" the parameter refers to the starting index. The substring will being at 2 and go to the end.
        System.out.println("The length of \"" + courseCode + "\" is: " + x);
    }

    private static void exampleOne() {
        String simpleText = "This is a String.";
        int number = 7;
        System.out.println(simpleText);
        System.out.println(number);
    }
}
