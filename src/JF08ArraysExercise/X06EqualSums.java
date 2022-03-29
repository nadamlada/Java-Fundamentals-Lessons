package JF08ArraysExercise;
/*
Write a program that determines if there exists an element in the array such that the sum of the elements on its left is equal
to the sum of the elements on its right. If there are no elements to the left/right, their sum is considered to be 0.
Print the index that satisfies the required condition or "no" if there is no such index.
*/

import java.util.Arrays;
import java.util.Scanner;

public class X06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        boolean isFound = false;

        int index = 0;

        for (int i = 0; i < input.length; i++) {
            index = i;

            if (i == 0 || i == (input.length - 1)) {
                int leftSum = 0;
                int rightSum = 0;
            }

            //leftSum
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += input[j];
            }

            //rightsum
            int rightSum = 0;
            for (int k = i + 1; k < input.length; k++) {
                rightSum += input[k];
            }

            if (leftSum == rightSum) {

                isFound = true;
                System.out.println(index);
            }
        }

        if (!isFound) {
            System.out.println("no");
        }
    }
}