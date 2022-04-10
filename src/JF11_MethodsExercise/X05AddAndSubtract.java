package JF11_MethodsExercise;

/*
You will receive 3 integers. Write a method sum to get the sum of the first two integers and subtract the
method that subtracts the third integer from the result from the sum method.
 */

import java.util.Scanner;

public class X05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        sumOfFirstTwoIntegers(a, b);
        int sum = sumOfFirstTwoIntegers(a, b);

        subtract(sum, c);
        int result = subtract(sum, c);
        System.out.println(result);
    }

    private static int subtract(int sum, int c) {
        return (sum - c);
    }

    private static int sumOfFirstTwoIntegers(int a, int b) {
        return (a + b);
    }
}