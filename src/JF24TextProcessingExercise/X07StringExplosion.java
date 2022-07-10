package JF24TextProcessingExercise;

/*
Explosions are marked with ">". Immediately after the mark, there will be an integer, which signifies the strength of the explosion.
You should remove x characters (where x is the strength of the explosion), starting after the punched character (">").
If you find another explosion mark (">") while you’re deleting characters, you should add the strength to your previous explosion.
When all characters are processed, print the string without the deleted characters.
You should not delete the explosion character – ">", but you should delete the integers, which represent the strength.
Input
You will receive a single line with the string.
Output
Print what is left from the string after explosions.
Constraints
•	You will always receive strength for the punches.
•	The path will consist only of letters from the Latin alphabet, integers, and the char ">".
•	The strength of the punches will be in the interval [0…9].
Examples
 */

import java.util.Scanner;

public class X07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);

        int strength = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '>') {
                strength += Integer.parseInt(text.charAt(i + 1) + "");
            } else if (strength > 0 && text.charAt(i) != '>') {
                text.deleteCharAt(i);
                strength--;
                i--;
            }
        }

        System.out.println(text);
    }
}