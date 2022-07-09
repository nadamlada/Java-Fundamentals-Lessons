package JF24TextProcessingExercise;

/*
Create a method that takes two strings as arguments and returns the sum of their character codes multiplied
(multiply str1[0] with str2[0] and add to the total sum). Then continue with the next two characters.
If one of the strings is longer than the other, add the remaining character codes to the total sum without multiplication.
 */

import java.util.Scanner;

public class X02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(" ");
        String firstName = text[0];
        String secondName = text[1];

        int minLength = Math.min(firstName.length(), secondName.length());
        int sum = 0;
        String forAdd = null;

        //първия е по-къс
        if (minLength == firstName.length()) {
            forAdd = secondName.substring(minLength);
        } else {
            forAdd = firstName.substring(minLength);
        }

        for (int i = 0; i < minLength; i++) {
            int a = firstName.charAt(i);
            int b = secondName.charAt(i);
            int currentSym = a * b;
            sum += currentSym;
        }

        char[] addChar = forAdd.toCharArray();

        for (char c : addChar) {
            sum += c;
        }

        System.out.println(sum);
    }
}