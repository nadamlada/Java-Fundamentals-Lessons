package JF08ArraysExercise;

/*
Write a program to find all the top integers in an array. A top integer is an integer that is bigger than all the elements to its right.
 */

/*
https://youtu.be/kZpfsxBYMX0?t=13360
 */

import java.util.Scanner;

public class X05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] nums = input.split("\\s");

        int[] numbers = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            numbers[i] = Integer.parseInt(nums[i]);

            for (int j = 0; j < nums.length; j++) {
                int currentNumber = numbers[i];
                if (i == numbers.length - 1) {
                    System.out.println(currentNumber + " ");
                    break;
                }

                boolean isTop = false;

                // обхождам всички числа след моето
                for (int k = i + 1; k < nums.length; k++) {

                    if (currentNumber > numbers[i]) {
                        isTop = true;
                    } else {
                        isTop = false;
                        break;
                    }
                }

                if (isTop) {
                    System.out.println(currentNumber + " ");
                }
            }
        }
    }
}