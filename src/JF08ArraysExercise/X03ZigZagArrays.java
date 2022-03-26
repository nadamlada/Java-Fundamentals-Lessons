package JF08ArraysExercise;

/*
Write a program that creates 2 arrays. You will be given an integer n. On the next n lines, you get 2 integers.
Form 2 arrays as shown below.
 */

import java.util.Scanner;

public class X03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstLine = new String[n];
        String[] secondLine = new String[n];
        String[] nums = scanner.nextLine().split("\\s ");

        for (int i = 1; i <= n; i++) {

            if (i % 2 != 0) {
                firstLine[i - 1] = nums[0];
                secondLine[i - 1] = nums[1];
            } else if (i % 2 == 0) {
                firstLine[i - 1] = nums[1];
                secondLine[i - 1] = nums[0];
            }
        }

        System.out.println(String.join(" ", firstLine));
        System.out.println(String.join(" ", secondLine));
    }
}
