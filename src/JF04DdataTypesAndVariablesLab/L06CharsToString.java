package JF04DdataTypesAndVariablesLab;

/*
Write a program that reads 3 lines of input. On each line, you get a single character. Combine all the characters into one string and print it on the console.
 */

import java.util.Scanner;

public class L06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        char firstChar = first.charAt(0);

        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c", firstChar, secondChar, thirdChar);

    }
}