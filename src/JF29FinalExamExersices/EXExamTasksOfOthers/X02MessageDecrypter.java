package JF29FinalExamExersices.EXExamTasksOfOthers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class X02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            int counter = 0;
            String regex = "^([\\$\\%])[A-Z][a-z]{2,}\\1: \\[(?<first>\\d+)]\\|\\[(?<second>\\d+)]\\|\\[(?<third>\\d+)]\\|$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                counter = 0;
                counter++;
                String whatIsMatched = matcher.toString();

                //decrypt
                int number1 = Integer.parseInt(matcher.group("first"));
                int number2 = Integer.parseInt(matcher.group("second"));
                int number3 = Integer.parseInt(matcher.group("third"));
                String forPrint = (char) number1 + "" + (char) number2 + (char) number3;
                System.out.printf("Request: %s%n", forPrint);
            }

            if (counter == 0) {
                System.out.printf("Valid message not found!%n");

            }
        }
    }
}
