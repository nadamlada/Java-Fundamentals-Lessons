package JF07ArraysLab;
 /*
 Read an array from the console and sum only the even numbers.
 */

import java.util.Scanner;

public class L03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] numbersAsStrings = input.split("\\s");

        int sum = 0;
        int[] numbers = new int[numbersAsStrings.length];
        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);

            if (numbers[i] % 2 == 0) {
                sum = sum + numbers[i];
            }
        }

        System.out.println(sum);
    }
}