package JF08ArraysExercise;

/*
Write a program to find all the top integers in an array. A top integer is an integer that is bigger than all the elements to its right.
 */

/*
https://youtu.be/kZpfsxBYMX0?t=13360
 */

import java.util.Arrays;
import java.util.Scanner;

public class X05TopIntegersDesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //прави парснат масив извикваш с parsearray customized
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {

            boolean isBigger = false;
            int currentNumber = numbers[i];

            for (int j = (i + 1); j < numbers.length; j++) {

                if (currentNumber > numbers[j]) {
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                System.out.print(currentNumber + " ");
            }
        }

        System.out.print(numbers[numbers.length - 1]);
    }
}