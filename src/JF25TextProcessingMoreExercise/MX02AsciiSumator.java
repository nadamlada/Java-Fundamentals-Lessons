package JF25TextProcessingMoreExercise;

/*
Write a program that prints a sum of all characters between two given characters (their ASCII code). In the first line,
you will get a character. On the second line, you get another character. On the last line, you get a random string.
Find all the characters between the two given and print their ASCII sum.
 */

import java.util.Scanner;

public class MX02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a1 = scanner.nextLine();
        String b1 = scanner.nextLine();
        char a = a1.charAt(0);
        char b = b1.charAt(0);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar > a && currentChar < b) {
                sum += currentChar;
            }
        }

        System.out.println(sum);
    }
}