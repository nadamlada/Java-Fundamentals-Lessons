package JF24TextProcessingExercise;

/*
Write a program that reads user names on a single line (joined by ", ") and prints all valid usernames.
A valid username is:
•	Has a length between 3 and 16 characters.
•	Contains only letters, numbers, hyphens, and underscores.
 */

import java.util.Scanner;

public class X01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(", ");

        for (String username : text) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValid(String s) {

        if (s.length() < 3 || s.length() > 16) {
            return false;
        }

        for (char symbol : s.toCharArray()) {
            //(!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '-' && currentSymbol != '_')
            if (!((Character.isLetterOrDigit(symbol))
                    || (symbol == '_')
                    || (symbol == '-'))) {
                return false;
            }
        }

        return true;
    }
}