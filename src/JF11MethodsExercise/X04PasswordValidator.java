package JF11MethodsExercise;

/*
Write a program that checks if a given password is valid. Password rules are:
•	6 – 10 characters (inclusive);
•	Consists only of letters and digits;
•	Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule print a message:
•	"Password must be between 6 and 10 characters";
•	"Password must consist only of letters and digits";
•	"Password must have at least 2 digits".
 */

import java.util.Scanner;

public class X04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        sixToTenCharacters(input);
        onlyDigitsAndLetters(input);
        digitsCount(input);

        boolean sixToTenCharacters = sixToTenCharacters(input);

        if (!sixToTenCharacters) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean onlyDigitsAndLetters = onlyDigitsAndLetters(input);

        if (!onlyDigitsAndLetters) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean digitsCount = digitsCount(input);

        if (!digitsCount) {
            System.out.println("Password must have at least 2 digits");
        }

        if ((digitsCount) && (onlyDigitsAndLetters) && (sixToTenCharacters)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean sixToTenCharacters(String input) {
        int length = input.length();
        return (6 <= length && length <= 10);
    }

    private static boolean onlyDigitsAndLetters(String input) {
        String lowerText = input.toLowerCase();

        for (char i = 0; i < input.length(); i++) {
            char element = lowerText.charAt(i);
            //проверка дали са цифри или букви
            if ((element < 48 || element > 57) && (element < 97 || element > 122)) {
                return false;
            }
        }

        return true;
    }

    private static boolean digitsCount(String input) {
        String lowerText = input.toLowerCase();
        int counter = 0;
        for (char i = 0; i < input.length(); i++) {
            char element = lowerText.charAt(i);
            //проверка дали са цифри
            if (element >= 48 && element <= 57) {
                counter++;
            }
        }

        return (counter >= 2);
    }
}