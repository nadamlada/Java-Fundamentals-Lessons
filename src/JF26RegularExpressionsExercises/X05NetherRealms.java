package JF26RegularExpressionsExercises;
/*
A mighty battle is coming. In the stormy nether realms, demons are fighting against each other for supremacy in a duel from which only one will survive.
Your job, however, is not so exciting. You are assigned to sign in all the participants in the nether realm's mighty battle's demon book.
A demon's name contains his health and his damage.
The sum of the asci codes of all characters (excluding numbers (0-9), arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.')) gives a demon's total health.
The sum of all numbers in his name forms his base damage. Note that you should consider the plus '+' and minus '-' signs (e.g. +10 is 10 and -10 is -10). However, there are some symbols ('*' and '/') that can further alter the base damage by multiplying or dividing it by 2 (e.g. in the name "m15*/

//c-5.0", the base damage is 15 + (-5.0) = 10 and then you need to multiply it by 2 (e.g. 10 * 2 = 20) and then divide it by 2 (e.g. 20 / 2 = 10)).
//        So, multiplication and division are applied only after all numbers are included in the calculation and the order, they appear in the name.
//        Input
//        The input will be read from the console. The input consists of a single line containing all demon names separated by commas and zero or more spaces in the format: "{demon name}, {demon name}, … {demon name}"
//        Output
//        Print all demons, each on a separate line in the format:
//        •	"{demon name} - {health points} health, {damage points} damage"
//        Constraints
//        •	A demon's name will contain at least one character.
//        •	A demon's name cannot contain blank spaces ' ' or commas ','.
//        •	A floating-point number will always have digits before and after its decimal separator.
//        •	Number in a demon's name is considered everything that is a valid integer or floating point number (with dot '.' used as separator). For example, all these are valid numbers: '4', '+4', '-4', '3.5', '+3.5', '-3.5'.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class X05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oldInput = scanner.nextLine();
        String input = oldInput.replaceAll("\\s+", "");

        String[] names = input.split(",");

        for (String name : names) {
            name.replace(",", "");

            String regexHealth = "[^\\-\\+\\*\\/\\d\\.]";
            Pattern patternH = Pattern.compile(regexHealth);
            Matcher matcherH = patternH.matcher(name);

            int sumH = 0;

            while (matcherH.find()) {
                String healthyElement = matcherH.group();

                for (int i = 0; i < healthyElement.length(); i++) {
                    char current = healthyElement.charAt(i);
                    sumH += current;
                }
            }

            String regexDamage = "[\\+|\\-]?\\d+(\\.\\d+)?";

            Pattern patternD = Pattern.compile(regexDamage);
            Matcher matcherD = patternD.matcher(name);

            double sumD = 0;
            while (matcherD.find()) {
                double damageElement = Double.parseDouble(matcherD.group());
                sumD += damageElement;
            }

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == '*') {
                    sumD *= 2;
                }
                if (name.charAt(i) == '/') {
                    sumD /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", name, sumH, sumD);
        }
    }
}