package JF10MethodsLab;

/*
You are given two values of the same type as input. The values can be of type int, char of String.
Create a method getMax() that returns the greater of the two values:
 */

import java.util.Scanner;

public class L09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        if (type.equals("int")) {
            int num = compareInts(input1, input2);
            System.out.println(num);
        }

        if (type.equals("char")) {
            char printThisChar = compareChars(input1, input2);
            System.out.println(printThisChar);
        }

        if (type.equals("string")) {
            String printThisString = compareStrings(input1, input2);
            System.out.println(printThisString);
        }
    }

    private static int compareInts(String input1, String input2) {

        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);

        if (num1 > num2) {
            return num1;
        }

        return num2;
    }

    public static char compareChars(String first, String second) {

        char f = first.charAt(0);
        char s = second.charAt(0);

        if (f > s) {
            return f;
        }

        return s;
    }

    public static String compareStrings(String first, String second) {

        if (first.compareTo(second) > 0) {                                       // сравняване на стрингове лексикографски
            return first;                                                       //първият е по-голям
        }

        return second;                                                          //вторият е по-голям
    }
}