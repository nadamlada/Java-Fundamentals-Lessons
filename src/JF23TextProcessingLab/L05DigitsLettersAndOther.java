package JF23TextProcessingLab;

/*
Write a program that receives a single string and on the first line prints all the digits, on the second – all the letters, and on the third –
all the other characters. There will always be at least one digit, one letter, and one other character.
 */

import java.util.Scanner;

public class L05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder textString = new StringBuilder();
        StringBuilder numsString = new StringBuilder();
        StringBuilder elseString = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if ((current >= 'a' && current <= 'z') || (current >= 'A' && current <= 'Z')) {
                textString.append(current);
            } else if (current >= '0' && current <= '9') {
                numsString.append(current);
            } else {
                elseString.append(current);
            }
        }

        System.out.println(numsString.toString());
        System.out.println(textString.toString());
        System.out.println(elseString.toString());
    }
}