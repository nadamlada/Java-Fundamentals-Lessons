package JF28RegularExpressionsMoreExercise;

/*
You read a single line of ASCII symbols, and the message is somewhere inside it, you must find it.
 The input consists of three parts separated with "|" like this:
"{firstPart}|{secondPart}|{thirdPart}"
Each word starts with capital letter and has a fixed length, you can find those in each different part of the input.
The first part carries the capital letters for each word inside the message. You need to find those capital letters 1 or more from A to Z. The capital letters should be surrounded from both sides with any of the following symbols – "#, $, %, *, &". And those symbols should match on both sides. This means that $AOTP$ - is a valid pattern for the capital letters. $AKTP% - is invalid since the symbols do not match.
The second part of the data contains the starting letter ASCII code and words length /between 1 – 20 characters/, in the following format: "{asciiCode}:{length}". For example, "67:05" – means that '67' - ASCII code equal to the capital letter "C", represents a word starting with "C" with the following 5 characters: like "Carrot". The ASCII code should be a capital letter equal to a letter from the first part. Word's length should be exactly 2 digits. Length less than 10 will always have a padding zero, you don't need to check that.
The third part of the message are words separated by spaces. Those words have to start with the Capital letter [A…Z] equal to the ASCII code and have exactly the length for each capital letter you have found in the second part. Those words can contain any ASCII symbol without spaces.
When you find the valid word, you have to print it on a new line.
Input / Constraints
•	On the first line – the text is in form of three different parts separated by "|". There can be any ASCII character inside the input, except '|'.
•	Input will always be valid - you don’t need to check it.
•	The input will always have three different parts, that will always be separated by "|".
Output
•	Print all extracted words, each on a new line.
•	Allowed working time / memory: 100ms / 16MB.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MX03PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] parts = input.split("\\|");
        String firstPart = parts[0];
        String secondPart = parts[1];
        String thirdPart = parts[2];
        //([#$%*&])([A-Z]+)\\1
        String regexFP = "(?<symbols>[#$%*&])([A-Z]+)(\\1)";
        Pattern patternFP = Pattern.compile(regexFP);
        Matcher matcherFP = patternFP.matcher(firstPart);

        Map<Character, Integer> map = new LinkedHashMap<>();
        //map -> chars, length

        while (matcherFP.find()) {
            String validPlusSymbols = matcherFP.group();

            for (int i = 1; i < validPlusSymbols.length() - 1; i++) {
                char validChar = validPlusSymbols.charAt(i);
                map.putIfAbsent(validChar, 0);
            }
        }

        String regexSp = "\\d{2}:\\d{2}";
        Pattern patternSP = Pattern.compile(regexSp);
        Matcher matcherSP = patternSP.matcher(secondPart);

        while (matcherSP.find()) {
            String allPairs = matcherSP.group();
            String[] buff = allPairs.split("\\:");
            int asciiCode = Integer.parseInt(buff[0]);
            int length = Integer.parseInt(buff[1]);

            if (length >= 1 && length <= 20) {

                if (map.containsKey((char) asciiCode)) {

                    //трябва ни първана намерена
                    if (map.get((char) asciiCode) == 0) {
                        map.put((char) asciiCode, 1 + length);
                    }
                }
            }
        }

        String[] third = thirdPart.split("\\s+");
        // думите трябва да се вадят по реда на буквите, мачнати от първата част.

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            for (String word : third) {

                if (word.length() == entry.getValue() && word.charAt(0) == entry.getKey()) {
                    System.out.println(word);
                }
            }
        }
    }
}