package JF27RegularExpressionsExercises;

/*
Write a program to calculate the total cost of different types of furniture. You will be given some lines of input until you receive the line "Purchase". For the line to be valid it should be in the following format:
">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number. Store the names of the furniture and the total price. At the end print each bought furniture on a separate line in the format:
"Bought furniture:
{1st name}
{2nd name}
…"
And on the last line print, the following: "Total money spend: {spend money}" formatted to the second decimal point.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class X01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // регекс за дробно или цяло->   \d+.?\d*
        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+.?\\d*)!(?<qty>(\\d)+)";

        List<String> archive = new ArrayList<>();
        double sum = 0;

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                Double price = Double.parseDouble(matcher.group("price"));
                int qty = Integer.parseInt(matcher.group("qty"));
                archive.add(name);
                double currentSum = qty * price;
                sum += currentSum;
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        archive.forEach(f -> System.out.println(f));
        System.out.printf("Total money spend: %.2f", sum);
    }
}