package JF23TextProcessingLab;

/*
Write a program that takes a text and a string of banned words. All words included in the ban list should be replaced with asterisks "*",
equal to the word's length. The entries in the ban list will be separated by a comma and space ", ".
The ban list should be entered on the first input line and the text on the second input line.
 */

import java.util.Scanner;

public class L04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bans = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String ban : bans) {
            if (text.contains(ban)) {
                String replacement = repeatString("*", ban.length());
                text = text.replace(ban, replacement);
            }
        }

        System.out.println(text);
    }

    private static String repeatString(String censored, int length) {
        // не конкатенирай, а със стрингбилдър
        String replacement = "";

        for (int i = 0; i < length; i++) {
            replacement += censored;
        }

        return replacement;
    }
}