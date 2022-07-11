package JF25TextProcessingMoreExercise;

/*
Write a program that translates messages from Morse code to English (capital letters). Use this page to help you
(without the numbers). The words will be separated by a space (' '). There will be a "|" character which you should
replace with ' ' (space).
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MX04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Character> dictionary = new HashMap<>();
        dictionary.put(".-", 'A');
        dictionary.put("-...", 'B');
        dictionary.put("-.-.", 'C');
        dictionary.put("-..", 'D');
        dictionary.put(".", 'E');
        dictionary.put("..-.", 'F');
        dictionary.put("--.", 'G');
        dictionary.put("....", 'H');
        dictionary.put("..", 'I');
        dictionary.put(".---", 'J');
        dictionary.put("-.-", 'K');
        dictionary.put(".-..", 'L');
        dictionary.put("--", 'M');
        dictionary.put("-.", 'N');
        dictionary.put("---", 'O');
        dictionary.put(".--.", 'P');
        dictionary.put("--.-", 'Q');
        dictionary.put(".-.", 'R');
        dictionary.put("...", 'S');
        dictionary.put("-", 'T');
        dictionary.put("..-", 'U');
        dictionary.put("...-", 'V');
        dictionary.put(".--", 'W');
        dictionary.put("-..-", 'X');
        dictionary.put("-.--", 'Y');
        dictionary.put("--..", 'Z');

        StringBuilder translated = new StringBuilder();

        String input = scanner.nextLine();

        String[] texts = input.split("\\s\\|\\s");

        for (String text : texts) {
            String[] letters = text.split(" ");

            for (String letter : letters) {
                translated.append(dictionary.get(letter));
            }

            translated.append(" ");
        }

        System.out.println(translated);
    }
}


/*
public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HashMap<String, Character> morse = new HashMap<>();
        morse.put(".-", 'A');
        morse.put("-...", 'B');
        morse.put("-.-.", 'C');
        morse.put("-..", 'D');
        morse.put(".", 'E');
        morse.put("..-.", 'F');
        morse.put("--.", 'G');
        morse.put("....", 'H');
        morse.put("..", 'I');
        morse.put(".---", 'J');
        morse.put("-.-", 'K');
        morse.put(".-..", 'L');
        morse.put("--", 'M');
        morse.put("-.", 'N');
        morse.put("---", 'O');
        morse.put(".--.", 'P');
        morse.put("--.-", 'Q');
        morse.put(".-.", 'R');
        morse.put("...", 'S');
        morse.put("-", 'T');
        morse.put("..-", 'U');
        morse.put("...-", 'V');
        morse.put(".--", 'W');
        morse.put("-..-", 'X');
        morse.put("-.--", 'Y');
        morse.put("--..", 'Z');
        String input = console.nextLine();
        StringBuilder output = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='|') output.append(" ");
            else if(input.charAt(i)==' ') {
                if(letter.length()==0) continue;
                output.append(morse.get(String.valueOf(letter)));
                letter.setLength(0);
            }
            else letter.append(input.charAt(i));
        }
        if(letter.length()>0) output.append(morse.get(String.valueOf(letter)));
        System.out.println(output);
    }
}
 */