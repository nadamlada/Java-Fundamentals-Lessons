package JF09ArraysMoreExercise;

/*
Write a program that reads a sequence of strings from the console. Encrypt every string by summing:
•	The code of each vowel multiplied by the string length
•	The code of each consonant divided by the string length
Sort the number sequence in ascending order and print it on the console.
On the first line, you will always receive the number of strings you have to read.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MX01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int[] printArray = new int[input];

        for (int i = 0; i < input; i++) {
            String name = scanner.nextLine();

            int sum = 0;

            //обхождам самото име
            for (int j = 0; j < name.length(); j++) {
                char letter = name.charAt(j);

                if (isVowel(letter)) {
                    sum += letter * name.length();

                } else {
                    sum += letter / name.length();
                }
            }

            printArray[i] = sum;
        }

        Arrays.sort(printArray);

        for (int i : printArray) {
            System.out.println(i);
        }
    }

    public static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(c + "");
    }

    public static boolean isConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return consonants.contains(c + "");
    }
}