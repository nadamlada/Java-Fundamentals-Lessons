package JF07ArraysLab;

/*
Write a program that calculates the difference between the sum of the even and the sum of the odd numbers in an array.
 */

import java.util.Scanner;

public class L05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sumEven = 0;
        int sumOdd = 0;

        String[] dividedNumbers = input.split("\\s");
        int[] intNumbers = new int[dividedNumbers.length];
        for (int i = 0; i < dividedNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(dividedNumbers[i]);

            if (intNumbers[i] % 2 == 0) {
                sumEven += intNumbers[i];
            } else {
                sumOdd += intNumbers[i];
            }
        }

        System.out.printf("%d", sumEven - sumOdd);
    }
}