package JF23TextProcessingExercise;

/*
Write a program that reads a string from the console and replaces any sequence of the same letters with a single
corresponding letter.
 */

import java.util.Scanner;

public class X6ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder output = new StringBuilder(text);

        for (int i = 0; i < output.length() - 1; i++) {
            if (output.charAt(i) == output.charAt(i + 1)) {
                output.deleteCharAt(i);
                i--;
            }
        }

        System.out.println(output);
    }
}