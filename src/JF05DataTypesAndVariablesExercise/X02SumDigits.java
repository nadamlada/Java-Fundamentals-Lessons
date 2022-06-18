package JF05DataTypesAndVariablesExercise;

/*
You will be given a single integer. Your task is to find the sum of its digits.
 */

import java.util.Scanner;

public class X02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            int nextNumber = num / 10;
            num = nextNumber;
        }

        System.out.println(sum);
    }
}