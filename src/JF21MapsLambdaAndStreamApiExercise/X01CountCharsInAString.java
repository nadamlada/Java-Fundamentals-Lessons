package JF21MapsLambdaAndStreamApiExercise;

/*
Write a program, which counts all characters in a string except space (' ').
Print all occurrences in the following format:
{char} -> {occurrences}
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class X01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> collection = new LinkedHashMap<>();

        //for(char currentChar : input.toCharArray()){}

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ' ') {
                continue;
            }

            if (collection.containsKey(currentChar)) {
                int existingValueOfKey = collection.get(currentChar);
                collection.put(currentChar, existingValueOfKey + 1);
            } else {
                collection.put(currentChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : collection.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

        //друг вид печатане:
        //collection.forEach((key,value) -> System.out.printf("%s -> %d%n", key, value));
        //или
        //collection.entrySet(entry -> System.out.println(entry.getKey() + " -> ", entry.getValue()));
    }
}