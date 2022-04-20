package JF14ListsExercise;

/*
Write a program that reads a sequence of numbers and a special bomb number with a certain power.
Your task is to detonate every occurrence of the special bomb number and according to its power -
his neighbors from left and right. Detonations are performed from left to right and all detonated numbers disappear.
Finally, print the sum of the remaining elements in the sequence.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbersInput = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        String[] buffer = numbersInput.split("\\s+");

        for (String s : buffer) {
            numbers.add(Integer.parseInt(s));
        }

        String line2 = scanner.nextLine();
        String[] commands = line2.split(" ");

        int bomb = Integer.parseInt(commands[0]);
        int spread = Integer.parseInt(commands[1]);

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);
            int left = Math.max(0, index - spread);
            int right = Math.min(numbers.size() - 1, index + spread);

            for (int i = left; i <= right; i++) {
                numbers.remove(left);
            }
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}