package JF14ListsMoreExercise;

/*
Write a program to calculate the winner of a car race. You will receive an array of numbers. Each element of the array represents
the time needed to pass through that step (the index). There are going to be two cars. One of them starts from the left
side and the other one starts from the right side. The middle index of the array is the finish line. (The number of elements of
the array will always be odd). Calculate the total time for each racer to reach the finish (the middle of the array) and print the
winner with his total time. (The racer with less time). If you have a zero in the array, you have to reduce the time of the racer
that reached it by 20% (from the time so far).
Print the result in the following format "The winner is {left/right} with total time: {total time}", formatted with one digit after
the decimal point.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MX02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> times = new ArrayList<>();
        String[] buffer = input.split("\\s+");

        for (String s : buffer) {
            times.add(Integer.parseInt(s));
        }

        //по толкова елемента събираш от ляво и от дясно
        int qtyElements = times.size() / 2;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int i = 1; i <= qtyElements; i++) {
            first.add(times.get(i - 1));
            second.add(times.get(times.size() - i));
        }

        double sumFirst = getSum(first);
        double sumSecond = getSum(second);
        double result = Math.min(sumFirst, sumSecond);

        if (result == sumFirst) {
            System.out.printf("The winner is left with total time: %.1f", result);
        } else {
            System.out.printf("The winner is right with total time: %.1f", result);
        }
    }

    private static double getSum(List<Integer> first) {
        double sumFirst = 0;

        for (int i = 0; i < first.size(); i++) {
            int currentElement = first.get(i);
            if (currentElement == 0) {
                sumFirst = 0.8 * sumFirst;
            }

            sumFirst += currentElement;
        }

        return sumFirst;
    }
}
