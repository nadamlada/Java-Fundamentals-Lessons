package JF23TextProcessingLab;

/*
Write a Program That Reads an Array of Strings. Each String is Repeated N Times, Where N is the length of the String. Print the Concatenated String.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");

        List<String> result = new ArrayList<>();

        for (String word : words) {
            result.add(repeat(word, word.length()));
        }

        System.out.println(String.join("", result));
    }

    public static String repeat(String s, int repeatCount) {
        String[] repeatedArr = new String[repeatCount];

        for (int i = 0; i < repeatCount; i++) {
            repeatedArr[i] = s;
        }

        return String.join("", repeatedArr);
    }
}