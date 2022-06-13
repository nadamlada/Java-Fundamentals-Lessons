package JF12ListsLab;

 /*
 Write a program to sum all adjacent equal numbers in a list of decimal numbers, starting from left to right.
	After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed as well (see the examples below).
	Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available).
 */

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01sumAdjacentEqualNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = (List) Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; ++i) {
            if (((Double) numbers.get(i)).equals(numbers.get(i + 1))) {
                numbers.set(i, (Double) numbers.get(i) + (Double) numbers.get(i + 1));
                numbers.remove(i + 1);
                i = -1;
            }
        }

        String output = joinElementsBydDelimiter(numbers, " ");
        System.out.println(output);
    }

    public static String joinElementsBydDelimiter(List<Double> items, String delimiter) {

        String output = "";

        Double item;
        for (Iterator var3 = items.iterator(); var3.hasNext(); output = output + (new DecimalFormat("0.#")).format(item) + delimiter) {
            item = (Double) var3.next();
        }

        return output;
    }
}