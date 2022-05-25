package JF10MethodsLab;

/*
Create a program that reads an integer number and multiplies the sum of all its even digits by the sum of all its odd digits:
 */

import java.util.Arrays;
import java.util.Scanner;

public class L10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        String numberAsString = number + "";
        int[] array = Arrays.stream(numberAsString.split("")).mapToInt(Integer::parseInt).toArray();

        sumOddDigits(array);

        sumEvenDigits(array);

        int result = Multiplication(sumEvenDigits(array), sumOddDigits(array));
        System.out.println(result);
    }

    private static int Multiplication(int a, int b) {
        return a * b;
    }

    private static int sumEvenDigits(int[] input) {

        int sumEvenElements = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                sumEvenElements += input[i];
            }
        }

        return sumEvenElements;
    }

    private static int sumOddDigits(int[] input) {

        int sumOddElements = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 != 0) {
                sumOddElements += input[i];
            }
        }

        return sumOddElements;
    }
}