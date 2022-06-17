package JF03BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

/*
Write a program that reverses a string and prints it on the console.
 */

import java.util.Scanner;

public class MX04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int length = input.length();


        for (int i = length - 1; i >= 0; i--) {
            char currentLetter = input.charAt(length - 1);
            System.out.print(currentLetter);
            length = length - 1;
        }
    }
}