package JF27RegularExpressionsMoreExercise;

/*
The lottery is exciting. What is not, is checking a million tickets for winnings only by hand. So, you are given the task to create a program that automatically checks if a ticket is a winner.
You are given a collection of tickets separated by commas and spaces. You need to check every one of them if it has a winning combination of symbols.
A valid ticket should have exactly 20 characters. The winning symbols are '@', '#', '$' and '^'. But for a ticket to be a winner the symbol should uninterruptedly repeat at least 6 times in both the tickets left half and the tickets right half.
For example, a valid winning ticket should be something like this:
"Cash$$$$$$Ca$$$$$$sh"
The left half "Cash$$$$$$" contains "$$$$$$", which is also contained in the tickets right half "Ca$$$$$$sh". A winning ticket should contain symbols repeating up to 10 times in both halves, which is considered a Jackpot (for example: "$$$$$$$$$$$$$$$$$$$$").
Input
The input will be read from the console. The input consists of a single line containing all tickets separated by commas and one or more white spaces in the format:
•	"{ticket}, {ticket}, … {ticket}"
Output
Print the result for every ticket in the order of their appearance, each on a separate line in the format:
•	"invalid ticket" - Invalid ticket
•	"ticket "{ticket}" - no match" - no match
•	"ticket "{ticket}" - {match length}{match symbol}" - Match with length 6 to 9
•	"ticket "{ticket}" - {match length}{match symbol} Jackpot!" - Match with length 10
Constrains
•	Number of tickets will be in range [0 … 100].

//тест @@@@@@@@@@et@@@@@@@@ ->8
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MX01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String separator = " *,+ *";
        String[] commands = input.split(separator);
        String regexValid = "@{6,10}|#{6,10}|\\${6,10}|\\^{6,10}";

        for (int i = 0; i < commands.length; i++) {

            String current = commands[i];

            if (current.length() == 20) {

                String firstPart = current.substring(0, 10);
                String secondPart = current.substring(10);

                Pattern pattern = Pattern.compile(regexValid);
                Matcher matcherFirst = pattern.matcher(firstPart);
                Matcher matcherSecond = pattern.matcher(secondPart);

                if ((matcherFirst.find()) && (matcherSecond.find())) {
                    String first = matcherFirst.group();
                    String second = matcherSecond.group();

                    if (first.charAt(first.length() / 2) == second.charAt(second.length() / 2)) {
                        int searchedLength = Math.min(first.length(), second.length());

                        if (searchedLength < 10) {
                            System.out.printf("ticket \"%s\" - %d%c%n", current, searchedLength, first.charAt(first.length() / 2));
                        } else if (searchedLength == 10) {
                            System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", current, first.charAt(0));
                        }
                    }

                } else {
                    System.out.printf("ticket \"%s\" - no match%n", current);
                }
            } else {
                System.out.printf("invalid ticket%n");
            }
        }
    }
}


