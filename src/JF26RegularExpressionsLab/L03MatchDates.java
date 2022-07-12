package JF26RegularExpressionsLab;

/*
Write a program, which matches a date in the format "dd{separator}MMM{separator}yyyy". Use named capturing groups in your regular expression.
Compose the Regular Expression
Every valid date has the following characteristics:
•	Always starts with two digits, followed by a separator.
•	After that, it has one uppercase and two lowercase letters (e.g. Jan, Mar).
•	After that, it has a separator and exactly 4 digits (for the year).
•	The separator could be either of three things: a period ("."), a hyphen ("-") or a forward-slash ("/").
•	The separator needs to be the same for the whole date (e.g. 13.03.2016 is valid, 13.03/2016 is NOT). Use a group back reference to check for this.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "\\b(?<day>\\d{2})([\\.\\-\\/])(?<month>[A-Z][a-z]{2})(\\2)(?<year>\\d{4})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}