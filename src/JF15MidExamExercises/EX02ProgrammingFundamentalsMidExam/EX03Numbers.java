package JF15MidExamExercises.EX02ProgrammingFundamentalsMidExam;

/*
Write a program to read a sequence of integers and find and print the top 5 numbers greater than the average value in the sequence, sorted in descending order.
Input
•	Read from the console a single line holding space-separated integers.
Output
•	Print the above-described numbers on a single line, space-separated.
•	If less than 5 numbers hold the property mentioned above, print less than 5 numbers.
•	Print "No" if no numbers hold the above property.
Constraints
•	All input numbers are integers in the range [-1 000 000 … 1 000 000].
•	The count of numbers is in the range [1…10 000].
 */

import java.util.*;
import java.util.stream.Collectors;

public class EX03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        int average = sum / numbers.size();

        List<Integer> top = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > average) {
                top.add(numbers.get(i));
            }
        }

        Collections.sort(top);
        Collections.reverse(top);

        if (top.size() == 0) {
            System.out.println("No");
        }

        int length = Math.min(5, top.size());

        String print = "";
        for (int i = 0; i < length; i++) {
            int currentEl = (top.get(i));
            print += (currentEl) + " ";
        }

        System.out.println(print);
    }
}