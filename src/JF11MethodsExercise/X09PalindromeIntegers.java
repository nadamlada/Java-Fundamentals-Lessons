package JF11MethodsExercise;

/*
A palindrome is a number that reads the same backward as forward, such as 323 or 1001. Write a program
that reads a positive integer number until you receive "END". For each numbered print whether the number
is palindrome or not.
 */

import java.util.Scanner;

public class X09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            ispalindome(input);
            boolean result = ispalindome(input);

            if (result) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }
    }

    private static boolean ispalindome(String input) {

        for (int i = 0; i < input.length() / 2; i++) {
            char atStart = input.charAt(i);
            int indexEnd = input.length() - (i + 1);
            char atEnd = input.charAt(indexEnd);

            if (atStart == atEnd) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}