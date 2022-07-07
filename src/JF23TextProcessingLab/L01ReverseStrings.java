package JF23TextProcessingLab;

/*
You will be given a series of strings until you receive an "end" command. Write a program that reverses strings and prints
 each pair on a separate line in the format "{word} = {reversed word}".
 */

import java.util.Scanner;

public class L01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        StringBuilder print = new StringBuilder();

        while (!text.equals("end")) {

            for (int i = text.length() - 1; i >= 0; i--) {
                print.append(text.charAt(i));
            }

            System.out.printf("%s = ", text);
            System.out.print(print.toString());
            System.out.println();
            print.setLength(0);
            text = scanner.nextLine();
        }
    }
}