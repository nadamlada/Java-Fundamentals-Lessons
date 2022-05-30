package JF26RegularExpressionsExercises;

/*
The war is at its peak, but you, young Padawan, can turn the tides with your programming skills. You are tasked to create a program to decrypt the messages of The Order and prevent the death of hundreds of lives.
You will receive several messages, which are encrypted using the legendary star enigma. You should decrypt the messages, following these rules:
To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive and remove the count from the current ASCII value of each symbol of the encrypted message.
After decryption:
Each message should have a planet name, population, attack type ('A', as an attack or 'D', as destruction), and soldier count.
The planet name starts after '@' and contains only letters from the Latin alphabet.
The planet population starts after ':' and is an Integer;
The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (Exclamation mark).
The soldier count starts after "->" and should be an Integer.
The order in the message should be: planet name -> planet population -> attack type -> soldier count. Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.
Input / Constraints
•	The first line holds n – the number of messages – integer in the range [1…100].
•	On the next n lines, you will be receiving encrypted messages.
Output
After decrypting all messages, you should print the decrypted information in the following format:
First print the attacked planets, then the destroyed planets.
"Attacked planets: {attackedPlanetsCount}"
"-> {planetName}"
"Destroyed planets: {destroyedPlanetsCount}"
"-> {planetName}"
The planets should be ordered by name alphabetically.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XNE04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String regexDecrypted = "[STARstar]";

            Pattern patternDecrypted = Pattern.compile(regexDecrypted);
            Matcher matcherDecypted = patternDecrypted.matcher(input);

            int counter = 0;
            while (matcherDecypted.find()) {
                counter++;
            }
            StringBuilder finalDecrypted = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char letter = (char) (input.charAt(j) - counter);
                finalDecrypted.append(letter);
            }
            //System.out.println(finalDecrypted.toString());

            String regexText = "@(?<name>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<type>[AD])![^@!:>-]*->(?<count>[0-9]+)";
            Pattern patternText = Pattern.compile(regexText);
            Matcher matcherText = patternText.matcher(finalDecrypted.toString());

            while (matcherText.find()) {
                String name = matcherText.group("name");
                String population = matcherText.group("population");
                String type = matcherText.group("type");
                String count = matcherText.group("count");

                if (type.equals("A")) {
                    attacked.add(name);
                } else {
                    destroyed.add(name);
                }
            }
        }

        Collections.sort(attacked);
        Collections.sort(destroyed);

        System.out.printf("Attacked planets: %d%n", attacked.size());
        for (String s : attacked) {
            System.out.printf("-> %s%n", s);
        }
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        for (String s : destroyed) {
            System.out.printf("-> %s%n", s);
        }
    }
}
