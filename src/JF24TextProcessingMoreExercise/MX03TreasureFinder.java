package JF24TextProcessingMoreExercise;
/*
Write a program that decrypts a message by a given key and gathers information about hidden treasure type and its coordinates.
On the first line, you will receive a key (sequence of numbers). On the next few lines until you receive "find" you will get
lines of strings. You have to loop through every string and decrease the ASCII code of each character with a corresponding number
of the key sequence. The way you choose a key number from the sequence is by just looping through it. If the length of the key
sequence is less than the string sequence, you start looping from the beginning of the key. For more clarification see the
example below. After decrypting the message you will get a type of treasure and its coordinates. The type will be between the
symbol "&" and the coordinates will be between the symbols "<" and ">". For each line print the type and the coordinates in
format "Found {type} at {coordinates}".
 */

import java.util.Scanner;

public class MX03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder key = new StringBuilder(scanner.nextLine());
        String savedKey = key.toString();

        StringBuilder code = new StringBuilder(scanner.nextLine());

        while (!code.toString().equals("find")) {

            if (key.length() < code.length()) {
                for (int i = 0; i < code.length(); i++) {
                    if (key.charAt(i) == ' ') {
                        key.deleteCharAt(i);
                    }
                    key.append(key.charAt(i));
                }
            }

            for (int i = 0; i < code.length(); i++) {
                String keyString = key.charAt(i) + "";
                int currentKey = Integer.parseInt(keyString);
                char currentChar = (char) (code.charAt(i) - currentKey);
                code.setCharAt(i, currentChar);

            }

            // System.out.println(code);
            String whatTheyFound = code.substring(code.indexOf("&") + 1, code.lastIndexOf("&"));
            String coordinates = code.substring(code.indexOf("<") + 1, code.indexOf(">"));
            System.out.printf("Found %s at %s%n", whatTheyFound, coordinates);

            code = new StringBuilder(scanner.nextLine());
            key = new StringBuilder(savedKey);
        }
    }
}