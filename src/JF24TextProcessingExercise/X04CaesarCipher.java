package JF24TextProcessingExercise;

/*
Write a program that returns an encrypted version of the same text. Encrypt the text by shifting each character with
three positions forward. For example, A would be replaced by D, B would become E, and so on. Print the encrypted text.
 */

import java.util.Scanner;

public class X04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String text = scanner.nextLine();

        char[] newArr = text.toCharArray();

        for (char c : newArr) {
            c += 3;
            stringBuilder.append(c);
        }

        System.out.println(stringBuilder.toString());
    }
}