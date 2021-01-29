package week1;

public class StringConcatanationAndOperators {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
        exampleFour();

    }

    /**
     * Remainder using the modulus operator (it is a form of division)
     * Usually only used with integers
     * Checks if a number is divisible by another number
     */
    private static void exampleFour() {
        int x = 11;
        
        int y = x % 2;      // % is the modulus operator, it has nothing to do with percent (obtains the remainder)
                            // y - is the remainder

        System.out.println(y);

        boolean isEven = (x % 2) == 0;          // == checks for equality (=) is assignment
                                                // boolean variables store true or false

        System.out.println(x + " is even: " + isEven);
    }

    /**
     * Review order of operations for string concatanation
     */

    private static void exampleThree() {
        int x = 4, y = 3;
        System.out.println(x+y);
        System.out.println(x + "+" + y + "=" + x+y); // "4 + 3 = 4" + 3 yields 4 + 3 = 43

        System.out.println(x + "+" + y + "=" + (x+y)); // BEDMAS still exists in programming.

        System.out.println(x + y + " = " + x + " + " + y);


        
    }

    /**
     * String Concatanation Example Will display something like 4+3=7
     */
    private static void exampleTwo() {
        int x = 4, y = 3, sum = x + y;          // Declared 3 different variables on a single line and assigned them values.

        System.out.println(x + "+" + y + "=" + sum);

    }

    /**
     * Topics covered:
     * Constants using modified final
     * double and int division
     * type casting
     */
    private static void exampleOne() {
        int markOne = 90;
        int markTwo = 94;
        int markThree = 88;

        final int NUM_TESTS = 3; // final ensures that the value stored cannot changed (IT IS CONSTANT)
        // numTests = 6;        // Causes an error because numTests is final (CONSTANT)


        double average = (markOne+markTwo+markThree)/NUM_TESTS; //Use 3.0 instaed of 3 to get exact answer.
                                                            //int / int yields (returns) an int (truncated)
                                                            //int / double or double / int or double / double yields a double when performing division
        System.out.println(average);

        average = (markOne+markTwo+markThree)/3.0;          // Don't like using 3.0 because I cannot have 3.0 tests
        System.out.println(average);

        average = (double)(markOne+markTwo+markThree)/NUM_TESTS;    // casts (markOne+markTwo+markThree) as a double to complete the operation
        System.out.println(average);

    }
}
