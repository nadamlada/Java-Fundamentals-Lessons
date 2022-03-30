package JF08ArraysExercise;

/*
Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.
 */

import java.util.Arrays;
import java.util.Scanner;

public class X08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nums.length; i++) {
            int searched = input - nums[i];

            for (int j = (i + 1); j < nums.length; j++) {

                if (nums[j] == searched) {
                    System.out.printf("%d %d%n", nums[i], nums[j]);
                }
            }
        }
    }
}