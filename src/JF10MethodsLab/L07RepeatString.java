package JF10MethodsLab;

/*
Write a method that receives a string and a repeat count n (integer). The method should return a new string (the old one repeated n times).
 */

import java.util.Scanner;

public class L07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repetitions = Integer.parseInt(scanner.nextLine());

        String repeated = printRepetitions(input, repetitions);          //присвояваме метода на променлива, за да можем да работим с нея
        System.out.println(repeated);
    }

    public static String printRepetitions(String s, int repetitions) {

        String[] newArray = new String[repetitions];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = s;
        }

        String repeated = String.join("", newArray);
        return repeated;
    }
}