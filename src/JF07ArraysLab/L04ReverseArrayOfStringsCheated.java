package JF07ArraysLab;

/*
Write a program to read an array of strings, reverse it and print its elements.
The input consists of a sequence of space-separated strings. Print the output on a single line (space separated).
 */

import java.util.Scanner;

public class L04ReverseArrayOfStringsCheated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] dividedString = input.split("\\s");

        String[] newString = new String[dividedString.length];
        for (int i = 0; i < dividedString.length; i++) {
            newString[i] = dividedString[dividedString.length - 1 - i];
            System.out.printf("%s ", newString[i]);
        }
    }
}